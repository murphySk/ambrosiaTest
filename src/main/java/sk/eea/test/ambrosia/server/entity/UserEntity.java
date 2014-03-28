package sk.eea.test.ambrosia.server.entity;
import com.sun.javafx.beans.annotations.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Silvia on 27. 3. 2014.
 */

@Entity
@Table(name = "USER")
public class UserEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
    @NonNull
    private String login;
    @NonNull
    private String password;
    @NonNull
    private String name;
    @NonNull
    private String surname;
    @NonNull
    private boolean deleted=false;

    private ArrayList<Tag> tag = new ArrayList<Tag>();

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "TAG")
    public Set<Tag> getTag() {
        return this.tag;
    }

    public void setTag(Set<Tag> tag) {
        this.tag = tag;
    }
}
