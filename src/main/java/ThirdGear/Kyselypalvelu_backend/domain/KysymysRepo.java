package ThirdGear.Kyselypalvelu_backend.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;



@RepositoryRestResource
@CrossOrigin
public interface KysymysRepo extends CrudRepository<Kysymys, Long> {

	List<Kysymys> findByKysymysteksti(String kysymysteksti);
	List<Kysymys> findByKysely(Optional<Kysely> kysely);
	    
	   
}
