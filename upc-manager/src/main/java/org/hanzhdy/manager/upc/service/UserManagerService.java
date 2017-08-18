package org.hanzhdy.manager.upc.service;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.hanzhdy.manager.form.mapper.FormDataMapperExt;
import org.hanzhdy.manager.form.model.FormData;
import org.hanzhdy.manager.form.model.FormDataExample;
import org.hanzhdy.manager.form.service.FormEngineService;
import org.hanzhdy.manager.support.constants.DBConstants;
import org.hanzhdy.manager.support.service.AbstractUpcService;
import org.hanzhdy.manager.upc.controller.params.UserParams;
import org.hanzhdy.manager.upc.mapper.UserBasicMapperExt;
import org.hanzhdy.manager.upc.mapper.UserInfoMapperExt;
import org.hanzhdy.manager.upc.mapper.UserRoleMapperExt;
import org.hanzhdy.manager.upc.mapper.UserStatusMapperExt;
import org.hanzhdy.manager.upc.model.*;
import org.hanzhdy.manager.upc.vo.UserVo;
import org.hanzhdy.utils.Strings;
import org.hanzhdy.utils.security.SecurityUtils;
import org.hanzhdy.web.bean.DatatableResult;
import org.hanzhdy.web.throwable.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description 用户管理Service
 * @author H.CAAHN
 * @createtime 2015年12月20日 下午8:42:11
 */
@Service
public class UserManagerService extends AbstractUpcService {
    @Autowired
    private UserBasicMapperExt  userBasicMapperExt;
    
    @Autowired
    private UserInfoMapperExt   userInfoMapperExt;
    
    @Autowired
    private UserStatusMapperExt userStatusMapperExt;
    
    @Autowired
    private FormDataMapperExt   formDataMapperExt;
    
    @Autowired
    private UserRoleMapperExt   userRoleMapperExt;
    
    @Autowired
    private FormEngineService   formEngineService;
    
    private static final Logger logger = LoggerFactory.getLogger(UserManagerService.class);
    
    /**
     * 分页查询用户信息，并按条件返回符合datatable数据格式的信息
     * @param params
     * @return
     */
    public DatatableResult queryAsDatatableResult(UserParams params) {
        // 构造查询条件
        Map<String, Object> search = new HashMap<String, Object>();
        search.put("page", params.createPage());
        if (StringUtils.isNotBlank(params.getAccount())) {
            search.put("account", "%" + params.getAccount() + "%");
        }
        if (StringUtils.isNotBlank(params.getEmail())) {
            search.put("email", "%" + params.getEmail() + "%");
        }
        if (StringUtils.isNotBlank(params.getMobileno())) {
            search.put("mobileno", "%" + params.getMobileno() + "%");
        }
        if (StringUtils.isNotBlank(params.getNickname())) {
            search.put("nickname", "%" + params.getNickname() + "%");
        }
        if (StringUtils.isNotBlank(params.getStatus())) {
            search.put("status", params.getStatus());
        }
        if (StringUtils.isNotBlank(params.getSearchkey())) {
            search.put("searchkey", "%" + params.getSearchkey() + "%");
        }
        
        // 查询数据
        int count = this.userBasicMapperExt.countAsList(search);
        List<UserVo> data = this.userBasicMapperExt.selectAsList(search);
        
        // 设置返回结果
        DatatableResult result = new DatatableResult();
        result.setTotal(count);
        result.setAaData(data);
        return result;
    }
    
    /**
     * 根据用户ID查询用户信息
     * @param userid
     * @return
     */
    public UserVo queryById(Long userid) {
        return this.userBasicMapperExt.selectById(userid);
    }
    
    /**
     * 根据用户帐号查询用户信息
     * @param account
     * @return
     */
    public UserVo queryByAccount(String account) {
        return this.userBasicMapperExt.selectByAccount(account);
    }
    
    /**
     * 插入用户信息
     * @param record
     * @param request
     * @return
     */
    public boolean insert(UserVo record, HttpServletRequest request) {
        // 构造基本信息
        UserBasic basic = new UserBasic();
        basic.setAccount(record.getAccount());
        if (StringUtils.isBlank(record.getPassword())) {
            record.setPassword("111111");
        }
        basic.setPassword(this.encryptPwd(record.getAccount(), record.getPassword()));
        basic.setNickname(record.getNickname());
        basic.setFormId(record.getFormid());
        
        UserInfo info = new UserInfo();
        info.setMobileno(record.getMobileno());
        info.setEmail(record.getEmail());
        info.setCerttype(record.getCerttype());
        info.setCertno(record.getCertno());
        info.setOfficephone(record.getOfficephone());
        info.setFaxno(record.getFaxno());
        
        UserStatus status = new UserStatus();
        status.setStatus(record.getStatus());
        status.setCreator(record.getCreator());
        status.setCreatetime(new Date());
        status.setUpdater(record.getCreator());
        status.setUpdatetime(status.getCreatetime());
        
        // 插入基本信息
        this.userBasicMapperExt.insertSelective(basic);
        
        info.setUserId(basic.getId());
        this.userInfoMapperExt.insertSelective(info);
        
        status.setUserId(basic.getId());
        this.userStatusMapperExt.insertSelective(status);
        return true;
    }
    
