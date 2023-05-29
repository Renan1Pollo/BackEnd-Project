## Documentação
Ao longo deste documento, será explicado todos os padrões que devem ser seguidos para o desenvolvimento de qualquer back-end feito pelo CEPEIN.

#### Padrão de nomenclatura de variavel CamelCase
Este padrão consistem em nomear as variaveis com nomes compostos retirando seus espaços e adicionando uma letra maiúscula ao inicio da palavra. Exemplo: 
- Se a variável deve representar o nome do cliente, o nome da variável pode ser escrito como nomeCliente.

O padrão *CamelCase* deve ser usado em todo o projeto.

#### Introdução
Neste projeto, já é incluso o pacote de **segurança**, que inclui todos os *interceptors* (interceptadores) que validam:
* O token em sua estrutura, validade e permissões.
* A origem permitida para acessar a aplicação.

Além de também possuirem os modelos de **Usuario** e **Permissão**, e o *Data Transfer Object* (**DTO**) da mensagem que é enviada quando o token está inválido, chamado **RequisicaoInvalidaDTO**.

#### Organização dos pacotes
Para cada funcionalidade, deverá ser criado um pacote com o nome desta funcionalidade com os seguintes pacotes:
* model
* dto
* form
* repository
* resource
* service
Em cada pacote, respectivamente, deve se conter as seguintes classes:  

##### Model
O *Model* (**Modelo**) deve conter as Classes do projeto, sejam elas mapeadas pelo Manco de Dados ou não.  
A nomenclatura deve ser apenas o nome a qual representa (Caso represente uma tabela, será o nome da tabela em *CamelCase*).

##### DTO
O *Data Transfer Object* (Objeto de Transferencia de Dados) deve conter apenas os atributos nescessários para retornar a requisição.  
A nomenclatura deve ser o nome da classe a qual representa, acrescido do sufixo "**DTO**".  
Exemplo:

Model: Cliente.java {id: Long, nome: String, rg: String, cpf: String}  
DTO: ClienteDTO.java {id: Long, nome: String}

##### FORM
O *Form* representa um objeto que é transferido do front-end para o back-end, para não expor dados desnecessários no modelo. A nomenclatura deve ser o nome da classe a qual representa, acrescido do sufixo "**FORM**".  
Exemplo:

Model: Cliente.java {id: Long, nome: String, rg: String, cpf: String}  
FORM: ClienteFORM.java {nome: String, rg: String, cpf: String}

##### Repository
O *Repository* é uma interface responsável unicamente pelo acesso ao Banco de Dados mapeado em dado **Modelo**. Nela deverão ser criados os métodos *JPA* personalizados.  
A nomenclatura deve ser o nome do **Modelo** a qual representa, acrescido do sufixo "**Repository**".  
Exemplo:

Model: Cliente.java {id: Long, nome: String, rg: String, cpf: String}
Repository: ClienteRepository.java
**OBS:** A interface "ClienteRepository" devera implementar JpaRepository<Cliente, Long>, sendo o primeiro parametro sempre o **Modelo** a qual representa no banco, e o segundo o tipo de dado do **id** da mesma.

##### Resource
O *Resource* é uma classe responsável pelos End-Points da aplicação, sendo a classe o End-Point mais geral, e cada método que possuir com seu próprio.  
Os métodos dessa classe deverão chamar os métodos de uma ou mais classes injetadas denominadas *Service*. O nome das variáveis que as representação deverá ser o mesmo nome da classe de *Service*, porém com a inicial minúscula.  
A nomenclatura deve ser o nome da **funcionalidade** a qual representa, acrescido do sufixo "**Resource**".  
Exemplo:

Funcionalidade: Atendimento de Cliente
Resource: AtendimentoClienteResource.java // Exemplo de End-point: /atendimento-cliente

##### Service
O *Service* é uma classe responsável por todos os processos do tratamento do dado e seu destino.  
Caso seja nescessário salvar ou recuperar dados, esta classe deverá injetar a interface Repository referente ao modelo ao qual vai trabalhar, sendo o nome da variável que a representa o mesmo nome da classe de *Repository*, porém com a inicial minúscula.
A nomenclatura deve ser o nome da **funcionalidade** a qual representa, acrescido do sufixo "**Service**".  
Exemplo:  

Funcionalidade: Atendimento de Cliente
Resource: AtendimentoClienteService.java
