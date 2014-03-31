package sk.eea.test.ambrosia.services;

import org.springframework.stereotype.Service;
import sk.eea.test.ambrosia.server.entity.EuropeanaObjectEntity;

import java.util.List;

/**
 * Created by murphy on 3/27/14.
 */
@Service
public interface EuropeanaDataFetchService {

    public List<EuropeanaObjectEntity> searchObjects(String key);

    public EuropeanaObjectEntity getSimpleObject(String objectId);
}
