package sk.eea.test.ambrosia.server.entity;

import javax.persistence.*;

/**
 * Created by Silvia on 23. 5. 2014.
 */

@Entity
@Table(name = "objectId")
public class ObjectIdEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idObjectId;

    private String europObjectId;

    public String getEuropObjectId() {
        return europObjectId;
    }

    public void setEuropObjectId(String europObjectId) {
        this.europObjectId = europObjectId;
    }
}
