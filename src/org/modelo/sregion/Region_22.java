package org.modelo.sregion;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the REGION_2 database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="SELECT_ALL_REGION_2", query="select a from Region_22 a"),
	@NamedQuery(name="SELECT_BY_ID_REGION_2", query="select a from Region_22 a where a.id = :p ")
})

public class Region_22 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

    public Region_22() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}