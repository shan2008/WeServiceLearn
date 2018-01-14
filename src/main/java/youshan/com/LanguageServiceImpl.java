package youshan.com;

import org.apache.cxf.frontend.ServerFactoryBean;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

/**
 * Created by syou on 2017/12/30.
 *
 */

/**
 * webService 发布方式：

 1.Java 自带发布
 a.带接口发布需要在接口上加上注解@WebService(serviceName = "")  name 可以自定义，则wsdl 文件最下刚绑定服务即为自定义name,
 如果serviceName没写那么服务名称就是类名+Service返回结果可以自定义 名称 WebResult 和WebParam
 发布方式：
 String address="http://127.0.0.1:8888/ws/phoneService";
 Endpoint.publish(address, new PhoneService());

 b.不带接口发布同上 可以排除不需要发布的方法  @WebMethod(exclude = true)

 2.cxf 发布
 LanguageService languageService=new LanguageServiceImpl();
 1.ServerFactoryBean bean=new ServerFactoryBean();//不支持注解,不支持参数返回类型自定义 ，服务名称就是类名
 2.JaxWsServerFactoryBean bean=new JaxWsServerFactoryBean();
 //支持注解,支持参数返回类型自定义 ，服务名称不自定义就是 类型+Service否则就是自定义


//  ServerFactoryBean bean=new ServerFactoryBean();
bean.setAddress("http://127.0.0.1:8999/webServiceLearn/LanguageService");
        bean.setServiceClass(LanguageService.class);
        bean.setServiceBean(languageService);
        bean.getInInterceptors().add(new LoggingInInterceptor()) ;
        bean.getOutInterceptors().add(new LoggingOutInterceptor());
        bean.create();
        }
 */

public class LanguageServiceImpl implements LanguageService {

    public String getLanguage(int position) {
        switch (position){
            case 1: return "java";
            case 2: return "C#";
            case 3: return "c";
            case 4: return "c++";
        }

        return null;
    }

    public static void main(String[] args) {
     LanguageService languageService=new LanguageServiceImpl();
       /**
        *ServerFactoryBean bean=new ServerFactoryBean();//不支持注解
        *  JaxWsServerFactoryBean 支持注解修饰，支持添加拦截器
        */
        JaxWsServerFactoryBean bean=new JaxWsServerFactoryBean();
      //  ServerFactoryBean bean=new ServerFactoryBean();
        bean.setAddress("http://127.0.0.1:8999/webServiceLearn/LanguageService");
        bean.setServiceClass(LanguageService.class);
        bean.setServiceBean(languageService);
        bean.getInInterceptors().add(new LoggingInInterceptor()) ;
        bean.getOutInterceptors().add(new LoggingOutInterceptor());
        bean.create();
    }
}
