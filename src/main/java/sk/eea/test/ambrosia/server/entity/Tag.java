package sk.eea.test.ambrosia.server.entity;

import javax.persistence.*;

/**
 * Created by marti_000 on 3/28/2014.
 */
@Entity
@Table(name = "tag")
public class Tag {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;

    private User user;

    public Tag(User parent) {
        this.user = parent;
    }
    public Tag() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }
}
