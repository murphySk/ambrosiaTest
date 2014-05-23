package sk.eea.test.ambrosia.web;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import sk.eea.test.ambrosia.server.dao.ObjectIdDAO;
import sk.eea.test.ambrosia.server.dao.TagDAO;
import sk.eea.test.ambrosia.server.dao.UserDAO;
import sk.eea.test.ambrosia.server.entity.ObjectIdEntity;
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

    @Autowired
    private ObjectIdDAO objectIdDAO;

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
        ObjectIdEntity objectIdEntity = new ObjectIdEntity();
        objectIdEntity.setEuropObjectId(id2);
        objectIdEntity = objectIdDAO.makePersistent(objectIdEntity);
        //tagEntity.setObjectId(id2);
        System.out.println(tagName+" PRIDAVAM"+ id2 );
        tagName= Normalizer.normalize(tagName, Normalizer.Form.NFD);
        tagName = tagName.replaceAll("\\p{M}", "");
        System.out.println(tagName);
        tagEntity.setNormalizedTag(tagName);
        tagEntity.setUser(userEntity);
        tagEntity.setObjectId(objectIdEntity);
        //System.out.println(tagEntity.getObjectId().getEuropObjectId()+"WAAAAAW" );

        tagEntity=tagDAO.makePersistent(tagEntity);
        System.out.println(tagEntity.getObjectId().getEuropObjectId()+"WAAAAAW" );
        System.out.println(tagDAO.findAll().size());
    }

    @RequestMapping(value = "/detailedObject2", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody  JSONArray getTags(ModelMap model, @RequestParam("tag") String partOfTag){
        List<TagEntity> tagEntities = tagDAO.findAll();
        List<TagEntity> finalTagEntities = new ArrayList<TagEntity>();
        JSONArray jArray = new JSONArray();
        System.out.println("SOM TUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");

        for(int i = 0; i < tagEntities.size(); i++) {
            if (tagEntities.get(i).getTag().startsWith(partOfTag))
                finalTagEntities.add(tagEntities.get(i));
        }



        for(int i = 0; i < finalTagEntities.size(); i++){
            JSONObject object = new JSONObject();
            object.element("tag", finalTagEntities.get(i).getTag());
            System.out.println(finalTagEntities.get(i).getObjectId().getEuropObjectId()+" OBJECTIDDDD???????");
            object.element("objectId", finalTagEntities.get(i).getObjectId().getEuropObjectId());
            jArray.element(object);
          }


        return jArray;
    }

    @RequestMapping(value = "/detailedObject3", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody  JSONArray getTagsForObject(ModelMap model, @RequestParam("idObject") String idObject){
        List<TagEntity> tagEntities = tagDAO.findAll();
        List<TagEntity> finalTagEntities = new ArrayList<TagEntity>();
        JSONArray jArray = new JSONArray();
        //System.out.println(idObject+" IDOBJECT!!!!!!!");
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
       // System.out.println(tagEntities.get(0).getObjectId().getEuropObjectId()+"  !!!!!!!!!!  "+idObject);
        for(int i = 0; i < tagEntities.size(); i++) {
            System.out.println(tagEntities.get(i).getObjectId().getEuropObjectId()+"  !!!!!!!!!!  "+idObject);
            if (tagEntities.get(i).getObjectId().getEuropObjectId().compareTo(idObject)==0) {
              //  System.out.println("PRESLO");
                finalTagEntities.add(tagEntities.get(i));
            }
        }



        for(int i = 0; i < finalTagEntities.size(); i++){

            JSONObject object = new JSONObject();
            object.element("tag", finalTagEntities.get(i).getTag());
           // System.out.println(finalTagEntities.get(i).getTag()+"TAAAAG");
            jArray.element(object);
        }


        return jArray;
    }

    void deleteTag(){

    }
}
