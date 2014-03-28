package sk.eea.test.ambrosia.server.dao.impl;

/**
 * Created by Silvia on 28. 3. 2014.
 */
import static org.junit.Assert.*;

import org.hsqldb.User;
import org.junit.Test;
//import sk.eea.test.ambrosia.server.UserDAO;
import sk.eea.test.ambrosia.server.entity.Tag;
import sk.eea.test.ambrosia.server.entity.UserEntity;
import sk.eea.test.ambrosia.ApplicationContextAwareTest;

import javax.annotation.Resource;

public class TestsForUser extends ApplicationContextAwareTest{
    @Resource
    private UserDAO userdao;

    @Test
    public void testPersistTestEntity() {
        int countBefore = userdao.findAll().size();
        UserEntity userEntity = new UserEntity();
        userdao.makePersistent(userEntity);

        int countAfter = userdao.findAll().size();
        assertEquals(countBefore + 1, countAfter);
    }

    @Test
    public void testUpdate(){
        UserEntity userEntity = new UserEntity();
        userdao.makePersistent(userEntity);
        int countBefore = userdao.findAll().size();
        UserEntity userEntity2 = userdao.findById(userEntity.getId(),false);
        userdao.makePersistent(userEntity2);
        int countAfter = userdao.findAll().size();
        assertEquals(countBefore , countAfter);

    }

    @Test
    public void delete(){
        UserEntity userEntity = new UserEntity();
        userdao.makePersistent(userEntity);
        int countBefore = userdao.findAll().size();
        userdao.makeTransient(userEntity);
        int countAfter = userdao.findAll().size();
        assertTrue(userEntity.isDeleted());
       // assertEquals(countBefore-1 , countAfter);
    }

    @Test
    public void testOneToMany(){
        UserEntity user = new UserEntity();
        Tag tag = new Tag();
        tag.setUser(user);
        user.getTag().add(tag);
        Tag tag2 = new Tag();
        tag2.setUser(user);
        user.getTag().add(tag2);
        int size=user.getTag().size();
        assertEquals( size , 2);
    }

}
