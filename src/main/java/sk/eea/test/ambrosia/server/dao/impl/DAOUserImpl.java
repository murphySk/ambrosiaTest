package sk.eea.test.ambrosia.server.dao.impl;

import org.springframework.stereotype.Repository;
import sk.eea.test.ambrosia.server.dao.DAOUser;
import sk.eea.test.ambrosia.server.entity.User;

/**
 * Created by marti_000 on 3/27/2014.
 */
@Repository
public class DAOUserImpl extends GenericHibernateDAOImpl<User, Long> implements DAOUser {
    public void makeTransient(User entity) {
        entity.setDeleted(true);
        getHibernateTemplate().delete(entity);
    }
}
