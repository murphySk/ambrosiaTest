package sk.eea.test.ambrosia.server.dao.impl;

import org.springframework.stereotype.Repository;
import sk.eea.test.ambrosia.server.dao.ObjectIdDAO;
import sk.eea.test.ambrosia.server.entity.ObjectIdEntity;

/**
 * Created by Silvia on 23. 5. 2014.
 */

@Repository
public class ObjectIdDAOimpl extends GenericHibernateDAOImpl<ObjectIdEntity, Long> implements ObjectIdDAO {
}
