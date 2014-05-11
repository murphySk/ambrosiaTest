package sk.eea.test.ambrosia.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import sk.eea.test.ambrosia.server.dao.TagDAO;
import sk.eea.test.ambrosia.server.entity.TagEntity;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by marti_000 on 4/25/2014.
 */

@Controller
public class DetailedObjectController {

    @Autowired
    private TagDAO tagDAO;

    @RequestMapping(value = "/detailedObject", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody
    void addTag(ModelMap model, @RequestParam("txt") String name){
        String tagName = name;

        /*TagEntity tagEntity = new TagEntity();
        tagEntity.setNormalizedTag(tagName);
        tagEntity.setTag(tagName);
        tagName.replaceAll(" ","-");
        tagEntity.setUser(null);
        tagDAO.makePersistent(tagEntity); */
        System.out.println(tagName);
        //model.addAttribute(tagName);
    }
}
