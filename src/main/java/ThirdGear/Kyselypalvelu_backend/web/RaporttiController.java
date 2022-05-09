package ThirdGear.Kyselypalvelu_backend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ThirdGear.Kyselypalvelu_backend.domain.KyselyRepo;



@Controller
public class RaporttiController {
	
	@Autowired	
	private KyselyRepo kyselyrepo; 
	

	
	@RequestMapping(value = "/vastausraportit")
	public String kyselyRaportit(Model model) {
		model.addAttribute("kyselyt", kyselyrepo.findAll());
		return "vastausraportit";
	}	
	
	
	
	

}
