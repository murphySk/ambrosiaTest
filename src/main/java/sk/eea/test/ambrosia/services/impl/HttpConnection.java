package sk.eea.test.ambrosia.services.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by marti_000 on 3/31/2014.
 */
public class HttpConnection {
    private final String USER_AGENT = "Mozilla/5.0";

    public String sendGet(String searched) throws Exception{
        searched = searched.replaceAll(" ", "+");
        String url = "http://www.europeana.eu/api//v2/search.json?wskey=PaVZsTDPQ&query=toto&start=1&rows=24&profile=standard";
        url = url.replaceAll("toto", searched);

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }
}
