package alura.com.br.TabelaFipe.service;

import alura.com.br.TabelaFipe.model.Dados;
import alura.com.br.TabelaFipe.model.Modelos;
import alura.com.br.TabelaFipe.model.Veiculo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FipeService {

    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

    public void consultarVeiculo(String opcao, Scanner scanner) {

        String tipoVeiculo = switch (opcao) {
            case "1" -> "carros";
            case "2" -> "motos";
            case "3" -> "caminhoes";
            default -> {
                System.out.println("Opção inválida");
                yield null;
            }

        };
        if (tipoVeiculo == null) return;


        var endereco = URL_BASE + tipoVeiculo + "/marcas";
        var marcas = conversor.obterLista(consumo.obterDados(endereco), Dados.class);
        var json = consumo.obterDados(endereco);

        System.out.println("\n Lista de Marcas: ");
        marcas.forEach(m -> System.out.println(" - " + m.nome()));

        System.out.println("\nDigite a marca do veículo: ");
        var nomeMarca = scanner.nextLine();

        var marcaEscolhida = marcas.stream()
                .filter(m -> m.nome().equalsIgnoreCase(nomeMarca.toLowerCase()))
                .findFirst()
                .orElse(null);


        if (marcaEscolhida == null) {
            System.out.println("Marca não encontrada.");
            return;
        }

        var codigoMarca = marcaEscolhida.codigo();

        endereco = URL_BASE + tipoVeiculo + "/marcas/" + codigoMarca + "/modelos";
        var modeloLista = conversor.obterDados(consumo.obterDados(endereco), Modelos.class);

        System.out.println("\nLista de Modelos:");
        modeloLista.modelos().stream()
                .sorted(Comparator.comparing(Dados::nome))
                .forEach(m -> System.out.println("- " + m.nome()));

        System.out.println("\nDigite o nome do modelo desejado:");
        var nomeModelo = scanner.nextLine();

        List<Dados> modelosFiltrados = modeloLista.modelos().stream()
                .filter(m -> m.nome().toLowerCase().contains(nomeModelo.toLowerCase()))
                .sorted(Comparator.comparing(Dados::codigo).reversed())
                .collect(Collectors.toList());

        if (modelosFiltrados.isEmpty()) {
            System.out.println("Nenhum modelo encontrado com esse nome.");
            return;
        }


        System.out.println("\nModelos encontrados: ");
        modelosFiltrados.forEach(System.out::println);


        System.out.println("\nDigite por favor o código do modelo para buscar os valores de avaliação: ");
        var codigoModelo = scanner.nextLine();

         endereco = URL_BASE + tipoVeiculo + "/marcas/" + codigoMarca + "/modelos/" + codigoModelo + "/anos";


        json = consumo.obterDados(endereco );
         List<Dados> anos = conversor.obterLista(json, Dados.class);
         List<Veiculo> veiculos = new ArrayList<>();

        for (int i = 0; i < anos.size(); i++) {
            var enderecoAnos = endereco + "/" + anos.get(i).codigo();
            json = consumo.obterDados(enderecoAnos);
            Veiculo veiculo = conversor.obterDados(json, Veiculo.class);
            veiculos.add(veiculo);
        }




        System.out.println("\nVeiculos e suas avalições filtrados por ano: ");
        veiculos.forEach(v -> System.out.printf("Ano: %d | Modelo: %s | Valor: %s | Combustível: %s%n",
                v.ano(), v.modelo(), v.valor(), v.tipoCombustivel()));



    }
}