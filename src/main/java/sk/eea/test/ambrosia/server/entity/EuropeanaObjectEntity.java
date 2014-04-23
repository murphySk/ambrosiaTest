package sk.eea.test.ambrosia.server.entity;

/**
 * Created by murphy on 3/27/14.
 */
public class EuropeanaObjectEntity {

    private String objectId;

    private String title;

    private String description;

    private int completeness;

    private String dataProvider;

    private String[] europeanaCollectionName;

    private String guid;

    private String link;

    private String provider;

    private String[] rights;

    private String language;







    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCompleteness() {
        return completeness;
    }

    public void setCompleteness(int completeness) {
        this.completeness = completeness;
    }

    public String getDataProvider() {
        return dataProvider;
    }

    public void setDataProvider(String dataProvider) {
        this.dataProvider = dataProvider;
    }

    public String[] getEuropeanaCollectionName() {
        return europeanaCollectionName;
    }

    public void setEuropeanaCollectionName(String[] europeanaCollectionName) {
        this.europeanaCollectionName = europeanaCollectionName;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String[] getRights() {
        return rights;
    }

    public void setRights(String[] rights) {
        this.rights = rights;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
