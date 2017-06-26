package org.hanzhdy.manager.engine.build;

import java.util.HashMap;
import java.util.Map;

import org.hanzhdy.manager.engine.utils.FieldHtmlFormat;

/**
 * @description tr builder
 * @author H.CAAHN
 * @createtime 2017年6月10日 下午12:32:04
 */
public class LineBuilder {
    private int                 maxColumns;
    
    private int                 curColumns;
    
    private String              templateHtml;
    
    private String              tdExtendHtml;
    
    private StringBuffer        content;
    
    private Map<String, Object> params;
    
    public LineBuilder initBuilder(int maxColumns) {
        this.maxColumns = maxColumns;
        content = new StringBuffer();
        templateHtml = FieldHtmlFormat.getTemplate("field.engine.table.template", "tr.normal");
        tdExtendHtml = FieldHtmlFormat.getTemplate("field.engine.table.template", "td.extend");
        return this;
    }
    
    public String getHtml() {
        if (content.length() == 0) {
            return "";
        }
        
        // 空白对齐
        if (curColumns < maxColumns) {
            String colspan = "";
            if (maxColumns - curColumns > 1) {
                colspan = " colspan=\"" + (maxColumns - curColumns) + "\" ";
            }
            content.append(FieldHtmlFormat.parseHTML(tdExtendHtml, colspan));
        }
        
        if (params != null && !params.isEmpty()) {
            params.put("content", content.toString());
            return FieldHtmlFormat.parseHTML(templateHtml, params);
        }
        return FieldHtmlFormat.parseHTML(templateHtml, content.toString());
    }
    
    public void addAttribute(String key, Object value) {
        if ("content".equalsIgnoreCase(key)) {
            throw new RuntimeException("Can not put the key of name: content, please try another name.");
        }
        
        if (params == null) {
            params = new HashMap<String, Object>();
        }
        params.put(key, value);
    }
    
    public boolean testAppend(int columns) {
        return maxColumns >= columns + curColumns || (curColumns == 0 && columns >= maxColumns);
    }
    
    public void append(String content, int columns) {
        this.curColumns += columns;
        this.content.append(content);
    }
    
    public void clear() {
        if (params != null) {
            params.clear();
        }
        curColumns = 0;
        content.setLength(0);
    }
}
