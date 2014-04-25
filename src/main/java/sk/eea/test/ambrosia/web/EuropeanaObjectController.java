package sk.eea.test.ambrosia.web;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sk.eea.test.ambrosia.server.entity.DetailedObjectEntity;
import sk.eea.test.ambrosia.server.entity.EuropeanaObjectEntity;
import sk.eea.test.ambrosia.services.EuropeanaDataFetchService;
import sk.eea.test.ambrosia.services.impl.EuropeanaDataFetchServiceImpl;
import sk.eea.test.ambrosia.services.impl.EuropeanaObjectParserImpl;
import sk.eea.test.ambrosia.services.impl.HttpConnection;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by murphy on 3/27/14.
 */
@Controller
public class EuropeanaObjectController {

    @Autowired
    private EuropeanaDataFetchService europeanaDataFetchService;

    @RequestMapping(value = "/allobjects", method = RequestMethod.POST)
    public String showAllObjects(ModelMap model, HttpServletRequest request) {
        EuropeanaObjectParserImpl dummyPars = new EuropeanaObjectParserImpl();
        EuropeanaDataFetchServiceImpl con = new EuropeanaDataFetchServiceImpl();
        String term = request.getParameter("term");
        try {
            List<EuropeanaObjectEntity> list = dummyPars.parseObjects(con.sendHttpGetRequest(term));
            model.addAttribute("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "allobjects";
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String handleRequestAllObjects(ModelMap model, HttpServletRequest request) {
        final String USER_AGENT="Mozzila/5.0";
        EuropeanaObjectParserImpl dummyPars = new EuropeanaObjectParserImpl();
        EuropeanaDataFetchServiceImpl con = new EuropeanaDataFetchServiceImpl();
        DetailedObjectEntity obj;

        String id= request.getParameter("id");

        String url="http://europeana.eu/api/v2/record/"+id+".json?wskey=PaVZsTDPQ";
        try {
            String list =con.sendHttpGetRequest2(url);
            obj = dummyPars.parseSimpleRecord(list);
            model.addAttribute("obj", obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
      /* try {
            List<EuropeanaObjectEntity> list = dummyPars.parseObjects(id);
            model.addAttribute("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        return "detailedObject";
    }

}
