# Documento de Visão
| Data | Versão | Autor(a) | Descrição |
| - | - | - | - |
| 11/09/2019 | 0.1 | Erick Reis | Estrutura básica do documento e índice|
| 11/09/2019 | 0.2 | Erick Reis | Adicionando Posicionamento e Restrições|
| 12/09/2019 | 0.3 | Isabella Carneiro| Adicionando Visão Geral do Produto|
| 13/09/2019 | 0.4 | Luiza Cezario | Adicionando Descrição dos Envolvidos e dos Usuários

## Índice

- [1. Introdução](#1-introdução)
  * [1.1. Finalidade](#11-finalidade)
  * [1.2. Escopo](#12-escopo)
  * [1.3. Visão geral](#13-visão-geral)
  * [1.4. Referências](#14-referências)
- [2. Posicionamento](#2-posicionamento)
  * [2.1. Oportunidade de Negócios](#21-oportunidade-de-negõcios)
  * [2.2. Descrição do problema](#22-descrição-do-problema)
  * [2.3. Sentença de Posição do Produto](#23-sentença-de-posição-do-produto)
- [3. Descrição dos Envolvidos e dos Usuários](#3-descrição-dos-envolvidos-e-dos-usuários)
  * [3.1. Resumo dos Envolvidos](#31-resumo-dos-envolvidos)
  * [3.2. Resumo dos Usuários](#32-resumo-dos-usuários)
  * [3.3. Ambiente do Usuário](#33-ambiente-do-usuário)
  * [3.4. Perfis dos Envolvidos](#34-perfis-dos-envolvidos)
  * [3.5. Perfis dos Usuários](#35-perfis-dos-usuários)
  * [3.6. Alternativas e concorrência](#36-alternativas-e-concorrência)
- [4. Visão Geral do Produto](#4-visão-geral-do-produto)
  * [4.1. Perspectiva do produto](#41-perspectiva-do-produto)
  * [4.2. Resumo dos recursos](#42-resumo-dos-recursos)
- [5. Recursos do Produto](#5-recursos-do-produto)
- [6. Restrições](#6-restrições)
  * [6.1. Restrições de Design](#61-restrições-de-design)
  * [6.2. Restrições de Implementação](#62-restrições-de-implementação)
  * [6.3. Restrições de Segurança](#63-restrições-de-segurança)
  * [6.4. Restrições de Uso](#64-restrições-de-uso)
- [7. Intervalos de Qualidade](#7-intervalos-de-qualidade)

## 1. Introdução

### 1.1. Finalidade

### 1.2. Escopo

### 1.3. Visão geral

### 1.4. Referências

## 2. Posicionamento

### 2.1. Oportunidade de Negócios

Diversos bancos disponibilizam o sistema de cheque especial para seus cliente, para utilizar esta função normalmente são necessárias algumas etapas por mais que este crédito já seja pré-ativado. Além disso, sempre que necessário, o cliente deve voltar a ativá-lo.

Este projeto oferecerá uma maneira muito mais prática não só para fazer a ativição do seu cheque especial mas também monitorar sua utilização. O sistema manterá o cheque especial ativo para que sempre que necessário o cliente posso utiliza-lo sem se preocupar com etapas de ativação.

Usuário do aplicativo terão o cheque especial no momento que precisarem e além disso poderão acompanhar com detalhes essa funcionalidade.

### 2.2. Descrição do problema

Solicitar o cheque especial quase sempre não é uma tarefa prática, a falta de controle e detalhes sobre sua utilação podem causar um grande problema financeiro para aqueles que não têm facilidade com organização de gastos.

### 2.3. Sentença de Posição do Produto

Este produto visa não só facilitar a utilização de cheque especial, mas principalmente tornar o controle de sue uso muito mais simples e intuitivo.

## 3. Descrição dos Envolvidos e dos Usuários

### 3.1. Resumo dos Envolvidos

Os envolvidos são a empresa N26 que será a entidade que fornece o crédito e os usuários que possuem uma conta no aplicativo que serão os solicitantes do crédito.

### 3.2. Resumo dos Usuários

Os usuários podem ser pessoas físicas ou jurídicas que tem cadastro ativo no aplicativo da N26 e que tem interesse na funcionalidade de cheque especial.

### 3.3. Ambiente do Usuário

O usuário poderá em seu ambiente solicitar o crédito, ativar o crédito, ajustar o limite de crédito disponível, pedir aumento do limite de crédito, visualizar suas dívidas e pedir parcelamento da dívida.

### 3.4. Perfis dos Envolvidos

Banco N26 - Entidade financeira fornecedora de crédito - Tem interesse em implementar a função para agregar valor aos usuários e para que seja mais confortável para eles utulizar a função de crédito quando precisarem.

Usuários - Os usuários do sistema são pessoas que precisaram em determinado momento de u valor maior do que tinham disponível em conta para realizar uma compra ou pagar uma dívida.

### 3.5. Perfis dos Usuários

### 3.6. Alternativas e concorrência

Como alternativa diversos bancos oferecem a funcionalidade de cheque especial, bancos como Bradesco, Banco do Brasil, Santander, Caixa e diversos outros presentes no Brasil.

## 4. Visão Geral do Produto

### 4.1. Perspectiva do produto
 O aplicativo tem a função de realizar o processo de oferta de crédito aos clientes do banco que solicitarem o mesmo. Tal aplicação também oferecerá ao usuário a opção de gerenciar seu limite de crédito.

### 4.2. Resumo dos recursos
| Benefício para os clientes | Recursos de suporte |
| Facilidade de requisitar crédito | Layout simples |
| Possibilidade de modificar o crédito | Tela em que é possível gerenciar o crédito|


## 5. Recursos do Produto

## 6. Restrições

### 6.1. Restrições de Design

O _design_ deve se manter no padrão presente na aplicação principal da N26, mantendo a simplicidade proposta pelo projeto.

### 6.2. Restrições de Implementação

O projeto será desenvolvido utlizando o Node.js e o Express.js com _framework_, e todo _front-end_ sob a linguagem Kotlin numa aplicação Android. A aquitetura sequirá o modelo de cliente-servidor.

### 6.3. Restrições de Segurança

Por se tratar de uma aplicação bancária a segurança é algo essencial, por isso todo acesso deve ser precedido de um login que deve deixar todas a funcionalidades protegidas.

### 6.4. Restrições de Uso

Para o uso do sistema é necessário que o usuário tenha uma aparelho compatível com a aplicação e deve estar conectado à internet Caso o usuário do sistema não possua acesso à internet não será possível realizar o login.

## 7. Intervalos de Qualidade

Para total desempenho e aproveitamento do cliente devem ser respeitados os seguintes intervalos de qualidade:

Disponibilidade: O Sistema deve estar sempre disponível, isto é, 24 horas por dia e 7 dias por semana.

Usabilidade: O Sistema deve ser intuitivo para facilitar o uso do cliente e um time de suporte online deve estar sempre a postos para tirar qualquer dúvida do cliente.

Manutenção: O Sistema deve ser facilmente manutenível, para que todos dados dos clientes possam ser modificáveis sem a necessidade de uma recompilação e para facilitar um aprimoramento futuro.
