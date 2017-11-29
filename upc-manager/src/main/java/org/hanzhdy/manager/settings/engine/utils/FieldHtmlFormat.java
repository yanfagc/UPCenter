package org.hanzhdy.manager.settings.engine.utils;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.hanzhdy.manager.settings.engine.FieldEngine;
import org.hanzhdy.utils.formatter.StringFormatter;
import org.hanzhdy.utils.resources.GlobalPlus;
import org.hanzhdy.utils.resources.GlobalPlus.Env;
import org.hanzhdy.utils.resources.Resources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description 文件格式化工具，类似MessageFormat，但该工具可以直接读取文件
 *              支持Map替换和数组格式化
 * @author H.CAAHN
 */
public final class FieldHtmlFormat {
    /** elementMap */
    private static Map<String, Map<String, StringFormatter>> elementMap;
    
    /** 日志对象 */
    private static final Logger                     logger = LoggerFactory.getLogger(FieldHtmlFormat.class);
    
    static {
        elementMap = new ConcurrentHashMap<String, Map<String, StringFormatter>>();
        
        //资源文件
        String msgf = Resources.getDefault("field.engine.message.file", "templates.engines.message");
        
        Resources.addResources(msgf);
    }
    
    /**
     * 根据key值获取引擎HTML模版
     * @param tempkey
     * @return
     */
    public static String getTemplate(String tempkey) {
        if (GlobalPlus.getEnv() != Env.production) {
            String template = loadTemplate(tempkey);
            return template;
        }
        else {
            StringFormatter formatter = StringFormatter.getFormatter(tempkey, true);
            return formatter.getSource();
        }
    }
    
    /**
     * 根据key值获取引擎HTML模版中html标签id等于moduleid值的内容
     * 返回首次匹配的内容
     * @param tempkey
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
            
            return getModuleById(template, moduleid);
        }
        else {
            Map<String, StringFormatter> elements = elementMap.get(tempkey);
            if (elements == null) {
                Map<String, StringFormatter> e = new ConcurrentHashMap<String, StringFormatter>();
                elements = elementMap.putIfAbsent(tempkey, e);
                if (elements == null) {
                    elements = e;
                }
            }
    
            StringFormatter ele = elements.get(moduleid);
            if (ele != null) {
                return ele.getSource();
            }
            
            String template = getTemplate(tempkey);
            String temp = getModuleById(template, moduleid);
            StringFormatter f = StringFormatter.getFormatter(temp);
            ele = elements.putIfAbsent(moduleid, ele);
            if (ele == null) {
                ele = f;
            }
            
            return ele.getSource();
        }
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
     * 根据模版内容和参数，解析为最终的HTML
     * @param template
     * @param params
     * @return
     */
    public static String parseHTML(String template, Object params) {
        if (StringUtils.isBlank(template)) {
            return template;
        }
    
        StringFormatter formatter = StringFormatter.getFormatter(template, true);
        return formatter.toReplaceString(params);
    }
    
    public static String getModuleById(String template, String moduleid) {
        int index = template.indexOf("\"" + moduleid + "\"");
        if (index == -1) {
            index = template.indexOf("\'" + moduleid + "\'");
        }
        if (index == -1) {
            return "";
        }

        int begin = template.indexOf(">", index + moduleid.length() + 2);
        if (begin == -1) {
            return "";
        }

        int end = template.indexOf("</html>", begin + 1);
        if (end == -1) {
            return "";
        }

        return template.substring(begin + 1, end);
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
