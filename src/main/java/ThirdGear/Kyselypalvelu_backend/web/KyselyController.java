package ThirdGear.Kyselypalvelu_backend.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ThirdGear.Kyselypalvelu_backend.domain.Kysely;
import ThirdGear.Kyselypalvelu_backend.domain.KyselyRepo;
import ThirdGear.Kyselypalvelu_backend.domain.Kysymys;
import ThirdGear.Kyselypalvelu_backend.domain.KysymysRepo;



@Controller
public class KyselyController {

	@Autowired
	private KyselyRepo kyselyrepo;


// LOGIN-SIVU ***********************************************************
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }
//***********************************************************************
    
    
	
// 1. KAIKKIEN KYSELYIDEN LISTAAMINEN jA TYHJÄN LOMAKKEEN NÄYTTÄMINEN
// 2. KYSELYN TALLENNUS	
// 3. KYSELYN POISTAMINEN
	
	
	
// 1. ---------------KAIKKIEN KYSELYIDEN LISTAAMINEN JA TYHJÄN LOMAKKEEN NÄYTTÄMINEN--------------------------------------------------------------------	
	@RequestMapping(value = "/kyselyt")
	public String kyselyLista(Model model) {
		model.addAttribute("kyselyt", kyselyrepo.findAll());
		model.addAttribute("kysely", new Kysely()); // "tyhjä" olio
		return "kyselyt";
	}	
	
	
// 2. ---------------KYSELYN TALLENNUS --------------------------------------------------------------------	
 
	@RequestMapping(value = "/tallenna", method = RequestMethod.POST)
	public String tallenna(Kysely kysely) {
		kyselyrepo.save(kysely);
		return "redirect:kyselyt";
	}
	
// 3. ---------------KYSELYN POISTAMINEN --------------------------------------------------------------------	

		@RequestMapping(value = "poista/kysely/{id}", method = RequestMethod.GET)
		public String poistaKysely(@PathVariable("id") Long id) {
			kyselyrepo.delete(kyselyrepo.findById(id).get());
			return "redirect:/kyselyt";
		}
 	}