package org.hanzhdy.manager.engine.utils;

import org.apache.tools.ant.util.DateUtils;
import org.springframework.util.DigestUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-25
 * Time: 下午5:16
 * To change this template use File | Settings | File Templates.
 */
public class Lang {
    private static final Random  random           = new Random();
    
    private static final char[]  lowerChars       = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    
    private static final char[]  lowerCharsAndNum = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
    
    private static AtomicInteger atomicInteger    = new AtomicInteger(100);
    
    public static DecimalFormat df                = new DecimalFormat("#0.00");
    
    /**
     * 较方便的创建一个列表，比如：
     * 
     * <pre>
     * List&lt;Pet&gt; pets = Lang.list(pet1, pet2, pet3);
     * </pre>
     * 
     * 注，这里的 List，是 ArrayList 的实例
     * @param eles
     *        可变参数
     * @return 列表对象
     */
    public static <T> List<T> list(T... eles) {
        List<T> list = new ArrayList<T>(eles.length);
        for (T ele : eles) {
            list.add(ele);
        }
        return list;
    }
    
    /**
     * 创建一个 Hash 集合
     * @param eles
     *        可变参数
     * @return 集合对象
     */
    public static <T> Set<T> set(T... eles) {
        Set<T> set = new HashSet<T>();
        for (T ele : eles)
            set.add(ele);
        return set;
    }
    
    /**
     * 生成双MD5密码
     * @param password
     * @return
     */
    public static String DMd5Encode(String password) {
        return DigestUtils
                .md5DigestAsHex(("KSA" + DigestUtils.md5DigestAsHex(password.getBytes()) + "ASK")
                        .getBytes());
    }
    
    /**
     * 获取0~max值的随机数(不包括max)
     * @param max
     * @return
     */
    public static int randomNum(int max) {
        return random.nextInt(max);
    }
    
    /**
     * 获取min~max值的随机数(不包括max)
     * @param min
     * @param max
     * @return
     */
    public static int randomNum(int min, int max) {
        return random.nextInt(max - min) + min;
    }
    
    /**
     * 生成{len}位数字随机密码
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
     * 生成{len}位字母的随机字符串
     * @return
     */
    public static String randomLetterStr(int len) {
        String str = "";
        for (int i = 0; i < len; i++) {
            str = str + lowerChars[random.nextInt(26)];
        }
        return str;
    }
    
    /**
     * 生成{len}位字母+数字随机密码
     * @return
     */
    public static String random(int len) {
        String str = "";
        for (int i = 0; i < len; i++) {
            str = str + lowerCharsAndNum[random.nextInt(36)];
        }
        return str;
    }
    
    /**
     * 把string数组生成map
     * 
     * <pre>
     *     vals : [key1,val1,key2,val2.....,keyn,valn]
     *     return :{key1:val1,key2:val2...,keyn:valn}
     * </pre>
     * @param vals
     * @return
     */
    public static Map<String, String> map(String... vals) {
        if (vals == null) {
            return new HashMap<String, String>();
        }
        Map<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < vals.length; i = i + 2) {
            map.put(vals[i], vals[i + 1]);
        }
        return map;
    }
    
    /**
     * 解析key1=val1&key2=val2...
     * @param str
     * @return
     */
    public static String[] strToArr(String str) {
        String[] keyVals = str.split("&");
        String[] vals = new String[keyVals.length * 2];
        
        for (int i = 0; i < keyVals.length; i++) {
            String[] keyVal = keyVals[i].split("=");
            vals[i * 2] = keyVal[0];
            if (keyVal.length == 1) {
                vals[i * 2 + 1] = "";
            }
            if (keyVal.length == 2) {
                vals[i * 2 + 1] = keyVal[1];
            }
        }
        return vals;
    }
    
    /**
     * 生成20位流水号
     * @return
     */
    public static String genSerialNumber() {
        String timestamp = DateUtils.format(new Date(), "yyyyMMddHHmmssSSS");
        int num = atomicInteger.getAndIncrement();
        if (num >= 999) {
            atomicInteger = new AtomicInteger(100);
        }
        return timestamp + num;
    }
    
    /**
     * 获取四舍五入值，保留index位的小数
     * @param d
     * @param index
     * @return
     */
    public static double getNearValue(double d, int index) {
        BigDecimal bd = new BigDecimal(d);
        return getNearValue(bd, index);
    }
    
    /**
     * 获取四舍五入值，保留index位的小数
     * @param d
     * @param index
     * @return
     */
    public static double getNearValue(BigDecimal d, int index) {
        if (d == null) {
            return 0.0;
        }
        return d.setScale(index, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    
    public static String formatAsFundValue(BigDecimal value) {
        return df.format(value.add(new BigDecimal(0.000001)));
    }
    
    public static void main(String[] args) {
        System.out.println(formatAsFundValue(new BigDecimal(23.23)));
        System.out.println(formatAsFundValue(new BigDecimal(23.230)));
        System.out.println(formatAsFundValue(new BigDecimal(23.231)));
        System.out.println(formatAsFundValue(new BigDecimal(23.232)));
        System.out.println(formatAsFundValue(new BigDecimal(23.233)));
        System.out.println(formatAsFundValue(new BigDecimal(23.234)));
        System.out.println(formatAsFundValue(new BigDecimal(23.235)));
        System.out.println(formatAsFundValue(new BigDecimal(23.236)));
        System.out.println(formatAsFundValue(new BigDecimal(23.237)));
        System.out.println(formatAsFundValue(new BigDecimal(23.238)));
        System.out.println(formatAsFundValue(new BigDecimal(23.239)));
        System.out.println(formatAsFundValue(new BigDecimal(23.2)));
        System.out.println(formatAsFundValue(new BigDecimal(23.0)));
        System.out.println(formatAsFundValue(new BigDecimal(23)));
        System.out.println(formatAsFundValue(new BigDecimal(2334)));
    }
}