    /**
     * 更新用户信息
     * @param record
     * @param request
     * @return
     */
    public boolean update(UserVo record, HttpServletRequest request) {
        // 构造基本信息
        UserBasic basic = new UserBasic();
        basic.setAccount(record.getAccount());
        if (StringUtils.isNotBlank(record.getPassword())) {
            basic.setPassword(this.encryptPwd(record.getAccount(), record.getPassword()));
        }
        basic.setNickname(record.getNickname());
        basic.setFormId(record.getFormid());
        basic.setId(record.getId());
        
        UserInfo info = new UserInfo();
        info.setMobileno(record.getMobileno());
        info.setEmail(record.getEmail());
        info.setCerttype(record.getCerttype());
        info.setCertno(record.getCertno());
        info.setOfficephone(record.getOfficephone());
        info.setFaxno(record.getFaxno());
        info.setUserId(record.getId());
        
        UserStatus status = new UserStatus();
        status.setStatus(record.getStatus());
        status.setUpdater(record.getUpdater());
        status.setUpdatetime(new Date());
        status.setUserId(record.getId());
        
        // 更新用户信息
        this.userBasicMapperExt.updateByPrimaryKeySelective(basic);
        this.userInfoMapperExt.updateByPrimaryKeySelective(info);
        this.userStatusMapperExt.updateByPrimaryKeySelective(status);
        
        return true;
    }
    
    /**
     * 更改用户状态
     * @param record
     * @return
     */
    public boolean updateStatus(UserStatus record) {
        UserStatus status = new UserStatus();
        status.setUserId(record.getUserId());
        status.setStatus(record.getStatus());
        status.setUpdater(record.getUpdater());
        status.setUpdatetime(new Date());
        int count = this.userStatusMapperExt.updateByPrimaryKeySelective(status);
        return count > 0;
    }
    
    /**
     * 插入用户的扩展信息
     * @param userid
     * @param formid
     * @param request
     */
    public void insertExtendData(Long userid, Long formid, HttpServletRequest request) {
        if (userid == null) {
            logger.warn("插入扩展信息失败，userid=null");
            return;
        }
        
        UserBasic record = new UserBasic();
        record.setId(userid);
        record.setFormId(formid);
        this.userBasicMapperExt.updateByPrimaryKeySelective(record);
        
        // 删除已有的数据
        FormDataExample example = new FormDataExample();
        example.createCriteria().andDatatypeEqualTo(DBConstants.FORM_DATA_TYPE_USER).andRecordidEqualTo(userid);
        formDataMapperExt.deleteByExample(example);
        
        if (formid == null) {
            return;
        }
        
        // 处理并插入表单数据
        List<FormData> dataList = formEngineService.getFormData(formid, request);
        if (dataList != null && !dataList.isEmpty()) {
            for (FormData data : dataList) {
                data.setRecordid(userid);
                data.setDatatype(DBConstants.FORM_DATA_TYPE_USER);
                formDataMapperExt.insert(data);
            }
        }
    }
    
    /**
     * 保存用户的角色信息
     * @param userid
     * @param roles
     * @return
     */
    public boolean updateUserRole(Long userid, String roles) {
        if (userid == null) {
            logger.warn("保存用户角色信息失败，userid=null");
            throw new BizException(respCode.SAVE_PRIMARY_EMPTY);
        }
    
        UserRoleExample ure = new UserRoleExample();
        ure.createCriteria().andUserIdEqualTo(userid);
        this.userRoleMapperExt.deleteByExample(ure);
        if (StringUtils.isNotBlank(roles)) {
            List<String> strs = JSON.parseArray(roles, String.class);
            for (String str : strs) {
                try {
                    Long roleid = Long.valueOf(str);
                    UserRoleKey key = new UserRoleKey();
                    key.setRoleId(roleid);
                    key.setUserId(userid);
                    this.userRoleMapperExt.insertSelective(key);
                }
                catch (Exception ex) {
                    logger.warn("用户角色信息保存失败, 角色ID：" + str + ", 用户ID: " + userid, ex);
                }
            }
        }
        
        return true;
    }
    
    /**
     * 根据用户名和密码，对密码进行组合加密，并返回加密后字符串
     * @param account
     * @param password
     * @return
     */
    protected String encryptPwd(String account, String password) {
        String pwdstr = password + "$" + account;
        String encstr = SecurityUtils.encryptSHA256String(pwdstr);
        return encstr;
    }
    
    /**
     * 验证密码是否正确
     * @param account
     * @param password
     * @param encryptPwd
     * @return
     */
    public boolean checkPwd(String account, String password, String encryptPwd) {
        String pwdstr = password + "$" + account;
        String encstr = SecurityUtils.encryptSHA256String(pwdstr);
        return StringUtils.equalsIgnoreCase(encstr, encryptPwd);
    }
    
    public static void main(String[] args) {
        UserManagerService s = new UserManagerService();
        System.out.println(s.encryptPwd("sysadmin", "111111"));
        
        byte[] bs = SecurityUtils.encryptDES("111111".getBytes(), "zhangzhongqiang".getBytes());
        System.out.println(Strings.parse16(bs));
    }
}
