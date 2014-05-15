package sk.eea.test.ambrosia.server;

import junit.framework.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sk.eea.test.ambrosia.ApplicationContextAwareTest;
import sk.eea.test.ambrosia.server.dao.TagDAO;
import sk.eea.test.ambrosia.server.dao.UserDAO;
import sk.eea.test.ambrosia.server.entity.TagEntity;
import sk.eea.test.ambrosia.server.entity.UserEntity;

import javax.annotation.Resource;
import java.text.Normalizer;

/**
 * Created by murphy on 3/28/14.
 */
public class UserTagTest extends ApplicationContextAwareTest {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private TagDAO tagDAO;

    @Test
    public void testUserInsert() {
        UserEntity userEntity = new UserEntity();
        userEntity.setPassword("1111");
        userEntity.setUserName("uzivatel");

        int size = userDAO.findAll().size();
        userDAO.makePersistent(userEntity);
        Assert.assertEquals(size + 1, userDAO.findAll().size());
    }

    @Test
    public void testUserTagInsert() {
        UserEntity userEntity = new UserEntity();
        userEntity.setPassword("1111");
        userEntity.setUserName("uzivatel");
        userEntity = userDAO.makePersistent(userEntity);

        TagEntity tagEntity = new TagEntity();
        tagEntity.setNormalizedTag("uzivatel-tag");
        tagEntity.setTag("uzivatel tag");
        tagEntity.setUser(userEntity);
        int size = tagDAO.findAll().size();
        tagEntity = tagDAO.makePersistent(tagEntity);

        Assert.assertEquals(size + 1, tagDAO.findAll().size());
    }


    @Test
    public void testTagInsert() {
        String tagName = "čťtbbuzťz jniu";
        TagEntity tagEntity = new TagEntity();
        UserEntity userEntity = new UserEntity();
        userEntity.setPassword("1111");
        userEntity.setUserName("uzivatel");
        userEntity = userDAO.makePersistent(userEntity);
        tagEntity.setTag(tagName);
        System.out.println(tagName);
        tagName= Normalizer.normalize(tagName, Normalizer.Form.NFD);
        tagName=tagName.replaceAll("\\p{M}", "");
        System.out.println(tagName);
        tagEntity.setNormalizedTag(tagName);
        tagEntity.setUser(userEntity);
        int size = tagDAO.findAll().size();
        tagDAO.makePersistent(tagEntity);

        Assert.assertEquals(size + 1, tagDAO.findAll().size());
    }

}
