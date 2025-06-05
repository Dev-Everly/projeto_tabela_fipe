package alura.com.br.TabelaFipe.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
}
