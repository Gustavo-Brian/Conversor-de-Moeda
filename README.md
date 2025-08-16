Conversor de Moedas
Este é um projeto simples em Java que permite converter valores entre diferentes moedas, utilizando uma API externa para obter as taxas de câmbio em tempo real.

Pré-requisitos
Para rodar este projeto na sua máquina, você vai precisar do seguinte:

Java Development Kit (JDK) 17 ou superior
Biblioteca Gson

Configuração da Chave da API
Este projeto utiliza a API exchangerate-api.com para obter as taxas de câmbio. Para que ele funcione, você precisa:

Obter uma Chave da API: Visite exchangerate-api.com e registre-se para obter sua chave de API gratuita.

Inserir a Chave no Código: Abra o arquivo src/main/java/service/ConversorMoedas.java e localize a linha que define CHAVE_API:

private static final String CHAVE_API = "SUA_CHAVE_AQUI";

Substitua "SUA_CHAVE_AQUI" pela chave que você obteve.

Como Compilar e Executar
Siga os passos abaixo para compilar e rodar o projeto:

Clone o Repositório (ou faça o download): Se o projeto estiver em um repositório Git, clone-o para sua máquina local:

git clone <URL_DO_SEU_REPOSITORIO>

Se você apenas baixou os arquivos, descompacte-os em uma pasta de sua preferência.

Navegue até a Pasta do Projeto: Abra seu terminal ou prompt de comando e vá até a pasta raiz do projeto (onde está o arquivo pom.xml):

cd /caminho/para/seu/projeto/conversor-moedas

Compile o Projeto: Use o Maven para compilar o projeto e gerar o arquivo executável (JAR):

mvn clean install

Este comando irá baixar as dependências (como a biblioteca Gson) e compilar o código. Você deverá ver uma mensagem de BUILD SUCCESS no final.

Execute a Aplicação: Após a compilação, o arquivo JAR executável estará na pasta target. Execute-o com o comando Java:

java -jar target/conversor-moedas-1.0-SNAPSHOT.jar

(O nome do arquivo JAR pode variar ligeiramente, verifique a pasta target para o nome exato se for diferente de conversor-moedas-1.0-SNAPSHOT.jar).

Agora, o programa deverá iniciar no seu terminal, apresentando o menu do conversor de moedas!

Dúvidas ou Problemas?
Se você encontrar algum problema durante a configuração ou execução, sinta-se à vontade para abrir uma "issue" no seu repositório Git (se tiver um) ou revisar os passos acima.
