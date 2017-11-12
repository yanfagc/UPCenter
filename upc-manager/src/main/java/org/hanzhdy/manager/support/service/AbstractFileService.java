package org.hanzhdy.manager.support.service;

import org.apache.commons.lang3.StringUtils;
import org.hanzhdy.manager.support.enums.FileUploadType;
import org.hanzhdy.utils.formatter.StringFormatter;
import org.hanzhdy.utils.resources.Resources;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * AbstractFileService
 * Created by H.CAAHN on 2017/11/2.
 */
public abstract class AbstractFileService extends AbstractUpcService {
    protected Map<FileUploadType, String> dirpath;
    
    @PostConstruct
    public void init() {
        dirpath = new HashMap<FileUploadType, String>();
        FileUploadType[] typeArray = FileUploadType.values();
        if (typeArray != null && typeArray.length > 0) {
            for (FileUploadType type : typeArray) {
                String path = Resources.getString(type.getPathkey());
                StringFormatter formatter = new StringFormatter(path);
                path = formatter.toReplaceString();
                if (StringUtils.isNotBlank(path)) {
                    if (!path.endsWith("/") && !path.endsWith("\\")) {
                        path += '/';
                    }
                    
                    dirpath.put(type, path);
                }
            }
        }
    }
}
