# Atividade-1BI-ApBD
Atividade referente a 1 Bimestral de Aplicação de Banco de Dados

Curso de Tecnologia em Análise e Desenvolvimento de Sistemas do Instituto Federal do Pará

Discente: Adinayane Souza.

Sobre o projeto:
Sistema de Biblioteca que realiza empréstimos conforme solicitado na atividade.
 - Java Versão 17, H2 Database e Hibernate.
 - Acompanha pom.xml e persistence.xml



Organização:
O projeto possui a seguinte estrutura:
 - pom.xml
 - META-INF: persistence.xml
 - dao: EmprestimoDAO
 - entidade: Aluno, Emprestimo e Publicacao
 - main: TesteBiblioteca
 - recursos: Config, SQL-At1BI-ApBD (criação de tabelas) e SQL-At1BI-ApBD-POPULAÇÃO (inserção de dados nas tabelas)

Orientações:
 - No H2, crie o banco de dados denominado "biblioteca" conforme o caminho indicado no persistence.xml
 - Utilize o pom.xml para instalação das depedências e persistence.xml para a configuração do banco.
 - As tabelas são criadas automaticamente. Se não ocorrer, utilizar o SQL de criação de tabelas (SQL-At1BI-ApBD).
 - Popule o banco usando os comandos em SQL-At1BI-ApBD-POPULAÇÃO.
 - Para testar o CRUD, em TesteBiblioteca, chame cada método na método principal.

Observações:
- em Config está a principal estrutura de conexão do banco, separada em métodos estáticos. Tomar cuidado ao manipular.
