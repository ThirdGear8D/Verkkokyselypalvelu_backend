package ThirdGear.Kyselypalvelu_backend.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ThirdGear.Kyselypalvelu_backend.domain.Kysely;
import ThirdGear.Kyselypalvelu_backend.domain.KyselyRepo;
import ThirdGear.Kyselypalvelu_backend.domain.Kysymys;
import ThirdGear.Kyselypalvelu_backend.domain.KysymysRepo;
import ThirdGear.Kyselypalvelu_backend.domain.Vastaus;
import ThirdGear.Kyselypalvelu_backend.domain.VastausRepo;





@CrossOrigin(origins = "*")//jotta JSON muotoinen tieto voidaan hakea verkkosivulta
@Controller

public class RestController {
	
	
	@Autowired	
	private KyselyRepo kyselyrepo; 
	
	@Autowired	
	private KysymysRepo kysymysrepo; 
	
	
	@Autowired 
	private VastausRepo vastausrepo;
	
	
	
// *********** KYSELYT **************************************************************************

	// 1 . REST kaikkien kyselyiden hakuun
		@RequestMapping(value = "/api/kyselyt")
		public @ResponseBody List<Kysely> kyselyListaRest() {
			return (List<Kysely>) kyselyrepo.findAll();
		}

	// 2.  REST hakee kyselyn id:n perusteella  th:href="@{kysely/{id}(id=${kysely.id})}"
		@RequestMapping(value = "/api/kysely/{id}", method = RequestMethod.GET)
		public @ResponseBody Optional<Kysely> findKyselyRest(@PathVariable("id") Long id) {
			return kyselyrepo.findById(id);
		}
		
		
		
// *********** KYSYMYKSET **************************************************************************   
	
	
// 1.  REST kaikkien kysymysten hakuun
    @RequestMapping(value="/api/kysymykset", method = RequestMethod.GET)
    public @ResponseBody List<Kysymys> kysymyslistaRest() {	
        return (List<Kysymys>) kysymysrepo.findAll();
    } 


// 2. REST --> hakee kysymykset id:n avulla
    @RequestMapping(value="/api/kysymykset/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Kysymys> findKysymysRest(@PathVariable("kysymysid") Long Id) {	
    	return kysymysrepo.findById(Id);
    }  
    
	// 4. REST --> hakee tietyn kyselyn kysymykset kysely id:n avulla
	@RequestMapping(value = "/api/kysymykset/kysely/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Kysymys> findKysymyksetByKyselyId(@PathVariable("id") Long id) {
		Kysely kysely = kyselyrepo.findById(id).get();
		return kysely.getKysymykset();
	}
	
	
	
 // ********* VASTAUKSET *********************************************************************************
	
// 1. Hakee kaikki vastaukset	
	@RequestMapping(value = "/api/vastaukset", method = RequestMethod.GET)
	public @ResponseBody List<Vastaus> listVastauksetRest() {
		return (List<Vastaus>) vastausrepo.findAll();
	}
	
	

//---- Vastausten liittäminen kyselyyn ----------------------------------------------------------	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/api/vastaukset", method = RequestMethod.POST)
	public @ResponseBody Kysely tallennaRest(@RequestBody Kysely kysely) {
		
		
		Kysely vastauksetKyselyyn = kyselyrepo.findById(kysely.getId()).get(); 
		vastauksetKyselyyn.setVastaukset(kysely.getVastaukset());
			
		
//---Vastaukset linkitetään kyselyyn joilloin ne tulevat näkyviin /api/kyselyt -endpointiin	
		// jos tätä ei ole, tallentuvat vastaukset vain /api/vastaukset -end pointiin ilman yhteyttä kyselyihin
		for (Vastaus vastaus : vastauksetKyselyyn.getVastaukset()) {
			vastaus.setKysymys(kysymysrepo.findById(vastaus.getId()).get());
			vastaus.setKysely(vastauksetKyselyyn);
		}
		
		kyselyrepo.save(vastauksetKyselyyn);
		return kysely;
		
	}

}


