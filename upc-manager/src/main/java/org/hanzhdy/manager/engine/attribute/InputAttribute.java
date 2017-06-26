package org.hanzhdy.manager.engine.attribute;

import org.hanzhdy.manager.engine.constants.InputMacrosType;

/**
 * @description Input
 * @author H.CAAHN
 * @createtime 2017年6月8日 下午4:52:05
 */
public class InputAttribute extends FieldAttribute {
    private InputMacrosType macrostype;
    
    public InputMacrosType getMacrostype() {
        return macrostype;
    }
    
    public void setMacrostype(InputMacrosType macrostype) {
        this.macrostype = macrostype;
    }
}
