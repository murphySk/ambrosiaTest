package sk.eea.test.ambrosia.server.dao.impl;

import javax.annotation.Resource;

import org.junit.Test;

import sk.eea.test.ambrosia.ApplicationContextAwareTest;
import sk.eea.test.ambrosia.server.dao.DummyDAO;
import sk.eea.test.ambrosia.server.entity.DummyEntity;

import static org.junit.Assert.*;

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
        dummyEntity.setId((long)1);
        dummyDAO.makePersistent(dummyEntity);
        int countBefore = dummyDAO.findAll().size();
        dummyDAO.findById((long) 1,false);
        DummyEntity dummyEntity2 = new DummyEntity();
        dummyEntity2.setId((long)1);
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
        //dummyEntity.setId((long)1);
        dummyDAO.makePersistent(dummyEntity);
        int countBefore = dummyDAO.findAll().size();
        dummyEntity2=dummyDAO.findById(dummyEntity.getId(),false);
        dummyEntity2.setName("Maros");
        dummyDAO.makePersistent(dummyEntity2);
        int countAfter = dummyDAO.findAll().size();
        assertEquals(countBefore , countAfter);
    }

    @Test
    public void testChangeOfData(){
        DummyEntity dummyEntity = new DummyEntity();
        DummyEntity dummyEntity2 = new DummyEntity();
        String name1, name2;

        dummyEntity.setName("Silvia");
        dummyEntity.setPassword("1234");
        name1=dummyEntity.getName();
        dummyDAO.makePersistent(dummyEntity);
        dummyEntity2=dummyDAO.findById(dummyEntity.getId(),false);
        dummyEntity2.setName("Maros");
        dummyDAO.makePersistent(dummyEntity2);
        dummyEntity2=dummyDAO.findById(dummyEntity.getId(),false);
        name2=dummyEntity2.getName();
        assertFalse(name2.equals(name1));
        //assertNotSame(name1, name2);

    }

}
