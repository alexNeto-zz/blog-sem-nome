# Blog Sem Nome

## exemplos de:

- Java versão 8 ou superior: [build.gradle](https://github.com/alexNeto/blog-sem-nome/blob/master/build.gradle#L10)
- JPA com Hibernate 5 ou superior: [build.gradle](https://github.com/alexNeto/blog-sem-nome/blob/master/build.gradle#L21)
- Padrão MVC:
  - [model: TopicoServico.java](https://github.com/alexNeto/blog-sem-nome/blob/master/src/main/java/com/blog/topico/TopicoServico.java)
  - [view: topico.jsp](https://github.com/alexNeto/blog-sem-nome/blob/master/src/main/webapp/topico.jsp)
  - [controller: TopicoControlador](https://github.com/alexNeto/blog-sem-nome/blob/master/src/main/java/com/blog/topico/TopicoControlador.java)
- Servlet anotados: [TopicoControlador](https://github.com/alexNeto/blog-sem-nome/blob/master/src/main/java/com/blog/topico/TopicoControlador.java#L14)
- Java Server Page: [topico.jsp](https://github.com/alexNeto/blog-sem-nome/blob/master/src/main/webapp/topico.jsp)
- Javascript Closure: [autenticacao.js](https://github.com/alexNeto/blog-sem-nome/blob/master/src/main/webapp/src/js/autenticacao.js#L47)
- Javascript DOM handler: [autenticacao.js](https://github.com/alexNeto/blog-sem-nome/blob/master/src/main/webapp/src/js/autenticacao.js#L90)
- Javascript event listner: [autenticacao.js](https://github.com/alexNeto/blog-sem-nome/blob/master/src/main/webapp/src/js/autenticacao.js#L129)
- Javascript para criar elementos do DOM dinâmcamente: [principal.js](https://github.com/alexNeto/blog-sem-nome/blob/master/src/main/webapp/src/js/principal.js#L79)
- Utilização de JQuery: [autenticacao.js](https://github.com/alexNeto/blog-sem-nome/blob/master/src/main/webapp/src/js/autenticacao.js#L3)
- Marcação HTML5: [genrencia.jsp](https://github.com/alexNeto/blog-sem-nome/blob/master/src/main/webapp/gerencia.jsp)
- Fonte externa no CSS: [fonts.css](https://github.com/alexNeto/blog-sem-nome/blob/master/src/main/webapp/src/css/fonts.css) [fonts](https://github.com/alexNeto/blog-sem-nome/tree/master/src/main/webapp/src/assets/fonts)
- Media Query com CSS: [mestre.css](https://github.com/alexNeto/blog-sem-nome/blob/master/src/main/webapp/src/css/mestre.css#L27)
- Configuração do MySQL: [persistence.xml](https://github.com/alexNeto/blog-sem-nome/blob/master/src/main/resources/META-INF/persistence.xml)

# Dependencias

- gradle
- tomcat v8.0
- MariaDB

# Executando

- `$ git clone https://github.com/alexNeto/blog-sem-nome.git` ou baixe o zip e extraia o projeto
- `$ cd blog-sem-nome; gradle build`
- Crie um `database` com o nome de blog, `create database blog;`
- atualize as credenciais do banco de dados no [persistence.xml](https://github.com/alexNeto/blog-sem-nome/blob/master/src/main/resources/META-INF/persistence.xml) de acordo com as configurações do seu banco
- Use o plugin do tomcat do eclipse ou netbeans para rodar o tomcat, ou copie e cole o `blog.war` da pasta `build/libs` para a pasta webapp do seu tomcat
- acesse o link configurado do seu tomcat com o caminho /blog
