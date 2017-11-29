package org.hanzhdy.manager.support.enums;

/**
 * 文件上传类型
 * Created by H.CAAHN on 2017/10/25.
 */
public enum FileUploadType {
    USER_IMG("file.upload.userimg", "用户头像");
    
    private String pathkey;
    
    private String remark;
    
    FileUploadType(String pathkey, String remark) {
        this.pathkey = pathkey;
        this.remark = remark;
    }
    
    public String getPathkey() {
        return pathkey;
    }
    
    public String getRemark() {
        return remark;
    }
}
