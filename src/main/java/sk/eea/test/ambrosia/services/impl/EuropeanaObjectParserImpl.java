package sk.eea.test.ambrosia.services.impl;
import org.springframework.stereotype.Service;
import sk.eea.test.ambrosia.server.entity.EuropeanaObjectEntity;
import sk.eea.test.ambrosia.services.EuropeanaObjectParser;

import java.util.List;

/**
 * Created by murphy on 3/31/14.
 */
@Service
public class EuropeanaObjectParserImpl implements EuropeanaObjectParser {
    @Override
    public List<EuropeanaObjectEntity> parseObjects(String jsonInput) {
        return null;
    }

    @Override
    public EuropeanaObjectEntity parseSimpleRecord(String jsonInput) {
        return null;
    }
}
