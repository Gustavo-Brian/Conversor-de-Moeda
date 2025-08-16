# Conversor de Moedas (Java)

Projeto Java simples que converte valores entre moedas usando uma API externa.

## Requisitos

- **Java 17+ (JDK)**
- **Conexão com a internet**
- **`Gson` (dependência externa obrigatória)**

## Configuração da Chave da API

1. Crie uma conta gratuita em **exchangerate-api.com** e obtenha sua chave.
2. Abra `src/main/java/service/ConversorMoedas.java` e defina:

   ```java
   private static final String CHAVE_API = "SUA_CHAVE_AQUI";

   
