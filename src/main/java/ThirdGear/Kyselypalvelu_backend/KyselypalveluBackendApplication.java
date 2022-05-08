package ThirdGear.Kyselypalvelu_backend;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class KyselypalveluBackendApplication {
	
	private static final Logger log = LoggerFactory.getLogger(KyselypalveluBackendApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KyselypalveluBackendApplication.class, args);
	}	
}
