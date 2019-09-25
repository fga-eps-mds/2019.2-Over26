# Histórico de Versões

| Data | Versão | Autor(a) | Descrição |
| - | - | - | - |
| 18/09/2019 | 0.1 |Natália Rodrigues | Criação da estrutura do documento, adicionando introdução e objetivos. |
| 23/09/2019 | 0.2 | Natália Rodrigues | Adicionando padrões de formatação do código |
| 24/09/2019 | 0.3 | Natália Rodrigues | Completando guia de estilo para o projeto Kotlin |

# Índice

* [1. Introdução](#_1-introdução)
* [2. Objetivos](#_2-objetivos)
* [3. Guia de estilo para o projeto Kotlin (frontend)](#_3-guia-de-estilo-para-o-projeto-kotlin-frontend)
    * [3.1. Organização do código fonte]()
    * [3.2. Estrutura dos arquivos]()
    * [3.3. Formatação]()
        * [3.3.1. Organização do código]()
        * [3.3.2. Chaves]()
        * [3.3.3. Espaços em branco]()
        * [3.3.4. Construtores específicos]()
        * [3.3.5. Nomenclatura]()
* [4. Guia de estilo para o projeto Node (backend)]()
* [5. Referências]()

# 1. Introdução

A necessidade da determinação de padrões estruturais e de código se faz presente em todo projeto de software, isso porque projetos mal organizados e com códigos pouco legíveis tendem a se tornar custosos no que se refere à manutenção, entre outros aspectos.

Por conta disso, este documento foi criado. Serão apontados aqui os padrões referentes à formatação de código, comentários e nomenclatura do projeto, além de algumas recomendações relevantes para o desenvolvimento. 

# 2. Objetivos

Este documento tem como objetivo principal guiar o desenvolvimento, apresentando os padrões a serem seguidos com a finalidade de manter o projeto em uma estrutura bem organizada e aumentar a legibilidade do código produzido.

# 3. Guia de estilo para o projeto Kotlin (frontend)

## 3.1. Organização do código fonte



## 3.2. Estrutura dos arquivos

A estrutura dos arquivos seguirá a seguinte ordem:

1. Cabeçalho de direitos autorais e/ou licença (opcional):

```
/* 
 * Copyright 2017 Google, Inc.
 *
 * ...
 */ 
```

2. Anotações no nível de arquivo:

    Anotações do tipo ```@file:JvmName("Foo")``` são colocadas entre os comentários de cabeçalho, se existirem, e a declaração de pacote.

3. Declaração de pacote: 

    Sem limite de caracteres por coluna e sem quebras de linha.

4. Declarações de imports

    Declarações de import para classes, funções, e propriedades são agrupadas juntas em uma única lista e ordenadas de acordo com a tabela ASCII. Todas as declarações de import também não possuem limite de caracteres por coluna e não devem ter quebras de linha.


5. Declarações de nível superior

    As declarações de tipos, funções e propriedades são colocadas após os imports, mas não tem restrições de ordenação. Orienta-se ordenar essas declarações de forma mais legível e lógica possível.
    
## 3.3. Formatação

### 3.3.1. Organização do código

* **Identação**

    Toda vez que um novo bloco é aberto, a identação incrementa em 4 espaços. Quando o bloco termina, a identação retorna ao nível anterior. Isso se aplica ao código e aos comentários do bloco.
    
* **Uma declaração por linha**

    Toda declaração é seguida por uma quebra de linha. Ponto e vírgula `;` não é utilizado.
    
* **Quebras de linha**

    O código deve ter um limite de 100 caracteres por coluna. As exceções são para as declarações de pacote e imports.
    

    * Faça:

    ```
    fun <T> Iterable<T>.joinToString(
        separator: CharSequence = ", ",
        prefix: CharSequence = "",
        postfix: CharSequence = ""
    ): String {
        // …
    }
    ```
    
    ```
    private val defaultCharset: Charset? =
            EncodingRegistry.getInstance().getDefaultCharsetForPropertiesFiles(file)
    ```



### 3.3.2. Chaves

As chaves `{}` seguem o estilo _Kernighan and Ritchie_ (K&R).

* **Blocos não vazios:**

    * Sem quebras de linha antes da chave de abertura `{`
    * Quebra de linha após à chave de abertura `{`
    * Quebra de linha antes da chave de fechamento `}`
    * Quebra de linha após à chave de fechamento, apenas se a chave encerrar uma declaração ou o corpo de uma função, construtor, ou classe nomeada. Por exemplo, não há quebra de linha depois de uma chave se ela é seguida por `else` ou `,`.


    *    Faça:
    ```
    return Runnable {
        while (condition()) {
            foo()
        }
    }

    return object : MyClass() {
        override fun foo() {
            if (condition()) {
                try {
                    something()
                } catch (e: ProblemException) {
                    recover()
                }
            } else if (otherCondition()) {
                somethingElse()
            } else {
                lastThing()
            }
        }
    }

    ```

* **Blocos vazios:**

    * Faça:
    ```
    try {
        doSomething()
    } catch (e: Exception) {
    }
    ```


    * Não faça:
    ```
    try {
    doSomething()
    } catch (e: Exception) {}
    ```
    
* **Expressões**

    Condições `if/else` e declarações de funções podem omitir as chaves `{}` apenas se a expressão inteira couber em uma única linha.

    * Faça:

    ```
    val value = if (string.isEmpty()) 0 else 1
    ```
    
    ```
    override fun toString(): String = "Hey"
    ```

### 3.3.3. Espaços em branco

* **Verticalmente**

    Uma única linha em branco aparece nas seguintes situações:

    * Entre membros consecutivos de uma classe: propriedades, construtores, funções, classes aninhadas, etc. Há excessão para duas propriedades consecutivas (não existindo nenhum outro código entre elas), onde a linha em branco é opcional.
    * Entre declarações, como for necessário para organizar o código em subseções lógicas.
    * Opcionalmente antes da primeira declaração dentro de uma função, antes do primeiro membro de uma classe, ou depois do último membro de uma classe.
    * Como requisitado nas outras seções deste documento (como a seção de [Esrtutura dos Arquivos](#_32-estrutura-dos-arquivos)).
    * Linhas em branco consecutivas são permitidas, mas não encorajadas.

* **Horizontalmente**

    Espaços aparecem nas seguintes situações:
    
    * Separando qualquer palavra reservada de um parêntesis de abertura `(` que a segue na mesma linha.
        * Faça:
        ```
        for (i in 0..1) {
        }
        ```
        
        * Não faça:
        ```
        for(i in 0..1) {
        }
        ```
        
    * Separando qualquer palavra reservada de uma chave de fechamento `}` que a precede na mesma linha.

        * Faça:
        ```
        } else {
        }
        ```
        
        * Não faça:
        ```
        }else {
        }
        ```
        
    * Antes de qualquer chave de abertura `{`

        * Faça:
        ```
        if (list.isEmpty()) {
        }
        ```
        
        * Não faça:
        ```
        if (list.isEmpty()){
        }
        ```
    * Nos dois lados de qualquer operador binário

        * Faça:
        ```
        val two = 1 + 1
        ```
        * Não faça:
        ```
        val two = 1+1
        ```
        
    * Nos dois lados da flecha em uma expressão lambda
    
        * Faça:
        ```
        ints.map { value -> value.toString() }
        ```
        
        * Não faça:
        ```
        ints.map { value->value.toString() }
        ```
        
    * Antes dos dois pontos `:` apenas se usados em uma declaração de classe para especificar uma classe base ou uma interface, ou quando usados em uma cláusula `where` para restrições genéricas.

        * Faça:
        ```
        class Foo : Runnable
        ```
        ```
        fun <T : Comparable> max(a: T, b: T)
        ```
        ```
        fun <T> max(a: T, b: T) where T : Comparable<T>
        ```
        
        * Não faça:
        ```
        class Foo: Runnable
        ```
        ```
        fun <T: Comparable> max(a: T, b: T)
        ```
        ```
        fun <T> max(a: T, b: T) where T: Comparable<T>
        ```
        
    * Depois de vírgulas `,` ou dois pontos `:`.

        * Faça:
        ```
        val oneAndTwo = listOf(1, 2)
        ```
        ```
        class Foo : Runnable
        ```
        
        * Não faça:
        ```
        val oneAndTwo = listOf(1,2)
        ```
        ```
        class Foo :Runnable
        ```
        
    * Nos dois lados das barras duplas que iniciam um comentário de fim de linha.
        * Faça:
        ```
        var debugging = false // disabled by default
        ```
        * Não faça:
        ```
        var debugging = false//disabled by default
        ```
        
    * Porém, para os símbolos `::`, `.` e `..`
        * Faça: 
        ```
        val toString = Any::toString
        ```
        ```
        it.toString()
        ```
        ```
        for (i in 1..4) print(i)
        ```
        * Não faça:
        ```
        val toString = Any :: toString
        ```
        ```
        it . toString()
        ```
        ```
         for (i in 1 .. 4) print(i)
        ```
    

### 3.3.4. Construtores específicos

* **Classes enum**

    Uma classe enum com nenhuma declaração de função ou documentação nas suas constantes pode ser opcionalmente formatada em uma única linha.
    
    ```
    enum class Answer { YES, NO, MAYBE }
    ```
    
    Quando as constantes em uma classe enum são colocadas em linhas separadas, uma linha em branco não é necessária entre elas, exceto nos casos onde elas definem um corpo.
    
    ```
    enum class Answer {
        YES,
        NO,

        MAYBE {
            override fun toString() = """¯\_(ツ)_/¯"""
        }
    }
    ```

* **Anotações**

    Anotações de membro ou de tipo são colocadas em linhas separadas, imediatamente antes da construção anotada.
    
    ```
    @Retention(SOURCE)
    @Target(FUNCTION, PROPERTY_SETTER, FIELD)
    annotation class Global
    ```
    
    Anotações sem argumentos podem ser colocadas em uma única linha.
    
    ```
    @JvmField @Volatile
    var disposable: Disposable? = null
    ```
    
    Quando uma única anotação sem argumentos está presente, ela pode ser colocada na mesma linha da declaração.
    
    ```
    @Volatile var disposable: Disposable? = null

    @Test fun selectAll() {
        // …
    }
    ```
    
* **Tipos implícitos de propriedades e retornos**

    Se uma o corpo da função de uma expressão ou um inicializador de uma propriedade é um valor escalar ou o tipo de retorno pode ser claramente inferido pelo corpo, então ele pode ser omitido.

    ```
    override fun toString(): String = "Hey"
    // se torna
    override fun toString() = "Hey
    ```

    ```
    private val ICON: Icon = IconLoader.getIcon("/icons/kotlin.png")
    // se torna
    private val ICON = IconLoader.getIcon("/icons/kotlin.png")

    ```


### 3.3.5. Nomenclatura

* **Nomes de pacotes**
    * Faça:
    ```
    package com.example.deepspace
    ```
    * Não faça:
    ```
    package com.example.deepSpace

    package com.example.deep_space
    ```

* **Nomes de tipos**

    Nomes de classes são escritos em _PascalCase_ e são tipicamente substantivos ou frases substantivas.

    ```
    Character
    ImmutableList
    ```

    Interfaces podem também ser substantivos ou frases substantivas, mas podem às vezes ser adjetivos ou frases adjetivas.

    ```
    List
    Readable
    ```

    Classes de teste são nomeadas iniciando com o nome da classe sendo testada e terminando com `Test`.

    ```
    HashTest
    HashIntegrationTest
    ```

* **Nomes de funções**

    Nomes de funções são escritos em _camelCase_ e são tipicamente verbos ou frases verbais.

    ```
    sendMessage
    stop
    ```

* **Nomes de constantes**

    Nomes de constantes utilizam _UPPER_SNAKE_CASE_ e são tipicamente substantivos ou frases substantivas.

    ```
    const val NUMBER = 5
    val NAMES = listOf("Alice", "Bob")
    val AGES = mapOf("Alice" to 35, "Bob" to 32)
    val COMMA_JOINER = Joiner.on(',')
    val EMPTY_ARRAY = arrayOf()
    ```

    Constantes cujos valores são escalares devem utilizar o modificador `const`.

* **Nomes de variáveis**

    Nomes de variáveis são escritos em _camelCase_ e são tipicamente substantivos ou frases substantivas.

    ```
    val variable = "var"
    val nonConstScalar = "non-const"
    val mutableCollection: MutableSet = HashSet()
    val mutableElements = listOf(mutableInstance)
    val mutableValues = mapOf("Alice" to mutableInstance, "Bob" to mutableInstance2)
    val logger = Logger.getLogger(MyClass::class.java.name)
    val nonEmptyArray = arrayOf("these", "can", "change")
    ```

# 4.  Guia de estilo para o projeto Node (backend)

# 5. Referências

* https://developer.android.com/kotlin/style-guide
* https://kotlinlang.org/docs/reference/coding-conventions.html
* https://ktlint.github.io/#rules
* https://medium.com/swlh/node-js-coding-style-guidelines-74a20d00c40b