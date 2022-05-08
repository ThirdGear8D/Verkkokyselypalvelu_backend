package ThirdGear.Kyselypalvelu_backend.domain;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

//Repository käyttäjälle, Id tyyppi on Long
public interface UserRepository extends CrudRepository<User, Long> {
	//käyttäjä haetaan käyttäjänimen perusteella (Spring security käyttää tätä metodia)
	User findByUsername(String username);
}