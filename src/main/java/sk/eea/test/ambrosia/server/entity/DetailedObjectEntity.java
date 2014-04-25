package sk.eea.test.ambrosia.server.entity;

import java.util.Map;

/**
 * Created by marti_000 on 4/25/2014.
 */
public class DetailedObjectEntity {
    private String objectId;
    private String dcCreator;  //tvorca diela
    private String[] dcType;   //typ diela
    private String edmDataProvider; //poskytovatel dat do europeany
    private String edmProvider;     //poskytovatel diela
    private String[] dcDescription;   //popis diela
    private String dcLanguage;      //jazyk v ktorom je dielo
    private String edmCountry;      //krajina poskytovatel diela
    private String edmObject;       //url k objektu(vacsinou obrazok)
    private String[] webResources;   //linky na info o diele na webe

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getDcCreator() {
        return dcCreator;
    }

    public void setDcCreator(String dcCreator) {
        this.dcCreator = dcCreator;
    }

    public String[] getDcType() {
        return dcType;
    }

    public void setDcType(String[] dcType) {
        this.dcType = dcType;
    }

    public String getEdmDataProvider() {
        return edmDataProvider;
    }

    public void setEdmDataProvider(String edmDataProvider) {
        this.edmDataProvider = edmDataProvider;
    }

    public String getEdmProvider() {
        return edmProvider;
    }

    public void setEdmProvider(String edmProvider) {
        this.edmProvider = edmProvider;
    }

    public String[] getDcDescription() {
        return dcDescription;
    }

    public void setDcDescription(String[] dcDescription) {
        this.dcDescription = dcDescription;
    }

    public String getDcLanguage() {
        return dcLanguage;
    }

    public void setDcLanguage(String dcLanguage) {
        this.dcLanguage = dcLanguage;
    }

    public String getEdmCountry() {
        return edmCountry;
    }

    public void setEdmCountry(String edmCountry) {
        this.edmCountry = edmCountry;
    }

    public String getEdmObject() {
        return edmObject;
    }

    public void setEdmObject(String edmObject) {
        this.edmObject = edmObject;
    }

    public String[] getWebResources() {
        return webResources;
    }

    public void setWebResources(String[] webResources) {
        this.webResources = webResources;
    }
}
