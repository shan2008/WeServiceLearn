package youshan.com;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * Created by syou on 2017/12/30.
 */
@WebService(serviceName = "languageManager")
public interface LanguageService {
    @WebResult(name="result") String getLanguage(@WebParam(name="position")int position);
}
