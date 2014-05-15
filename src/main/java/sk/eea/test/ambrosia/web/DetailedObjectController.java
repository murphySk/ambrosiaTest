package sk.eea.test.ambrosia.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import sk.eea.test.ambrosia.server.dao.TagDAO;
import sk.eea.test.ambrosia.server.dao.UserDAO;
import sk.eea.test.ambrosia.server.entity.TagEntity;
import sk.eea.test.ambrosia.server.entity.UserEntity;

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

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "/detailedObject", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody
    void addTag(ModelMap model, @RequestParam("txt") String name){
        String tagName = name;
        TagEntity tagEntity = new TagEntity();
        UserEntity userEntity = new UserEntity();
        userEntity.setPassword("1111");
        userEntity.setUserName("uzivatel");
        userEntity = userDAO.makePersistent(userEntity);
        tagEntity.setTag(tagName);
        System.out.println(tagName+" PRIDAVAM" );
        tagName= Normalizer.normalize(tagName, Normalizer.Form.NFD);
        tagName=tagName.replaceAll("\\p{M}", "");
        //System.out.println(tagName);
        tagEntity.setNormalizedTag(tagName);
        tagEntity.setUser(userEntity);
        tagDAO.makePersistent(tagEntity);

    }

    @RequestMapping(value = "/detailedObject2", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody
    String getTags(ModelMap model, @RequestParam("txt2") String partOfTag){
        TagEntity tagEntity = new TagEntity();
       // List<TagEntity> tagEntities= tagDAO.findByExample(tagEntity, partOfTag);
        System.out.println(partOfTag+"HLADAM");
        return partOfTag;
    }

    void deleteTag(){

    }
}
