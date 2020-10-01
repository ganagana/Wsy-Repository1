package com.wsy.util;

import javax.servlet.http.HttpServletRequest;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * @author: wsy
 * Date: 2020/9/29
 * Time: 23:34
 * Description: No Description
 */
public class BaseUtil {
    /**
     * 判断请求是否是Ajax
     *
     * @param request
     * @return
     */
    public static boolean judgeRequestType(HttpServletRequest request) {
        //获取请求头
        String acceptHeader = request.getHeader("Accept");
        String xRequestHeader = request.getHeader("X-Requested-With");
        //判断
        return (acceptHeader != null && acceptHeader.contains("application/json")) || (xRequestHeader != null && xRequestHeader.equals("XMLHttpRequest"));
    }

    /**
     * 手机号判定
     *
     * @param str
     * @return
     * @throws PatternSyntaxException
     */
    public static boolean isChinaPhoneLegal(String str) {
        String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    /**
     * 判断中文以及标点
     *
     * @param str
     * @return
     */
    public static boolean isContainChinese(String str) {
        Pattern pattern = Pattern.compile("[\u4E00-\u9FA5|\\！|\\，|\\。|\\（|\\）|\\《|\\》|\\“|\\”|\\？|\\：|\\；|\\【|\\】]");
        Matcher m = pattern.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }
    /**
     * 发送短信
     * @param phoneNum 电话号码
     *
     */
    public static Msg sendShortMessage(String phoneNum) {
        String appCode="f52857fa7e6b497cb4ce91fdc60521dd";
        String sign="1";
        String skin="2";
        String host="https://feginesms.market.alicloudapi.com";
        String path="/codeNotice";
        //生成验证码
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int random = (int) (Math.random() * 10);
            builder.append(random);
        }
        String param = builder.toString();
        // 【5】拼接请求链接
        String urlSend = host + path + "?sign=" + sign + "&skin=" + skin + "&param=" + param + "&phone=" + phoneNum;
        try {
            URL url = new URL(urlSend);
            HttpURLConnection httpURLCon = (HttpURLConnection) url.openConnection();
            // 格式Authorization:APPCODE
            // (中间是英文空格)
            httpURLCon.setRequestProperty("Authorization", "APPCODE " + appCode);
            int httpCode = 0;
            httpCode = httpURLCon.getResponseCode();
            if (httpCode == 200) {
//                String json = read(httpURLCon.getInputStream());
                return Msg.ok("发送成功！",param);
            }
            if (httpCode != 200) {
                Map<String, List<String>> map = httpURLCon.getHeaderFields();
                String error = map.get("X-Ca-Error-Message").get(0);
                return Msg.error("发送失败！",error);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Msg.error("发送失败！",e.getMessage());
        }
        return null;
    }
}
