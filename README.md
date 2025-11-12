# Projeto Locadora de Filmes

## Estrutura do Projeto

```
locadora-filmes/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── br/
│   │   │   │   ├── cwcdev/
│   │   │   │   │   ├── entidades/
│   │   │   │   │   │   ├── Filme.java
│   │   │   │   │   │   ├── Locacao.java
│   │   │   │   │   │   ├── Usuario.java
│   │   │   │   │   ├── exceptions/
│   │   │   │   │   │   ├── DadosInvalidosException.java
│   │   │   │   │   │   ├── EstoqueInsuficienteException.java
│   │   │   │   │   ├── service/
│   │   │   │   │   │   ├── LocacaoService.java
│   ├── test/
│       ├── java/
│       │   ├── br/
│       │   │   ├── cwcdev/
│       │   │   │   ├── entidades/
│       │   │   │   │   ├── FilmeTest.java
│       │   │   │   │   ├── LocacaoTest.java
│       │   │   │   │   ├── UsuarioTest.java
│       │   │   │   ├── service/
│       │   │   │   │   ├── LocacaoServiceTest.java
```

## Linguagens de Programação Usadas

- Java

## Dependências e Instruções de Instalação

### Dependências

- JUnit 5 (para testes unitários)
- Java 8 (para suporte à classe `LocalDate`)

### Instruções de Instalação

1. Clone o repositório.
2. Certifique-se de ter o Java 8 ou superior instalado.
3. Instale as dependências usando Maven ou Gradle.

   **Maven**:
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

   **Gradle**:
   ```gradle
   dependencies {
       testImplementation 'org.junit.jupiter:junit-jupiter-engine:5.8.2'
   }
   ```

4. Compile e execute o projeto usando seu IDE ou a linha de comando.

## Como Rodar o Projeto e Executar Testes

### Rodar o Projeto

1. Abra o projeto em seu IDE.
2. Execute a classe principal da aplicação (não fornecida no resumo, mas geralmente localizada no pacote `main`).

### Executar Testes

1. Abra o projeto em seu IDE.
2. Execute os testes nas classes localizadas em `src/test/java/`.
3. Alternativamente, use Maven ou Gradle para executar os testes.

   **Maven**:
   ```bash
   mvn test
   ```

   **Gradle**:
   ```bash
   gradle test
   ```

## Explicação Detalhada dos Arquivos de Código

### `LocacaoService.java`

**Responsabilidades**:
- Gerencia o processo de aluguel de filmes.
- Valida os dados de entrada.
- Atualiza o estoque do filme após uma locação bem-sucedida.

**Métodos**:
- `alugarFilme(Usuario usuario, Filme filme)`: Aluga um filme para um usuário.
- `criarLocacao(Usuario usuario, Filme filme)`: Cria uma nova locação.

**Exceções**:
- `DadosInvalidosException`: Lançada quando os dados de entrada são inválidos.
- `EstoqueInsuficienteException`: Lançada quando não há estoque suficiente.

### `EstoqueInsuficienteException.java`

**Responsabilidades**:
- Exceção lançada quando o estoque de um filme é insuficiente.

### `Usuario.java`

**Responsabilidades**:
- Armazena informações básicas sobre um usuário.

**Métodos**:
- Construtores para inicializar um usuário.
- Getters e setters para `nome` e `email`.

### `FilmeTest.java`

**Responsabilidades**:
- Testa a classe `Filme`.

**Funções**:
- `deveCriarFilmeCorretamente()`: Testa a criação de um filme.
- `devePermitirAlteracaoDeEstoque()`: Testa a alteração do estoque de um filme.

### `Filme.java`

**Responsabilidades**:
- Armazena informações básicas sobre um filme.

**Métodos**:
- Construtores para inicializar um filme.
- Getters e setters para `titulo`, `estoque` e `valor`.

### `LocacaoServiceTest.java`

**Responsabilidades**:
- Testa a classe `LocacaoService`.

**Funções**:
- `deveAlugarFilmeComSucesso()`: Testa o aluguel bem-sucedido de um filme.
- `deveReduzirEstoqueAposLocacao()`: Testa a redução do estoque após uma locação.

### `DadosInvalidosException.java`

**Responsabilidades**:
- Exceção lançada quando os dados de entrada são inválidos.

### `Locacao.java`

**Responsabilidades**:
- Armazena informações sobre uma locação de filme.

**Métodos**:
- Construtores para inicializar uma locação.
- Getters e setters para `usuario`, `filme`, `valor`, `dataLocacao` e `dataRetorno`.

### `LocacaoTest.java`

**Responsabilidades**:
- Testa a classe `Locacao`.

**Funções**:
- `deveCriarLocacaoCorretamente()`: Testa a criação de uma locação.

### `UsuarioTest.java`

**Responsabilidades**:
- Testa a classe `Usuario`.

**Funções**:
- `deveCriarUsuarioCorretamente()`: Testa a criação de um usuário.
- `devePermitirAlteracaoDeDados()`: Testa a alteração dos dados de um usuário.

## Exemplos de Uso

### Alugando um Filme

```java
Usuario usuario = new Usuario("João", "joao@email.com");
Filme filme = new Filme("Filme Teste", 5, 10.0);
try {
    LocacaoService service = new LocacaoService();
    Locacao locacao = service.alugarFilme(usuario, filme);
    System.out.println(locacao.toString());
} catch (EstoqueInsuficienteException | DadosInvalidosException e) {
    System.err.println(e.getMessage());
}
```

## Boas Práticas e Dicas para Contribuir

1. **Codificação**:
   - Utilize nomes de variáveis e métodos descritivos.
   - Mantenha métodos curtos e focados em uma única responsabilidade.
   - Utilize comentários para explicar a lógica complexa.

2. **Testes**:
   - Escreva testes para todos os métodos públicos.
   - Inclua testes para casos de sucesso e falha.
   - Utilize `@BeforeEach` para inicializar objetos de teste.

3. **Gerenciamento de Dependências**:
   - Utilize Maven ou Gradle para gerenciar as dependências do projeto.

4. **Pull Requests**:
   - Faça pull requests pequenos e focados.
   - Inclua uma descrição detalhada das mudanças.

5. **Documentação**:
   - Mantenha a documentação atualizada.
   - Utilize Javadoc para documentar classes e métodos.

Para mais detalhes, consulte a [documentação](https://docs.maritaca.ai).