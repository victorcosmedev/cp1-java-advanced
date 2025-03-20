# DOCUMENTAÇÃO CP1 - JAVA

Este projeto tem como objetivo desenvolver um sistema em **Java** para gerenciar funcionários, aplicando conceitos de **orientação a objetos**, **herança**, **sobrescrita de métodos** e **anotações personalizadas**. Além disso, o projeto implementa a geração automática de código SQL utilizando **Reflection** e **Hibernate** para integração com um banco de dados **Oracle**.
## Nome Integrantes
<div align="center">

| Nome | RM |
| ------------- |:-------------:|
| Arthur Eduardo Luna Pulini|554848|
|Lucas Almeida Fernandes de Moraes| 557569     |
|Victor Nascimento Cosme|558856|

</div>

## Informações
Antes de realmente começarmos, preciso passar algumas informações. Ao criarmos a classe `Funcionario`, também criamos o **`SequenceGenerator`** com o **`sequenceName = "SQ_FUNCIONARIO"`**. Caso essa sequência já exista no banco Oracle, podem ocorrer alguns erros durante os testes, especificamente nas operações de **`ViewDAODelete`**, **`ViewDAOBuscarPorID`** e **`ViewDAOAtualizar`**.

Para evitar esses erros, recomendo que altere o nome da sequência para algo como **`SQ_FUNCIONARIO_XTL`**. Com isso, uma nova sequência será gerada e os erros serão evitados.
## 🚀 Começando
Como solicitado fizemos a classe `Funcionario`, ele é uma `abstract`, as anotações que utilizamos nela foram: 

![image](https://github.com/user-attachments/assets/919486c6-59c3-4baf-9330-4b6314406793)
A única diferença é que foi utilizada a anotação `@Inheritance(strategy = InheritanceType.JOINED)`, que serve para criar tabelas separadas no banco de dados quando uma classe é herdada por outra.

E seus atributos estão assim:
![image](https://github.com/user-attachments/assets/d931fa79-d29e-4951-a60c-ad8af96621ca)

Seguindo como solicidado dois métodos:

![image](https://github.com/user-attachments/assets/42089b0a-0fc4-473e-bfed-3562e6222bf3)


A herança de classe está assim: 

```mermaid
graph TD;
    Funcionario --> FuncionarioJunior;
    Funcionario --> FuncionarioSenior;
    Funcionario --> FuncionarioPleno;
```

Os métodos `calcularSalario` e `imprimirInformacao` têm poucas diferenças entre si. No método `calcularSalario`, a alteração está na porcentagem de ganho a cada 15 horas trabalhadas, enquanto no método `imprimirInformacao`, as mudanças se limitam a alguns prints.


## ⚙️ Executando os testes

Os testes foram realizados no pacote chamado `view`, e todas as classes tem algum tipo de teste, a seguir vou falar dos testes seguindo o *CRUD* *(Create, Read, Update e Delete)*.

### ViewDAOCadastro
![image](https://github.com/user-attachments/assets/2b1f2d7a-0850-408a-a0eb-bf3b98b12f56)

O começo é igual para todas as Views, como pode ver, criamos três funcionários, um de cada classe. Em seguida, instanciamos a `EntityManagerFactory`, depois criamos o `EntityManager` e chamamos a `FuncionarioDAOImpl`, que é responsável pela operação de _Create_.

Ao rodarmos o código, ele irá aparecer algumas informações, com a criação da _anotation_ @Tabela, ela irá printar isso:
![image](https://github.com/user-attachments/assets/9dd946c8-4f66-4650-8b89-94892d029070)
![image](https://github.com/user-attachments/assets/35beada5-6da1-4938-9317-59a28b60446b)
![image](https://github.com/user-attachments/assets/c174f3b3-de67-4c74-b0c1-4a45adf41302)

Mas a Hibernate fornece outra saída:

![image](https://github.com/user-attachments/assets/c659bc5e-2b42-4bf3-82dc-81084abcf23b)
![image](https://github.com/user-attachments/assets/356256cd-08be-4062-9731-1163cfdd6cc7)
![image](https://github.com/user-attachments/assets/3944f309-81fe-46b7-97c3-80ff87f2d32f)

## ViewDAOBuscarPorID
![image](https://github.com/user-attachments/assets/7602ed53-e362-4b5f-94af-c40edc9dfbad)

Como falado anteriormente os IDs estão bem diferente pois fizemos varios testes para chegarmos nessa solução, mas quando finalizar vou deixar os IDs como 1,2,3.. 
como se fosse a primeira vez rodando.

Ela chama a função `imprimirInformacao`, que retorna as informações do Funcionario já com o salário atualizado.

Com o @Tabela ela imprime assim: 

![image](https://github.com/user-attachments/assets/0978ea02-62f4-4711-a806-905540cc8f8d)

Com o Hibernate:

![image](https://github.com/user-attachments/assets/3055764c-4563-4c64-82e5-ed597d44b32d)

Ele faz um join, por causa do `@Inheritance(strategy = InheritanceType.JOINED)` que colocamos na classe pai.

E junto com essa saída ele imprime as informações do funcionario:

![image](https://github.com/user-attachments/assets/ef31ecd0-44e0-4823-a0f2-1c6f7af0f11c)

Vou fazer só com um funcionario porque se não vai ficar muito grande.

## ViewDAOAtualizar

![image](https://github.com/user-attachments/assets/edb124c9-c09a-4d50-be3c-d6e43e13e415)

Com o @Tabela:

![image](https://github.com/user-attachments/assets/2777438d-db6f-423b-bcfc-afb87981b069)

Com o Hibernate:

![image](https://github.com/user-attachments/assets/e7b3c5b4-05f7-46b7-a0c7-c554d97ef6d6)


## ViewDAODelete

![image](https://github.com/user-attachments/assets/7a65ac59-df75-4935-a23d-2445c7f2f670)

Com o @Tabela:

![image](https://github.com/user-attachments/assets/6b1c6614-d2f6-435d-ab17-c03f8a4dab11)

Com o Hibernate:

![image](https://github.com/user-attachments/assets/c1bcd35f-2bcd-42b1-a123-1679f53a504d)
