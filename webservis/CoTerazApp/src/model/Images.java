package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the Whatsnow_en database table.
 * 
 */
@Entity
@NamedQueries(value = { @NamedQuery(name = "Images.findAll", query = "SELECT im FROM Images im")
})
public class Images implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	private String name;
	private String src;
	
	
	
	public Images() {
	}

	public Images(int ID, String name, String src) {
		super();
		this.ID = ID;
		this.name = name;
		this.src = src;
	}

	
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}
	
}
