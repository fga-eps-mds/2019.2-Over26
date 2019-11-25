# Teste de Usabilidade

" Teste de usabilidade é uma técnica de caixa-preta. O objetivo é observar usuários reais usando o produto para descobrir problemas e pontos de melhorias. O produto, que pode ser um site, uma aplicação web, um produto físico, não precisa estar completamente desenvolvido. Protótipos são vastamente utilizados em testes de usabilidade para validação do que está sendo feito." - [Caelum](https://www.caelum.com.br/apostila-ux-usabilidade-mobile-web/usabilidade/#o-que--medido)

## Sobre

O teste de usabilidade a ser desenvolvido se fundamentará no [artigo de Jakob Nielsen](http://www.nngroup.com/articles/why-you-only-need-to-test-with-5-users) que diz que o número ideal de pessoas para realização do teste de um produto é 5, visto que essas 5 pessoas de fato utilizarão o seu aplicativo. Como metodologia para realização do teste, será utilizada a entrevista em 5 passos, uma técnica de UX criada por Michael Margolis e retirada o livro [Sprint - O método usado no google para testar e aplicar novas ideias em apenas 5 dias](https://www.skoob.com.br/livro/resenhas/663568/edicao:665834). Segue abaixo o template base criado para a entrevista:

# Entrevista em 5 passos 
 
1. Cumprimento Amigável

    * Olá, boa tarde/bom dia, muito obrigada por nos ajudar. Estamos tentando testar a nossa solução e descobrir meios de aprimorá-las. Sua opinião é importante para nós.

    * Lembrando que o teste é informal e não precisa ter receio de responder às perguntas da maneira mais sincera quanto possível.

    * Nós gravaremos a sua interação com o produto para que possamos identificar problemas e potenciais necessidades de melhorias, tudo bem?

Bom, vamos começar com algumas perguntas apenas para contextualizar o nosso produto.
 
2. Contextualização do cliente

    * Você tem contas em bancos digitais? Se sim, qual, na sua opinião, é a principal vantagem?

    * Você utiliza a função de crédito das suas contas?

    * Você acha que o seu limite é suficiente para os seus gastos?

    * Você conhece o cheque especial? Já utilizou? O que pensa desse serviço?

    * Qual a sua principal motivação pra utilizar ou não esse serviço?

3. Apresentação do produto

    Vou te explicar a situação: “Você precisa realizar uma compra cujo valor é bem maior que o saldo disponível na sua conta”

    O produto permite simular o uso do cheque especial atrelado à uma conta de pagamento 100% digital. Nele, ao iniciar uma simulação você recebe um usuário e uma conta, por meio dos quais é possível:

        * Realizar transações de entrada e saída de valores
        * Ativar ou desativar cheque especial
        * Acompanhar as dívidas geradas 
        * Acompanhar o limite do cheque especial

4. Tarefas

    Analisar e anotar as reações do usuário enquanto realiza os seguintes fluxos: 

    * Ativar o cheque especial

    * Ver quanto do limite foi usado

    * Ajustar limite 

    * Utilizar o cheque especial

            Para testar o uso do cheque especial, considerar os seguintes cenários: 

            Cenário 1

                Usuário utiliza o overdraft e após o período de 26 dias ele insere o valor necessário pra ser pago, de modo que não é criada dívida

            Cenário 2

                Cliente entra em overdraft, faz retiradas a mais, aumentando o valor devido e após os 26 dias deposita para cobrir a dívida

            Cenário 3 

                Usuário entra em overdraft, faz entrada no valor em dívida, faz mais retiradas entrando em overdraft de novo e prazo dos 26 dias se altera, ao 26 dia ele cobre a dívida e não há nenhuma taxa cobrada

            Cenário 4

                Cliente entra em overdraft e não quita o saldo antes dos 26 dias. Cliente acompanha a dívida criada e paga parcela.

    * Visualizar dívidas

5. Debriefing

    * Você utilizaria o serviço de cheque especial Over26? Por quê?
    * O que você menos gostou no uso do cheque especial Over26?
    * Qual foi a sua impressão sobre o processo de ativar o cheque especial?
    * Qual foi a sua impressão sobre o processo de visualizar a sua dívida? 
    * Qual foi a sua principal dificuldade para acompanhar o uso do limite de cheque especial? E para ajustar o seu limite?
    * O que você mais gostou do APP? E o que você mudaria?

