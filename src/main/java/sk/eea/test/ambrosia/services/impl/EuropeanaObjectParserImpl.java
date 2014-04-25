package sk.eea.test.ambrosia.services.impl;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.stereotype.Service;
import sk.eea.test.ambrosia.server.entity.DetailedObjectEntity;
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
             JSONArray temp;
            JSONObject jsonobj = jsonArray.getJSONObject(i);
             if(jsonobj.containsKey("id"))
                 e.setObjectId(jsonobj.getString("id"));
             if(jsonobj.containsKey("title")) {
                 temp =  jsonobj.getJSONArray("title");
                 e.setTitle(temp.get(0).toString());}
             if(jsonobj.containsKey("type"))
                 e.setDescription(jsonobj.getString("type"));
             if(jsonobj.containsKey("completeness"))
                 e.setCompleteness(jsonobj.getInt("completeness"));
             if(jsonobj.containsKey("dataProvider")) {
                 temp =  jsonobj.getJSONArray("dataProvider");
                 e.setDataProvider(temp.get(0).toString());
             }
             if(jsonobj.containsKey("europeanaCollectionName")) {
                 temp =  jsonobj.getJSONArray("europeanaCollectionName");
                 String[] tempString = new String[temp.size()];
                 for(int c = 0; c < temp.size(); c++)
                    tempString[c] = temp.get(c).toString();
                 e.setEuropeanaCollectionName(tempString);
             }
             if(jsonobj.containsKey("guid")) {
                 e.setGuid(jsonobj.getString("guid"));
             }
             if(jsonobj.containsKey("link")) {
                 e.setLink(jsonobj.getString("link"));
             }
             if(jsonobj.containsKey("provider")) {
                 temp =  jsonobj.getJSONArray("provider");
                 e.setProvider(temp.get(0).toString());
             }
             if(jsonobj.containsKey("rights")) {
                 temp =  jsonobj.getJSONArray("rights");
                 String[] tempString = new String[temp.size()];
                 for(int c = 0; c < temp.size(); c++)
                     tempString[c] = temp.get(c).toString();
                 e.setRights(tempString);
             }
             if(jsonobj.containsKey("language")) {
                 temp =  jsonobj.getJSONArray("language");
                 e.setLanguage(temp.get(0).toString());
             }
             if(jsonobj.containsKey("edmPreview")) {
                 temp =  jsonobj.getJSONArray("edmPreview");
                 e.setEdmPreview(temp.get(0).toString());
             }

             list.add(e);
         }

        return list;
    }

    @Override
    public DetailedObjectEntity parseSimpleRecord(String json) {
        DetailedObjectEntity e = new DetailedObjectEntity();
        JSONObject tempObj = (JSONObject) JSONSerializer.toJSON(json);
        JSONObject tempObject = null;
        JSONArray tempProxiesAggre = null;
        JSONObject proxyAggre = null;
        JSONObject temp = null;
        JSONArray tempArray = null;
        if(tempObj.containsKey("object")) {
            tempObject = tempObj.getJSONObject("object");
            if(tempObject.containsKey("about")) {
                e.setObjectId(tempObject.getString("about"));
            }
            if(tempObject.containsKey("title")) {
                tempArray =  tempObject.getJSONArray("title");
                e.setObjectId(tempArray.get(0).toString());
            }
        }
        if(tempObject.containsKey("proxies")) {
            tempProxiesAggre =  tempObject.getJSONArray("proxies");
            proxyAggre = tempProxiesAggre.getJSONObject(0);
            if(proxyAggre.containsKey("dcCreator")) {
                temp = proxyAggre.getJSONObject("dcCreator");
                if(temp.containsKey("def")) {
                    tempArray = temp.getJSONArray("def");
                    e.setDcCreator(tempArray.get(0).toString());
                }
            }

            if(proxyAggre.containsKey("dcLanguage")) {
                temp = proxyAggre.getJSONObject("dcLanguage");
                if(temp.containsKey("def")) {
                    tempArray = temp.getJSONArray("def");
                    e.setDcLanguage(tempArray.get(0).toString());
                }
            }

            if(proxyAggre.containsKey("dcType")) {
                temp = proxyAggre.getJSONObject("dcType");
                String[] dcType = new String[2];
                int c = 0;
                if(temp.containsKey("def")) {
                    tempArray = temp.getJSONArray("def");
                    dcType[c] = (tempArray.get(0).toString());
                    c++;
                }
                if(temp.containsKey("eng")) {
                    tempArray = temp.getJSONArray("eng");
                    dcType[c] = (tempArray.get(0).toString());
                    c++;
                }
                c=0;
                e.setDcType(dcType);

            }

            if(proxyAggre.containsKey("dcDescription")) {
                temp = proxyAggre.getJSONObject("dcDescription");
                String[] dcDesc = null;
                String[] dcDesc2 = null;
                if(temp.containsKey("def")) {
                    tempArray = temp.getJSONArray("def");
                    dcDesc = new String[tempArray.size()];
                    for(int c = 0; c < tempArray.size(); c++)
                        dcDesc[c] = (tempArray.get(c).toString());
                }
                if(temp.containsKey("eng")) {
                    tempArray = temp.getJSONArray("eng");
                    dcDesc2 = new String[tempArray.size()];
                    for(int c = 0; c < tempArray.size(); c++) {
                        dcDesc2[c] = (tempArray.get(c).toString());
                    }
                }
                e.setDcDescription((String[]) ArrayUtils.addAll(dcDesc, dcDesc2));
            }
        }

        if(tempObject.containsKey("europeanaAggregation")) {
            proxyAggre = tempObject.getJSONObject("europeanaAggregation");
            if (proxyAggre.containsKey("edmPreview")) {
                e.setEdmPreview(proxyAggre.getString("edmPreview"));
            }
        }

        if(tempObject.containsKey("aggregations")) {
            tempProxiesAggre = tempObject.getJSONArray("aggregations");
            proxyAggre = tempProxiesAggre.getJSONObject(0);
            if (proxyAggre.containsKey("edmDataProvider")) {
                temp = proxyAggre.getJSONObject("edmDataProvider");
                if (temp.containsKey("def")) {
                    tempArray = temp.getJSONArray("def");
                    e.setEdmDataProvider(tempArray.get(0).toString());
                }
            }

            if (proxyAggre.containsKey("edmProvider")) {
                temp = proxyAggre.getJSONObject("edmProvider");
                if (temp.containsKey("def")) {
                    tempArray = temp.getJSONArray("def");
                    e.setEdmProvider(tempArray.get(0).toString());
                }
            }

            if (proxyAggre.containsKey("webResources")) {
                JSONArray temparray2 = proxyAggre.getJSONArray("webResources");
                String[] docas = new String[temparray2.size()];
                for (int i = 0; i < temparray2.size(); i++) {
                    temp = temparray2.getJSONObject(i);
                    if (temp.containsKey("about")) {
                        docas[i] = temp.getString("about");
                    }
                }
                e.setWebResources(docas);
            }
        }
        return e;
    }
}
