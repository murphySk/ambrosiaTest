package sk.eea.test.ambrosia.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import sk.eea.test.ambrosia.server.dao.TagDAO;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by marti_000 on 4/25/2014.
 */

@Controller
public class DetailedObjectController {

    @RequestMapping(value = "/detailedObject", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void addTag(ModelMap model, HttpServletRequest request){
        String tagName = request.getParameter("tagName");
        System.out.println(tagName);
        //model.addAttribute(tagName);
    }
}
