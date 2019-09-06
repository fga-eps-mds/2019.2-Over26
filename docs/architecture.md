# Documento de Arquitetura
| Data | Versão | Autor(a) | Descrição |
| - | - | - | - |
| 05/09/2019 | 0.1 | João Gabriel | Criação do índice e adição da introdução|
| 05/09/2019 | 0.2 | Gabriel | Adição da visão lógica e desempenho|

# Índice
* [1. Introdução](#1.-Introdução)
     * [1.1 Objetivos](1.1.-Objetivos)
     * [1.2. Escopo](1.2.-Escopo-do-documento)

* [5. Visão Lógica](#5.-Visão-Lógica)
     * [5.1. Visão Geral](5.1.-Visão-Geral)

* [7. Desempenho](#7.-Desempenho)


# 1. Introdução

## 1.1. Objetivos

Tem se por objetivo deste documento detalhar a arquitetura e tecnologias usadas na criação da funcionalidade de "cheque especial" que deverá ser implementada na versão mobile do sistema do banco europeu N26 ,no Brasil.

A nescessidade deste detalhamento se da para o melhor entendimento daqueles responsaveis pelo desenvolvimento, sobre o que foi definido e o que foi produzido de que forma.

##  1.2. Escopo do documento

Conforme dito em Objetivos (1.1.), este documento conterá detalhes sobre a arquitetura escolhida para o sistema,as lógicas por trás das implementações, as linguagens/tecnologias usadas, os padrões estabelecidos pela equipe ,informaçoes referentes a bancos de dados, diagramas de classe  e de caso de uso.

# 5. Visão Lógica

## 5.1. Visão Geral

 A arquitetura utilizada no projeto é a arquitetura Cliente/Servidor, que se baseia na relação de dois módulos, o cliente e o servidor. O servidor será responsável pela manutenção e processamento dos dados, enquanto ao cliente será encarregada a função de fornecer os dados.

O cliente solicitará uma função do aplicativo, por exemplo um pedido de crédito, que será enviada para o servidor, para análise dos dados. Caso a solicitação seja válida, o sistema efetuará o pedido e disponibilizará o crédito para o usuário.

# 7. Desempenho

A funcionalidade integrada ao aplicativo utilizará um banco de dados, contendo uma grande quantidade de informações dos clientes, devendo realizar múltiplos processos em tempo real, sendo modificações ou adições, para uso sem interrupções do cliente. Esse desempenho também dependerá das especificações do sistema do usuário, no caso seu celular, e a qualidade da internet utilizada.
