package cn.tc.WS_Client.d;

/**
 * 测试自己发布的  webservice(PhoneService服务)
 *
 * Created by 聪 on 2017/4/20.
 */
public class _Main {
    public static void main(String[] args) {
        //创建服务对象    http://127.0.0.1:8008/ws/phoneService?WSDL 的<service name="PhoneManager">
        PhoneManager phoneManager=new PhoneManager();
        //访问方式      http://127.0.0.1:8008/ws/phoneService?WSDL 的 <port name="PhoneServicePort" binding="tns:PhoneServicePortBinding">
        PhoneService phoneService=phoneManager.getPhoneServicePort();

        //调用PhoneService的方法
        Phone phoneInfo=phoneService.getMobileInfo("ios");

        System.out.println(phoneInfo.getName()+" - "+phoneInfo.getOwner()+" - "+phoneInfo.getTotal());
    }
}
