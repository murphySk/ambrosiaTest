package sk.eea.test.ambrosia.server.dao.impl;

import org.springframework.stereotype.Repository;
import sk.eea.test.ambrosia.server.entity.UserEntity;

/**
 * Created by Silvia on 27. 3. 2014.
 */

@Repository
public class UserDAOImpl extends GenericHibernateDAOImpl<UserEntity, Long> implements UserDAO{

    public void makeTransient(UserEntity entity) {
        getHibernateTemplate().delete(entity);
        entity.setDeleted(true);

    }
}
