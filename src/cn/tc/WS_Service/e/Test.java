package cn.tc.WS_Service.e;

import javax.xml.ws.Endpoint;

/**
 * Created by 聪 on 2017/4/20.
 */
public class Test {
    public static void main(String[] args) {
        JobService jobService=new JobServiceImpl();
        String address="http://127.0.0.1:9999/ws/jobservice";
        Endpoint.publish(address, jobService);
        System.out.println("wsdl地址:"+address+"?WSDL");

    }
}
