package cn.tc.WS_Service.d;

import cn.tc.WS_Service.model.Phone;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * 手机的业务类，该业务类通过webservice 对外提供服务
 * 1. 声明： @webservice
 * 2. 发布 EndPoint
 * <p>
 * Created by 聪 on 2017/4/19.
 */
@WebService(serviceName = "PhoneManager", //修改服务名
        targetNamespace = "http:d.WS_Service.tc.cn")//修改命名空间 ，默认包名，取反
//声明该业务类 对外提供webservice服务   ,默认只是对public 修饰的方法对外以webservice形式发布
public class PhoneService {

    /**
     * @WebMethod(operationName="getMObileInfo"): 修改方法名
     * @WebResult(name="phone")：修改返回参数名
     * @WebParam(name="osName")：修改输入参数名
     * @param osName
     * @return
     */
    @WebMethod(operationName = "getMobileInfo")
    public @WebResult(name = "phone")
    Phone getPhoneInfo(@WebParam(name = "osName") String osName) {
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
}
