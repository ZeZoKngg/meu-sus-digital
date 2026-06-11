# 🏥 Meu SUS Digital

> Sistema web de agendamento e gestão de consultas pelo SUS — Projeto Acadêmico

[![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square&logo=java)](https://www.java.com)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.5-green?style=flat-square&logo=springboot)](https://spring.io/projects/spring-boot)
[![HTML/CSS/JS](https://img.shields.io/badge/Frontend-HTML%2FCSS%2FJS-blue?style=flat-square&logo=html5)](https://developer.mozilla.org/en-US/docs/Web)
[![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow?style=flat-square)]()

---

## 📋 Sobre o Projeto

O **Meu SUS Digital** é uma aplicação web acadêmica que simula o sistema de agendamento e gestão de consultas médicas pelo Sistema Único de Saúde (SUS). O projeto foi desenvolvido como trabalho acadêmico com foco em boas práticas de orientação a objetos e arquitetura REST.

---

## 🚀 Tecnologias

### Backend
- **Java 17**
- **Spring Boot 3.2.5**
- **Spring Data JPA**
- **Spring Security** (autenticação básica)
- **H2 Database** (desenvolvimento) / **MySQL** (produção)
- **Maven**

### Frontend
- **HTML5 / CSS3 / JavaScript** (puro, sem frameworks)
- Consumo de API REST via `fetch`

---

## ✨ Funcionalidades

- 📅 Agendamento de consultas médicas
- 👤 Cadastro e autenticação de usuários (pacientes)
- 🩺 Gerenciamento de especialidades e médicos
- 📋 Histórico de consultas por usuário
- ❌ Cancelamento de consultas
- 🔄 Reagendamento (PATCH)
- 🏥 Painel administrativo básico

---

## 📁 Estrutura do Projeto

```
meu-sus-digital/
├── src/
│   ├── main/
│   │   ├── java/com/sus/
│   │   │   ├── controller/
│   │   │   ├── service/
│   │   │   ├── repository/
│   │   │   ├── model/
│   │   │   └── dto/
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/   ← frontend HTML/CSS/JS
│   └── test/
├── pom.xml
└── README.md
```

---

## ▶️ Como Rodar

### Pré-requisitos
- Java 17+
- Maven 3.8+

### Passos

```bash
# Clone o repositório
git clone https://github.com/ZeZoKngg/meu-sus-digital.git
cd meu-sus-digital

# Execute com Maven
mvn spring-boot:run
```

Acesse: [http://localhost:8080](http://localhost:8080)

---

## 👨‍💻 Desenvolvedores

| Nome | GitHub |
|------|--------|
| Miguel Luiz | [@ZeZoKngg](https://github.com/ZeZoKngg) |

---

## 📄 Licença

Projeto acadêmico — sem licença comercial.

