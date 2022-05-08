package ThirdGear.Kyselypalvelu_backend.domain;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;




@Entity
public class Kysymys {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long kysymysid;
    private String kysymysteksti;
    private Boolean pakollinen;
    

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "kyselyid", referencedColumnName = "id") 
    private Kysely kysely;
    
     

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kysymys")
    private List<Vastaus> vastaukset;

  

 
    public Kysymys() {
    	super();
    	this.kysymysteksti = null;
    	this.kysely = null;
    	this.pakollinen = false;
    }
    
    
 


	
//----- GET --------------------------------------------------------
	
	public Long getId() {
		return kysymysid;
	}
	public String getKysymysteksti() {
		return kysymysteksti;
	}


	public Kysely getKysely() {
		return kysely;
	}
	
	public Boolean getPakollinen() {
		return pakollinen;
	}

//----- SET --------------------------------------------------------
	
	public void setId(Long kysymysid) {
		this.kysymysid = kysymysid;
	}
	
	public void setKysymysteksti(String kysymysteksti) {
		this.kysymysteksti = kysymysteksti;
	}

	public void setKysely(Kysely kysely) {
		this.kysely = kysely;
	}
	 
	public void setPakollinen(Boolean pakollinen) {
		this.pakollinen = pakollinen;
	}
	

	
	@Override
	public String toString() {
		if (this.kysely != null)
			return "Kysymys [kysymysid=" + kysymysid + ", kysymysteksti=" + kysymysteksti + ", pakollinen=" + pakollinen + ",  kysely =" + this.getKysely() + "]";		
		else
			return "Kysymys [kysymysid=" + kysymysid + ", kysymysteksti=" + kysymysteksti + ", pakollinen=" + pakollinen + "]";	
	}
}
