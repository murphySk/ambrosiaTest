package sk.eea.test.ambrosia.server.dao.impl;

import org.springframework.stereotype.Repository;

import sk.eea.test.ambrosia.server.dao.DummyDAO;
import sk.eea.test.ambrosia.server.entity.DummyEntity;

/**
 * Plain DAO which provides only {@link sk.eea.test.ambrosia.server.dao.impl.GenericHibernateDAOImpl} methods
 */
@Repository
public class DummyDAOImpl extends GenericHibernateDAOImpl<DummyEntity, Long> implements DummyDAO {
    public void makeTransient(DummyEntity entity) {
        entity.setDeleted(true);
        getHibernateTemplate().delete(entity);
    }
}
