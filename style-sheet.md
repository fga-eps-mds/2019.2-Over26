# Índice

* [1. Introdução](#_1-introdução)
* [2. Objetivos](#_2-objetivos)
* [3. Guia de estilo para o projeto Kotlin (frontend)](#_3-Guia-de-estilo-para-o-projeto-Kotlin-frontend)
    * [3.1. Estrutura dos arquivos](#_31-Estrutura-dos-arquivos)
    * [3.2. Formatação](#_32-Formatação)
        * [3.2.1. Organização do código](#_321-Organização-do-código)
        * [3.2.2. Chaves](#_322-Chaves)
        * [3.2.3. Espaços em branco](#_323-Espaços-em-branco)
        * [3.2.4. Construtores específicos](#_324-Construtores-específicos)
    * [3.3. Nomenclatura](#_33-Nomenclatura)
    * [3.4. Comentários](#_34-Comentários)
* [4. Guia de estilo para o projeto Node (backend)](#_4-Guia-de-estilo-para-o-projeto-Node-backend)
    * [4.1 Estrutura dos arquivos](#_41-Estrutura-dos-arquivos)
    * [4.2. Formatação](#_42-Formatação)
    * [4.3. Nomenclatura](#_43-Nomenclatura)
    * [4.4. Comentários](#_44-Comentários)
* [5. Recomendações](#_5-Recomendações)
* [6. Referências](#_6-Referências)
* [Histórico de Versões](#_histórico-de-versões)

# 1. Introdução

A necessidade da determinação de padrões estruturais e de código se faz presente em todo projeto de software, isso porque projetos mal organizados e com códigos pouco legíveis tendem a se tornar custosos no que se refere à manutenção, entre outros aspectos.

Por conta disso, este documento foi criado. Serão apontados aqui os padrões para os projetos do frontend e do backend, além de algumas recomendações relevantes para o desenvolvimento.

# 2. Objetivos

Este documento tem como objetivo principal guiar o desenvolvimento, apresentando os padrões a serem seguidos com a finalidade de manter o projeto em uma estrutura bem organizada e aumentar a legibilidade do código produzido.

# 3. Guia de estilo para o projeto Kotlin (frontend)

## 3.1. Estrutura dos arquivos

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
    
## 3.2. Formatação

### 3.2.1. Organização do código

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



### 3.2.2. Chaves

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

### 3.2.3. Espaços em branco

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
    

### 3.2.4. Construtores específicos

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


## 3.3. Nomenclatura

* **Nomes de arquivos**

    Para arquivos .kt, utilize o nome da classe comportada pelo mesmo para nomeá-lo. O nome deve estar em Inglês e seguir o padrão _PascalCase_.

    ```
    MainActivity.kt
    ```

    Para arquivos de outras extensões, utilize o padrão _lowercase_, separando as palavras com _underscores_.

    ```
    main_activity.xml
    example_image.png
    ```

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
    
## 3.4. Comentários

* O uso de barras duplas `//` ou barras com asteriscos `/**/` é opcional. Recomenda-se utilizar `//` para comentários de uma única linha e `/**/` para comentários de múltiplas linhas.


* Tente escrever comentários que explicam mecanismos de alto nível ou que esclareçam partes difíceis do seu código. Não use comentários para reafirmar coisas triviais.


    * Faça:
    ```
    // Returns the absolute value of the given [number].
    fun abs(number: Int) = ...
    ```
    ```
    /*
     * This function is intended to return all the objetcs
     * corresponding with the given [id]. If any object matches with
     * [id], then it returns an empty list.
     */
     fun getObjects(id: Int): List<Object> {
         ...
     }
    ```
    
    * Não faça:
    ```
    // Execute abs.
    fun abs(number: Int) = ...
    ```
    ```
     // This function is intended to return all the objetcs
     // corresponding with the given [id]. If any object matches with
     // [id], then it returns an empty list.
     fun getObjects(id: Int): List<Object> {
         ...
     }
    ```

# 4.  Guia de estilo para o projeto Node (backend)

## 4.1. Estrutura dos Arquivos

A estrutura dos arquivos .js devem seguir a seguinte ordem:

1. Informações de licensa ou de direitos autorais
2. Declarações de `import`
3. Declarações de `require`
4. Implementação

## 4.2. Formatação

* **Use 4 espaços para a identação**

    Use 4 espaços para identar o seu código e nunca misture tabs e espaços.
    
* **Novas linhas**
    
    Use o estilo de novas linhas do UNIX (\n), e um caractere de nova linha como último caractere de um arquivo.
    
* **Nenhum espaço em branco à direita**

    Retire todos os espaços em branco que estiverem sobrando à direita de todo código no seu arquivo .js.
    
* **Use ponto e vírgula `;`**

    O uso de ponto e vírgula é um valor central da comunidade JavaScript.

* **80 caracteres por linha**

    Limte as linhas do código a 80 caracteres.

* **Use aspas simples**

    Use aspas simples, a menos que você esteja codificando um tipo JSON.
    
    * Faça:
    ```
    var foo = ‘bar’;
    ```
    
    * Não faça:
    ```
    var foo = "bar";
    ```
    
* **Chaves de abertura `{` vão na mesma linha**

    * Faça:
    ```
    if (true) {
        console.log(‘winning’);
    }
    ```
    
    ```
    if (true) {
        console.log(‘winning’);
    } else if (false) {
        console.log(‘this is good’);
    } else {
        console.log(‘finally’);
    }
    ```
    
    * Não faça:
    ```
    if (true)
    {
        console.log(‘winning’);
    }
    ```
    
    ```
    if (true) 
    {
        console.log(‘winning’);
    } 
    else if (false) 
    {
        console.log(‘this is good’);
    } 
    else 
    {
        console.log(‘finally’);
    }
    ```
    
* **Declare uma variável por declaração `var` ou `const`**

    * Faça:
    ```
    var keys = [‘foo’, ‘bar’];
    var values = [23, 42];
    var object = {};
    ```
    
    * Não faça:
    ```
    var keys = [‘foo’, ‘bar’],
    values = [23, 42],
    object = {},
    key;
    ```
    
* **Use vírgulas à direita e coloque declarações curtas em uma única linha**

    * Faça:
    ```
    var a = ['hello', 'world'];
    var b = {
      good: 'code',
      'is generally': 'pretty',
    };
    ```
    
    * Não faça:
    
    ```
    var a = [
      'hello', 'world'
    ];
    var b = {"good": 'code'
            , is generally: 'pretty'
            };
    ```

Use trailing commas and put short declarations on a single line. 

## 4.3. Nomenclatura

* **Use _camelCase_ para variáveis propriedades e nomes de funções**

    Variáveis, propriedades e nomes de funções devem usar _camelCase_. Eles devem também ser descritivos. Variáveis identificadas com apenas um caracter e abreviações incomuns devem geralmente ser evitadas.

    * Faça:
    ```
    var adminUser = db.query(‘SELECT * FROM users …’);
    ```
    
    * Não faça:
    ```
    var admin_user = db.query(‘SELECT * FROM users …’);
    ```
    
* **Use _PascalCase_ para nomes de classes**

    * Faça:
    ```
    function BankAccount() {
    
    }
    ```
    
    * Não faça:
    ```
    function bank_Account() {
    
    }
    ```
    
* **Use _UPPERCASE_ para propriedades estáticas de classe**

    * Faça:
    ```
    function File() {
    
    }
    
    File.FULL_PERMISSIONS = 0777;
    ```
    
    * Não faça:
    ```
    function File() {
    
    }
    
    File.fullPermissions = 0777;
    ```

## 4.4. Comentários

* O uso de barras duplas `//` ou barras com asteriscos `/**/` é opcional. Recomenda-se utilizar `//` para comentários de uma única linha e `/**/` para comentários de múltiplas linhas.


* Tente escrever comentários que explicam mecanismos de alto nível ou que esclareçam partes difíceis do seu código. Não use comentários para reafirmar coisas triviais.

    * Faça:

    ```
    /* 
     * This function has a nasty side effect where a failure to 
     *  increment a redis counter used for statistics will 
     * cause an exception. This needs to be fixed in a later iteration.
     */
    function loadUser(id, cb) {
        ...
    }


    // Check if user is able to access system functionalities
    var isSessionValid = (session.expires < Date.now());
    if (isSessionValid) {
        ...
    }
    ```

    * Não faça:

    ```
    // Execute a regex
    var matches = item.match(/ID_([^\n]+)=([^\n]+)/);

    // Usage: loadUser(5, function() { ... })
    function loadUser(id, cb) {
      // ...
    }

    // Check if the session is valid
    var isSessionValid = (session.expires < Date.now());
    // If the session is valid
    if (isSessionValid) {
      // ...
    }
    ```

# 5. Recomendações

* Escreva tudo em Inglês (código, comentários, nomes de arquivos e diretórios, etc.), com exceção das informações exibidas para usuários finais.
* Mantenha o código logicamente organizado, para que outras pessoas consigam entendê-lo de maneira fácil.
* Utilize uma nomenclatura simples e descritiva.
* **Não ignore os padrões definidos neste documento.**

# 6. Referências

* https://developer.android.com/kotlin/style-guide
* https://kotlinlang.org/docs/reference/coding-conventions.html
* https://ktlint.github.io/#rules
* https://medium.com/swlh/node-js-coding-style-guidelines-74a20d00c40b

# Histórico de Versões

| Data | Versão | Autor(a) | Descrição |
| - | - | - | - |
| 18/09/2019 | 0.1 |Natália Rodrigues | Criação da estrutura do documento, adicionando introdução e objetivos. |
| 23/09/2019 | 0.2 | Natália Rodrigues | Adicionando padrões de formatação do código |
| 24/09/2019 | 0.3 | Natália Rodrigues | Completando guia de estilo para o projeto Kotlin |
| 25/09/2019 | 0.4 | Natália Rodrigues | Adicionando o guia de estilo para o projeto Node |
| 26/09/2019 | 0.5 | Natália Rodrigues | Finalizando o guia de estilo para o projeto Node e fazendo algumas alterações no documento. |