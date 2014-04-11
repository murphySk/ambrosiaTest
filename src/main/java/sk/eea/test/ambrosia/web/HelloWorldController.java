package sk.eea.test.ambrosia.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Simple index page controller serving hello.jsp file 
 */
//Spring mvc controller
@Controller
public class HelloWorldController {

    /**
     * Simply serves hello.jsp
     * @return view with name 'hello'
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String handleRequest(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "hello";
    }

}
