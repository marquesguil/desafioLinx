# desafioLinx
CRUD Users

Instalação das ferramentas
Checklist:
 Google Chrome
 Postman: https://www.postman.com/downloads/
 Java JDK (versão LTS 11)
o https://www.oracle.com/java/technologies/javase-downloads.html
o https://downloads.apache.org/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.zip
  Após download do apache maven, pegar arquivo zip e desconpactar no C:\
  
o Configurar variáveis de ambiente do sistema
 Painel de Controle -> Variáveis de Ambiente
 JAVA_HOME:
 C:\Program Files\Java\jdk-11.0.6
 Path: incluir
 C:\Program Files\Java\jdk-11.0.6\bin
 Testar no terminal de comando: java -version
Vídeo: https://www.youtube.com/watch?v=-LdVKkKLGk

o Configurar variáveis de ambiente do sistema
 M2_HOME:
 C:\apache-maven-3.6.3
 Path: incluir
 C:\apache-maven-3.6.3\bin
 Testar no terminal de comando: mvn -version
Vídeo: https://www.youtube.com/watch?v=-ucX5w8Zm8s

Intellij IDEA
https://www.jetbrains.com/pt-br/idea/download/download-thanks.html?platform=windows&code=IIC
Instalação default

Open project e selecionar o projeto clonado do repositorio.

Obs.:O banco de dados utilizado é o M2, ele é instânciado em memória, ou seja, sempre que o projeto para, o banco é excluido e a insformações nele também.

Payload para inserção usando o método POST:

{
    "id": 1,
    "name": "Leanne Graham",
    "username": "Bret",
    "email": "Sincere@april.biz",
    "address": {
      "street": "Kulas Light",
      "suite": "Apt. 556",
      "city": "Gwenborough",
      "zipcode": "92998-3874",
      "geo": {
        "lat": "-37.3159",
        "lng": "81.1496"
      }
    },
    "phone": "1-770-736-8031 x56442",
    "website": "hildegard.org",
    "company": {
      "name": "Romaguera-Crona",
      "catchPhrase": "Multi-layered client-server neural-net",
      "bs": "harness real-time e-markets"
    }
}
