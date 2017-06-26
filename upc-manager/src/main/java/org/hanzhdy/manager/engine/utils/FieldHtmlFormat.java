package org.hanzhdy.manager.engine.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.hanzhdy.manager.engine.FieldEngine;
import org.hanzhdy.manager.engine.attribute.HtmlAttribute;
import org.hanzhdy.manager.engine.express.ExpressPoint;
import org.hanzhdy.manager.engine.express.ExpressResult;
import org.hanzhdy.utils.resources.GlobalPlus;
import org.hanzhdy.utils.resources.GlobalPlus.Env;
import org.hanzhdy.utils.resources.Resources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description 文件格式化工具，类似MessageFormat，但该工具可以直接读取文件
 *              支持Map替换和数组格式化
 * @author H.CAAHN
 */
public final class FieldHtmlFormat {
    /** 模版Map */
    private static Map<String, String>              templateMap;
    
    /** elementMap */
    private static Map<String, Map<String, String>> elementMap;
    
    /** 日志对象 */
    private static final Logger                     logger = LoggerFactory.getLogger(FieldHtmlFormat.class);
    
    static {
        templateMap = new HashMap<String, String>();
        elementMap = new HashMap<String, Map<String, String>>();
        
        //资源文件
        String msgf = Resources.getDefault("field.engine.message.file", "templates.engines.message");
        
        Resources.addResources(msgf);
    }
    
    /**
     * 根据key值获取引擎HTML模版
     * @param tempKey
     * @return
     */
    public static String getTemplate(String tempkey) {
        if (GlobalPlus.getEnv() != Env.production) {
            String template = loadTemplate(tempkey);
            return template;
        }
        else {
            String template = templateMap.get(tempkey);
            if (template == null) {
                synchronized (FieldEngine.class) {
                    template = templateMap.get(tempkey);
                    if (template == null) {
                        template = loadTemplate(tempkey);
                        templateMap.put(tempkey, template);
                    }
                }
            }
            return template;
        }
    }
    
    /**
     * 根据key值获取引擎HTML模版中html标签id等于moduleid值的内容
     * 返回首次匹配的内容
     * @param tmepkey
     * @param moduleid
     * @return
     */
    public static String getTemplate(String tempkey, String moduleid) {
        // 如果是debug模式，则每次访问刚方法时，都从文件中读取一次
        if (GlobalPlus.getEnv() != Env.production) {
            String template = getTemplate(tempkey);
            // 如果template模版为空，则直接返回
            if (StringUtils.isBlank(template)) {
                return template;
            }
            
            return ExpressUtils.getModuleById(template, moduleid);
        }
        else {
            Map<String, String> elements = elementMap.get(tempkey);
            if (elements == null) {
                synchronized (elementMap) {
                    if ((elements = elementMap.get(tempkey)) == null) {
                        elements = new HashMap<String, String>();
                        elementMap.put(tempkey, elements);
                    }
                }
            }
            
            String ele = elements.get(moduleid);
            if (ele != null) {
                return ele;
            }
            
            String template = getTemplate(tempkey);
            synchronized (elements) {
                if ((ele = elements.get(moduleid)) == null) {
                    ele = ExpressUtils.getModuleById(template, moduleid);
                    elements.put(moduleid, ele);
                }
            }
            return ele;
        }
    }
    
    /**
     * 根据模版key值和参数，创建HTML
     * @param tempkey
     * @param params
     * @return
     */
    public static String createHTML(String tempkey, Map<String, Object> params) {
        String template = getTemplate(tempkey);
        return parseHTML(template, params);
    }
    
    /**
     * 根据模版key值和参数，创建HTML
     * @param tempkey
     * @param params
     * @return
     */
    public static String createHTML(String tempkey, String... params) {
        String template = getTemplate(tempkey);
        return parseHTML(template, params);
    }
    
    /**
     * 根据模版key值、HTML的moduleid和参数，提取并创建HTML的NODE节点
     * @param tempkey
     * @param moduleid
     * @param params
     * @return
     */
    public static String createElement(String tempkey, String moduleid, Map<String, Object> params) {
        String template = getTemplate(tempkey, moduleid);
        return parseHTML(template, params);
    }
    
