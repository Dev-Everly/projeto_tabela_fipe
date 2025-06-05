package alura.com.br.TabelaFipe.principal;

import alura.com.br.TabelaFipe.service.ConsumoApi;

import java.util.Scanner;

public class Principal {
   private  Scanner scanner = new Scanner(System.in);
   private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";

   private ConsumoApi consumo = new ConsumoApi();

    public void exibirMenu() {

        var menu = """
                *** OPÇÕES ***
                Carro
                Moto
                Caminhão
                
                Digite uma das opções para comsultar:
                """;

        System.out.println(menu);
        var opcao = scanner.nextLine();

        String endereco;

        if(opcao.toLowerCase().contains("carr")) {
            endereco = URL_BASE + "carros/marcas";
        } else if(opcao.toLowerCase().contains("mot")) {
            endereco = URL_BASE + "motos/marcas";
        } else {
            endereco = URL_BASE + "caminhoes/marcas";
        }

        var json = consumo.obterDados(endereco);
        System.out.println(json);

    }
}
