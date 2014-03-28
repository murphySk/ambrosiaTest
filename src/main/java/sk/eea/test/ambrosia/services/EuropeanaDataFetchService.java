package sk.eea.test.ambrosia.services;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by murphy on 3/27/14.
 */
@Service
public interface EuropeanaDataFetchService {

    public List<EuropeanaObject> searchObjects(String key);

    public EuropeanaObject getSimpleObject(String objectId);
}
