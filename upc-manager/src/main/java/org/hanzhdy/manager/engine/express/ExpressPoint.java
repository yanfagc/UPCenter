package org.hanzhdy.manager.engine.express;

/**
 * @description
 * @author H.CAAHN
 */
public class ExpressPoint {
    private int     start;
    
    private int     end;
    
    private boolean replace;
    
    private String  key;
    
    public int getStart() {
        return start;
    }
    
    public void setStart(int start) {
        this.start = start;
    }
    
    public int getEnd() {
        return end;
    }
    
    public void setEnd(int end) {
        this.end = end;
    }
    
    public boolean isReplace() {
        return replace;
    }
    
    public void setReplace(boolean replace) {
        this.replace = replace;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
