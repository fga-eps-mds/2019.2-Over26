# Histórico de Versões

| Data | Versão | Autor(a) | Descrição |
| - | - | - | - |
| 01/10/2019 | 0.1 |Maria Luiza | Criação de gereciamento de riscos do projeto |


# Índice

* [Gerenciamento de Riscos](#_Gerenciamento-de-Riscos)
* [Riscos e Consequências](#Riscos-e-Consequências)
* [Grau dos Riscos](#Grau-dos-Riscos) 
* [Plano de Ação para os Riscos](#Plano-de-Ação-para-os-Riscos)    

# Gerenciamento de Riscos
Este plano tem como objetivo descrever quais são os riscos do projeto e como eles serão controlados ao longo das sprints, a fim de mitigá-los. 


# Riscos e Consequências

## Riscos de Projeto
| Risco | Consequência |
| - | - |
| Indefinição de escopo | Alteração no planejamento e andamento das sprints |
| Projeto de domínio complexo | Dificuldade de entendimento do escopo por parte da equipe |
| Alteração na Arquitetura | Gera retrabalho, alteração nas histórias planejadas, mudança de infraestrutura e código  |
| Falha na Comunicação  | Falhas de desenvolvimento, perda de informação e retrabalho |
| Descomprometimento da equipe | Risco para o planejamento e aumento de tarefas não concluídas |
| Imaturidade da gerência | Planejamentos falhos, falta de qualidade, aumento do custo e tempo do projeto, entre outros |
| Desistencia de membros | Sobrecarga e desgaste dos outros membros |
| Erro de Priorização | Estimativa de produtividade errada e refatoração |


## Riscos Técnicos
| Risco | Consequência |
| - | - |
| Falta de conhecimento/experiência com as tecnologias escolhidas | Qualidade ruim do código, muitos bugs, aumento de custo e tempo do projeto e planejamento falho |
| Defeito de algum equipamento | Prejudica o planejamento e atrasa as entregas |
| Problemas relacionados ao ambiente de desenvolvimento | Prejudica o planejamento e atrasa as entregas |

## Riscos Externos
| Risco | Consequência |
| - | - |
| Demora para obter respostas do cliente | Falta de entendimento do escopo, problema de planejamento e organização da equipe  |

## Riscos de Produto
| Risco | Consequência |
| - | - |
| O produto não atender às expectativas do cliente | Projeto falho e inutilizável  |

# Grau dos Riscos

O grau dos riscos é definido pela multiplicação da probabilidade de ocorrência pelo impacto dos mesmos causados ao projeto. 

O risco foi definido da seguinte forma: 

Risco >= 15 - **Elevado**
<br>
5 < Risco >= 15 - **Médio**
<br>
5 > Risco - **Baixo**

A probabilidade foi definida da seguinte forma:

0 - **Nula**
<br>
1 - **Muito Baixa**
<br>
2 - **Baixa**
<br>
3 - **Média**
<br>
4 - **Alta**
<br>
5 - **Muito Alta**

O impacto foi definido da seguinte forma:

0 - **Nulo**
<br>
1 - **Muito Baixo**
<br>
2 - **Baixo**
<br>
3 - **Médio**
<br>
4 - **Alto**
<br>
5 - **Muito Alto**


| Descrição | Probabilidade | Impacto | Risco
| - | - | - | - |
| Indefinição de escopo | 4 | 5 | 20 |
| Projeto de domínio complexo | 3 | 4 | 12 |
| Alteração na Arquitetura | 4 | 5 | 20 |
| Falha na Comunicação | 5 | 5 | 25 |
| Descomprometimento da equipe | 4 | 5 | 20 |
| Imaturidade da gerência | 4 | 5 | 20 |
| Desistencia de membros | 3 | 4 | 12 |
| Erro de Priorização | 3 | 4 | 12 |
| Falta de conhecimento/experiência com as tecnologias escolhidas | 5 | 4 | 20 |
| Defeito de algum equipamento | 3 | 2 | 6 |
| Problemas relacionados ao ambiente de desenvolvimento | 4 | 4 | 16 |
| Demora para obter respostas do cliente | 4 | 4 | 16 |
| O produto não atender às expectativas do cliente | 2 | 5 | 10 |


# Plano de Ação para os Riscos
| Descrição | Risco | Ação | Plano de Ação | Responsável |
| - | - | - | - | - |
| Indefinição de escopo | 20 | Previnir | Validar constantemente com os Stakeholders | Product Owner |
| Projeto de domínio complexo | 12 | Previnir | Deixar de forma clara para que todos da equipe entendam o que deve ser feito | Product Owner |
| Alteração na Arquitetura | 20 | Mitigar |  Procurar suporte para a construção da arquitetura e pensar na arquitetura de forma crítica e cuidadosa| Arquiteta |
| Falha na Comunicação | 25 | Previnir | Monitorar a comunicação da equipe e dos pareamentos durante a sprint | Scrum Master |
| Descomprometimento da equipe | 20 | Previnir | Enfatizar a importância dos membros e do projeto para a vida profissional de cada um, trazer a responsabilidade para todos da equipe | EPS |
| Imaturidade da gerência | 20 | Mitigar | Pensar de forma crítica e estratégica, monitorar as métricas e tomar atitudes pertinentes | EPS |
| Desistencia de membros | 12 | Aceitar | Redistribuição das tarefas | Scrum Master |
| Erro de Priorização | 12 | Previnir | Monitorar priorização e utilizar técnicas de priorizaçãr | Product Owner |
| Falta de conhecimento/experiência com as tecnologias escolhidas | 20 | Mitigar | Dar treinamentos e suporte ao time de MDS | EPS, principalmente Devops e Arquiteta|
| Defeito de algum equipamento | 6 | Previnir | Cuidar dos equipamentos de trabalho | Todo o time |
| Problemas relacionados ao ambiente de desenvolvimento | 16 | Mitigar | Colocar o docker no projeto e padronizar ambientes | Devops |
| Demora para obter respostas do cliente | 16  | Previnir | Estar sempre em contato com o cliente e já marcar reuniões em dias específicos | Product Owner |
| O produto não atender às expectativas do cliente | 10 | Previnir | Estar sempre recebendo feedback do cliente e mostrando o produto sempre que possível | Product Owner|

**Observação**: É importante salientar que o monitoramento dos riscos será feito através do Burndown de Riscos. Assim como a visão do Scrum Master apresentando os riscos e como serão mitigados. 