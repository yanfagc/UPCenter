package org.hanzhdy.manager.support.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.hanzhdy.manager.support.enums.FileUploadType;
import org.hanzhdy.manager.support.service.FilePreviewService;
import org.hanzhdy.web.throwable.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.MessageFormat;

/**
 * 文件预览
 * Created by H.CAAHN on 2017/11/2.
 */
@Controller
@RequestMapping("/basic/viewfile/")
public class FilePreviewController extends ApplicationController {
    private static final Logger logger = LoggerFactory.getLogger(FilePreviewController.class);
    
    @Autowired
    private FilePreviewService filePreviewService;
    
    /**
     * 查看用户头像
     * @param month
     * @param id
     * @param request
     * @return
     */
    @RequiresPermissions("basic:downfile:user")
    @RequestMapping(value = "userImage/{month}/{id:.+}", method = RequestMethod.GET)
    @ResponseBody
    public void uploadUserImage(@PathVariable("month") String month, @PathVariable("id") String id,
                                HttpServletRequest request, HttpServletResponse response) {
        try {
            this.filePreviewService.preview(FileUploadType.USER_IMG, month, id, response);
        }
        catch (BizException ex) {
            logger.warn("查看用户头像失败: {}/{}, 错误信息：[{}, {}]", month, id, ex.getCode(), ex.getMsg());
        }
        catch (Exception ex) {
            String errmsg = MessageFormat.format("查看用户头像失败: {0}/{1}", month, id);
            logger.error(errmsg, ex);
        }
    }
}
