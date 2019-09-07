# Documento de Arquitetura
| Data | Versão | Autor(a) | Descrição |
| - | - | - | - |
| 05/09/2019 | 0.1 | João Gabriel | Criação do índice e adição da introdução|
| 05/09/2019 | 0.2 | Gabriel | Adição da visão lógica e desempenho|
|06/09/2019|0.3|Isabella| Adição de Restrições do projeto|
|06/09/2019|0.4|Isabella e João Gabriel| Adição de Qualidade|

# Índice
* [1. Introdução](#1.-Introdução)
     * [1.1 Objetivos](1.1.-Objetivos)
     * [1.2. Escopo](1.2.-Escopo-do-documento)

* [5. Visão Lógica](#5.-Visão-Lógica)
     * [5.1. Visão Geral](5.1.-Visão-Geral)

* [6. Restrições](#6.-Restrições)

* [7. Desempenho](#7.-Desempenho)

* [8. Qualidade](#8.-Qualidade)


# 1. Introdução

## 1.1. Objetivos

Tem se por objetivo deste documento detalhar a arquitetura e tecnologias usadas na criação da funcionalidade de "cheque especial" que deverá ser implementada na versão mobile do sistema do banco europeu N26 ,no Brasil.

A nescessidade deste detalhamento se da para o melhor entendimento daqueles responsaveis pelo desenvolvimento, sobre o que foi definido e o que foi produzido de que forma.

##  1.2. Escopo do documento

Conforme dito em Objetivos (1.1.), este documento conterá detalhes sobre a arquitetura escolhida para o sistema,as lógicas por trás das implementações, as linguagens/tecnologias usadas, os padrões estabelecidos pela equipe ,informaçoes referentes a bancos de dados, diagramas de classe  e de caso de uso.

# 3. Restrições e Metas Arquiteturais

A aplicação do Sistema de Oferta de Crédito terá como base de sua arquitetura o framework Express, que é baseado na linguagem de programação Node.js. O Express permite a criação de APIs de maneira robusta, rápida e fácil e conta com recursos para aplicativos mobile, necessários para o projeto. Ele conta também com um sistema de Views Intuitivo (MVC).

Uma vantagem da utilização do framework é a sua escalabilidade, sendo um requisito necessário para sistemas com diversas conexões concorrentes, além disso o framework é minimalista e flexível, o Express conta com bibliotecas para trabalhar com cookies, sessões, login de usuário e diversas outras funcionalidades.

# 4. Visão de Casos de Uso

## 4.1 Atores

### 4.1.1 Cliente do Banco

Este ator tem acesso aos dados de seu perfil, as funcionalidades de cadastrar e descadastrar no sistema, login, solicitar crédito, pagar débito e fazer simulação.

## 4.2 Descrição dos Casos de Uso

### 4.2.1 Cadastrar Usuário

Tem como objetivo realizar o cadastro do usuário no sistema, coletando seus dados pessoais para que ele tenha acesso ao aplicativo.

### 4.2.2 Descadastrar Usuário

Essa funcionalidade permite que o usuário solicite a retirada de seus dados do sistema, caso tenha algum débito em seu perfil ele só poderá se descadastrar quando o débito for quitado.

### 4.2.3 Login

Tem como objetivo fornecer o acesso do usuário ao sistema.

### 4.2.4 Solicitar Crédito

Essa funcionalidade tem como objetivo solicitar so sistema a liberação de créditos para o usuário, através dela é liberada uma quantia que o usuário poderá utilizar, apoś a liberação o usuário terá em seu perfil um débito com o banco, ao qual serão aplicados juros.

### 4.2.5 Pagar Débito

O usuário poderá quitar os seus débitos no sistema através dessa funcionalidade, o débito poderá ser pago parcialmente ou integramente, o valor adicionado será reduzido do débito até que ele seja quitado integralmente.

### 4.2.6 Simulação de Crédito

O usuário antes de solicitar o crédito poderá simular a transação, na funcionalidade serão mostrados os débitos gerados pela transação e total em juros de acordo com o tempo que o usuário estima quitar o débito.

# 5. Visão Lógica

## 5.1. Visão Geral

 A arquitetura utilizada no projeto é a arquitetura Cliente/Servidor, que se baseia na relação de dois módulos, o cliente e o servidor. O servidor será responsável pela manutenção e processamento dos dados, enquanto ao cliente será encarregada a função de fornecer os dados.

O cliente solicitará uma função do aplicativo, por exemplo um pedido de crédito, que será enviada para o servidor, para análise dos dados. Caso a solicitação seja válida, o sistema efetuará o pedido e disponibilizará o crédito para o usuário.

# 6. Restrições
O sistema será desenvolvido para ser utilizado em smartphones com sistema Android. 
Para alcançar tal finalidade será feito usando Node.js com express para o backend da aplicação e o frontend da mesma será utilizado o kotlin.
O modelo pretendido é cliente-servidor, priorizando a experiência do cliente com o sistema.

# 7. Desempenho

A funcionalidade integrada ao aplicativo utilizará um banco de dados, contendo uma grande quantidade de informações dos clientes, devendo realizar múltiplos processos em tempo real, sendo modificações ou adições, para uso sem interrupções do cliente. Esse desempenho também dependerá das especificações do sistema do usuário, no caso seu celular, e a qualidade da internet utilizada.

# 8. Qualidade
Como objetivo de qualidade a aplicação deseja ter um bom sistema de segurança, visto que existem importantes informações de usuários que serão acessadas pela aplicação e que não podem ser visualizados por todos.
O código deverá ser bem estruturado, seguindo as normas de boas práticas para que terceiros, responsáveis por suas eventuais manutenções, consigam trabalhar sem a necessidade consultar os desenvolvedores originais.
