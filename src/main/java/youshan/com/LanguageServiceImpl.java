package youshan.com;

import org.apache.cxf.frontend.ServerFactoryBean;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

/**
 * Created by syou on 2017/12/30.
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
        bean.setAddress("http://127.0.0.1:8999/webServiceLearn/LanguageService");
        bean.setServiceClass(LanguageService.class);
        bean.setServiceBean(languageService);
        bean.getInInterceptors().add(new LoggingInInterceptor()) ;
        bean.getOutInterceptors().add(new LoggingOutInterceptor());
        bean.create();
    }
}
