# 🧪 Automacao de Testes com Java, MySQL, JUnit e Selenium

Este projeto tem como objetivo demonstrar a automacao de testes relacionada a manipulacao de dados em um banco de dados MySQL. Os testes abrangem a criacao da tabela, insercao de usuarios via API, verificacao da integridade dos dados e validacao de regras como a nao duplicidade de IDs e remocao de registros.

---

## 🚀 Funcionalidades Testadas

* \*\*Criacao automatica da tabela \*\*\`\`
* **Importacao de usuarios via chamada a uma API externa**
* **Insercao de novos usuarios com verificacao de duplicidade**
* **Remocao de usuarios**
* **Validacao da existencia ou nao de registros no banco de dados apos as operacoes**
* **Integracao com Selenium para cenarios de interface (UI)**

---

## 📆 Tecnologias Utilizadas

* **Java 21**
* **JUnit 5**
* **Selenium WebDriver**
* **MySQL**
* **Maven**

---

## 📁 Organizacao do Codigo

```
src/
├── main/
│   └── java/
│       ├── ImportaClientes.java         # Codigo principal para importar os usuarios
│       ├── TestAddUser.java             # Teste: insercao de novo usuario
│       ├── AddUserExistent.java         # Teste: tentativa de insercao duplicada
│       └── TestRemoveUser.java          # Teste: remocao de usuario
```

---

## 📝 Como Executar

1. Clone este repositorio
   mvn test

---

## 🤝 Contribuicoes

Contribuicoes sao bem-vindas! Sinta-se a vontade para abrir issues ou enviar pull requests.
