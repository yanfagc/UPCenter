package org.hanzhdy.manager.engine.utils;

import org.springframework.util.StringUtils;

import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URLEncoder;
import java.util.Random;

public class Util {
    private static final Random random = new Random();

    public static String[] list() {
        String basePath = Util.class.getResource("/").getPath();
        basePath = basePath.substring(1, basePath.length());
        return new File(basePath + File.separator + "diagrams").list();
    }

    /**
     * 生成{len}位数字随机密码
     *
     * @return
     */
    public static String randomNumStr(int len) {
        String str = "";
        for (int i = 0; i < len; i++) {
            str = str + random.nextInt(9);
        }
        return str;
    }

    /**
     * 替换email地址
     *
     * @param emailAddress 邮箱地址
     * @return 替换后地址
     */
    public static String replaceEmailAddress(String emailAddress) {
        String emailPre = emailAddress.substring(0, emailAddress.indexOf("@"));
        String emailSuf = emailAddress.substring(emailAddress.indexOf("@"));
        if (emailPre.length() < 3)
            return emailPre;
        StringBuilder sb = new StringBuilder(emailPre);
        for (int i = 2; i < emailPre.length(); i++) {
            sb.setCharAt(i, '*');
        }
        sb.append(emailSuf);
        return sb.toString();
    }

    /**
     * 设置下载文件中文件的名称
     *
     * @param filename
     * @param request
     * @return
     */
    public static String encodeFilename(String filename, HttpServletRequest request) {
        /**
         * 获取客户端浏览器和操作系统信息
         * 在IE浏览器中得到的是：User-Agent=Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; Maxthon; Alexa Toolbar)
         * 在Firefox中得到的是：User-Agent=Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.7.10) Gecko/20050717 Firefox/1.0.6
         */
        String agent = request.getHeader("USER-AGENT");
        try {
            if ((agent != null) && (-1 != agent.indexOf("MSIE"))) {
                String newFileName = URLEncoder.encode(filename, "UTF-8");
                newFileName = StringUtils.replace(newFileName, "+", "%20");
                if (newFileName.length() > 150) {
                    newFileName = new String(filename.getBytes("GB2312"), "ISO8859-1");
                    newFileName = StringUtils.replace(newFileName, " ", "%20");
                }
                return newFileName;
            }
            if ((agent != null) && (-1 != agent.indexOf("Mozilla")))
                return MimeUtility.encodeText(filename, "UTF-8", "B");
            return filename;
        } catch (Exception ex) {
            return filename;
        }
    }
    
    /**
     * 判断字符串中含有某个字符的个数
     *param str1 需要判断的字符串
     *param str2 查找的字符
     **/
    public static int countStr(String str1, String str2) {   
        int counter=0;  
        if (str1.indexOf(str2) == -1) {    
            return 0;  
        }   
        while(str1.indexOf(str2)!=-1){  
            counter++;  
            str1=str1.substring(str1.indexOf(str2)+str2.length());  
        }  
        return counter;    
    } 
}
