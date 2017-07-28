package org.hanzhdy.manager.settings.vo;

import org.hanzhdy.manager.settings.model.DictData;

/**
 * @description
 * @author H.CAAHN
 * @createtime 2016年10月9日 下午10:02:08
 */
public class DictDataVo extends DictData {
    /** 序列化号 */
    private static final long serialVersionUID = -7468186446558046921L;
    
    private String            typename;
    
    public String getTypename() {
        return typename;
    }
    
    public void setTypename(String typename) {
        this.typename = typename;
    }
}
