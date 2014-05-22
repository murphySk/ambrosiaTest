package sk.eea.test.ambrosia.server.entity;

import sk.eea.test.ambrosia.server.dao.UserDAO;

import javax.persistence.*;

/**
 * Created by murphy on 3/28/14.
 */
@Entity
@Table(name = "tag")
public class TagEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long tagId;

    private String tag;

    private String normalizedTag;

    private String objectId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private UserEntity user;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getNormalizedTag() {
        return normalizedTag;
    }

    public void setNormalizedTag(String normalizedTag) {
        this.normalizedTag = normalizedTag;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
