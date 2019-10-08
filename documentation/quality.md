# Plano de Qualidade

## Histórico de Versões

| Data | Versão | Autor(a) | Descrição |
| - | - | - | - |
| 06/10/2019 | 0.1 | Natália Rodrigues | Criando versão inicial do documento |
| 07/10/2019 | 0.2 | Natália Rodrigues | Terminando primeira versão do documento |


## Índice

* [1. Introdução](#_1-Introdução)
* [2. Objetivos do Plano](#_2-Objetivos-do-Plano)
* [3. Metodologia de aplicação do plano](#_3-Metodologia-de-aplicação-do-plano)
* [4. Métricas analisadas](#_4-Métricas-analisadas)
* [5. Ferramentas e tecnologias utilizadas](#_5-Ferramentas-e-tecnologias-utilizadas)
* [6. Referências](#_6-Referências)

## 1. Introdução

Este documento tem como finalidade a apresentação do plano de qualidade do projeto. Serão apontados os objetivos do plano e como o mesmo será aplicado, além das métricas determinadas para análise e das ferramentas que serão utilizadas na coleta dos dados.

## 2. Objetivos do Plano

A qualidade de software pode ser entendida como o nível de conformidade do sistema com seus requisitos implícitos e explícitos. Tendo isso como base, e, com o intuito de garantir que os aspectos funcionais e não funcionais (como manutenibilidade, por exemplo) do projeto sejam atendidos da melhor forma possível, criou-se este documento.

O Plano de Qualidade tem, então, como principais objetivos garantir um acompanhamento a respeito da qualidade do produto desenvolvido, e estabelecer métricas e ferramentas que possibilitem a análise da mesma.

## 3. Metodologia de aplicação do Plano

Serão definidas algumas métricas, que ajudarão a analisar aspectos importantes da qualidade do código e do produto como um todo. Essas métricas serão coletadas periodicamente, com a ajuda de algumas tecnologias definidas.

Após a coleta das métricas, se os valores obtidos apresentarem resultados ruins/regulares, ações de refatoração e readequação serão tomadas, visando sempre atingir os melhores resultados possíveis.

## 4. Métricas analisadas

As métricas a serem analisadas estão apresentadas na tabela a seguir, com a especificação da análise para as faixas de valores correspondentes.

Métrica | Bom | Regular | Ruim
- | - | - | -
Cobertura de testes unitários | Acima de 90% |De 75% a 90% | Abaixo de 75%
Duplicação de código | Abaixo de 2% | De 2% a 4% | Acima de 4%
Tamanho dos métodos | Abaixo de 25 linhas | De 25 a 40 linhas | Acima de 40 linhas
Complexidade ciclomática | Abaixo de 11 | De 11 a 20 | Acima de 20
Manutenibilidade | A ou B | C | D ou F


## 5. Ferramentas e tecnologias utilizadas

* **[Jest](https://jestjs.io/)**
* **[Code Climate](https://codeclimate.com/)**
* **[ESLint](https://eslint.org/)**

## 6. Referências

* http://softwaretestingfundamentals.com/software-quality/