Mutant Spotlight
================

Web app que permite compartilhar resultados de testes de mutação.

Hardcore Way
========

Build
-----

O build do projeto:
`mvn install`

Será gerado um pacote .war na pasta `target`.

Run
---

Baixe o servidor [Apache Tomcat](http://tomcat.apache.org/download-70.cgi), extraia o servidor e insira o pacote do build na pasta `[apache-tomcat]/webapps`. Em seguida, inicie o servidor executando `[apache-tomcat]/bin/startup.sh`


Eclipse J2EE
============

Importe o projeto para o seu workspace com File -> Import -> Existing Maven Projects. O Eclipse irá baixar todas as dependências do projeto automaticamente.

Run
---

Crie um servidor Apache Tomcat utilizando a ferramenta 'Server' do Eclipse e adicione o projeto no servidor. Agora é só rodar o servidor.
