package sk.eea.test.ambrosia.server.dao;

import sk.eea.test.ambrosia.server.entity.DummyEntity;

/**
 * Plain DAO which provides only {@link sk.eea.test.ambrosia.server.dao.impl.GenericHibernateDAOImpl} methods
 */
public interface DummyDAO extends GenericDAO<DummyEntity, Long> {
}
