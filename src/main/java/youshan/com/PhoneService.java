package youshan.com;

import sun.net.www.http.HttpClient;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * Created by syou on 2017/12/30.
 */
@WebService(serviceName = "PhoneManager") //声明对外服务
public class PhoneService {

    public @WebResult(name="phone") Phone getphoneInfo(@WebParam(name="osName")String osName){
        Phone phone=new Phone();
        phone.setOsName(osName);
        phone.setTotal(5);
        return phone;
    }

    public static void main(String[] args) {
        String address="http://127.0.0.1:8888/ws/phoneService";
        Endpoint.publish(address, new PhoneService());
    }

    @WebMethod(exclude = true) //排除
    public void sayHello(){
        System.out.println("hello world");
    }
}
