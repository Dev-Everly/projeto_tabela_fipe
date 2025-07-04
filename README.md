# 🚗 FIPE Consulta - Java API Client

Este é um projeto Java que permite consultar marcas, modelos e valores de veículos (carros, motos e caminhões) usando a [API pública da Tabela FIPE](https://deividfortuna.github.io/fipe/).

> Projeto desenvolvido como prática de consumo de APIs REST com Java, utilizando `HttpClient`, `Jackson`, `Java`, `Spring`' e boas práticas de organização de código  utilizando conceitos como coleções, listas e streams no Java.

---

## 📌 Funcionalidades

- Consulta de marcas disponíveis por tipo de veículo (carros, motos, caminhões)
- Filtragem de modelos por nome
- Exibição de avaliações de preço por ano
- Leitura de dados da API FIPE em tempo real
- Conversão de JSON para objetos Java (`record`)
- Organização limpa em camadas: `Service`, `Model`, `API`, `Conversão`,`Controller`

---

## 🛠 Tecnologias Utilizadas

- **Java 17+**
- `HttpClient` (java.net.http)
- `Jackson` (para serialização/deserialização JSON)
- API REST da FIPE
- IDE: IntelliJ / Eclipse
- -Spring

---

## 📂 Estrutura do Projeto

src/
- ├── alura.com.br.TabelaFipe/
- | |__Controller
- │ ├── Model
- │ ├── Service
- └── Main.java
# Dicas de usabilidade
## Selecione o tipo de veículo:
-  1 - Carros
-  2 - Motos
-  3 - Caminhões

## Digite a marca do veículo: Fiat

-  Digite o modelo: Uno

-  Digite o código do modelo: 4763

-  📋 Veículos e suas avaliações:
-  Ano: 2013 | Modelo: Uno Mille Celeb. WAY ECON. 1.0 F.Flex 2p | Valor: R$ 24.689,00 | Combustível: Gasolina
...

