package sk.eea.test.ambrosia.server.dao.impl;

import org.junit.Test;
import sk.eea.test.ambrosia.ApplicationContextAwareTest;
import sk.eea.test.ambrosia.server.dao.DAOUser;
import sk.eea.test.ambrosia.server.entity.Tag;
import sk.eea.test.ambrosia.server.entity.User;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by marti_000 on 3/28/2014.
 */
public class TestPerson extends ApplicationContextAwareTest{

    @Resource
    private DAOUser daoUser;

    @Test
    public void testPersistTestEntity() {
        int countBefore = daoUser.findAll().size();
        User user = new User();
        daoUser.makePersistent(user);

        int countAfter = daoUser.findAll().size();
        assertEquals(countBefore + 1, countAfter);
    }

    @Test
    public void testUpdateTestEntity() {
        User user = new User();
        daoUser.makePersistent(user);
        int countBefore = daoUser.findAll().size();

        User user2 = new User();

        user2 = daoUser.findById(user.getId(), false);
        daoUser.makePersistent(user2);
        int countAfter = daoUser.findAll().size();
        assertEquals(countBefore, countAfter);
    }
    @Test
    public void testDelete() {
        User user = new User();
        daoUser.makePersistent(user);
        int countBefore = daoUser.findAll().size();

        daoUser.makeTransient(user);
        int countAfter = daoUser.findAll().size();
        assertEquals(countBefore - 1, countAfter);
        assertTrue(user.isDeleted());

    }
    @Test
    public void testOneToMany() {
        User user = new User();
        Tag tag = new Tag(user);
        Tag tag2 = new Tag(user);
        user.getTags().add(tag);
        user.getTags().add(tag2);

        assertEquals(user.getTags().size(), 2);

    }
}
