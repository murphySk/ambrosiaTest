package sk.eea.test.ambrosia.services.impl;
import org.springframework.stereotype.Service;
import sk.eea.test.ambrosia.server.entity.EuropeanaObjectEntity;
import sk.eea.test.ambrosia.services.EuropeanaObjectParser;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by murphy on 3/31/14.
 */
@Service
public class EuropeanaObjectParserImpl implements EuropeanaObjectParser {
    @Override
    public List<EuropeanaObjectEntity> parseObjects(String jsonInput) {
        List<EuropeanaObjectEntity> list = new ArrayList<EuropeanaObjectEntity>();

        JSONObject tempObj = (JSONObject) JSONSerializer.toJSON(jsonInput);

        JSONArray jsonArray = tempObj.getJSONArray("items");
         for(int i = 0; i < jsonArray.size(); i++) {
             EuropeanaObjectEntity e = new EuropeanaObjectEntity();
            JSONObject jsonobj = jsonArray.getJSONObject(i);
             if(jsonobj.containsKey("id"))
                 e.setObjectId(jsonobj.getString("id"));
             if(jsonobj.containsKey("title")) {
                 JSONArray temp =jsonobj.getJSONArray("title") ;
                 e.setTitle(temp.get(0).toString());
             }
             if(jsonobj.containsKey("type"))
                 e.setDescription(jsonobj.getString("type"));
             list.add(e);
         }

        return list;
    }

    @Override
    public EuropeanaObjectEntity parseSimpleRecord(String jsonInput) {
        EuropeanaObjectEntity e = new EuropeanaObjectEntity();
        JSONObject jsonObject = (JSONObject) JSONSerializer.toJSON(jsonInput);
        if(jsonObject.containsKey("id"))
            e.setObjectId(jsonObject.getString("id"));
        if(jsonObject.containsKey("title"))
            e.setTitle(jsonObject.getString("title"));
        if(jsonObject.containsKey("type"))
            e.setDescription(jsonObject.getString("type"));

        return e;
    }
}
