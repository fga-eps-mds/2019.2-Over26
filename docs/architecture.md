# Documento de Arquitetura
| Data | Versão | Autor(a) | Descrição |
| - | - | - | - |
| 05/09/2019 | 0.1 | João Gabriel | Criação do índice e adição da introdução|
| 05/09/2019 | 0.2 | Gabriel | Adição da visão lógica e desempenho|
| 06/09/2019 | 0.3 | Isabella | Adição de Restrições do projeto|
| 06/09/2019 | 0.4 | Isabella e João Gabriel | Adição de Qualidade|
| 06/09/2019 | 0.5 | Luiza | Adição de Visão de Casos de Uso|
| 09/09/2019 | 0.6 | Erick | Adição de Representação da Arquitetura e correção de índice|
| 11/09/2019 | 0.7 | Luiza | Refatoração da Visão de Casos de Uso|
| 11/09/2019 | 0.7.1 | Erick | Corrigindo índice|

# Índice

- [1. Introdução](#1-introdução)
  * [1.1. Objetivos](#11-objetivos)
  * [1.2. Escopo do documento](#12-escopo-do-documento)

- [2. Representação da Arquitetura](#2-representação-da-arquitetura)

- [3. Restrições e Metas Arquiteturais](#3-restrições-e-metas-arquiteturais)

- [4. Visão de Casos de Uso](#4-visão-de-casos-de-uso)
  * [UC01 - Realizar Login](#uc01-realizar-login)
  * [UC02 - Cadastrar](#uc02-cadastrar)
  * [UC03 - Solicitar Crédito](#uc03-solicitar-crédito)
  * [UC04 - Visualizar Regras de Contratação](#uc04-visualizar-regras-de-contratação)
  * [UC05 - Fornecer Feedback da Solicitação de Crédito](#uc05-fornecer-feedback-da-solicitação-de-crédito)
  * [UC06 - Analisar Perfil do Usuário](#uc06-analisar-perfil-do-usuário)
  * [UC07 - Ativar Limite de Crédito](#uc07---ativar-limite-de-crédito)
  * [UC08 - Ajustar Limite](#uc08-ajustar-limite)
  * [UC09 - Acompanhar Limite](#uc09-acompanhar-limite)
  * [UC10 - Solicitar Aumento de Limite](#uc10-solicitar-aumento-de-limite)
  * [UC11 - Fornecer Feedback da Solicitação de Aumento](#uc11-fornecer-feedback-da-solicitação-de-aumento)
  * [UC12 - Visualizar Saldo da Conta](#uc12-visualizar-saldo-da-conta)
  * [UC13 - Visualizar Extrato da Conta](#uc13-visualizar-extrato-da-conta)
  * [UC14 - Pesquisar uma Transação](#uc1--pesquisar-uma-transação)
  * [UC15 - Visualizar Detalhamento da Dívida](#uc15-visualizar-detalhamento-da-dívida)
  * [UC16 - Solicitar Parcelamento da Dívida](#uc16-solicitar-parcelamento-da-dívida)

- [5. Visão Lógica](#5-visão-l-gica)
  * [5.1. Visão Geral](#51-visão-geral)

- [6. Restrições](#6-restrições)

- [7. Desempenho](#7-desempenho)

- [8. Qualidade](#8-qualidade)

# 1. Introdução

## 1.1. Objetivos

Tem se por objetivo deste documento detalhar a arquitetura e tecnologias usadas na criação da funcionalidade de "cheque especial" que deverá ser implementada na versão mobile do sistema do banco europeu N26 ,no Brasil.

A nescessidade deste detalhamento se da para o melhor entendimento daqueles responsaveis pelo desenvolvimento, sobre o que foi definido e o que foi produzido de que forma.

##  1.2. Escopo do documento

Conforme dito em Objetivos (1.1.), este documento conterá detalhes sobre a arquitetura escolhida para o sistema,as lógicas por trás das implementações, as linguagens/tecnologias usadas, os padrões estabelecidos pela equipe ,informaçoes referentes a bancos de dados, diagramas de classe  e de caso de uso.

# 2. Representação da Arquitetura

A arquitetura irá seguir o modelo cliente-servidor, onde existe uma aplicação que realiza de fato as tarefas e serviços, o servidor, e outra que faz requisições desses servições e tarefas, o cliente.

Este tipo de arquitetura fornece alta escalabilidade e tem uma grande vantagem quando se trata de manutenção, ponto crítico no caso desde projeto.

Visando manter a escalabilidade da aplicação foi escolhido o Node.js como plataforma de desenvolvimento, além disso com o Express.js, framework de aplicação web, a criação de APIs deve se torna um processo mais simples. Ambas as tecnologias seriam utilizadas no back-end.

Para o front-end será utilizada a linguagem de programação Kotlin visando manter o padrão do sistema da N26.

# 3. Restrições e Metas Arquiteturais

A aplicação do Sistema de Oferta de Crédito terá como base de sua arquitetura o framework Express, que é baseado na linguagem de programação Node.js. O Express permite a criação de APIs de maneira robusta, rápida e fácil e conta com recursos para aplicativos mobile, necessários para o projeto. Ele conta também com um sistema de Views Intuitivo (MVC).

Uma vantagem da utilização do framework é a sua escalabilidade, sendo um requisito necessário para sistemas com diversas conexões concorrentes, além disso o framework é minimalista e flexível, o Express conta com bibliotecas para trabalhar com cookies, sessões, login de usuário e diversas outras funcionalidades.

# 4. Visão de Casos de Uso

## UC01 - Realizar Login

| Descrição | |
| Atores | |
| Pré-condições | |
| Pós-condições | |
| Fluxo principal | |
| Fluxo alternativo | |
| Fluxo de exceção | |

## UC02 - Cadastrar

| Descrição | |
| Atores | |
| Pré-condições | |
| Pós-condições | |
| Fluxo principal | |
| Fluxo alternativo | |
| Fluxo de exceção | |

## UC03 - Solicitar Crédito

| Descrição | |
| Atores | |
| Pré-condições | |
| Pós-condições | |
| Fluxo principal | |
| Fluxo alternativo | |
| Fluxo de exceção | |

## UC04 - Visualizar Regras de Contratação 

| Descrição | |
| Atores | |
| Pré-condições | |
| Pós-condições | |
| Fluxo principal | |
| Fluxo alternativo | |
| Fluxo de exceção | |

## UC05 - Fornecer Feedback da Solicitação de Crédito

| Descrição | |
| Atores | |
| Pré-condições | |
| Pós-condições | |
| Fluxo principal | |
| Fluxo alternativo | |
| Fluxo de exceção | |

## UC06 - Analisar Perfil do Usuário

| Descrição | |
| Atores | |
| Pré-condições | |
| Pós-condições | |
| Fluxo principal | |
| Fluxo alternativo | |
| Fluxo de exceção | |

## UC07 - Ativar Limite de Crédito

| Descrição | |
| Atores | |
| Pré-condições | |
| Pós-condições | |
| Fluxo principal | |
| Fluxo alternativo | |
| Fluxo de exceção | |

## UC08 - Ajustar Limite 

| Descrição | |
| Atores | |
| Pré-condições | |
| Pós-condições | |
| Fluxo principal | |
| Fluxo alternativo | |
| Fluxo de exceção | |

## UC09 - Acompanhar Limite

| Descrição | |
| Atores | |
| Pré-condições | |
| Pós-condições | |
| Fluxo principal | |
| Fluxo alternativo | |
| Fluxo de exceção | |

## UC10 - Solicitar Aumento de Limite

| Descrição | |
| Atores | |
| Pré-condições | |
| Pós-condições | |
| Fluxo principal | |
| Fluxo alternativo | |
| Fluxo de exceção | |

## UC11 - Fornecer Feedback da Solicitação de Aumento

| Descrição | |
| Atores | |
| Pré-condições | |
| Pós-condições | |
| Fluxo principal | |
| Fluxo alternativo | |
| Fluxo de exceção | |

## UC12 - Visualizar Saldo da Conta

| Descrição | |
| Atores | |
| Pré-condições | |
| Pós-condições | |
| Fluxo principal | |
| Fluxo alternativo | |
| Fluxo de exceção | |

## UC13 - Visualizar Extrato da Conta

| Descrição | |
| Atores | |
| Pré-condições | |
| Pós-condições | |
| Fluxo principal | |
| Fluxo alternativo | |
| Fluxo de exceção | |

## UC14 - Pesquisar uma Transação

| Descrição | |
| Atores | |
| Pré-condições | |
| Pós-condições | |
| Fluxo principal | |
| Fluxo alternativo | |
| Fluxo de exceção | |

## UC15 - Visualizar Detalhamento da Dívida

| Descrição | |
| Atores | |
| Pré-condições | |
| Pós-condições | |
| Fluxo principal | |
| Fluxo alternativo | |
| Fluxo de exceção | |

## UC16 - Solicitar Parcelamento da Dívida

| Descrição | |
| Atores | |
| Pré-condições | |
| Pós-condições | |
| Fluxo principal | |
| Fluxo alternativo | |
| Fluxo de exceção | |

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
