package ThirdGear.Kyselypalvelu_backend.domain;

import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;




@Entity
public class Kysely {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
	private Long id;
	private String nimi;
	private String kuvaus;


	
//Kyselyllä on monta kysymystä mutta Kysymys kuuluu vain yhteen Kyselyyn	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kysely")
	private List<Kysymys> kysymykset;
	
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kysely")
	private List<Vastaus> vastaukset;
	

	
// ---------------------------------------------------------------------------------------------------------------
	
	public Kysely() {
		super();
		this.nimi = null;
		this.kuvaus = null;
		this.kysymykset = null;
		this.vastaukset = null;
	}
	
	
	
	
//----- GET --------------------------------------------------------
	
	public Long getId() {
		return id;
	}
	
	public String getNimi() {
		return nimi;
	}
	
	public String getKuvaus() {
		return kuvaus;
	}
	
// -- hae kysymyslista  ----------
	public List<Kysymys> getKysymykset() {
		return kysymykset;
	}
	
// -- hae kysymysten määrä --------
	public int getKysymyksetSize() {
		return kysymykset.size();
	}
	
	public List<Vastaus> getVastaukset() {
		return vastaukset;
	}
	

	
	
//----- SET ---------------------------------------------------------	
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public void setKuvaus(String kuvaus) {
		this.kuvaus = kuvaus;
	}
	
// -- aseta kysymyslista  ----------	
	public void setKysymykset(List<Kysymys> kysymykset) {
		this.kysymykset = kysymykset;
	}
	
	public void setVastaukset(List<Vastaus> vastaukset) {
		this.vastaukset = vastaukset;
	}

	
// ---- STRING TO STRING ----------------------------------------------------
	
	@Override
	public String toString() {
		                                    
		return "Kysely [id=" +id + ", nimi=" + nimi   + "]";
		
	}

}
