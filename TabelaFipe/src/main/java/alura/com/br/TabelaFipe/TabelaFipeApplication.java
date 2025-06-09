package alura.com.br.TabelaFipe;

import alura.com.br.TabelaFipe.Controller.TabelaFipeController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.Principal;

@SpringBootApplication
public class TabelaFipeApplication {

	public static void main(String[] args) {

		SpringApplication.run(TabelaFipeApplication.class, args);



		TabelaFipeController controller = new TabelaFipeController();
		controller.iniciarConsulta();

	}

}
