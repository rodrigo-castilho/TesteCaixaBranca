# **TesteCaixaBranca - Sistema de Login**
---

## **Problemas Identificados**

### 1. **Erro no driver JDBC**
- **Descrição:** O código utiliza a classe `"com.mysql.DriverManager"` como driver JDBC, o que está incorreto.
- **Impacto:** Impede a conexão com o banco de dados, tornando o sistema inutilizável.

---

### 2. **SQL Injection**
- **Descrição:** As variáveis `login` e `senha` são conectadas diretamente na query SQL, deixando o sistema vulnerável a ataques de SQL Injection.
- **Impacto:** Possibilidade de invasões ao banco de dados, comprometendo a segurança do sistema.

---

### 3. **Conexão não fechada**
- **Descrição:** A conexão com o banco de dados (`Connection`) não é fechada após o uso, causando vazamento de recursos.
- **Impacto:** Péssimo desempenho e possibilidade de falhas no sistema devido ao esgotamento de conexões.

---

### 4. **Manipulação de exceções**
- **Descrição:** O código ignora exceções ao capturá-las.
- **Impacto:** Dificuldade para diagnosticar erros e manter o sistema.

---

### 5. **Nomes confusos**
- **Descrição:** As variáveis globais `result` e `nome` possuem nomes genéricos, dificultando o entendimento do código.
- **Impacto:** Reduz a legibilidade e aumenta a chance de erros por confusão.

---

### 6. **Possível NullPointerException**
- **Descrição:** Caso a conexão ao banco de dados falhe, a variável `conn` será nula. O código não verifica essa possibilidade antes de utilizá-la.
- **Impacto:** Erros inesperados durante a execução do sistema.



