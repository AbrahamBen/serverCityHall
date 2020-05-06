package cg.powersoft.server.cityhall;

import cg.powersoft.server.cityhall.service.IDeclarationInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerCityHallApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ServerCityHallApplication.class, args);
	}


	//Injection de dependance
	@Autowired
	IDeclarationInitService iDeclarationInitService;
	/**
	 * Callback used to run the bean.
	 *
	 * @param args incoming main method arguments
	 * @throws Exception on error
	 */
	@Override
	public void run(String... args) throws Exception {
		iDeclarationInitService.initDocuments();
		iDeclarationInitService.initNationalites();
		iDeclarationInitService.initPeres();
		iDeclarationInitService.initMeres();
		iDeclarationInitService.initEnfants();
		iDeclarationInitService.initDeclarations();
	}
}
