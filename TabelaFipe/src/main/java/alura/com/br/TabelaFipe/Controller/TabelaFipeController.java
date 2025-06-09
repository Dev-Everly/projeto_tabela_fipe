package alura.com.br.TabelaFipe.Controller;



import alura.com.br.TabelaFipe.service.FipeService;

import java.util.Scanner;

public class TabelaFipeController {

    private Scanner scanner = new Scanner(System.in);
    private FipeService service = new FipeService();

    public void iniciarConsulta() {
        System.out.println("""
                *** OPÇÕES ***
                1 - Carro
                2 - Moto
                3 - Caminhão
                Digite o número da opção:
                """);
        var opcao = scanner.nextLine();
        service.consultarVeiculo(opcao, scanner);

    }

}
