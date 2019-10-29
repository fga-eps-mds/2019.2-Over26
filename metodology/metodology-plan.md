## Metodologia
<hr>

A metodologia aplicada no projeto Over26 consiste na junção de aspectos e princípios do framework Scrum, Extreme Programming e kanban. As técnicas selecionadas para dar origem à metodologia híbrida utilizada, foram:  

- [1. Papéis](#_1-Papéis)
- [2. Rituais](#_2-Rituais)
- [3. Planejamento](#_3-Planejamento)
- [4. Gerenciamento](#_4-Gerenciamento)

## 1. Papéis

### Scrum Master

Responsável por remover impedimentos relacionados ao desenvolvimento; Minimizar riscos do projeto; Garantir a disseminação de contéudo entre os membros da equipe; Monitorar e aperfeiçoar a produtividade da equipe utilizando métricas bem definidas; Garantir que a metodologia seja aplicada.


### Product Owner

Responsável por trazer a visão de produto às decisões do time; Analisar e priorizar os pontos mais valiosos, do ponto de vista dos stakeholders; E Definir critérios de aceitação considerando visão do cliente. 

### DevOps

Responsável por garantir a disponibilidade dos ambientes de desenvolvimento, homologação e produção; E Configurar integração e deploy contínuo; 

### Arquiteto

Responsável por modelar a arquitetura do sistema e garantir que ela está sendo seguida no desenvolvimento; E monitorar qualidade do código.

### Desenvolvedor

Responsável por programar as histórias de usuário; Seguir técnicas de programação; E realizar testes no código produzido. 

## 2. Rituais

* Sprints
    - Duração de 7 dias : Início no domingo e término no sábado da outra semana.
    - Poderão ser menores devido as releases : Mais curtas ou longas, conforme decisão do Scrum Master.
* Daily Meeting
    - As dailies da equipe serão realizadas diariamente por meio do telegram, prioritariamente no período da manhã. Todos os membros têm como obrigação informar a respeito do andamento das suas atividades.
* Sprint Review
    - Ocorrerão aos sábados, iniciando às 14h 
* Sprint Restropective
    - Ocorrerá aos sábados, iniciando às 15:30h
* Sprint Planning
    - Será realizado nas reuniões de sábado


## 3. Planejamento

* Issues 
    - As issues serão criadas para todos os tipos de contribuição com o projeto, a fim de registrar o trabalho da equipe. Ainda com esse objetivo, o uso de labels servirão identificar facilmente : O responsável e o tipo de atividade relacionada. 
    - As labels utilizadas até o momento, são: 
        - Architecture
        - Bug
        - Devops
        - Documentation
        - Enhancement
        - EPS
        - MDS
        - Meetings
        - Planning
        - PO
        - Question
        - Scrum Master
        - Spike
        - Technical Story
        - TechnicalT
        - StoryUS 
        - Wontfix
        
* Milestones

    - As milestones serão utilizadas para identificar as sprints, visto que considera-se que a cada sprint tem-se uma entrega de funcionalidades/incrementos, é possível caracterizá-las como macros do projeto. Assim, as issues planejadas devem ser mapeadas para as milestones referentes.

* Épicos

    - Os épicos serão utilizados para associar issues de um mesmo módulo ou para representar issues que possuam um alto nível de complexidade/dificuldade, a fim de facilitar o desenvolvimento.
    
* User Story

    - As user stories seguirão o seguinte padrão: Eu como [usuário] desejo [ação que será executada] para [justificativa];
    - Toda user story, associada à uma issue deve possuir critérios de aceitação a serem verificados a fim de definir uma tela como concluída;

* Planning Poker

    - Técnica aplicada para auxiliar na estimativa da dificuldade das atividades a serem realizadas nas sprints, a fim de conseguir mapear a capacide de produção da equipe;
    - Os pontos estimados para as issues devem constar no seu registro;
    - As pontuações consideradas são: 0, 1, 2, 3, 5, 8, 13 e 21;

* Priorização 
    - A priorização foi simplificada adotando-se os seguintes níveis: Baixa, média, alta.

## 4. Gerenciamento

* Velocity
    - O velocity atuará como ferramenta para análise da capacidade de desenvolvimento da equipe. Ele será elaborado ao fim de cada sprint e será consultado pelo Scrum Master no planejamento da sprint seguinte.

* Burndown
    - Para monitorar as atividades entregues, o Scrum Master utilizará também o burndown, gerado pelo kanban usado pela equipe. Ele irá utilizá-lo inclusive ao longo das sprints para garantir as entregas. 

* Burndown de Riscos
    - Para monitorar os riscos do projeto, a fim de evitar complicações e maiores problemas, o Scrum Master irá criar e monitorar o burndown de riscos ao longo das sprints. 