package sk.eea.test.ambrosia.server.entity;

import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Required;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name = "USER")
public class DummyEntity {
    
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private Long id;
    @NotNull
    private String name;
    private ArrayList<DummyEntity> entities = new ArrayList<DummyEntity>();

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @NotNull
    private String password;

    @NotNull
    private boolean deleted = false;

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }


	public Long getId() {
		return id;
	}

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }
}
