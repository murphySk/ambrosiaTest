package sk.eea.test.ambrosia.server.dao.impl;

import org.springframework.stereotype.Repository;
import sk.eea.test.ambrosia.server.entity.UserEntity;
import sk.eea.test.ambrosia.server.dao.UserDAO;

/**
 * Created by murphy on 3/27/14.
 */
@Repository
public class UserDAOimpl extends GenericHibernateDAOImpl<UserEntity, Long> implements UserDAO {
}
