package sk.eea.test.ambrosia.web;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import sk.eea.test.ambrosia.server.dao.TagDAO;
import sk.eea.test.ambrosia.server.dao.UserDAO;
import sk.eea.test.ambrosia.server.entity.TagEntity;
import sk.eea.test.ambrosia.server.entity.UserEntity;

import java.text.Normalizer;
import java.util.ArrayList;
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
    void addTag(ModelMap model, @RequestParam("tag") String name,@RequestParam("id2") String id2){
        String tagName = name;
        TagEntity tagEntity = new TagEntity();
        UserEntity userEntity = new UserEntity();
        userEntity.setPassword("1111");
        userEntity.setUserName("uzivatel");
        userEntity = userDAO.makePersistent(userEntity);
        tagEntity.setTag(tagName);
        tagEntity.setObjectId(id2);
        System.out.println(tagName+" PRIDAVAM"+ id2 );
        tagName= Normalizer.normalize(tagName, Normalizer.Form.NFD);
        tagName = tagName.replaceAll("\\p{M}", "");
        System.out.println(tagName);
        tagEntity.setNormalizedTag(tagName);
        tagEntity.setUser(userEntity);
        tagDAO.makePersistent(tagEntity);
        System.out.println(tagDAO.findAll().size());
    }

    @RequestMapping(value = "/detailedObject2", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody  JSONArray getTags(ModelMap model, @RequestParam("tag") String partOfTag){
        List<TagEntity> tagEntities = tagDAO.findAll();
        List<TagEntity> finalTagEntities = new ArrayList<TagEntity>();
       // Gson gson = new Gson();
        JSONArray jArray = new JSONArray();


        for(int i = 0; i < tagEntities.size(); i++) {
            if (tagEntities.get(i).getTag().startsWith(partOfTag))
                finalTagEntities.add(tagEntities.get(i));
        }

        String[] finalTagNames = new String[finalTagEntities.size()];
        String[] objectId = new String[finalTagEntities.size()];

        for(int i = 0; i < finalTagEntities.size(); i++){
            finalTagNames[i] = finalTagEntities.get(i).getTag();
            objectId[i] = finalTagEntities.get(i).getObjectId();
           // objectId[i]= "DataObject [tag=" + finalTagEntities.get(i).getTag() + ", id=" + finalTagEntities.get(i).getObjectId() + "]";
            JSONObject object = new JSONObject();
            object.element("tag", finalTagEntities.get(i).getTag());
            object.element("objectId", finalTagEntities.get(i).getObjectId());
            jArray.element(object);
          //  System.out.println(object + " BUUUU");
          //  System.out.println(finalTagNames[i] +" HLADANY");
        }


        //System.out.println(partOfTag +" HLADANY" );
        return jArray;
    }

    void deleteTag(){

    }
}
