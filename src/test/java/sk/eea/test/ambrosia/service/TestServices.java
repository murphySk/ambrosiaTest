package sk.eea.test.ambrosia.service;

import sk.eea.test.ambrosia.ApplicationContextAwareTest;
import org.junit.Test;
import sk.eea.test.ambrosia.server.entity.EuropeanaObjectEntity;
import sk.eea.test.ambrosia.services.EuropeanaObjectParser;
import sk.eea.test.ambrosia.services.impl.EuropeanaObjectParserImpl;
import sk.eea.test.ambrosia.services.impl.HttpConnection;

import javax.annotation.Resource;
import javax.annotation.Resources;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by marti_000 on 4/2/2014.
 */

public class TestServices extends ApplicationContextAwareTest{

    @Test
    public void singleObjParserTest() {
        EuropeanaObjectParserImpl dummyPars = new EuropeanaObjectParserImpl();
        EuropeanaObjectEntity e = new EuropeanaObjectEntity();

        e = dummyPars.parseSimpleRecord("{\"id\":\"/15503/E627F23EF13FA8E6584AF8706A95DB85908413BE\",\"completeness\":6,\"europeanaCollectionName\":[\"15503_Ag_AT_Kulturpool_khm_fs\"],\"index\":0,\"language\":[\"de\"],\"type\":\"IMAGE\",\"provider\":[\"Kulturpool\"],\"title\":[\"Gustaf Gründgens\"],\"dataProvider\":[\"Österreichisches Theatermuseum\"],\"dcCreator\":[\"anonym\"],\"europeanaCompleteness\":6,\"edmPreview\":[\"http://europeanastatic.eu/api/image?uri=http%3A%2F%2Fbilddatenbank.khm.at%2Fimages%2F500%2FFS_PM133355alt.jpg&size=LARGE&type=IMAGE\"],\"edmIsShownAt\":[\"http://europeana.eu/api/13282/redirect?shownAt=http%3A%2F%2Fbilddatenbank.khm.at%2FviewArtefact%3Fid%3D500066%26bt%3Deuropeanaapi&provider=Kulturpool&id=http://www.europeana.eu/resolve/record/15503/E627F23EF13FA8E6584AF8706A95DB85908413BE&profile=standard\"],\"score\":3.4447985,\"link\":\"http://europeana.eu/api/v2/record/15503/E627F23EF13FA8E6584AF8706A95DB85908413BE.json?wskey=PaVZsTDPQ\",\"guid\":\"http://www.europeana.eu/portal/record/15503/E627F23EF13FA8E6584AF8706A95DB85908413BE.html?utm_source=api&utm_medium=api&utm_campaign=PaVZsTDPQ\"}");

        String testId = "/15503/E627F23EF13FA8E6584AF8706A95DB85908413BE";

        assertEquals(e.getObjectId(), testId);
    }

