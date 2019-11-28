# Documento de Visão

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
- [Histórico de Versões](#_histórico-de-versões)

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

| | |
| -- | -- |
| Para | usuários de bancos digitais endividados |
| Que | precisam utilizar o serviço de cheque especial |
| O Over26 | é um Mínimo Produto Viável funcional de código aberto, que implementa uma nova experiência da funcionalidade de cheque especial |
| Diferente dos | demais bancos que fornecem cheque especial de uso burocrático, nada transparente e com taxas aplicadas imediatamente após a instância da dívidas |
| Nosso produto | irá fornecer uma experiência transparente e menos burocrática de contratação e acompanhamento do serviço, reduzindo o impacto expressivo das altas taxas por meio de uma margem de 26 dias antes que elas sejam computadas sobre a dívida |


## 3. Descrição dos Envolvidos e dos Usuários

### 3.1. Resumo dos Envolvidos

| Nome | Descrição | Finalidade
| -- | -- | -- |
| Equipe de Desenvolvimento | Estudantes da Universidade de Brasília, discentes da disciplina de Métodos de Desenvolvimento de Software. | Desenvolver, testar e implantar o Software descrito neste documento. |
| Equipe de Gestão do Projeto | Estudantes da Universidade de Brasília, discentes da disciplina de Engenharia de Produto. | Gerir a equipe visando prever e mitigar possíveis riscos relativos à aplicação a ser desenvolvida, no que diz respeito à qualidade, custos e tempo previsto, assim como as relações entre os membros da equipe. Além disso, compete aos gestores disseminar o conhecimento da equipe e garantir a máxima produtividade. |
| Cliente | Responsável por definir o produto, objetivo do projeto. | Descrever o problema a ser solucionado, validar delimitação de escopo e  entregas. |

### 3.2. Resumo dos Usuários

| Nome | Descrição |
| -- | -- |
| Pessoas físicas |  Todo ser humano enquanto indivíduo que possua conta na N26 e queira ativar e/ou utilizar o serviço de cheque especial |

### 3.3. Ambiente do Usuário

O software será um aplicativo mobile para sistemas android. Ele funcionará para as seguintes versões:

- Versão mínima: Android 4.4;
- Versão ideal: Android 7.0;

### 3.4. Perfis dos Envolvidos

#### 3.4.1 Equipe de Gestão de Projeto

| |  |
| -- | -- |
| Representantes | Maria Luiza <br> Adrianne Alves <br> Natália Rodrigues <br> Andrew Lucas |
| Descrição | Equipe de Gestão do Projeto |
| Tipo | 	Discentes da disciplina de Engenharia de Produto de Software da Universidade de Brasília. |
| Critérios de sucesso | Nivelar o conhecimento da equipe, mantê-la organizada, motivada, harmoniosa e alinhada. Coordenar a qualidade e prazos das entregas feitas, tal que a aplicaçã o seja finalizada no tempo previsto e conforme exigências do cliente. |
| Envolvimento | Alto |


#### 3.4.2 Equipe de Desenvolvimento

| |  |
| -- | -- |
| Representantes | Luiza Cesário <br> Erick Antônio <br> Gabriel Lopes <br> Isabella Carneiro <br> João Gabriel <br> João Paulo |
| Descrição | Time de Desenvolvimento |
| Tipo | 	Discentes da disciplina de Metodologia de Desenvolmento de Software da Universidade de Brasília. |
| Critérios de sucesso | Entregar as funcionalidades solicitadas no prazo, com qualidade e de acordo aos critérios de aceitação estabelecidos. |
| Envolvimento | Alto |

#### 3.4.3 Cliente

| |  |
| -- | -- |
| Representantes | Banco N26 |
| Descrição | Solicitante do Projeto |
| Tipo | Cliente |
| Critérios de sucesso | Fornecer o problema a ser desenvolvido, auxiliar no estabelecimento do escopo, validar a solução do time |
| Envolvimento | Alto |

### 3.5. Perfis dos Usuários

| |  |
| -- | -- |
| Representantes | Pessoas físicas |
| Descrição | Pessoas físicas que possuem contas em bancos digitais |
| Tipo | Usuários do sistema |
| Critérios de sucesso | Usuário conseguir utilizar o aplicativo com uma boa experiência de usabilidade |
| Envolvimento | Alto |

### 3.6. Alternativas e concorrência

O cheque especial é um sistema bastante difundido entre os bancos, assim, como alternativa à essa funcionalidade da N26, teríamos as ofertas de bancos como:

- Bradesco;
- Banco do Brasil;
- Santander;
- Caixa Econômica, entre outros.

Entretanto, os bancos possuem licença diferente da Sociedade de Crédito Direto e não possuem sistemas digitais eficientes para oferta desse serviço. Além disso, implementam taxas exorbitantes aos usuários.

## 4. Visão Geral do Produto

### 4.1. Perspectiva do produto
 O aplicativo tem a função de fornecer o serviço de cheque especial aos clientes que necessitarem, oferecendo cobertura desde a ativação do serviço ao parcelamento da dívida gerada. O mesmo fornecerá um prazo de 26 dias a partir da instância da dívida para começar a aplicar as taxas, fornecendo ao usuário maior controle para programar a quitação da mesma.

### 4.2. Resumo dos recursos
| Benefício para os usuários | Recursos de suporte |
| - | - |
| Facilidade na solicitação do serviço de cheque especial | Fluxo de solicitação simples e enxuto. |
| Fácil controle do valor máximo de crédito | Ajuste de valor máximo de limite |
| Acompanhamento transparente da dívida | Relatório de parcelamento de dívidas por cheque especial |
| Transparência nas taxas aplicadas | Demonstração das taxas aplicadas à dívida |
| Controle do pagamento da dívida | Parcelamento da dívida por cheque especial |
| Feedback constante | Notificação a cada passo do fluxo de cheque especial. |


## 5. Recursos do Produto
A aplicação permitirá ao usuario solicitar crédito de cheque especial, cancelar o crédito,controlar o quanto deste crédito estará disponivel para gasto, entre outros, como se segue:

- Visualizar saldo e extrato da conta;
- Checar elegibilidade para uso do cheque especial;
- Ativar o serviço;
- Acompanhar limite de cheque especial;
- Acompanhar e parcelar dívida;
- Feedback de elegibilidade;
- Ativação do serviço;
- Acompanhamento do período de isenção de juros;

## 6. Restrições

### 6.1. Restrições de Design

O _design_ deve se manter no padrão presente na aplicação principal da N26, mantendo a simplicidade proposta pelo projeto, conforme [video](https://www.youtube.com/watch?v=T6JfLJ1zaXA&feature=youtu.be)

### 6.2. Restrições de Implementação

O projeto será desenvolvido utlizando o Node.js e o Express.js com _framework_, e todo _front-end_ sob a linguagem Kotlin numa aplicação Android. A aquitetura seguirá o modelo cliente-servidor.

### 6.3. Restrições de Uso

Para o uso do sistema é necessário que o usuário tenha uma aparelho compatível com a aplicação e deve estar conectado à internet . As versões suportadas do android são a partir da 4.4, logo, para versões anteriores não é possível garantir o bom funcionamento do produto.

## 7. Intervalos de Qualidade

Para total desempenho e aproveitamento por parte dos usuários devem ser respeitados os seguintes intervalos de qualidade:

Disponibilidade: O Sistema deve estar disponível na maior parte do tempo, utilizando-se as madrugadas para manutenção, ou seja, 20 horas por dia e 7 dias por semana.

Usabilidade: O Sistema deve ser intuitivo, possuir um baixo número de passos para alcançar o objetivo, ser fácil de compreender.

Manutenção: O Sistema deve ter boa manutenabilidade, a fim de facilitar futuras evoluções e correções por equipes diferentes da original. Assim, esses aspectos de qualidade devem ser observados no código entregue.

## Histórico de Versões

| Data | Versão | Autor(a) | Descrição |
| - | - | - | - |
| 11/09/2019 | 0.1 | Erick Reis | Estrutura básica do documento e índice|
| 11/09/2019 | 0.2 | Erick Reis | Adicionando Posicionamento e Restrições|
| 12/09/2019 | 0.3 | Isabella Carneiro| Adicionando Visão Geral do Produto|
| 13/09/2019 | 0.4 | Luiza Cezario | Adicionando Descrição dos Envolvidos e dos Usuários
| 13/09/2019 | 0.5 | João Gabriel | Adicionando Recursos|
| 14/09/2019 | 0.6 | Gabriel | Adicionando Introdução|
| 29/09/2019 | 0.7 | Isabella Carneiro | Atualizando Introdução e Posicionamento|
| 30/09/2019 | 0.8 | Adrianne Alves | Revisão da finalidade, Escopo, Referências, Oportunidade de Negócios, Descrição do problema, Sentença de Posição do Produto, Descrição dos Envolvidos e dos Usuários, Visão Geral do Produto, Restrições e Intervalos de Qualidade |

