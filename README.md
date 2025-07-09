# 📚 Sistema de Biblioteca – Padrões de Projeto e Princípios SOLID em Java

Este repositório contém a implementação de um **Sistema de Gerenciamento de Biblioteca** em Java, desenvolvido como projeto de estudo de **Engenharia de Software**. O sistema aplica diversos **padrões de projeto** e os **princípios SOLID**, com foco em código limpo, modular e orientado a objetos.

Todas as classes estão organizadas de forma separada por arquivos para facilitar a leitura e reutilização.

## Conceitos e Padrões Utilizados

### Padrões de Projeto

- **Singleton**  
  As classes `ConsoleIO` e `Repositorio` utilizam o padrão Singleton para garantir uma única instância por meio do método estático `getInstancia()`.

- **Command**  
  Cada ação do sistema (como `EmprestarComando`, `DevolverComando`, `ConsultarUsuarioComando`, etc.) implementa a interface `Comando`, encapsulando requisições como objetos reutilizáveis.

- **Observer**  
  A classe `Livro` implementa a interface `Subject`, permitindo o registro de observadores (como `Professor`) que são notificados automaticamente quando há novas reservas.

- **Strategy**  
  A interface `IRegraEmprestimo` e suas implementações (`RegraEmprestimoAluno`, `RegraEmprestimoProfessor`) permitem que regras de empréstimo sejam definidas dinamicamente, conforme o tipo de usuário.

### Princípios SOLID

- **S – Single Responsibility (Responsabilidade Única)**  
  Cada classe tem uma responsabilidade clara, como `Emprestimo` que lida com os dados de empréstimos ou `Livro` que gerencia exemplares e reservas.

- **O – Open/Closed (Aberto/Fechado)**  
  É possível adicionar novos comandos ou tipos de usuários sem modificar as classes existentes.

- **L – Liskov Substitution (Substituição de Liskov)**  
  Subclasses como `Graduacao`, `PosGraduacao` e `Professor` podem ser usadas no lugar da classe `Usuario` sem alterar o comportamento do sistema.

- **I – Interface Segregation (Segregação de Interfaces)**  
  Interfaces como `Comando`, `Observer` e `Subject` são específicas e focadas.

- **D – Dependency Inversion (Inversão de Dependência)**  
  O sistema depende de abstrações (interfaces), como `Comando` e `IRegraEmprestimo`, e não de implementações concretas.

---

## Funcionamento

- O usuário interage pelo console (`Main.java`)
- Os comandos são mapeados e executados dinamicamente pela classe `Sistema`
- Os dados são mantidos em memória usando o Singleton `Repositorio`
- Usuários podem pegar livros emprestados, devolver, reservar e se registrar como observadores
- Professores são automaticamente notificados quando o número de reservas de um livro atinge um certo limite

---

## Comandos Disponíveis

| Comando | Ação                               | Classe Responsável               |
|---------|------------------------------------|----------------------------------|
| `emp`   | Realizar empréstimo                | `EmprestarComando`              |
| `dev`   | Realizar devolução                 | `DevolverComando`               |
| `res`   | Realizar reserva                   | `ReservarComando`               |
| `obs`   | Registrar observador para um livro | `RegistrarObservadorComando`    |
| `liv`   | Consultar informações do livro     | `ConsultarLivroComando`         |
| `usu`   | Consultar informações do usuário   | `ConsultarUsuarioComando`       |
| `ntf`   | Consultar notificações recebidas   | `ConsultarNotificacoesComando`  |
| `sai`   | Encerrar o sistema                 | `SairComando`                   |

---