    @Test
    public void parseObjectsTest() {
        EuropeanaObjectParserImpl dummyPars = new EuropeanaObjectParserImpl();

        List<EuropeanaObjectEntity> list = dummyPars.parseObjects("{\"apikey\":\"PaVZsTDPQ\",\"action\":\"search.json\",\"success\":true,\"requestNumber\":0,\"itemsCount\":3,\"totalResults\":3,\"items\":[{\"id\":\"/2022608/RF_HJB0602\",\"completeness\":5,\"europeanaCollectionName\":[\"2022608_Ag_NO_ELocal_kulturit\"],\"index\":0,\"language\":[\"no\"],\"type\":\"IMAGE\",\"provider\":[\"Kulturrådet\"],\"title\":[\"Spissknok\"],\"dataProvider\":[\"Ryfylkemuseet\"],\"rights\":[\"http://creativecommons.org/publicdomain/zero/1.0/\",\"\"],\"europeanaCompleteness\":5,\"edmPreview\":[\"http://europeanastatic.eu/api/image?uri=http%3A%2F%2Fmedia31.dimu.no%2Fmedia%2Fimage%2FRF%2FHJB0602%2F0%3FbyIndex%3Dtrue%26height%3D400%26width%3D400&size=LARGE&type=IMAGE\"],\"edmIsShownAt\":[\"http://europeana.eu/api/13282/redirect?shownAt=http%3A%2F%2Fdigitaltmuseum.no%2Fthings%2Fthing%2FRF%2FHJB0602%3Fbt%3Deuropeanaapi&provider=Kulturr%C3%A5det&id=http://www.europeana.eu/resolve/record/2022608/RF_HJB0602&profile=standard\"],\"score\":5.2218256,\"link\":\"http://europeana.eu/api/v2/record/2022608/RF_HJB0602.json?wskey=PaVZsTDPQ\",\"guid\":\"http://www.europeana.eu/portal/record/2022608/RF_HJB0602.html?utm_source=api&utm_medium=api&utm_campaign=PaVZsTDPQ\",\"timestamp_created_epoch\":1385749207460,\"timestamp_update_epoch\":1385749207460,\"timestamp_created\":\"2013-11-29T18:20:07.460Z\",\"timestamp_update\":\"2013-11-29T18:20:07.460Z\"},{\"id\":\"/2022608/NF_NFSA_1294\",\"completeness\":5,\"europeanaCollectionName\":[\"2022608_Ag_NO_ELocal_kulturit\"],\"index\":0,\"language\":[\"no\"],\"type\":\"IMAGE\",\"provider\":[\"Kulturrådet\"],\"title\":[\"Redskap\"],\"dataProvider\":[\"Norsk Folkemuseum\"],\"rights\":[\"http://creativecommons.org/licenses/by-sa/3.0/\",\"\"],\"europeanaCompleteness\":5,\"edmPreview\":[\"http://europeanastatic.eu/api/image?uri=http%3A%2F%2Fmedia31.dimu.no%2Fmedia%2Fimage%2FNF%2FNFSA.1294%2F0%3FbyIndex%3Dtrue%26height%3D400%26width%3D400&size=LARGE&type=IMAGE\"],\"edmIsShownAt\":[\"http://europeana.eu/api/13282/redirect?shownAt=http%3A%2F%2Fdigitaltmuseum.no%2Fthings%2Fthing%2FNF%2FNFSA.1294%3Fbt%3Deuropeanaapi&provider=Kulturr%C3%A5det&id=http://www.europeana.eu/resolve/record/2022608/NF_NFSA_1294&profile=standard\"],\"score\":2.1099362,\"link\":\"http://europeana.eu/api/v2/record/2022608/NF_NFSA_1294.json?wskey=PaVZsTDPQ\",\"guid\":\"http://www.europeana.eu/portal/record/2022608/NF_NFSA_1294.html?utm_source=api&utm_medium=api&utm_campaign=PaVZsTDPQ\",\"timestamp_created_epoch\":1385744218497,\"timestamp_update_epoch\":1385744218497,\"timestamp_created\":\"2013-11-29T16:56:58.497Z\",\"timestamp_update\":\"2013-11-29T16:56:58.497Z\"},{\"id\":\"/2022608/artifactView_do_idOwner_NF_idIdentifier_NFL_23921\",\"completeness\":0,\"europeanaCollectionName\":[\"2022608_Ag_NO_ELocal_kulturit\"],\"index\":0,\"language\":[\"no\"],\"type\":\"IMAGE\",\"provider\":[\"Norsk Kulturråd\"],\"title\":[\"Spissknok\"],\"dataProvider\":[\"Norsk Folkemuseum\"],\"rights\":[\"http://creativecommons.org/publicdomain/zero/1.0/\",\"\"],\"europeanaCompleteness\":0,\"edmIsShownAt\":[\"http://europeana.eu/api/13282/redirect?shownAt=http%3A%2F%2Fdigitaltmuseum.no%2Fthings%2Fthing%2FNF%2FNFL.23921%3Fbt%3Deuropeanaapi&provider=Norsk+Kulturr%C3%A5d&id=http://www.europeana.eu/resolve/record/2022608/artifactView_do_idOwner_NF_idIdentifier_NFL_23921&profile=standard\"],\"score\":2.1099362,\"link\":\"http://europeana.eu/api/v2/record/2022608/artifactView_do_idOwner_NF_idIdentifier_NFL_23921.json?wskey=PaVZsTDPQ\",\"guid\":\"http://www.europeana.eu/portal/record/2022608/artifactView_do_idOwner_NF_idIdentifier_NFL_23921.html?utm_source=api&utm_medium=api&utm_campaign=PaVZsTDPQ\",\"timestamp_created_epoch\":1385750766325,\"timestamp_update_epoch\":1385750766325,\"timestamp_created\":\"2013-11-29T18:46:06.325Z\",\"timestamp_update\":\"2013-11-29T18:46:06.325Z\"}]}");
        String[] ids = {"/2022608/RF_HJB0602","/2022608/NF_NFSA_1294","/2022608/artifactView_do_idOwner_NF_idIdentifier_NFL_23921"};

        for(int i = 0; i < list.size(); i++) {
            assertEquals(list.get(i).getObjectId(), ids[i]);
        }
    }

    @Test
    public void searchTest(){
        EuropeanaObjectParserImpl dummyPars = new EuropeanaObjectParserImpl();
        HttpConnection con = new HttpConnection();

        try{
            List<EuropeanaObjectEntity> list = dummyPars.parseObjects(con.sendGet("Spissknok"));
            String[] ids = {"/2022608/RF_HJB0602","/2022608/NF_NFSA_1294","/2022608/artifactView_do_idOwner_NF_idIdentifier_NFL_23921"};
            for(int i = 0; i < list.size(); i++) {
                assertEquals(list.get(i).getObjectId(), ids[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
