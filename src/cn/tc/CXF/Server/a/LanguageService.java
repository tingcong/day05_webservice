package cn.tc.CXF.Server.a;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * Created by 聪 on 2017/4/21.
 */

@WebService
public interface LanguageService {
    public @WebResult(name = "language") String getLanguage(@WebParam(name = "position") int position);
}
