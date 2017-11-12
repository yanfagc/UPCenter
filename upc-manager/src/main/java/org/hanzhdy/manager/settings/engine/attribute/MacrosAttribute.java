package org.hanzhdy.manager.settings.engine.attribute;

import org.hanzhdy.manager.settings.engine.constants.NormalMacrosType;

/**
 * @description 宏控件
 * @author H.CAAHN
 * @createtime 2017年6月8日 下午4:56:05
 */
public class MacrosAttribute extends FieldAttribute {
    private NormalMacrosType macrostype;
    
    public NormalMacrosType getMacrostype() {
        return macrostype;
    }
    
    public void setMacrostype(NormalMacrosType macrostype) {
        this.macrostype = macrostype;
    }
}
