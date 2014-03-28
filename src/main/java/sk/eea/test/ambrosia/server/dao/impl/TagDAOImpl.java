package sk.eea.test.ambrosia.server.dao.impl;

import org.springframework.stereotype.Repository;
import sk.eea.test.ambrosia.server.dao.DAOUser;
import sk.eea.test.ambrosia.server.dao.TagDAO;
import sk.eea.test.ambrosia.server.entity.Tag;
import sk.eea.test.ambrosia.server.entity.User;

/**
 * Created by marti_000 on 3/28/2014.
 */
@Repository
public class TagDAOImpl extends GenericHibernateDAOImpl<Tag, Long> implements TagDAO {
}
