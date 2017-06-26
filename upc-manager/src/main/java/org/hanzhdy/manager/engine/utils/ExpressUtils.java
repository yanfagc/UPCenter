package org.hanzhdy.manager.engine.utils;

import org.hanzhdy.manager.engine.express.ExpressResult;

/**
 * @description 表达式引擎
 * @author H.CAAHN
 */
public class ExpressUtils {
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
     * 若需要解析${result}=${args1}+${args2}, header设置为true
     * 若解析普通的HTML字符串，则header应设置为false
     * @param template
     * @param header
     * @return
     */
    public static ExpressResult parseAsResult(String template, boolean header) {
        ExpressResult result = new ExpressResult(template);
        int begin = 0;
        boolean start = false;
        char[] chs = template.toCharArray();
        for (int i = 0; i < chs.length;) {
            if (start) {
                if (chs[i] == '}') {
                    start = false;
                    String key = template.substring(begin + 2, i);
                    if (header) {
                        if (i + 1 == chs.length) {
                            header = false;
                        }
                        else if (chs[i + 1] == '=') {
                            i += 2;
                            begin = i;
                        }
                        else if (Character.isWhitespace(chs[i + 1])) {
                            int j = i + 2;
                            for (; j < chs.length; j++) {
                                if (chs[j] == '=') {
                                    begin = j + 1;
                                    i = begin;
                                    break;
                                }
                                else if (!Character.isWhitespace(chs[j])) {
                                    header = false;
                                    break;
                                }
                            }
                        }
                        else {
                            header = false;
                        }
                    }
                    if (header) {
                        result.setRtype(key);
                        header = false;
                    }
                    else {
                        result.addPoint(key);
                        i++;
                        begin = i;
                    }
                    continue;
                }
                else if (chs[i] == '\n') {
                    result.addPoint(begin, i + 1);
                    start = false;
                    begin = i + 1;
                }
            }
            else if (chs[i] == '$' && (i + 1 < chs.length) && chs[i + 1] == '{') {
                result.addPoint(begin, i);
                start = true;
                begin = i;
                i += 2;
                continue;
            }
            else if (header && !Character.isWhitespace(chs[i])) {
                header = false;
            }
            i++;
        }
        
        result.addPoint(begin, chs.length);
        return result;
    }
}
