# 📺 Projeto Assistir Vídeo

Este projeto simula um sistema de interação entre usuários (Gafanhotos) e vídeos em uma plataforma de conteúdo, utilizando conceitos de Programação Orientada a Objetos (POO) em Java com persistência em banco de dados MySQL.

## 🚀 Funcionalidades

- Cadastro de Gafanhotos e Vídeos
- Registro de Visualizações
- Avaliação de vídeos com cálculo automático de média
- Registro de curtidas
- Atualização automática das estatísticas de vídeos e usuários
- Persistência de dados com JDBC (sem uso de frameworks)

## 🧱 Estrutura do Projeto

O projeto está dividido em pacotes:

- `modelo`: Classes que representam as entidades do sistema (`Gafanhoto`, `Video`, `Visualizacao`)
- `dao`: Classes de acesso a dados que realizam as operações no banco (DAO)
- `servico`: Lógica de negócios e orquestração das interações
- `conexao`: Conexão com o banco de dados
- `app`: Classe principal com exemplos de execução e testes

## 🗃️ Banco de Dados

O banco de dados MySQL utilizado possui relacionamentos com **chaves estrangeiras**, garantindo integridade entre:

- Gafanhotos
- Vídeos
- Visualizações

As operações incluem `INSERT`, `UPDATE`, `SELECT`, e `DELETE`, com controle manual das chaves.

## ⚙️ Tecnologias Utilizadas

- Java 8+
- JDBC
- MySQL
- Orientação a Objetos
- Git
