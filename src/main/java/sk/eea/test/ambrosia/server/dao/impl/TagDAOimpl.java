package sk.eea.test.ambrosia.server.dao.impl;

import org.springframework.stereotype.Repository;
import sk.eea.test.ambrosia.server.dao.TagDAO;
import sk.eea.test.ambrosia.server.entity.TagEntity;

/**
 * Created by murphy on 3/28/14.
 */
@Repository
public class TagDAOimpl extends GenericHibernateDAOImpl<TagEntity, Long> implements TagDAO {
}
