# Entrega contínua

## Histórico de Versões

| Data | Versão | Autor(a) | Descrição |
| - | - | - | - |
| 12/11/2019 | 0.1 | Andrew Lucas | Criando versão inicial do documento |


# 1. Introdução
Este documento visa fornecer um detalhamento a cerca do pipeline de entrega contínua do projeto. Serão apresentadas as ferramentas utilizadas, os estágios utilizados e os artefatos gerados.

# 2. Ferramentas
- **Gitlab-ci**: executar e monitorar os pipelines, espelhos de cada repositório do github foram criados no gitlab
- **Jest**: teste unitário backend  
- **Espresso**: teste de aceitação front  
- **Codeclimate**: monitoramento de cobertura de teste e qualidade do código em ambos repositórios  
- **ESlint**: para garantir que a folha de estilo está sendo seguida no backend    
- **Docker/Docker-compose**: conteinerização da aplicação e facilitar a execução das tarefas do pipeline
- **Digital Ocean**: droplet para rodar os ambiente de staging e produção

# 3. Pipeline Backend
Para conferir os ultimos pipelines executados [entre aqui](https://gitlab.com/andrewlucas/2019-2-Over26-Backend/pipelines)

## 3.1. Estágios
- **Build**: é realizado o build da imagem, e em seguida é feito push para o registry.
- **Test**: são executados os testes unitários, utilizando a imagem do estágio anterior. E após rodar os testes com sucesso a taxa de cobertura é reportada ao codeclimate. Também é executada a verificação da folha de estilo, usando o eslint.
- **Release**: é realizado o build da imagem, a imagem é tageada como dev(staging) ou latest(production) e em seguida é feito push para o registry.
- **deploy**: as variáveis de ambiente são atualizadas na droplet do ambiente alvo. A útlima versão da imagem é baixada e o serviço é atualizado utilizando docker-compose para orquestrar os containers.

## 3.1. Ambientes
Quando uma branch é mesclada na devel, o pipeline é executado para atualzar a versão staging, e quando na master, atualiza a versão de produção.
- **Staging**: diponível através da url http://staging.over26.tk/ ou http://159.65.222.74. [Código fonte](https://github.com/fga-eps-mds/2019.2-Over26-Backend/tree/devel)
- **Produção**: diponível através da url http://over26.tk/ ou http://157.245.95.245. [Código fonte](https://github.com/fga-eps-mds/2019.2-Over26-Backend/tree/master)

# 3. Pipeline Frontend (Mobile)
Para conferir os ultimos pipelines executados [entre aqui](https://gitlab.com/andrewlucas/2019-2-Over26/pipelines)
## 3.1. Estágios
- **environment**: O ambiente é preparado para rodar as próximas tarefas. Se o Dockerfile for alterado, a imagem é buildada, e pushada para o registry. Esta imagem contém as ferramentas necessárias para realizar o build, test e deploy do app.
- **build**: O projeto kotlin é buildado em modo debug, para verificar erros, e em modo release, para gerar o apk que será publicado em uma versão específica.
- **test**: Os tests são rodados utilizando a versão previamente buildada em modo de debug.
- **internal**: Esta etapa é manual, onde o apk será publicado internamente.
- **alpha**:  Esta etapa é automática e será executada somente na devel. Publica o apk para teste fechado na play store
- **beta**:   Esta etapa é automática e será executada somente na devel. Publica o apk para teste aberto na play store
- **production**:  Esta etapa é automática e será executada somente na devel. Publica o apk para produção na play store

## 3.2. Versões
- **Teste interno**: Versão de teste para verificar sugetões de alteraçoes em PR's e/ou testar branchs em desenvolvimento. Para participar desses testes acesse [esse link](https://play.google.com/apps/internaltest/4699361648800961760) 
- **Teste fechado**: Versão de teste da branch devel. Para participar desses testes acesse [esse link](https://play.google.com/apps/testing/com.eps.creditoffer)
- **Teste aberto**: Versão de teste pré-lançamento. Esta versão utiliza o código da branch master, e para participar desses testes acesse [esse link](https://play.google.com/apps/testing/com.eps.creditoffer)
- **Produção**: Última versão estável, o código se encontra nas branchs release-[o numero da versão do app]. Essa versão está disponível abertamente na [play store](https://play.google.com/store/apps/details?id=com.eps.creditoffer)
