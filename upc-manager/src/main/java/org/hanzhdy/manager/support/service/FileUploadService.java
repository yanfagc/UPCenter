package org.hanzhdy.manager.support.service;

import org.apache.commons.lang3.StringUtils;
import org.hanzhdy.manager.support.enums.FileUploadType;
import org.hanzhdy.utils.DateUtils;
import org.hanzhdy.utils.MathUtils;
import org.hanzhdy.web.throwable.BizException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;

/**
 * FileUploadService - 文件上传Service
 * Created by H.CAAHN on 2017/10/24.
 */
@Service
public class FileUploadService extends AbstractFileService {
    /**
     * 文件上传
     * @param type
     * @param file
     * @return
     */
    public String upload(FileUploadType type, MultipartFile file) throws  Exception {
        String path = dirpath.get(type);
        if (StringUtils.isBlank(path)) {
            throw new BizException(respCode.UPLOAD_ERROR_CONFIGURE);
        }
        
        String relativePath = null;
        Date nowtime = new Date();
        try {
            StringBuffer pathBuffer = new StringBuffer();
            pathBuffer.append(DateUtils.getTimeString(nowtime, "yyyyMM"));
            File dir = new File(path + pathBuffer.toString());
            if (!dir.exists()) {
                dir.mkdirs();
            }
    
            pathBuffer.append('/');
            pathBuffer.append(DateUtils.getTimeString(nowtime, "ddHHmmssSSS"));
            pathBuffer.append("_");
            pathBuffer.append(MathUtils.getRandomNum(100, 1000));
            pathBuffer.append(this.getSuffix(file.getOriginalFilename()));
            relativePath = pathBuffer.toString();
            
            pathBuffer.insert(0, path);
            File rfile = new File(pathBuffer.toString());
            rfile.createNewFile();
            file.transferTo(rfile);
        }
        catch (Exception ex) {
            throw ex;
        }
        return relativePath;
    }
    
    private String getSuffix(String fileName) {
        int index = fileName.lastIndexOf(".");
        if (index > -1) {
            return fileName.substring(index);
        }
        return "";
    }
}
