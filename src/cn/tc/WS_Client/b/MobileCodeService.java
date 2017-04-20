package cn.tc.WS_Client.b;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 调用第三方的webservice服务 (http://www.webxml.com.cn/zh_cn/index.aspx)，获取电话号码信息
 *
 * Created by 聪 on 2017/4/19.
 */


public class MobileCodeService {
    //  1.  http-get方式访问webservice
    public void get(String mobileCode,String userID)throws Exception{
        URL url=new URL("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx/getMobileCodeInfo?mobileCode="+mobileCode+"&userID="+userID);

        HttpURLConnection connection= (HttpURLConnection) url.openConnection();

        connection.setConnectTimeout(5000);
        connection.setRequestMethod("GET");
        if(connection.getResponseCode()==HttpURLConnection.HTTP_OK){    //结果码200
            InputStream is=connection.getInputStream();

            //内存流
            ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
            byte[] buffer=new byte[1024];
            int len=-1;
            if((len=is.read(buffer))!=-1){
                byteArrayOutputStream.write(buffer,0,len);
            }

            System.out.println("GET请求获取的数据："+byteArrayOutputStream.toString());
            byteArrayOutputStream.close();
            is.close();
        }
    }

    //  2.post请求：通过Http-client框架模拟实现http请求
    public void post(String mobileCode,String userID) throws Exception{
        /**
         * HttpClient访问网络的实现步骤
         *  1.准备一个请求客户端：浏览器
         *  2.准备请求方式：GET/POST
         *  3.设置传递的参数
         *  4.执行请求
         *  5.获取结果
         */
        HttpClient client=new HttpClient();
        PostMethod postMethod=new PostMethod("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx/getMobileCodeInfo");
        //设置请求参数(封装在请求体中)
        postMethod.setParameter("mobileCode",mobileCode);
        postMethod.setParameter("userID",userID);
        //执行请求，结果码
        int code=client.executeMethod(postMethod);
        //获取结果
        String result=postMethod.getResponseBodyAsString();
        System.out.println("post请求结果："+result);
    }

    public void soap() throws Exception{
        HttpClient client=new HttpClient();
        PostMethod postMethod=new PostMethod("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx");
        //设置请求参数
        postMethod.setRequestBody(new FileInputStream("C:/Users/胡廷聪/Desktop/JavaPJ/day05_webservice/src/soap.xml"));
        //修改请求的头部
        postMethod.setRequestHeader("Context-Type","text/xml;charset=utf-8");
        //执行请求，结果码
        int code=client.executeMethod(postMethod);
        System.out.println("结果码："+code);
        //获取结果
        String result=postMethod.getResponseBodyAsString();
        System.out.println("soap Post请求结果："+result);
    }

    public static void main(String[] args) throws Exception {
        MobileCodeService ws=new MobileCodeService();
        ws.get("13062829857","");

        ws.post("15179690961","");

        ws.soap();
    }
}
