# Histórico de Versões

| Data | Versão | Autor(a) | Descrição |
| - | - | - | - |
| 30/08/2019 | 0.1 |Natália Rodrigues | Documentação da política de branches e demais definições a respeito do Git Flow. |
|03/09/2019 | 0.2 | Natália Rodrigues | Fluxo de adição de documentos. |


# Índice

* [1. Estrutura de branches](#1.-Estrutura-de-branches)
* [2. Padrões definidos](#2.-Padrões-definidos)
    * [2.1. Nomes de branches](#2.1.-Nomes-de-branches)
    * [2.2. Commits](#2.2.-Commits)
    * [2.3. Fluxo de adição de uma nova funcionalidade](#2.3.-Fluxo-de-adição-de-uma-nova-funcionalidade)
    * [2.4. Fluxo de adição de documentos](#2.4.-Fluxo-de-adição-de-documentos)
* [3. Referências](#3.-Referências)
    

# 1. Estrutura de branches

A estrutura de branches do repositório seguirá a organização definida a seguir:

* branch padrão **_master_**, para hospedar o código estável do projeto (que estará em ambiente de produção); 
* branches **_release/*_**, para  abrigar as versões do código em estágio de preparação para serem colocadas em produção; 
* branch **_develop_**, para manter o código mais atualizado do projeto, que está em estágio preparatório para a próxima entrega (onde serão integradas as funcionalidades desenvolvidas); 
* branches **_feature/*_**, nas quais serão desenvolvidas as novas funcionalidades; 
* branches **_hotfix/*_**, que servirão para correção de eventuais bugs encontrados em produção.
* branches **_docs/*_**, que serão utilizadas para o desenvolvimento da documentação do projeto.


# 2. Padrões definidos

## 2.1. Nomes de branches

Em Inglês, letras minúsculas, palavras separadas por '-', respeitando o padrão gitflow. 

Ex: _feature/cadastro-usuario_


## 2.2. Commits

Em Inglês, verbo no gerúndio com descrição do que foi feito, com ponto no final da frase e co-authored para as pessoas no pareamento (usar _git commit -s_). 

Ex:

_Implementing user register._

_Co-authored-by: Natália Rodrigues <nataliamrq@gmail.com\>_


## 2.3. Fluxo de adição de uma nova funcionalidade

#### 1. Criar a branch para a nova funcionalidade a partir de _develop_

Na branch _develop_ (atualizada):

`git checkout -b feature/new-feature`

#### 2. Implementar a nova funcionalidade
#### 3. Fazer o merge da branch _develop_ para a branch da nova funcionalidade

Na branch _feature/new-feature_:

 `git fetch`
`git merge develop`

ou

`git pull origin develop`

#### 4. Resolver os conflitos e subir as alterações

`git push origin feature/new-feature`

#### 5. Abrir o Pull Request da branch _feature/new-feature_ para a branch _develop_


## 2.4. Fluxo de adição de documentos

#### 1. Criar a branch para o novo documento a partir de _master_

Na branch _master_ (atualizada):

`git checkout -b docs/new-docs`

#### 2. Produzir o(s) documento(s)

Adicione o(s) documento(s) criado(s) em markdown na pasta docs e os links para ele(s) no arquivo _sidebar.md

#### 3. Fazer o merge da branch _master_ para a branch do(s) novo(s) documento(s)

Na branch _docs/new-docs_:

 `git fetch`
`git merge master`

ou

`git pull origin master`

#### 4. Resolver os conflitos e subir as alterações

`git push origin docs/new-docs`

#### 5. Abrir o Pull Request da branch _docs/new-docs_ para a branch _master_


# 3. Referências

* https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow
* https://fjorgemota.com/git-flow-uma-forma-legal-de-organizar-repositorios-git/