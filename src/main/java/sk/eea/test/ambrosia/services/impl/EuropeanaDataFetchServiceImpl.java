package sk.eea.test.ambrosia.services.impl;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.stereotype.Service;
import sk.eea.test.ambrosia.server.entity.EuropeanaObjectEntity;
import sk.eea.test.ambrosia.services.EuropeanaDataFetchService;
import org.apache.http.impl.client.HttpClientBuilder;
//import org.apache.http.client.methods;



import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by murphy on 3/27/14.
 */
@Service
public class EuropeanaDataFetchServiceImpl implements EuropeanaDataFetchService{
    @PostConstruct
    public void init() {
       // HttpClient client = HttpClientBuilder.create().build();
    }

    @Override
    public List<EuropeanaObjectEntity> searchObjects(String key) {
        return null;
    }

    @Override
    public EuropeanaObjectEntity getSimpleObject(String objectId) {
        return null;
    }



    public String sendHttpGetRequest(String searched) throws IOException {
        final String USER_AGENT="Mozzila/5.0";
        searched = searched.replaceAll(" ", "+");
        String url = "http://www.europeana.eu/api//v2/search.json?wskey=PaVZsTDPQ&query=toto&start=1&rows=24&profile=standard";
        url = url.replaceAll("toto", searched);
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        request.addHeader("User-Agent",USER_AGENT);

            HttpResponse response = client.execute(request);

        System.out.println("Response Code : "
                + response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = new String();
        while ((line = rd.readLine()) != null) {
            result.append(line);


        }
        return result.toString();
    }




}
