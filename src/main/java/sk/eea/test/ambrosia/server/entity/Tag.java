package sk.eea.test.ambrosia.server.entity;

import org.hsqldb.User;

import javax.persistence.*;

/**
 * Created by Silvia on 28. 3. 2014.
 */

@Entity
@Table(name = "TAG")
public class Tag {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Tag(){

    }

    public Tag(UserEntity user){
        this.user=user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
