package alura.com.br.TabelaFipe;

import alura.com.br.TabelaFipe.principal.Principal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TabelaFipeApplication {

	public static void main(String[] args) {

		SpringApplication.run(TabelaFipeApplication.class, args);

		Principal principal = new Principal();
		principal.exibirMenu();
	}

}
