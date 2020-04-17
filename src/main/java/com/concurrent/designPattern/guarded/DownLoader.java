package com.concurrent.designPattern.guarded;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/20
 * Time: 14:46
 * Description: 通过Http的方式从网站下，下载内容
 */
public class DownLoader{
    private static String URL = "https://www.cnblogs.com/tiancai/p/7942201.html";
    public static List<String> download() throws IOException {
        java.net.URL url = new URL(URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        //设置超时间为3秒
        conn.setConnectTimeout(3*1000);
        //防止屏蔽程序抓取而返回403错误
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        String token="v32Eo2Tw+qWI/eiKW3D8ye7l19mf1NngRLushO6CumLMHIO1aryun0/Y3N3YQCv/TqzaO/TFHw4=";
        conn.setRequestProperty("lfwywxqyh_token",token);

        List<String> lines = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()))){
            String line;
            while ((line = bufferedReader.readLine()) != null){
                lines.add(line);
            }
        }
        return lines;

    }

    public static void main(String[] args) {
        try {
            List<String> res = download();
            System.out.println(res.size());
            res.stream().forEach(s -> System.out.println(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