    /**
     * 根据模版key值、HTML的moduleid和参数，提取并创建HTML的NODE节点
     * @param tempkey
     * @param moduleid
     * @param params
     * @return
     */
    public static String createElement(String tempkey, String moduleid, String... params) {
        String template = getTemplate(tempkey, moduleid);
        return parseHTML(template, params);
    }
    

    /**
     * 根据模版key值、HTML的moduleid和参数，提取并创建HTML的NODE节点
     * @param tempkey
     * @param moduleid
     * @param params
     * @return
     */
    public static String createElement(String tempkey, String moduleid, Object params) {
        String template = getTemplate(tempkey, moduleid);
        return parseHTML(template, params);
    }
    
    /**
     * 根据模内容和参数，解析为最终的HTML
     * @param tempkey
     * @param params
     * @return
     */
    public static String parseHTML(String template, Object params) {
        if (StringUtils.isBlank(template)) {
            return template;
        }
        
        int index = -1;
        ExpressResult exr = ExpressUtils.parseAsResult(template, false);
        List<ExpressPoint> pList = exr.getPoints();
        if (pList != null && !pList.isEmpty()) {
            StringBuffer buf = new StringBuffer();
            for (ExpressPoint point : pList) {
                if (point.isReplace()) {
                    index++;
                    Object val = getValue(point.getKey().trim(), index, params);
                    buf.append(val);
                }
                else {
                    buf.append(exr.getSource(), point.getStart(), point.getEnd() - point.getStart());
                }
            }
            return buf.toString();
        }
        return template;
    }
    
    /**
     * 从params中提取相应的值
     * @param key - params为Map时，使用key作为参数获取值
     * @param index - params为List或Array时，使用index遍历值来提取参数
     * @param params
     * @return
     */
    private static Object getValue(String key, int index, Object params) {
        Object val = "";
        if (params != null) {
            if (params instanceof Map) {
                @SuppressWarnings("unchecked")
                Map<Object, Object> map = (Map<Object, Object>) params;
                val = map.get(key);
            }
            else if (params instanceof List) {
                @SuppressWarnings("unchecked")
                List<Object> list = (List<Object>) params;
                val = list.size() > index ? list.get(index) : "";
            }
            else if (params.getClass().isArray()) {
                Object[] objs = (Object[]) params;
                val = objs.length > index ? objs[index] : "";
            }
            else if (params instanceof HtmlAttribute) {
                String mname = "get" + Character.toUpperCase(key.charAt(0)) + key.substring(1);
                try {
                    Method method = params.getClass().getMethod(mname);
                    val = method.invoke(params);
                }
                catch (NoSuchMethodException e) {
                    logger.warn("未在{}查找到指定的方法{}", params.getClass(), mname);
                }
                catch (Exception e) {
                    logger.error("getValue赋值失败", e);
                }
            }
            else {
                val = params;
            }
            
            val = val == null ? "" : val;
        }
        return val;
    }
    
    /**
     * 加载引擎模版
     * @param tempkey
     * @return
     */
    private static String loadTemplate(String tempkey) {
        String baseUrl = Resources.getDefault("field.engine.basepath", "templates/engines/");
        if (!baseUrl.endsWith("/") && !baseUrl.endsWith("\\")) {
            baseUrl += "/";
        }
        
        String path = baseUrl + Resources.getString(tempkey);
        InputStream in = null;
        try {
            in = FieldEngine.class.getResourceAsStream(path);
            return IOUtils.toString(in, "UTF-8");
        }
        catch (UnsupportedEncodingException e) {
            logger.error("UnsupportedEncoding: UTF-8");
        }
        catch (FileNotFoundException e) {
            logger.error("文件不存在", path);
        }
        catch (Exception e) {
            logger.error("文件读取失败", e);
        }
        finally {
            try {
                in.close();
            }
            catch (IOException e) {
            }
        }
        return null;
    }
    
}
