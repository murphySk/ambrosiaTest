package sk.eea.test.ambrosia.services.impl;

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

        return null;
    }
}
