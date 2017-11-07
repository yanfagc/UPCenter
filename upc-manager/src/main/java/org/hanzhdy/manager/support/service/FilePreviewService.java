package org.hanzhdy.manager.support.service;

import org.apache.commons.lang3.StringUtils;
import org.hanzhdy.manager.support.enums.FileUploadType;
import org.hanzhdy.web.throwable.BizException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 文件预览/下载
 * Created by H.CAAHN on 2017/11/2.
 */
@Service
public class FilePreviewService extends AbstractFileService {
    public void preview(FileUploadType type, String month, String id, HttpServletResponse response) throws Exception {
        String path = dirpath.get(type);
        if (StringUtils.isBlank(path)) {
            throw new BizException(respCode.UPLOAD_ERROR_CONFIGURE);
        }
        
        StringBuffer pathBuffer = new StringBuffer();
        pathBuffer.append(path);
        pathBuffer.append(month);
        pathBuffer.append('/');
        pathBuffer.append(id);
    
        InputStream in = null;
        try {
            File file = new File(pathBuffer.toString());
            in = new FileInputStream(file);
            
            int length = -1;
            byte[] bytes = new byte[8 * 1024];
            while ((length = in.read(bytes)) > -1) {
                response.getOutputStream().write(bytes, 0, length);
            }
            response.getOutputStream().flush();
        }
        catch (Exception ex) {
            throw ex;
        }
        finally {
            if (in != null) {
                try {
                    in.close();
                }
                catch (Exception ex) {
                
                }
            }
        }
    }
}
