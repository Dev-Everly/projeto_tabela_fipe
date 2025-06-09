package alura.com.br.TabelaFipe.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.List;

public class ConverteDados implements IConverteDados{

    //ObjectMapper converte json -> Objeto java
    private ObjectMapper mapper = new ObjectMapper();

    @Override // metodo generico devolve um objeto do tipo escolhido na chamada
    public <T> T obterDados(String json, Class<T> classe) {
        try {
            //mapper.readValue() -> lê a string json e tenta converter para o objeto da classe
            return mapper.readValue(json,classe);
        } catch (JsonProcessingException e ) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> List<T> obterLista(String json, Class<T> classe) {

        //coleções genericas do tipo que eu passar
        CollectionType lista = mapper.getTypeFactory()
                .constructCollectionType(List.class, classe); //construir lista do tipo de objeto que eu passar

        try {
            return mapper.readValue(json, lista);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
