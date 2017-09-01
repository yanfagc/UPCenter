package org.hanzhdy.manager.upc.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by H.CAAHN on 2017/7/4.
 */
public class Resource {
    private Long id;
    
    private String code;
    
    private String name;
    
    private String icon;
    
    private String url;
    
    private String urltype;

    private Boolean checked;

    private Long parentid;
    
    private List<Resource> children;
    
    public void addChild(Resource data) {
        if (children == null) {
            children = new ArrayList<>();
        }
        children.add(data);
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getIcon() {
        return icon;
    }
    
    public void setIcon(String icon) {
        this.icon = icon;
    }
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getUrltype() {
        return urltype;
    }
    
    public void setUrltype(String urltype) {
        this.urltype = urltype;
    }
    
    public Long getParentid() {
        return parentid;
    }
    
    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public List<Resource> getChildren() {
        return children;
    }
    
    public void setChildren(List<Resource> children) {
        this.children = children;
    }
}
