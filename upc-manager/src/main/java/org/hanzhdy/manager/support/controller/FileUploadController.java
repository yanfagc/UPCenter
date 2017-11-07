package org.hanzhdy.manager.support.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.hanzhdy.manager.support.constants.resp.RespResult;
import org.hanzhdy.manager.support.enums.FileUploadType;
import org.hanzhdy.manager.support.service.FileUploadService;
import org.hanzhdy.web.throwable.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * 文件上传
 * Created by H.CAAHN on 2017/10/24.
 */
@Controller
@RequestMapping("/basic/upfile/")
public class FileUploadController extends ApplicationController {
    /** 日志对象 */
    private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
    
    @Autowired
    private FileUploadService fileUploadService;
    
    /**
     * 上传用户头像GET
     * @param uploadFile
     * @param request
     * @return
     */
    @RequiresPermissions("basic:upfile:user")
    @RequestMapping(value = "userImage", method = RequestMethod.POST)
    @ResponseBody
    public Object uploadUserImage(@RequestParam("uploadFile")MultipartFile uploadFile, HttpServletRequest request) {
        try {
            String filePath = fileUploadService.upload(FileUploadType.USER_IMG, uploadFile);
            // 处理返回结果
            if (StringUtils.isNotBlank(filePath)) {
                return RespResult.create(respCode.SUCCESS, filePath);
            }
            else {
                return RespResult.create(respCode.UPLOAD_FAILURE);
            }
        }
        catch (BizException ex) {
            logger.warn("上传用户头像失败, 错误信息：[{}, {}]", ex.getCode(), ex.getMsg());
            return RespResult.create(ex.getStatus());
        }
        catch (Exception ex) {
            logger.error("上传用户头像失败, 文件大小：" + uploadFile.getSize(), ex);
            return RespResult.create(respCode.ERROR_EXCEPTION);
        }
    }
}
