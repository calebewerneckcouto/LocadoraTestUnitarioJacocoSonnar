# Projeto Locadora de Filmes

## Estrutura do Projeto

```
src/
├── main/
│   ├── java/
│   │   └── br/com/cwcdev/
│   │       ├── entidades/
│   │       │   ├── Filme.java
│   │       │   ├── Locacao.java
│   │       │   └── Usuario.java
│   │       ├── exceptions/
│   │       │   ├── DadosInvalidosException.java
│   │       │   ├── EstoqueInsuficienteException.java
│   │       │   └── LocacaoException.java
│   │       └── service/
│   │           └── LocacaoService.java
│   └── resources/
└── test/
    └── java/
        └── br/com/cwcdev/
            ├── entidades/
            │   ├── FilmeTest.java
            │   ├── LocacaoTest.java
            │   └── UsuarioTest.java
            └── service/
                └── LocacaoServiceTest.java
```

## Linguagens de Programação Usadas

- **Java**: Principal linguagem de programação utilizada para o desenvolvimento do projeto.

## Dependências e Instruções de Instalação

### Dependências

- **JUnit 5**: Utilizado para a execução de testes unitários.
- **Java 8 ou superior**: Utilizado para manipulação de datas com a classe `LocalDate`.

### Instruções de Instalação

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/seuusuario/locadora-de-filmes.git
   ```

2. **Instale as dependências**:
   Utilize Maven ou Gradle para gerenciar as dependências. Se estiver usando Maven, adicione as seguintes dependências ao `pom.xml`:
   ```xml
   <dependencies>
       <dependency>
           <groupId>org.junit.jupiter</groupId>
           <artifactId>junit-jupiter-engine</artifactId>
           <version>5.8.2</version>
           <scope>test</scope>
       </dependency>
   </dependencies>
   ```

## Como Rodar o Projeto e Executar Testes

### Rodar o Projeto

1. **Compile o projeto**:
   ```bash
   mvn clean install
   ```
   ou
   ```bash
   gradle build
   ```

2. **Execute a aplicação**:
   ```bash
   java -cp target/locadora-de-filmes-1.0-SNAPSHOT.jar br.com.cwcdev.Main
   ```
   (Note que o comando acima assume que você tem uma classe `Main` como ponto de entrada. Adapte conforme necessário.)

### Executar Testes

```bash
mvn test
```
ou
```bash
gradle test
```

## Explicação Detalhada dos Arquivos de Código

### `LocacaoService.java`

- **Funções**:
  - `alugarFilme(Usuario usuario, Filme filme)`: Gerencia o processo de aluguel, validando dados e reduzindo o estoque.
  - `validarDadosLocacao(Usuario usuario, Filme filme)`: Valida os dados do usuário e do filme, lançando exceções se necessário.
  - `reduzirEstoque(Filme filme)`: Reduz o estoque do filme em uma unidade.

### `EstoqueInsuficienteException.java`

- **Responsabilidade**: Exceção lançada quando o estoque de um filme é insuficiente.

### `Usuario.java`

- **Atributos**: `nome` e `email`.
- **Funções**: Métodos getters e setters para os atributos, além de um construtor.

### `Filme.java`

- **Atributos**: `titulo`, `estoque` e `valor`.
- **Funções**: Métodos getters e setters para os atributos, além de construtores e `toString()`.

### `Locacao.java`

- **Atributos**: `usuario`, `filme`, `valor`, `dataLocacao` e `dataRetorno`.
- **Funções**: Métodos getters e setters para os atributos, além de construtores e `toString()`.

### `LocacaoServiceTest.java`

- **Funções**: Testa o método `alugarFilme` do `LocacaoService`, verificando a criação correta da locação e a redução do estoque.

### `UsuarioTest.java`

- **Funções**: Testa a criação e alteração de dados da classe `Usuario`.

### `FilmeTest.java`

- **Funções**: Testa a criação e alteração de dados da classe `Filme`.

### `DadosInvalidosException.java`

- **Responsabilidade**: Exceção lançada quando os dados de entrada são inválidos.

### `LocacaoTest.java`

- **Funções**: Testa a criação correta de uma instância de `Locacao`.

## Exemplos de Uso

### Alugando um Filme

```java
Usuario usuario = new Usuario("João", "joao@email.com");
Filme filme = new Filme("Filme Teste", 5, 10.0);
LocacaoService service = new LocacaoService();
Locacao locacao = service.alugarFilme(usuario, filme);
System.out.println(locacao.toString());
```

## Boas Práticas e Dicas para Contribuir

1. **Pull Requests**: Antes de enviar um PR, certifique-se de que todos os testes estão passando e que o código está formatado corretamente.
2. **Testes**: Escreva testes para novas funcionalidades e corrija quaisquer testes quebrados.
3. **Exceções**: Utilize as exceções personalizadas (`DadosInvalidosException`, `EstoqueInsuficienteException`) para manter a consistência no tratamento de erros.
4. **Encapsulamento**: Mantenha os atributos das classes como privados e utilize getters e setters para manipulá-los.
5. **Documentação**: Adicione comentários Javadoc para métodos e classes.
6. **Nomenclatura**: Siga as convenções de nomenclatura do Java (camelCase para variáveis e métodos, PascalCase para classes).

## Contribuindo

Para contribuir com este projeto, siga os passos abaixo:

1. **Fork** o repositório.
2. Clone o seu fork:
   ```bash
   git clone https://github.com/seuusuario/locadora-de-filmes.git
   ```
3. Crie uma branch para sua funcionalidade:
   ```bash
   git checkout -b feature-nome-da-funcionalidade
   ```
4. Faça commit das suas mudanças:
   ```bash
   git commit -m "Adiciona funcionalidade XYZ"
   ```
5. Push para o seu fork:
   ```bash
   git push origin feature-nome-da-funcionalidade
   ```
6. Abra um **Pull Request**.

Para mais detalhes, consulte a [documentação](https://docs.maritaca.ai).