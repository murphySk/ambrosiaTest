package sk.eea.test.ambrosia.server.dao.impl;

import javax.annotation.Resource;

import org.junit.Test;

import sk.eea.test.ambrosia.ApplicationContextAwareTest;
import sk.eea.test.ambrosia.server.dao.DummyDAO;
import sk.eea.test.ambrosia.server.entity.DummyEntity;

import static org.junit.Assert.assertEquals;

/**
 * 
 */
public class SimpleIntegrationTest extends ApplicationContextAwareTest {

    @Resource
    private DummyDAO dummyDAO;

    /**
     * Tries to store {@link sk.eea.test.ambrosia.server.entity.DummyEntity}.
     */
    @Test
    public void testPersistTestEntity() {
        int countBefore = dummyDAO.findAll().size();
        DummyEntity dummyEntity = new DummyEntity();
        dummyDAO.makePersistent(dummyEntity);

        int countAfter = dummyDAO.findAll().size();
        assertEquals(countBefore + 1, countAfter);
    }

    @Test
    public void testUpdate(){
        DummyEntity dummyEntity = new DummyEntity();
        dummyEntity.setUserId((long)1);
        dummyDAO.makePersistent(dummyEntity);
        int countBefore = dummyDAO.findAll().size();

        DummyEntity dummyEntity2 = dummyDAO.findById((long)1, false);
        dummyEntity2.setUserId((long)1);
        dummyDAO.makePersistent(dummyEntity2);
        int countAfter = dummyDAO.findAll().size();
        assertEquals(countBefore , countAfter);

    }
    @Test
    public void testStringUpdate(){
        DummyEntity dummyEntity = new DummyEntity();
        DummyEntity dummyEntity2 = new DummyEntity();
        dummyEntity.setName("Silvia");
        dummyEntity.setPassword("1234");

        dummyEntity = dummyDAO.makePersistent(dummyEntity);
        int countBefore = dummyDAO.findAll().size();
        dummyEntity2 = dummyDAO.findById(dummyEntity.getUserId(),true);
        dummyEntity2.setName("Maros");
        dummyDAO.makePersistent(dummyEntity2);
        int countAfter = dummyDAO.findAll().size();
        assertEquals(countBefore , countAfter);
    }
}
