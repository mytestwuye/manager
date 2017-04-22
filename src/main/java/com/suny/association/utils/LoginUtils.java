package com.suny.association.utils;

import com.google.gson.Gson;
import com.suny.association.pojo.po.baiduLocation.GeneralLocationResult;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.util.Objects;

/**
 * Comments:    获取登录用户的信息工具
 * Author:   孙建荣
 * Create Date: 2017/04/20 19:57
 */
public class LoginUtils {

    public static GeneralLocationResult getGeneralLocation(String ip) {
        String city;   //定位到的城市
        String status;    //定位的状态
        String ipString = null;    // ip地址
        String jsonData = null;    //服务器返回的json数据
        try {
            ipString = URLEncoder.encode(ip, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String key = "8256e813b3dec54c5a6aac371c05e5eaa";   // 百度定位密匙
        String url = String.format("http://api.map.baidu.com/location/ip?ak=%s&ip=%s&coor=bd09ll", key, ipString);
        URL myUrl = null;
        URLConnection urlConnection = null;
        try {
            myUrl = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            urlConnection = myUrl != null ? myUrl.openConnection() : null;   //　不使用代理进行访问
            if (urlConnection != null) {
                inputStreamReader = new InputStreamReader(urlConnection.getInputStream(), "UTF-8");
                bufferedReader = new BufferedReader(inputStreamReader);
                String data;
                while ((data = bufferedReader.readLine()) != null) {
                    jsonData += data;
                }
                return parseJsonDate(jsonData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 解析百度传回来的json数据
     *
     * @param jsonData json数据
     * @return 得到的结果
     */
    private static GeneralLocationResult parseJsonDate(String jsonData) {
        GeneralLocationResult generalLocationResult = new GeneralLocationResult();
        /*这里对文本进行解析，因为此时返回的是一个返回的是请求出错的json数据
            * 返回格式是统一的类型，所以我们进行切割得到状态码
            * 统一状态码大概是这样的：   null{"status":2,"message":"Request Parameter Error:ip illegal"}
            * 其中status后面的数字是会变的，然后message也是根据不同的状态码来变的   */
        int statusTextIndex = jsonData.indexOf("status\":");
        int messageTextIndex = jsonData.indexOf(",\"message");
        int statusCode = Integer.parseInt(jsonData.substring(statusTextIndex + 8, messageTextIndex));
        /*   如果返回的文本不等于空的话，并且包含状态码0的话就说明百度成功定位了  */
        if (statusCode == 0) {
            Gson gson = new Gson();
        /*  使用Google的 Gson 把json数据封装到实体类里面去   */
            generalLocationResult = gson.fromJson(jsonData, GeneralLocationResult.class);
            return generalLocationResult;
        } else {
            generalLocationResult.setStatus(200);
            return generalLocationResult;
        }
    }


    /**
     * 获取客户端ip地址(可以穿透代理)
     */
    public static String getRemoteAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    private static final String[] HEADERS_TO_TRY = {
            "X-Forwarded-For",
            "Proxy-Client-IP",
            "WL-Proxy-Client-IP",
            "HTTP_X_FORWARDED_FOR",
            "HTTP_X_FORWARDED",
            "HTTP_X_CLUSTER_CLIENT_IP",
            "HTTP_CLIENT_IP",
            "HTTP_FORWARDED_FOR",
            "HTTP_FORWARDED",
            "HTTP_VIA",
            "REMOTE_ADDR",
            "X-Real-IP"};

    /***
     * 获取客户端ip地址(可以穿透代理)
     */
    public static String getClientIpAddress(HttpServletRequest request) {
        for (String header : HEADERS_TO_TRY) {
            String ip = request.getHeader(header);
            if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
                return ip;
            }
        }
        return request.getRemoteAddr();
    }

    /***
     * 获取客户端ip地址(可以穿透代理)
     */
    public static String getClientIpAdder(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_CLUSTER_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_FORWARDED");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_VIA");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("REMOTE_ADDR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if ("127.0.0.1".equals(ip) || "0:0:0:0:0:0:0:1".equals(ip))
            try {
                ip = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException ignored) {
            }
        return ip;
    }

    public static String getOSVersion(String userAgent) {
        if (Objects.equals(userAgent, "") || userAgent == null) {
            return "UnKnown";
        }
        if (userAgent.contains("Windows")) {//主流应用靠前
            if (userAgent.contains("Windows NT 10.0")) {//Windows 10
                return "Windows10";//判断浏览器
            } else if (userAgent.contains("Windows NT 6.2")) {//Windows 8
                return "Windows8";//判断浏览器
            } else if (userAgent.contains("Windows NT 6.1")) {//Windows 7
                return "Windows7";
            } else if (userAgent.contains("Windows NT 6.0")) {//Windows Vista
                return "WindowsVista";
            } else if (userAgent.contains("Windows NT 5.2")) {//Windows XP x64 Edition
                return "WindowsXP x64 Edition";
            } else if (userAgent.contains("Windows NT 5.1")) {//Windows XP
                return "WindowsXP";
            } else if (userAgent.contains("Windows NT 5.01")) {//Windows 2000, Service Pack 1 (SP1)
                return "Windows2000 SP1";
            } else if (userAgent.contains("Windows NT 5.0")) {//Windows 2000
                return "Windows2000";
            } else if (userAgent.contains("Windows NT 4.0")) {//Microsoft Windows NT 4.0
                return "WindowsNT 4.0";
            } else if (userAgent.contains("Windows 98; Win 9x 4.90")) {//Windows Millennium Edition (Windows Me)
                return "WindowsME";
            } else if (userAgent.contains("Windows 98")) {//Windows 98
                return "Windows98";
            } else if (userAgent.contains("Windows 95")) {//Windows 95
                return "Windows95";
            } else if (userAgent.contains("Windows Phone")) {//Windows Phone
                return getOSDetail("Windows", userAgent);
            } else if (userAgent.contains("Windows CE")) {//Windows CE
                return "WindowsCE";
            }
            return "Windows";
        } else if (userAgent.contains("Mac OS X")) {
            if (userAgent.contains("iPhone")) {
                if (userAgent.contains("iPhone 4")) {
                    return "iPhone 4";//判断浏览器
                } else if (userAgent.contains("iPhone 4S")) {
                    return "iPhone 4S";//判断浏览器
                } else if (userAgent.contains("iPhone 5")) {
                    return "iPhone 5";//判断浏览器
                } else if (userAgent.contains("iPhone 5S")) {
                    return "iPhone 5S";//判断浏览器
                } else if (userAgent.contains("iPhone 6")) {
                    return "iPhone 6";//判断浏览器
                } else if (userAgent.contains("iPhone 6S")) {
                    return "iPhone 6S";//判断浏览器
                } else if (userAgent.contains("iPhone ; U ;")) {
                    return "iPhone";//判断浏览器
                }
                return "iPhone";
            }
            if (userAgent.contains("iPod")) {
                return "iPod";//判断浏览器
            } else if (userAgent.contains("iPad")) {
                return "iPad";//判断浏览器
            } else if (userAgent.contains("iPad2")) {
                return "iPad2";//判断浏览器
            }
            return "Mac OS X";
        } else if (userAgent.contains("Linux")) {
            if (userAgent.contains("Android")) {
                return getOSDetail("Android", userAgent);
            }
            return "Linux";
        } else if (userAgent.contains("Ubuntu")) {
            return "Ubuntu";
        } else if (userAgent.contains("x11")) {
            return "Unix";
        }
        return "UnKnown";
    }

    private static String getOSDetail(String simpleName, String userAgent) {
        int simpleNameIndex = userAgent.indexOf(simpleName);
        String simpleNameText = userAgent.substring(simpleNameIndex);
        int osDetailLength = simpleNameText.split(";").length;
        if (osDetailLength > 12) {
            return simpleNameText.split("\\)")[0];
        }
        return simpleNameText.split(";")[0];
    }


    public static String getBrowserInfo(String userAgent) {
        String UserAgent = userAgent.toLowerCase();
        if (UserAgent.contains("edge")) {
            return (userAgent.substring(UserAgent.indexOf("edge")).split(" ")[0]).replace("/", "-");
        } else if (UserAgent.contains("ucbrowser") || UserAgent.contains("ubrowser")) {
            if (UserAgent.contains("ucbrowser")) {
                return (UserAgent.substring(UserAgent.indexOf("ucbrowser")).split(" ")[0]).replace("/", "-").replace("ucbrowser", "UC浏览器");
            } else if (UserAgent.contains("ubrowser")) {
                return (UserAgent.substring(UserAgent.indexOf("ubrowser")).split(" ")[0]).replace("/", "-").replace("ubrowser", "UC浏览器");
            }
        } else if (UserAgent.contains("msie")) {
            if (userAgent.contains("MSIE 11.0")) {//Internet Explorer 10
                return "Internet Explorer11";
            } else if (userAgent.contains("MSIE 10.0")) {//Internet Explorer 10
                return "Internet Explorer10";
            } else if (userAgent.contains("MSIE 9.0")) {//Internet Explorer 9
                return "Internet Explorer9";
            } else if (userAgent.contains("MSIE 8.0")) {//Internet Explorer 8
                return "Internet Explorer8";
            } else if (userAgent.contains("MSIE 7.0")) {//Internet Explorer 7
                return "Internet Explorer7";
            } else if (userAgent.contains("MSIE 6.0")) {//Internet Explorer 6
                return "Internet Explorer6";
            }
//            return "Internet Explorer";
            String substring = userAgent.substring(UserAgent.indexOf("msie")).split(";")[0];
            return substring.replace("MSIE", "IE").replace(" ", "-");
        } else if (UserAgent.contains("safari") && UserAgent.contains("version")) {
            return (userAgent.substring(userAgent.indexOf("Safari")).split(" ")[0]).split("/")[0] + "-" + (userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
        } else if (UserAgent.contains("opr") || UserAgent.contains("opera")) {
            if (UserAgent.contains("opera")) {
                return (userAgent.substring(UserAgent.indexOf("opera")).split(" ")[0]).split("/")[0] + "-" + (userAgent.substring(UserAgent.indexOf("version")).split(" ")[0]).split("/")[1];
            } else if (UserAgent.contains("opr")) {
                return ((userAgent.substring(UserAgent.indexOf("opr")).split(" ")[0]).replace("/", "-")).replace("OPR", "Opera");
            }
        } else if (UserAgent.contains("chrome")) {
            return (userAgent.substring(userAgent.indexOf("Chrome")).split(" ")[0]).replace("/", "-");
        } else if (UserAgent.contains("firefox")) {
            return (userAgent.substring(userAgent.indexOf("Firefox")).split(" ")[0]).replace("/", "-");
        } else if (UserAgent.contains("360SE")) {
            return "360安全浏览器";
        } else if (UserAgent.contains("QIHU 360EE")) {
            return "360急速浏览器";
        } else if (UserAgent.contains("Maxthon")) {
            return "傲游浏览器";
        } else if (UserAgent.contains("rv")) {
            String IEVersion = (userAgent.substring(userAgent.indexOf("rv")).split(" ")[0]).replace("rv:", "-");
            return "IE" + IEVersion.substring(0, IEVersion.length() - 1);
        }
        return "UnKnown";

    }


}
