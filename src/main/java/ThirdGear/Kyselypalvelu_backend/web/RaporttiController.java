package ThirdGear.Kyselypalvelu_backend.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import ThirdGear.Kyselypalvelu_backend.domain.KyselyRepo;

import ThirdGear.Kyselypalvelu_backend.domain.KysymysRepo;
import ThirdGear.Kyselypalvelu_backend.domain.VastausRepo;



@Controller
public class RaporttiController {
	
	@Autowired	
	private KyselyRepo kyselyrepo; 
	
	@Autowired	
	private KysymysRepo kysymysrepo;
	
	@Autowired	
	private VastausRepo vastausrepo;
	



// näyttää kaikki teemat ja sanat
@RequestMapping(value="/vastausraportti")
public String themeList(Model model) {	
   model.addAttribute("kyselyt", kyselyrepo.findAll());
    model.addAttribute("kysymykset", kysymysrepo.findAll());
    model.addAttribute("vastaukset", vastausrepo.findAll());
    return "vastausraportti";
}

}
