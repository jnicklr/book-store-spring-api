# 📚🚀 Documentação do Projeto Book Store

Bem-vindo(a)! Nesta documentação, você encontrará os passos necessários para configurar e executar o projeto **Book Store** com PostgreSQL via Docker e uma aplicação Spring Boot. Tudo isso embalado com emojis para uma melhor experiência! 😄

---
## 📋 Sumário

1. [Pré-requisitos](#-pré-requisitos-)
2. [1️⃣ Instalar o Java](#1️⃣-instalar-o-java-)
3. [2️⃣ Levantar o PostgreSQL (Docker)](#2️⃣-levantar-o-postgresql-docker-)
4. [3️⃣ Subir a aplicação Spring Boot](#3️⃣-subir-a-aplicação-spring-boot-)
5. [🔗 Configurar conexão com o banco](#🔗-configurar-conexão-com-o-banco)
6. [🚨 Observações](#🚨-observações)

---
## 🛠️ Pré-requisitos ✅

Antes de começar, certifique-se de ter instalado em sua máquina:

- **Java JDK 21+** ☕
- **Docker** 🐳
- **Maven** (caso não use o wrapper `mvnw`) ⚙️

> Dica: utilizamos o Maven Wrapper (`./mvnw`) para facilitar, mas você também pode usar o Maven instalado globalmente.

---
## 1️⃣ Instalar o Java ☕

### No Ubuntu/Debian
```bash
sudo apt update
sudo apt install -y openjdk-11-jdk
```

### No macOS (Homebrew)
```bash
brew update
brew install openjdk@11
brew link --force --overwrite openjdk@11
```

### Verificando a instalação
```bash
java -version
# Deve retornar algo como: openjdk version "11.x.x" 202x-xx-xx
```

---
## 2️⃣ Levantar o PostgreSQL (Docker) 🐘

Execute este comando para subir o container do PostgreSQL:

```bash
docker run -d \
  --name book_store_postgres \
  -e POSTGRES_USER=admin \
  -e POSTGRES_PASSWORD=admin123 \
  -e POSTGRES_DB=book_store \
  -p 5432:5432 \
  postgres:latest
```

- **--name**: nome do container (`book_store_postgres`)
- **-e**: variáveis de ambiente para usuário, senha e database
- **-p**: mapeia a porta 5432 do container para a 5432 do host

Verifique se deu tudo certo:
```bash
docker ps
# Deve listar o container 'book_store_postgres' em execução
```

---
## 3️⃣ Subir a aplicação Spring Boot 🌱

Navegue até a pasta raiz do projeto e execute:

### Com Maven Wrapper
```bash
./mvnw spring-boot:run
```

### Ou com Maven instalado globalmente
```bash
mvn spring-boot:run
```

### Gerando e executando o JAR
```bash
mvn clean package
java -jar target/book-store-0.0.1-SNAPSHOT.jar
```

A aplicação estará disponível em: `http://localhost:9000` 🎉

---
## 🔗 Configurar conexão com o banco de dados

No arquivo `src/main/resources/application.properties` (ou `application.yml`), defina as seguintes propriedades:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/book_store
spring.datasource.username=admin
spring.datasource.password=admin123
spring.jpa.hibernate.ddl-auto=update  # opcional, para criar/atualizar tabelas automaticamente
```

---
## 🚨 Observações

- Se preferir usar **Docker Compose**, crie um `docker-compose.yml` com serviços `postgres` e `app`.
- Certifique-se de que nenhuma outra aplicação esteja usando a porta **5432** ou **8080**.

---
✨ **Pronto!** Agora você tem um ambiente completo com PostgreSQL e Spring Boot rodando em container. Bom desenvolvimento e bons estudos! 📖👩‍💻👨‍💻