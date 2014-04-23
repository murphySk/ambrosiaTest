package sk.eea.test.ambrosia.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sk.eea.test.ambrosia.services.EuropeanaDataFetchService;

/**
 * Created by murphy on 3/27/14.
 */
@Controller
public class EuropeanaObjectController {

    @Autowired
    private EuropeanaDataFetchService europeanaDataFetchService;

    @RequestMapping(value = "/allobjects", method = RequestMethod.POST)
    public String showAllObjects() {
        return "allobjects";
    }

    @RequestMapping(value = "/detailedObject", method = RequestMethod.GET)
    public String handleRequestAllObjects() { return "detailedObject"; }

}
