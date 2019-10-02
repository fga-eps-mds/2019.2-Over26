# Documento de Visão
| Data | Versão | Autor(a) | Descrição |
| - | - | - | - |
| 11/09/2019 | 0.1 | Erick Reis | Estrutura básica do documento e índice|
| 11/09/2019 | 0.2 | Erick Reis | Adicionando Posicionamento e Restrições|
| 12/09/2019 | 0.3 | Isabella Carneiro| Adicionando Visão Geral do Produto|
| 13/09/2019 | 0.4 | Luiza Cezario | Adicionando Descrição dos Envolvidos e dos Usuários
| 13/09/2019 | 0.5 | João Gabriel | Adicionando Recursos|
| 14/09/2019 | 0.6 | Gabriel | Adicionando Introdução|
|29/09/2019 | 0.7 | Isabella Carneiro | Atualizando Introdução e Posicionamento|
|30/09/2019 | 0.8 | Adrianne Alves | Revisão da finalidade, Escopo, Referências, Oportunidade de Negócios, Descrição do problema |

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

Objetiva-se, por meio deste documento, apresentar o Over26, um Mínimo Produto Viável funcional e determinar sua utilidade e funcionalidades, abordando sua capacidade, recursos e relação com o usuário. Além disso, pretende-se ressaltar a inovação ofertada por meio da descrição do problema que ele aborda, oportunidades de negócios, envolvidos, entre outros. Espera-se então que o leitor entenda a proposta do projeto e sua aplicabilidade.

### 1.2. Escopo

O N26 é um banco digital alemão que se tornou popular na Europa e está em recente expansão para outros países como por exemplo, os EUA. Nesse aspecto, existe um interesse recente da empresa em trazer os seus serviços ao Brasil, na modalidade de conta de pagamento.

Segundo a FolhaPe, o endividamento entre jovens alcança a casa de 12 milhões de brasileiros, com idades entre 25 e 29 anos. Assim, dado o perfil financeiro brasileiro de endividamento, o N26 viu a possibilidade de inovar ou trazer novas soluções para a oferta de crédito no país, com foco na experiência do uso do cheque especial, cujas taxas são exorbitantes, por meio do seu aplicativo. Dessa forma, idealizou-se o Over26, um Mínimo Produto Viável funcional destinado a avaliar a experiência de usuário com um novo modo de oferta do serviço.

De modo geral, o produto final tem como propósito auxiliar a empresa a testar a experiência do usuário com a funcionalidade de cheque especial, considerando o principal diferencial das demais implementações: O usuário possui 26 dias a partir da primeira data de uso do serviço para pagar a sua dívida.

### 1.3. Visão geral

O documento apresenta informações essenciais relacionadas ao projeto, organizadas de modo a fornecer ao leitor a melhor forma de visualizá-las. Dessa forma, inicia-se demonstrando o contexto no qual o projeto foi pensado, expondo os envolvidos e a equipe responsável por desenvolver o software e gerir toda a produção. Por fim, o documento foca nas especificações do projeto, em termos de requisitos e funcionalidades do sistema.

### 1.4. Referências

Template do documento. Disponível em: https://www.ibm.com/support/knowledgecenter/pt-br/SSWMEQ_4.0.6/com.ibm.rational.rrm.help.doc/topics/r_vision_doc.html. Acesso em: 13 de Setembro de 2019.
N26: maior fintech da Europa chega ao Brasil ainda em 2019. Disponível em: https://www.infomoney.com.br/consumo/n26-maior-fintech-da-europa-chega-ao-brasil-ainda-em-2019-diz-executivo/. Acesso em: 30 de Setembro de 2019.
Banco N26 começa a operar nos EUA. Disponível em: https://www.mobiletime.com.br/noticias/11/07/2019/banco-n26-comeca-a-operar-nos-eua/. Acesso em: 30 de Setembro de 2019.
Endividamento entre jovens: 12 milhões de brasileiros, entre 25 e 29 anos, estão inadimplentes. Disponível em: https://www.folhape.com.br/noticias/noticias/educa-mais-brasil/2019/03/20/NWS,99493,70,1296,NOTICIAS,2190-ENDIVIDAMENTO-ENTRE-JOVENS-MILHOES-BRASILEIROS-ENTRE-ANOS-ESTAO-INADIMPLENTES.aspx. Acesso em: 30 de Setembro de 2019.

## 2. Posicionamento

### 2.1. Oportunidade de Negócios

O serviço de cheque especial já é disponibilizado por inúmeros bancos, mas para utilizá-lo os clientes precisam se submeter a etapas burocráticas, mesmo possuindo um crédito pré-ativado. Além disso, eles não têm acesso transparente às taxas pagas com a dívida adquirida, que, além de serem altas, já incidem desde o primeiro uso do serviço. O Over26 vem para simplificar esse processo e auxiliar o usuário à acompanhar a sua dívida.

Isso porque irá facilitar a ativação do serviço e reduzir os custos do usuário referentes à absorção das taxas nos primeiros 26 dias da instanciação da dívida. Além disso, tornará mais fácil para o usuário conhecer as taxas a serem pagas no momento de contratação do serviço, trazendo a ele o domínio sobre a decisão de adquirir o cheque ou planejar o pagamento. Essa funcionalidade tem o potencial de transformar o modo como a experiência de cheque especial é vista e sentida pelos usuários, sendo de menor custo para os mesmos.

### 2.2. Descrição do problema

| |  |
| -- | -- |
| O problema seria | Complexidade da contratação do serviço de crédito especial e taxas elevadas sobre o serviço assim que ele é utilizado |
| que afeta | o usuário |
| cujo o impacto é | frustração durante o processo de contratação e descontrole da dívida |
| e uma boa solução seria | uma funcionalidade de crédito especial que fornecesse um período de tempo para o usuário organizar o pagamento da sua dívida, sem incidẽncia de taxa, que estivesse focada na transparência para o usuário e facilidade de contratação do serviço. |

### 2.3. Sentença de Posição do Produto

Este produto visa não só facilitar a utilização de cheque especial, mas principalmente tornar o controle de seu uso muito mais simples e intuitivo, assim como facilita a quitação da dívida.

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
| - | - |
| Facilidade de requisitar crédito | Layout simples |
| Possibilidade de modificar o crédito | Tela em que é possível gerenciar o crédito|


## 5. Recursos do Produto
A aplicação permitirá ao usuario solicitar crédito de cheque especial,aceitar ou recusar o crédito,controlar o quanto deste credito estará disponivel para gasto,sendo que existirão telas especificas na mesma para poder acessar essas informações e fazer as solicitações.

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

## Histórico de Versões

| Data | Versão | Autor(a) | Descrição |
| - | - | - | - |
| 11/09/2019 | 0.1 | Erick Reis | Estrutura básica do documento e índice|
| 11/09/2019 | 0.2 | Erick Reis | Adicionando Posicionamento e Restrições|
| 12/09/2019 | 0.3 | Isabella Carneiro| Adicionando Visão Geral do Produto|
| 13/09/2019 | 0.4 | Luiza Cezario | Adicionando Descrição dos Envolvidos e dos Usuários
| 13/09/2019 | 0.5 | João Gabriel | Adicionando Recursos|
| 14/09/2019 | 0.6 | Gabriel | Adicionando Introdução|
