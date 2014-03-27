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
}
