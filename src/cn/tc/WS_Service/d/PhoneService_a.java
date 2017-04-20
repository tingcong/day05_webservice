package cn.tc.WS_Service.d;

import cn.tc.WS_Service.model.Phone;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * Created by 聪 on 2017/4/20.
 */
@WebService //声明该业务类
public class PhoneService_a {
    public Phone getPhoneInfo( String osName) {
        Phone phone = new Phone();
        if (osName.endsWith("android")) {
            phone.setName("android");
            phone.setOwner("google");
            phone.setTotal(80);
        } else if (osName.endsWith("ios")) {
            phone.setName("ios");
            phone.setOwner("apple");
            phone.setTotal(15);
        } else {
            phone.setName("windows phone");
            phone.setOwner("microsoft");
            phone.setTotal(5);
        }
        return phone;
    }

    public static void main(String[] args) {
        String address = "http://127.0.0.1:8008/ws/phoneService";
        //发布webservice
        Endpoint.publish(address,new PhoneService());
        System.out.println("PhoneService服务请访问 wsdl地址 :" + address + "?WSDL");
    }
}
