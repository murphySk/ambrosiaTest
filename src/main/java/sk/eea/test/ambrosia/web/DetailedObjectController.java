package sk.eea.test.ambrosia.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import sk.eea.test.ambrosia.server.dao.TagDAO;
import sk.eea.test.ambrosia.server.entity.TagEntity;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.Normalizer;
import java.util.List;

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
       /* TagEntity tagEntity = new TagEntity();
        tagEntity.setTag(tagName);
        System.out.println(tagName);
        tagName= Normalizer.normalize(tagName, Normalizer.Form.NFD);
        tagName=tagName.replaceAll("\\p{M}", "");
        System.out.println(tagName);
        tagEntity.setNormalizedTag(tagName);
        tagDAO.makePersistent(tagEntity);*/

    }

    void getTags(String[] partOfTag){
        //TagEntity tagEntity = new TagEntity();
        //List<TagEntity> tagEntities= tagDAO.findByExample(tagEntity, partOfTag);

    }

    void deleteTag(){

    }
}
