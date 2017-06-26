package org.hanzhdy.manager.engine.express;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 表达式计算结果
 * @author H.CAAHN
 */
public class ExpressResult {
    /** 结果类型 */
    private String             rtype;
    
    /** 参数列表 */
    private String[]           args;
    
    /** 源字符串 */
    private char[]             source;
    
    /** 点位值 */
    private List<ExpressPoint> points;
    
    public ExpressResult(String source) {
        points = new ArrayList<ExpressPoint>();
        this.source = source.toCharArray();
    }
    
    public void addPoint(int start, int end) {
        if (end <= start) {
            return;
        }
        ExpressPoint point = new ExpressPoint();
        point.setStart(start);
        point.setEnd(end);
        this.points.add(point);
    }
    
    public void addPoint(String key) {
        ExpressPoint point = new ExpressPoint();
        point.setReplace(true);
        point.setKey(key);
        this.points.add(point);
    }
    
    public void settingArgs(String args) {
        this.args = args.split(",\\s*");
    }
    
    public String getRtype() {
        return rtype;
    }
    
    public void setRtype(String rtype) {
        int start = -1;
        int end = -1;
        char[] chs = rtype.toCharArray();
        for (int i = 0, s = chs.length; i < s; i++) {
            if (chs[i] == '(') {
                start = i;
            }
            else if (chs[i] == ')') {
                end = i;
            }
        }
        if (start > -1 && end > -1 && start < end) {
            this.settingArgs(rtype.substring(start + 1, end));
            this.rtype = rtype.substring(0, start);
        }
        else {
            this.rtype = rtype;
        }
    }
    
    public String[] getArgs() {
        return args;
    }
    
    public void setArgs(String[] args) {
        this.args = args;
    }
    
    public char[] getSource() {
        return source;
    }
    
    public void setSource(char[] source) {
        this.source = source;
    }
    
    public List<ExpressPoint> getPoints() {
        return points;
    }
    
    public void setPoints(List<ExpressPoint> points) {
        this.points = points;
    }
}
