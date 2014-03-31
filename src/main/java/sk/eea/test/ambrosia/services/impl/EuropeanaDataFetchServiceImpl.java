package sk.eea.test.ambrosia.services.impl;

import org.springframework.stereotype.Service;
import sk.eea.test.ambrosia.server.entity.EuropeanaObjectEntity;
import sk.eea.test.ambrosia.services.EuropeanaDataFetchService;

import java.util.List;

/**
 * Created by murphy on 3/27/14.
 */
@Service
public class EuropeanaDataFetchServiceImpl implements EuropeanaDataFetchService {
    @Override
    public List<EuropeanaObjectEntity> searchObjects(String key) {
        return null;
    }

    @Override
    public EuropeanaObjectEntity getSimpleObject(String objectId) {
        return null;
    }
}
