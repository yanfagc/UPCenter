package org.hanzhdy.manager.support.enums;

/**
 * 菜单图标
 * Created by H.CAAHN on 2017/7/19.
 */
public enum MenuIcon {
    FA_USER_MD("fa-user-md"),
    
    FA_SUITCASE("fa-suitcase"),
    
    FA_CLIPBOARD("fa-clipboard"),
    
    FA_STETHOSCOPE("fa-stethoscope"),
    
    FA_COFFEE("fa-coffee"),
    
    FA_CUTLERY("fa-cutlery"),
    
    FA_FILE_TEXT_O("fa-file-text-o"),
    
    FA_BUILDING_O("fa-building-o"),
    
    FA_AMBULANCE("fa-ambulance"),
    
    FA_MEDKIT("fa-medkit"),
    
    FA_FIGHTER_JET("fa-fighter-jet"),
    
    FA_CIRCLE_O("fa-circle-o"),
    
    FA_CLOUD_UPLOAD("fa-cloud-upload"),
    
    FA_CLOUD_DOWNLOAD("fa-cloud-download");
    
    private String remark;
    
    private MenuIcon(String remark) {
        this.remark = remark;
    }
    
    public String getRemark() {
        return remark;
    }
}
