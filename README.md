# Sistema de Autenticação com Spring Security e OAuth2
[![Java](https://img.shields.io/badge/Java-17-%23ED8B00?logo=openjdk)](https://jdk.java.net/17/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.4.5-%236DB33F?logo=spring)](https://spring.io/projects/spring-boot)
[![Spring Security](https://img.shields.io/badge/Spring_Security-6.4.5-%236DB33F?logo=spring)](https://spring.io/projects/spring-security)
[![OAuth2](https://img.shields.io/badge/OAuth2-3.4.5-%23EB5424?logo=oauth)](https://oauth.net/2/)
[![Thymeleaf](https://img.shields.io/badge/Thymeleaf-3.1.3-%23005F0F?logo=thymeleaf)](https://www.thymeleaf.org/)

Este projeto demostra diferentes abordagens de autenticação utilizando o Spring Security, distribuídas em três branches distintas. Cada branch implementa uma estratégia de autenticação específica, com foco em aprendizado e aplicação práticas e recursos modernos de segurança em aplicações Java com Spring Boot.

<h2></h2>
<h3>Principais Tecnologias e Ferramentas</h3>

  [![My Skills](https://skillicons.dev/icons?i=git,java,spring,bootstrap,idea,postman&perline=6)](https://skillicons.dev)
<h2></h2>

<h3>1# Branch - feat/in-memory-auth</h3>
Autenticação básica.

- Implementa Basic Auth padrão do Spring Security.
- As credenciais estão sendo armazenadas no H2.
- Ideal para testes rápidos ou aplicações simples com requisitos mínimos de segurança.

<h2></h2>

<h3>2# Branch - feat/google-login</h3>
Autenticação Social com Google OAuth2.

- Integra login com conta Google via OAuth2.
- Utiliza Thymeleaf como motor de templates para redenrização das páginas de login e home.
- As páginas estão estilizadas com Bootstrap, oferecendo uma interface simples.
- Branch totalmente funcional e pronta para uso ou extensão.

<div align="center">
  <img src="https://github.com/Ki3lMigu3l/api-springboot-auth-jwt/blob/main/docs/login.png" width="600px" />
  <p><em>Página de Login.</em></p>
</div>

<div align="center">
  <img src="https://github.com/Ki3lMigu3l/api-springboot-auth-jwt/blob/main/docs/home.png" width="600px" />
  <p><em>Página Home</em></p>
</div>

<h2></h2>
<h3>3# Branch - feat/jwt-integration (Em desenvolvimento)</h3>
