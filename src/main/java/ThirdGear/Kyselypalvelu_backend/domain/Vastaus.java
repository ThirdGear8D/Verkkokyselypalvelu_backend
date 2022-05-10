package ThirdGear.Kyselypalvelu_backend.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;





@Entity
public class Vastaus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	public String vastauskysymykseen;
	

	
	@ManyToOne
    @JsonIgnore
    @JoinColumn(name = "kyselyid", referencedColumnName = "id") 
    private Kysely kysely;
	
	@ManyToOne
//	@JsonIgnoreProperties("vastaukset")
	@JoinColumn(name = "kysymysid", referencedColumnName = "kysymysid") 
	private Kysymys kysymys;

	
	public Vastaus() {
		super();
		this.vastauskysymykseen = null;
	
		this.kysymys = null;
	}

	public Vastaus(String vastaus, Kysymys kysymys) {
		super();
		this.vastauskysymykseen = vastaus;
		
		this.kysymys = kysymys;
	}

	
	
	
//----- GET --------------------------------------------------------
	
	public Long getId() {
		return id;
	}

	
	public Kysely getKysely() {
		return kysely;
	}
	
	public Kysymys getKysymys() {
		return kysymys;
	}
	
	
	public String getVastaus() {
		return vastauskysymykseen;
	}
	
	
//----- SET --------------------------------------------------------
	
	public void setId(Long id) {
		this.id = id;
	}

	
	public void setKysymys(Kysymys kysymys) {
		this.kysymys = kysymys;
	}
	
	
	public void setKysely(Kysely kysely) {
		this.kysely = kysely;
	}
	
	public void setVastaus(String vastauskysymykseen) {
		this.vastauskysymykseen = vastauskysymykseen;
	}

	



	@Override
	public String toString() {
	
		return "Vastaus [kysymys:" + kysymys 
				+ ", "
				+ "vastaus:" + vastauskysymykseen
				+ "]";
	}
		
}
