# Documento de Arquitetura

## Histórico de Versões

| Data | Versão | Autor(a) | Descrição |
| - | - | - | - |
| 05/09/2019 | 0.1 | João Gabriel | Criação do índice e adição da introdução|
| 05/09/2019 | 0.2 | Gabriel e João Paulo | Adição da visão lógica e desempenho|
| 06/09/2019 | 0.3 | Isabella | Adição de Restrições do projeto|
| 06/09/2019 | 0.4 | Isabella e João Gabriel | Adição de Qualidade|
| 06/09/2019 | 0.5 | Luiza | Adição de Visão de Casos de Uso|
| 09/09/2019 | 0.6 | Erick | Adição de Representação da Arquitetura e correção de índice|
| 10/09/2019 | 0.7 | Natália, Luiza, João Paulo, Erick, Maria Luiza | Adição do Diagrama de Casos de Uso |
| 11/09/2019 | 0.8 | Luiza | Refatoração da Visão de Casos de Uso|
| 11/09/2019 | 0.9 | Erick | Corrigindo índice|
| 11/09/2019 | 1.0 | Erick | Refatorando desempenho e realocando restrições|
| 11/09/2019 | 1.1 | João Gabriel| Refatoração da introdução|
| 11/09/2019 | 1.2 | Natália | Adição do diagrama de classes e do diagrama lógico |
| 13/09/2019 | 1.3 | João Paulo e Gabriel | Refatoração da Visão Lógica |
| 24/09/2019 | 1.4 | Natália | Refatoração do diagrama de classes e do diagrama lógico |
| 01/10/1029 | 1.5 | Isabella Carneiro | Refatoração da Introdução e Representação de Arquitetura |

