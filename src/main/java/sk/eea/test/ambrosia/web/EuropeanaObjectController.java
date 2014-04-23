package sk.eea.test.ambrosia.web;

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sk.eea.test.ambrosia.server.entity.EuropeanaObjectEntity;
import sk.eea.test.ambrosia.services.EuropeanaDataFetchService;
import sk.eea.test.ambrosia.services.impl.EuropeanaObjectParserImpl;
import sk.eea.test.ambrosia.services.impl.HttpConnection;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by murphy on 3/27/14.
 */
@Controller
public class EuropeanaObjectController {

//    @Autowired
//    private EuropeanaDataFetchService europeanaDataFetchService;

    @RequestMapping(value = "/allobjects", method = RequestMethod.GET)
    public String showAllObjects(ModelMap model, HttpServletRequest request) {
        EuropeanaObjectParserImpl dummyPars = new EuropeanaObjectParserImpl();
        HttpConnection con = new HttpConnection();
        String term = request.getParameter("term");
        try {
            List<EuropeanaObjectEntity> list = dummyPars.parseObjects(con.sendGet(term));
            model.addAttribute("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "allobjects"; }

    @RequestMapping(value = "/detailedObject", method = RequestMethod.GET)
    public String handleRequestAllObjects() { return "detailedObject"; }

}
