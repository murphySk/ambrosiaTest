package sk.eea.test.ambrosia.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by marti_000 on 4/25/2014.
 */

@Controller
public class DetailedObjectController {
    @RequestMapping(value = "/detailedObject", method = RequestMethod.GET)
    public String showDetailedObject(ModelMap model, HttpServletRequest request){


        return "detailedObject";
    }
}
