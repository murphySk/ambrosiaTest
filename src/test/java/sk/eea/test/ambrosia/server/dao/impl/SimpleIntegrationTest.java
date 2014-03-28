package sk.eea.test.ambrosia.server.dao.impl;

import javax.annotation.Resource;

import org.junit.Test;

import org.springframework.beans.factory.annotation.Required;
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
    public void testUpdateTestEntity() {
        DummyEntity dummyEntity = new DummyEntity();
        dummyEntity.setId((long) 1);
        dummyDAO.makePersistent(dummyEntity);

        DummyEntity dummyEntity2 = new DummyEntity();


        dummyDAO.findById((long) 1, false);
        int countAfter = dummyDAO.findAll().size();
        assertEquals(1, countAfter);
    }

    @Test
    public void testUpdateNamePass(){
        DummyEntity dummy = new DummyEntity();
        dummy.setName("Martin");
        dummy.setPassword("Lal");
        dummyDAO.makePersistent(dummy);
        int countBefore = dummyDAO.findAll().size();

        DummyEntity dummy2;
        dummy2 = dummyDAO.findById((long) 1, true);
        dummy2.setName("Ondrej");
        dummyDAO.makePersistent(dummy2);
        int countAfter = dummyDAO.findAll().size();
        assertEquals(countBefore, countAfter);
    }
    @Test
    public void testUpdateName() {
        DummyEntity dummy = new DummyEntity();
        String zmena = new String("Jozko");
        dummy.setName("Jozef");
        dummy.setPassword("1111");
        dummyDAO.makePersistent(dummy);

        dummyDAO.findById((long) 1, false).setName(zmena);
        dummyDAO.makePersistent(dummyDAO.findById((long) 1, false));

        assertEquals(dummyDAO.findById((long) 1, false).getName(), zmena);
    }
}