- [1. Introdução](#_1-introdução)
  * [1.1. Objetivos](#_11-objetivos)
  * [1.2. Escopo do documento](#_12-escopo-do-documento)

- [2. Representação da Arquitetura](#_2-representação-da-arquitetura)

- [3. Restrições e Metas Arquiteturais](#_3-restrições-e-metas-arquiteturais)
  * [3.1. Restrições](#_31-restrições)
  * [3.2. Metas Arquiteturais](#_32-metas-arquiteturais)

- [4. Visão de Casos de Uso](#_4-visão-de-casos-de-uso)
  * [4.1. Diagrama de Casos de Uso](#_41-Diagrama-de-Casos-de-Uso)
  * [4.2. Descrição dos Casos de Uso](#_42-Descrição-dos-Casos-de-Uso)
    * [UC01 - Realizar Login](#uc01-realizar-login)
    * [UC02 - Cadastrar](#uc02-cadastrar)
    * [UC03 - Solicitar Crédito](#uc03-solicitar-crédito)
    * [UC04 - Visualizar Regras de Contratação](#uc04-visualizar-regras-de-contratação-de-crédito)
    * [UC05 - Fornecer Feedback da Solicitação de Crédito](#uc05-fornecer-feedback-da-solicitação-de-crédito)
    * [UC06 - Analisar Perfil do Usuário](#uc06-analisar-perfil-do-usuário)
    * [UC07 - Ativar Limite de Crédito](#uc07-ativar-limite-de-crédito)
    * [UC08 - Ajustar Limite](#uc08---ajustar-limite)
    * [UC09 - Acompanhar Limite](#uc09-acompanhar-limite)
    * [UC10 - Solicitar Aumento de Limite](#uc10-solicitar-aumento-de-limite)
    * [UC11 - Fornecer Feedback da Solicitação de Aumento](#uc11-fornecer-feedback-da-solicitação-de-aumento)
    * [UC12 - Visualizar Saldo da Conta](#uc12-visualizar-saldo-da-conta)
    * [UC13 - Visualizar Extrato da Conta](#uc13-visualizar-extrato-da-conta)
    * [UC14 - Pesquisar uma Transação](#uc1-pesquisar-uma-transação)
    * [UC15 - Visualizar Detalhamento da Dívida](#uc15-visualizar-detalhamento-da-dívida)
    * [UC16 - Solicitar Parcelamento da Dívida](#uc16-solicitar-parcelamento-da-dívida)

- [5. Visão Lógica](#_5-visão-lógica)
  * [5.1. Visão Geral](#_51-visão-geral)

- [6. Desempenho](#_6-desempenho)

- [7. Qualidade](#_7-qualidade)

## 1. Introdução

### 1.1. Objetivos

O objetivo deste documento é detalhar a arquitetura e tecnologias usadas no projeto, que se trata de um aplicativo mobile focado na função de Cheque Especial.

A necessidade deste detalhamento se dá para o melhor entendimento do que está sendo produzido e de que forma está sendo realizado.

###  1.2. Escopo do documento

Este documento contém detalhes sobre a arquitetura escolhida para o sistema, as lógicas por trás das implementações, as linguagens/tecnologias usadas, os padrões estabelecidos pela equipe, informações referentes à bancos de dados, além dos  diagramas de classe e de caso de uso.

## 2. Representação da Arquitetura

A arquitetura que está sendo utilizada segue o modelo cliente-servidor, que funciona de forma que o processamento de dados é dividido em processos diferentes. O primeiro processo é o que obtém os dados e o outro é o que realiza a manutenção das informações.

No caso da aplicação o responsável pelo primeiro processo citado será o FrontEnd que fará as requisições na API. A mesma está sendo feita em Node.js e é responsável por fazer a comunicação com o Banco de Dados.

<!-- No parágrafo acima, eu colocaria "No caso deste projeto, o papel de cliente será desempenhado pelo frontend da aplicação (que está sendo implementado em Kotlin) e o de servidor pela API (implementada em Node.js), que faz toda a comunicação com a camada de persistência dos dados." -->

Este tipo de arquitetura fornece alta escalabilidade e tem uma grande vantagem quando se trata de manutenção, ponto crítico no caso desde projeto.

<!-- Acho que não é preciso colocar que a manutenção é ponto crítico do projeto (porque ele vai ser um MVP utilizado para o teste da funcionalidade, não um sistema que será utilizado e mantido de fato). -->

![Arquitetura](/images/architecture.png)

## 3. Restrições e Metas Arquiteturais

### 3.1. Restrições

O sistema será desenvolvido para ser utilizado em smartphones com sistema Android.
Para alcançar tal finalidade será feito usando Node.js com express para o backend da aplicação e o frontend da mesma será utilizado o kotlin.
O modelo pretendido é cliente-servidor, priorizando a experiência do cliente com o sistema.

<!-- Aqui eu colocaria "Para alcançar tal finalidade, o backend do sistema (API que fará a comunicação com o banco de dados) será desenvolvido utilizando o Node.js com o framework Express, e o frontend (que fará interface com o usuário final) em Kotlin.-->

### 3.2. Metas Arquiteturais

A aplicação do Sistema de Oferta de Crédito terá como base de sua arquitetura o framework Express, que é baseado na linguagem de programação Node.js. O Express permite a criação de APIs de maneira robusta, rápida e fácil e conta com recursos para aplicativos mobile, necessários para o projeto. Ele conta também com um sistema de Views Intuitivo (MVC).

Uma vantagem da utilização do framework é a sua escalabilidade, sendo um requisito necessário para sistemas com diversas conexões concorrentes, além disso o framework é minimalista e flexível, o Express conta com bibliotecas para trabalhar com cookies, sessões, login de usuário e diversas outras funcionalidades.

<!-- Acho que o texto deste tópico não está adequado, ele está muito focado na utilização do Node com o Express e a aplicação não está sendo desenvolvida utilizando apenas essas tecnologias. Seria interessante colocar aqui, ao invés do detalhamento das tecnologias, o que se deseja entregar para o usuário final com o sistema. -->

## 4. Visão de Casos de Uso

<!-- Esse tópico aqui pode deixar que eu vou tomar conta. -->

### 4.1. Diagrama de Casos de Uso

![Diagrama de Casos de Uso](/images/use_cases_diagram.png)

### 4.2. Descrição dos Casos de Uso

#### UC01 - Realizar Login

|||
|--|--|
| Descrição | Esta funcionalidade é responsável por realizar login no aplicativo |
| Atores | Usuário |
| Pré-condições | Usuário deve estar conectado à internet |
| Pós-condições | Usuário estará logado na aplicação e Usuário terá acesso às funcionalidades da aplicação |
| Fluxo principal | [FP01] Este fluxo se inicia quando o usuário deseja realizar login na aplicação: <br>1. Usuário deve inserir o seu e-mail <br> 2. Usuário deve inserir sua senha <br>3. Usuário deve clicar “Entrar” [FE01] |
|Fluxo de exceção | [FE01] Verificação de conexão à internet <br> No passo 3 do fluxo principal a aplicação verificará se o usuário está conectado a internet, se não, o sistema não permitirá o login|

#### UC02 - Cadastrar

|||
|--|--|
| Descrição | Esta funcionalidade é responsável por realizar cadastro. |
| Atores | Usuário| 
| Pré-condições | Usuário deve estar conectado à internet| 
| Pós-condições | Aplicação permitirá que o usuário possua um cadastro e dará como resposta de sucesso no cadastro ao usuário o acesso às funcionalidades.| 
| Fluxo principal | [FP01] Este fluxo se inicia quando o usuário deseja realizar cadastro na aplicação: <br> 1. Usuário insere seu e-mail ou telefone <br> 2. Usuário insere seu nome completo <br> 3. Usuário insere seu nome de usuário (username) <br> 4. Usuário insere sua senha <br>5. Usuário clica “Cadastre-se”"[FE01] 
| Fluxo de exceção | [FE01] Verificação de conexão à internet <br> No passo 5 do fluxo principal a aplicação verifica se o usuário está conectado a internet, se não, o sistema não permitirá o cadastro na aplicação. |

#### UC03 - Solicitar Crédito
|||
 ----- | ----- 
Descrição | Esta função solicita a liberação da funcionalidade de crédito para o sistema 
Atores | Usuário 
Pré-condições | O usuário deverá estar logado no aplicativo 
Pós-condições | A solicitação deverá ter sido enviada para o sistema para análise 
Fluxo principal | [FP01] Este fluxo se inicia quando o usuário deseja solicitar o acesso à funcionalidade de crédito:<br>1. O usuário clica em "Solicitar Crédito"<br>2. O usuário lê os termos de uso da funcionalidade [UC04]<br>3. O usuário clica em "Aceitar Termos de Uso" [FE01]<br>4. O usuário clica em "Confirmar Solicitação" [FE02]
Fluxo de exceção | [FE01] Se o usuário prosseguir para o passo 4 antes de realizar o passo 3 o sistema retornará uma mensagem de erro<br>[FE02] O usuário poderá decidir não realizar a solicitação e clicar em "Cancelar" 

#### UC04 - Visualizar Regras de Contratação de Crédito
|||
----- | -----
Descrição | A aplicação mostra ao usuário uma tela com as regras de contratação de crédito
Atores | Usuário 
Pré-condições | O usuário deverá ter clicado em "Solicitar Crédito" 
Pós-condições | Deverá ter sido aberta uma tela com as regras de contratação de crédito 
Fluxo principal | Este fluxo se inicia quando o usuário clica no botão de "Solicitar Crédito" [UC01];<br>[FP01] O usuário lê as regras de contratação e decide aceitar ou não os termos de uso, podendo ir para o passo 3 em [UC03] ou para [FE02] em [UC03] 

#### UC05 - Fornecer Feedback da Solicitação de Crédito
|||
----- | -----
| Descrição | O sistema fornece ao usuário o retorno sobre sua solicitação de crédito [UC03] |
| Atores | Sistema |
|Pré-condições | O usuário deverá ter solicitado a funcionalidade de crédito e O sistema deverá ter analisado o perfil do usuário [UC06] |
| Pós-condições | O usuário deverá ter recebido o retorno de sua solicitação |
|Fluxo principal | [FP01] O sistema envia ao usuário a mensagem sinalizando a aprovação do crédito|
|Fluxo alternativo | [FA01] O sistema envia ao usuário a mensagem sinalizando que seu crédito não foi aprovado e a lista de possíveis motivos para o retorno negativo | 

#### UC06 - Analisar Perfil do Usuário
|||
----- | ----- 
Descrição | O sistema envia a solicitação para que o servidor do banco analise o perfil do usuário com base nos dados que tem disponível 
Atores | Sistema 
Pré-condições | O usuário deverá ter solicitado a funcionalidade de crédito [UC03] 
Pós-condições | O sistema deverá aprovar ou recusar o crédito 
Fluxo principal | [FP01] O sistema envia a solicitação de análise para o servidor com os dados do usuário [FE01] 
Fluxo de exceção | A aplicação verifica se o usuário está conectado a internet, se não, o sistema não enviará a solicitação de análise para o servidor 

#### UC07 - Ativar Limite de Crédito
|||
----- | ----- 
| Descrição | Essa funcionalidade permite que o usuário ative o crédito que deseja usar |
| Atores | Usuário |
| Pré-condições | O usuário deverá ter acesso a funcionalidade de crédito |
| Pós-condições | O crédito deverá estar disponível para o uso pelo usuário |
| Fluxo principal | [FP01] Esse fluxo occore quando o usuário deseja ativar o crédito: <br>1. O usuário seleciona o valor que deseja ativar em [UC08] [FA01]<br> 2. O usário clica em ativar crédito<br> 3. Aparecem as regras e condições de uso <br> 4. O usuário clica em "Confirmar Operação" [FE01] 
| Fluxo alternativo | [FA01] O usuário necessita de um valor de crédito maior do que ele tem disponível no sistema e clica em "Solicitar Aumento de Limite" [UC10] |
| Fluxo de exceção | [FE01] O usuário decide não realizar a operação e clica em "Cancelar" |

#### UC08 - Ajustar Limite
|||
----- | ----- 
Descrição | Essa função permite que o usuário ajuste o valor do crédito que deseja usar
Atores | Usuário 
Pré-condições | O usuário deverá ter clicado em "Ativar Crédito"
Pós-condições | O limite deve ter sido ajustado de acordo com o valor escolhido pelo usuário
Fluxo principal | [FP01] O usuário seleciona na barrinha o valor que deseja de crédito [FA01]
Fluxo alternativo | [FA01] O usuário pode desejar um limite maior e clicar na opção "Aumentar Limite"


#### UC09 - Acompanhar Limite
|||
----- | ----- 
Descrição | Essa funcionalidade tem como objetivo apresentar ao usuário o valor de limite que ele tem disponível 
Atores | Usuário
Pré-condições | O usuário deve ter ativado a funcionalidade de crédito
Pós-condições | O usuário deve ter visualizado o limite de crédito disponível
Fluxo principal | [FP01] O usuário clica em "Acompanhar Limite" e visualiza as informações


#### UC10 - Solicitar Aumento de Limite
|||
----- | -----
Descrição | Essa funcionalidade tem como objetivo realizar a solicitação de aumento do limite de crédito
Atores | Usuário
Pré-condições | O usuário deve ter acesso a funcionalidade de crédito
Pós-condições | A solicitação deve ter sido enviada para análise do sistema
Fluxo principal | [FP01] Este fluxo se inicia quando o usuário deseja solicitar o acesso à funcionalidade de crédito:<br>1. O usuário clica em "Solicitar Aumento de Limite"<br>2. O usuário digita o valor que deseja de limite [FE01]<br>3. O usuário clica em "Confirmar Solicitação" [FE02]
Fluxo de exceção | [FE01] O usuário prossegue para o passo 3 antes de realizar o passo 2 e o sistema retorna uma mensagem de erro<br>[FE02] O usuário pode decidir não aumentar o limite e clicar em "Cancelar"

#### UC11 - Fornecer Feedback da Solicitação de Aumento
|||
----- | -----
Descrição | O sistema fornece ao usuário o retorno sobre sua solicitação de crédito [UC10] 
Atores | Sistema 
Pré-condições | O usuário deverá ter solicitado o aumento de limite<br>O sistema deverá ter analisado o perfil do usuário [UC06] |
Pós-condições | O usuário deverá ter recebido o retorno de sua solicitação
Fluxo principal | [FP01] O sistema envia ao usuário a mensagem sinalizando a aprovação do aumento de limite
Fluxo alternativo | [FA01] O sistema envia ao usuário a mensagem sinalizando que seu aumento não foi aprovado e a lista de possíveis motivos para o retorno negativo 

#### UC12 - Visualizar Saldo da Conta
|||
----- | ----- 
Descrição | Essa funcionalidade tem como objetivo mostar o saldo da conta do usuário
Atores | Usuário
Pré-condições | O usuário deverá estar logado na aplicação
Pós-condições | O usuário deverá ter visualizado o saldo 
Fluxo principal | [FP01] O usuário clica em "Saldo da Conta" e o saldo é mostrado na tela


#### UC13 - Visualizar Extrato da Conta
|||
----- | ----- 
Descrição | Essa funcionalidade tem como objetivo apresentar as transações realizadas pelo usuário
Atores | Usuário
Pré-condições | O usuário deverá estar logado
Pós-condições | O extrato completo deverá ter sido apresentado
Fluxo principal | [FP01] O usuário deverá clicar em "Extrato da Conta" e o extrato será mostrado na tela

#### UC14 - Pesquisar uma Transação
|||
----- | -----
Descrição | Essa funcionalidade tem como objetivo pesquisar uma transação no extrato do usuário
Atores | Usuário
Pré-condições | O usuário deverá ter clicado em "Extrato da Conta"
Pós-condições | A pesquisa deverá retornar os resultados na tela
Fluxo principal | [FP01] 1. O usuário digita a palavra chave <br>2. O usuário clica em pesquisar
Fluxo de exceção | [FE01] A pesquisa pode não ecnontrar a palavra chave<br> [FE02] O usuário pode realizar o passo 2 antes do 1 e o sistema retorna uma mensagem de erro

#### UC15 - Visualizar Detalhamento da Dívida
|||
----- | -----
Descrição | Essa funcionalidade mostra a dívida em detalhes
Atores | Usuário 
Pré-condições | O usuáro deverá ter utilizado uma quantidade de créditos
Pós-condições | Os detalhes da dívida devem ter sido mostrados
Fluxo principal | [FP01] O usuário deve clicar em "Destalhamento da Dívida"

#### UC16 - Solicitar Parcelamento da Dívida
|||
----- | ----- 
Descrição | Essa função permite que o usuário parcele a sua dívida 
Atores | Usuário
Pré-condições | O usuário deverá ter utilizado uma quantidade de créditos
Pós-condições | A dívida deverá ter sido parcelada
Fluxo principal | [FP01] Esse fluxo ocorre quando o usuário deseja parcelar sua dívida:<br>1. O usuário clica em parcelar a dívida<br>2. O usuário seleciona a quantidade de parcelas<br>3. O usuário visualiza os detalhes do parcelamento<br>4. O usuário clica em "Confirmar Operação"
Fluxo de exceção | [FE01] O usuário pode desistir de parcelar e clicar em "Cancelar"<br>[FE02] O usuário pode passar para o passo 4 sem ter realizado o passo 2 e o sistema retorna uma mensagem de erro

## 5. Visão Lógica

<!-- Esse daqui tbm pode deixar que eu vou cuidar. -->

### 5.1. Visão Geral

 A arquitetura utilizada no projeto é a arquitetura Cliente/Servidor, que se baseia na relação de dois módulos, o cliente e o servidor. O servidor será responsável pela manutenção e processamento dos dados, enquanto ao cliente será encarregada a função de fornecer os dados.

O cliente solicitará uma função do aplicativo, por exemplo um pedido de crédito, que será enviada para o servidor, para análise dos dados. Caso a solicitação seja válida, o sistema efetuará o pedido e disponibilizará o crédito para o usuário.

### 5.2. Visão Geral: Classes

O diagrama de classes a seguir tem como finalidade demonstrar todas classes, atributos, métodos e tipo de restrição de acesso dos dados utilizados.

Segue o diagrama de classes:

![Diagrama de Classes](/images/classes_diagram.png)

- Classes

    * User: Classe destinada ao cliente que abriga todas informações de sua conta.
    * UserWithCredit: Classe destinada ao cliente que já solicitou e recebeu seu crédito.
    * CreditRequest: Classe que permite a clase User solicitar crédito para sua conta.
    * Debt: Classe que armazena os dados relacionados ao pagamento do crédito concedido ao cliente e suas devidas prestações.
    * Account: Classe que dispõem os dados bancários do cliente, como transações e seu saldo bancário.
    * Transaction: Classe que detalha as transações realizadas.
- Relações

    * User é composto por CreditRequest: Demonstra que um usuário pode demandar várias solicitações de crédito e cada solicitação de crédito pertenca à um usuário. 
    * Account é composto por User: Demonstra que um conta só pode ser possuida por um usuário e também que um usuário só pode possuir uma conta.
    * Account é composto por Transaction: Demonstra que uma conta pode realizar várias transações, mas que casa transação está associada a apenas uma conta.
    * UserWithCreadt é composto por Debt: Demonstra que um usuário com crédito pode ter várias pendências, mas uma pendência remete à apenas um usuário.

### 5.3. Visão Geral: Banco de dados

O banco de dados permite com que os dados sejam persistidos para possibilitar a realização das funções do sistema, como por exemplo, permitir que o usuário solicite crédito. Esse banco de dados é composto pelas 6 a seguir:

![Banco de Dados](/images/logic_diagram.png)

## 6. Desempenho

O desempempenho do sistema está relacionado ao aparelho utilizado para rodar a aplicação, entretanto a conexão com a internet é o fator que pode causar os maiores problemas de desempenho.

## 7. Qualidade

Como objetivo de qualidade a aplicação deseja ter um bom sistema de segurança, visto que existem importantes informações de usuários que serão acessadas pela aplicação e que não podem ser visualizados por todos.
O código deverá ser bem estruturado, seguindo as normas de boas práticas para que terceiros, responsáveis por suas eventuais manutenções, consigam trabalhar sem a necessidade consultar os desenvolvedores originais.

<!-- O primeiro parágrafo tá todo errado. Creio que o foco principal do sistema será a experiência do usuário, teremos que oferecer um sistema amigável para os possíveis usuários finais, visto que é um MVP sendo desenvolvido para testar uma funcionalidade em específico. O segundo parágrafo tá de boa. -->
