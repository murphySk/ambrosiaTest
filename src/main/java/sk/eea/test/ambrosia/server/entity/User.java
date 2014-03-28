package sk.eea.test.ambrosia.server.entity;

/**
 * Created by marti_000 on 3/27/2014.
 */

import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Required;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table (name ="USER")

public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String surName;
    @NotNull
    private String password;
    @NotNull
    private String login;

    @NotNull
    private boolean deleted = false;

    private ArrayList<Tag> tags = new ArrayList<Tag>();

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurName() {
        return surName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "USER")
    public ArrayList<Tag> getTags() {
        return this.tags;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }
    /*
    public void addTag(Tag t) {
        for(int i = 0; i < tags.size(); i++) {
            if(tags.get(i) == t){
                System.out.println("uz obsahuje..");
                return;
            }
        }
        tags.add(t);
    }

    public void removeTag(Tag t) {
        tags.remove(t);
    } */

}
