package sk.eea.test.ambrosia.services;

import sk.eea.test.ambrosia.server.entity.EuropeanaObjectEntity;

import java.util.List;

/**
 * Created by murphy on 3/31/14.
 */
public interface EuropeanaObjectParser {
    public List<EuropeanaObjectEntity> parseObjects(String jsonInput); // input could be also JSONOArray

    public EuropeanaObjectEntity parseSimpleRecord(String jsonInput); // input could be also JSONObject
}
