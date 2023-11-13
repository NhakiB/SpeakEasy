# SpeakEasy

##Link do vídeo no Youtube -> [Sprint4-Devops](https://www.youtube.com/watch?v=TMcQ_p_pd8c)

O SpeakEasy é um assistente de reuniões baseado em software que utiliza tecnologia de Processamento de Linguagem Natural (NLP) para transcrever e resumir automaticamente as informações discutidas nas reuniões. Ele é capaz de reconhecer vozes, identificar informações importantes e organizar as informações em uma ata de reunião clara e concisa, que pode ser facilmente editada e compartilhada com os participantes da reunião.

Nesta documentação, você encontrará informações detalhadas sobre as rotas disponíveis, os parâmetros necessários e as respostas retornadas pela API.
## Pré-requisitos

Antes de começar, verifique se você atende aos seguintes requisitos:

- [Java JDK](https://www.oracle.com/java/technologies/javase-downloads.html) (versão 8 ou superior)
- [Maven](https://maven.apache.org/download.cgi)
- [Git](https://git-scm.com/downloads)

## Instalação

Para instalar este projeto em sua máquina local, siga estas etapas:

1. Clone o repositório:

   git clone https://github.com/DevallOficial/SpeakEasy

2. Navegue até o diretório do projeto:

    cd SpeakEasy\SpeakEasyAPI

3. Compile o projeto usando o Maven:

    mvn clean install

4. Inicie a aplicação Spring Boot:

    mvn spring-boot:run


# Documentação


Contribuidores

- [Caio Henrique Martins](https://github.com/Caiohrqm)
- [Gabriela Vieira](https://github.com/vieiragab)
- [Isadora Antunes](https://github.com/NhakiB)
- [Maria Eduarda Herrera](https://github.com/herrera3)

## Endpoints
- Usuário
    - [Cadastrar](#cadastrar-usuario)
    - [Listar](#listar-usuarios)
    - [Detalhar](#detalhar-usuarios)
    - [Alterar](#alterar-usuarios)
    - [Excluir](#excluir-usuarios)

- Reunião
    - [Cadastrar](#cadastrar-reunião)
    - [Listar](#listar-reuniões)
    - [Detalhar](#detalhar-reunião)
    - [Alterar](#alterar-reunião)
    - [Excluir](#excluir-reuniões)


- Colaborador
    - [Cadastrar](#cadastrar-colaborador)
    - [Listar](#listar-colaboradores)
    - [Excluir](#excluir-colaborador)



### Cadastrar usuário

`POST` /api/usuarios

| campo | tipo | obrigatório | descrição
|-------|------|-------------|-----------
| nome | string | sim | nome do usuário |
| email | string | sim | email de acesso e comunicação do usuário |
| senha | string | sim | senha de acesso do usuário |
| pais | string | sim | país de origem do usuário |

**Exemplo de corpo de requisição**

```json
{
    "nome": "DevAll",
    "email": "empresarial@devall.com.br",
    "senha": "DevAll123"
}
```

**Exemplo de corpo de resposta**

```json
{
    "id": 1,
    "nome": "DevAll",
    "email": "empresarial@devall.com.br",
    "senha": "DevAll123"
}

```

**Códigos de resposta**




| codigo | descrição |
|--------|-----------|
| 201 | Indica que a requisição POST foi bem-sucedida e o servidor criou um novo recurso como resultado |
| 404 | Indica que o recurso solicitado na requisição POST não foi encontrado no servidor |
| 500 | Indica que ocorreu um erro interno no servidor ao processar a requisição POST |

---

    
### Listar usuários
`GET` /api/usuarios

**Exemplo de Corpo de resposta**

```json
[
    {
    "id": 1,
    "nome": "DevAll",
    "email": "empresarial@devall.com.br",
    "senha": "DevAll123"
    },
    {
    "id": 2,
    "nome": "SpeakEasy",
    "email": "empresarial@SpeakEasy.com.br",
    "senha": "SpeakEasy123"
    }
]

```

**Códigos de resposta**

| codigo | descrição |
|--------|-----------|
| 200 | A requisição GET foi bem-sucedida e o servidor retornou os dados solicitados no corpo da resposta|
| 404 | O recurso solicitado na requisição GET não pode ser encontrado|
| 500 | Ocorreu um erro interno do servidor ao processar a requisição GET|

---


### Detalhar usuário
`GET` /api/usuarios/{id}
  
    
**Parâmetros de caminho**

id - código do usuário a ser detalhado

**Exemplo de Corpo de resposta** 

```json
{
    "id": 1,
    "nome": "DevAll",
    "email": "empresarial@devall.com.br",
    "senha": "DevAll123"
}

```

**Códigos de resposta**

| codigo | descrição |
|--------|-----------|
| 200 | A requisição GET foi bem-sucedida e o servidor retornou os dados solicitados no corpo da resposta|
| 404 | O recurso solicitado na requisição GET não pode ser encontrado|
| 500 | Ocorreu um erro interno do servidor ao processar a requisição GET|


---

### Alterar usuário

`PUT` /api/usuarios/{id}

        
**Parâmetros de caminho**

id - código do usuário a ser alterado
    
**Exemplo de corpo de requisição**

```json
{
    "nome": "DevAll",
    "email": "empresarial@devall.com.br",
    "senha": "DevAll321"
}

```

**Exemplo de corpo de resposta**

```json
{
    "id": 1,
    "nome": "DevAll",
    "email": "empresarial@devall.com.br",
    "senha": "DevAll321"
}
```

**Códigos de resposta**

| codigo | descrição |
|--------|-----------|
| 200 | A requisição PUT foi bem-sucedida e o recurso foi atualizado com sucesso|
| 404 | O recurso que a requisição PUT está tentando atualizar não pode ser encontrado|
| 500 | Ocorreu um erro interno do servidor ao processar a requisição PUT|

---

### Excluir usuário

`DELETE` /api/usuarios/{id}

**Parâmetros de caminho**

id - código do usuário a ser excluído

**Códigos de resposta**

| codigo | descrição |
|--------|-----------|
| 200 | este código é usado para indicar que a requisição DELETE foi bem-sucedida e o recurso foi excluído com sucesso. |
| 404  | este código é usado quando o recurso que a requisição DELETE está tentando excluir não pode ser encontrado| 
| 500  | este código é usado quando ocorre um erro interno do servidor ao processar a requisição DELETE|

---

### Cadastrar reunião

`POST` /api/reunioes

| campo | tipo | obrigatório | descrição
|-------|------|:-------------:|----------
| titulo | string | sim | título do video para identificação do próprio usuário|
| descricao | string | nao | descrição da reunião preenchida pelo próprio sistema |
| duracao | string | sim | tempo de duração da reunião |
| data | ZonedDateTime  | sim | data da reunião |
| dataAlteracao | ZonedDateTime | não | serve para armazenar a data de alteração da reunião |
| audio | byte | sim | áudio da reunião que será usado para transcrição |


**Exemplo de corpo de requisição**

```json
{
    "titulo": "Reunião sobre X assunto",
    "descricao": "Reunião feita para tomada de decisão sobre X coisas, reunião entimada pelo diretos geral, etc...",
    "data": "2023-11-10T14:30:00",
    "audioFile": [0x52, 0x49, 0x46, 0x46, 0x24, 0x08, 0x00, 0x00, 0x41, 0x56, 0x49, 0x20, 0x4C, 0x49, 0x53, 0x54, 0x08, 0x00, 0x00, 0x00, 0x57, 0x41, 0x56, 0x45, 0x66, 0x6D, 0x74, 0x20, 0x10, 0x00, 0x00, 0x00, 0x01, 0x00, 0x02, 0x00, 0x44, 0xAC, 0x00, 0x00, 0x10, 0xB1, 0x02, 0x00, 0x04, 0x00, 0x10, 0x00, 0x64, 0x61, 0x74, 0x61, 0x00, 0x08, 0x00, 0x00, 0x00, 0x48, 0x65, 0x6C, 0x6C, 0x6F, 0x20, 0x57, 0x6F, 0x72, 0x6C, 0x64]
}
```

**Exemplo de corpo de resposta**

```json
{
    "id": 1,
    "titulo": "Reunião sobre X assunto",
    "descricao": "Reunião feita para tomada de decisão sobre X coisas, reunião entimada pelo diretos geral, etc...",
    "data": "2023-11-10T14:30:00",
    "audiofile": [0x52, 0x49, 0x46, 0x46, 0x24, 0x08, 0x00, 0x00, 0x41, 0x56, 0x49, 0x20, 0x4C, 0x49, 0x53, 0x54, 0x08, 0x00, 0x00, 0x00, 0x57, 0x41, 0x56, 0x45, 0x66, 0x6D, 0x74, 0x20, 0x10, 0x00, 0x00, 0x00, 0x01, 0x00, 0x02, 0x00, 0x44, 0xAC, 0x00, 0x00, 0x10, 0xB1, 0x02, 0x00, 0x04, 0x00, 0x10, 0x00, 0x64, 0x61, 0x74, 0x61, 0x00, 0x08, 0x00, 0x00, 0x00, 0x48, 0x65, 0x6C, 0x6C, 0x6F, 0x20, 0x57, 0x6F, 0x72, 0x6C, 0x64]
}

```

**Códigos de resposta**


| codigo | descrição |
|--------|-----------|
| 201 | Indica que a requisição POST foi bem-sucedida e o servidor criou um novo recurso como resultado |
| 404 | Indica que o recurso solicitado na requisição POST não foi encontrado no servidor |
| 500 | Indica que ocorreu um erro interno no servidor ao processar a requisição POST |

---

### Listar reuniões
`GET` /api/reunioes

**Exemplo de Corpo de resposta**

```json
[
    {
    "id": 1,
    "titulo": "Reunião sobre X assunto",
    "descricao": "Reunião feita para tomada de decisão sobre X coisas, reunião entimada pelo diretos geral, etc...",
    "data": "2023-11-10T14:30:00",
    "audio": [0x52, 0x49, 0x46, 0x46, 0x24, 0x08, 0x00, 0x00, 0x41, 0x56, 0x49, 0x20, 0x4C, 0x49, 0x53, 0x54, 0x08, 0x00, 0x00, 0x00, 0x57, 0x41, 0x56, 0x45, 0x66, 0x6D, 0x74, 0x20, 0x10, 0x00, 0x00, 0x00, 0x01, 0x00, 0x02, 0x00, 0x44, 0xAC, 0x00, 0x00, 0x10, 0xB1, 0x02, 0x00, 0x04, 0x00, 0x10, 0x00, 0x64, 0x61, 0x74, 0x61, 0x00, 0x08, 0x00, 0x00, 0x00, 0x48, 0x65, 0x6C, 0x6C, 0x6F, 0x20, 0x57, 0x6F, 0x72, 0x6C, 0x64]
    },
    {
    "id": 2,
    "titulo": "Reunião sobre Y assunto",
    "descricao": "Reunião feita para tomada de decisão sobre Y coisas, reunião entimada pelo gerente de marketing, etc...",
    "data": "2023-11-10T14:30:00",
    "audio": [0x52, 0x49, 0x46, 0x46, 0x24, 0x08, 0x00, 0x00, 0x41, 0x56, 0x49, 0x20, 0x4C, 0x49, 0x53, 0x54, 0x08, 0x00, 0x00, 0x00, 0x57, 0x41, 0x56, 0x45, 0x66, 0x6D, 0x74, 0x20, 0x10, 0x00, 0x00, 0x00, 0x01, 0x00, 0x02, 0x00, 0x44, 0xAC, 0x00, 0x00, 0x10, 0xB1, 0x02, 0x00, 0x04, 0x00, 0x10, 0x00, 0x64, 0x61, 0x74, 0x61, 0x00, 0x08, 0x00, 0x00, 0x00, 0x48, 0x65, 0x6C, 0x6C, 0x6F, 0x20, 0x57, 0x6F, 0x72, 0x6C, 0x64]
    }
]

```

**Códigos de resposta**

| codigo | descrição |
|--------|-----------|
| 200 | A requisição GET foi bem-sucedida e o servidor retornou os dados solicitados no corpo da resposta|
| 404 | O recurso solicitado na requisição GET não pode ser encontrado|
| 500 | Ocorreu um erro interno do servidor ao processar a requisição GET|

---



### Detalhar reunião
`GET` /api/reunioes/{id}
  
    
**Parâmetros de caminho**

id - código da reunião a ser detalhada

**Exemplo de Corpo de resposta** 

```json
{
    "id": 1,
    "titulo": "Reunião sobre X assunto",
    "descricao": "Reunião feita para tomada de decisão sobre X coisas, reunião entimada pelo diretos geral, etc...",
    "data": "2023-11-10T14:30:00",
    "audioFile": [0x52, 0x49, 0x46, 0x46, 0x24, 0x08, 0x00, 0x00, 0x41, 0x56, 0x49, 0x20, 0x4C, 0x49, 0x53, 0x54, 0x08, 0x00, 0x00, 0x00, 0x57, 0x41, 0x56, 0x45, 0x66, 0x6D, 0x74, 0x20, 0x10, 0x00, 0x00, 0x00, 0x01, 0x00, 0x02, 0x00, 0x44, 0xAC, 0x00, 0x00, 0x10, 0xB1, 0x02, 0x00, 0x04, 0x00, 0x10, 0x00, 0x64, 0x61, 0x74, 0x61, 0x00, 0x08, 0x00, 0x00, 0x00, 0x48, 0x65, 0x6C, 0x6C, 0x6F, 0x20, 0x57, 0x6F, 0x72, 0x6C, 0x64]
    
    }

```

**Códigos de resposta**

| codigo | descrição |
|--------|-----------|
| 200 | A requisição GET foi bem-sucedida e o servidor retornou os dados solicitados no corpo da resposta|
| 404 | O recurso solicitado na requisição GET não pode ser encontrado|
| 500 | Ocorreu um erro interno do servidor ao processar a requisição GET|


---


### Alterar reunião

`PUT` /api/reunioes/{id}

        
**Parâmetros de caminho**

id - código do reuniões a ser alterado
    
**Exemplo de corpo de requisição**

```json
    {
    "titulo": "Reunião sobre X assunto",
    "descricao": "Reunião feita para tomada de decisão sobre X coisas, reunião entimada pelo diretos geral, etc...",
    "data": "2023-11-10T14:30:00",
    "audioFile": [0x52, 0x49, 0x46, 0x46, 0x24, 0x08, 0x00, 0x00, 0x41, 0x56, 0x49, 0x20, 0x4C, 0x49, 0x53, 0x54, 0x08, 0x00, 0x00, 0x00, 0x57, 0x41, 0x56, 0x45, 0x66, 0x6D, 0x74, 0x20, 0x10, 0x00, 0x00, 0x00, 0x01, 0x00, 0x02, 0x00, 0x44, 0xAC, 0x00, 0x00, 0x10, 0xB1, 0x02, 0x00, 0x04, 0x00, 0x10, 0x00, 0x64, 0x61, 0x74, 0x61, 0x00, 0x08, 0x00, 0x00, 0x00, 0x48, 0x65, 0x6C, 0x6C, 0x6F, 0x20, 0x57, 0x6F, 0x72, 0x6C, 0x64]
    }

```

**Exemplo de corpo de resposta**

```json
{
    "id": 1,
    "titulo": "Reunião sobre Y assunto",
    "descricao": "Reunião feita para tomada de decisão sobre Y coisas, reunião entimada pelo gerente de marketing, etc...",
    "data": "2023-04-09 15:30 -02:00",
    "audioFile": [0x52, 0x49, 0x46, 0x46, 0x24, 0x08, 0x00, 0x00, 0x41, 0x56, 0x49, 0x20, 0x4C, 0x49, 0x53, 0x54, 0x08, 0x00, 0x00, 0x00, 0x57, 0x41, 0x56, 0x45, 0x66, 0x6D, 0x74, 0x20, 0x10, 0x00, 0x00, 0x00, 0x01, 0x00, 0x02, 0x00, 0x44, 0xAC, 0x00, 0x00, 0x10, 0xB1, 0x02, 0x00, 0x04, 0x00, 0x10, 0x00, 0x64, 0x61, 0x74, 0x61, 0x00, 0x08, 0x00, 0x00, 0x00, 0x48, 0x65, 0x6C, 0x6C, 0x6F, 0x20, 0x57, 0x6F, 0x72, 0x6C, 0x64],
    }
```

**Códigos de resposta**

| codigo | descrição |
|--------|-----------|
| 200 | A requisição PUT foi bem-sucedida e o recurso foi atualizado com sucesso|
| 404 | O recurso que a requisição PUT está tentando atualizar não pode ser encontrado|
| 500 | Ocorreu um erro interno do servidor ao processar a requisição PUT|

---

### Excluir reunião

`DELETE` /api/reunioes/{id}

**Parâmetros de caminho**

id - código da reunião a ser excluida

**Códigos de resposta**

| codigo | descrição |
|--------|-----------|
| 200 | este código é usado para indicar que a requisição DELETE foi bem-sucedida e o recurso foi excluído com sucesso. |
| 404  | este código é usado quando o recurso que a requisição DELETE está tentando excluir não pode ser encontrado| 
| 500  | este código é usado quando ocorre um erro interno do servidor ao processar a requisição DELETE|


---



### Cadastrar colaboradores

`POST` /api/colaboradores

| campo | tipo | obrigatório | descrição
|-------|------|-------------|-----------
| nome | string | sim | nome colaborador |
| email | string | sim | email de envio da ata do colaborador |
| status | string | não | serve para armazenar o status do colaborador, caso seja ativo deve ser preenchido com "A" caso esteja inativo deve ser preenchido com "I" |


**Exemplo de corpo de requisição**

```json
{
    "nome": "Patricia",
    "email": "patricia@speakeasy.com.br"
}
```

**Exemplo de corpo de resposta**

```json
{
    "id": 1,
    "nome": "Patricia",
    "email": "patricia@speakeasy.com.br"
}

```

**Códigos de resposta**


| codigo | descrição |
|--------|-----------|
| 201 | Indica que a requisição POST foi bem-sucedida e o servidor criou um novo recurso como resultado |
| 404 | Indica que o recurso solicitado na requisição POST não foi encontrado no servidor |
| 500 | Indica que ocorreu um erro interno no servidor ao processar a requisição POST |

---

### Listar colaboradores
`GET` /api/colaboradores

**Exemplo de Corpo de resposta**

```json
[
    {
    "id": 1,
    "nome": "Patricia",
    "email": "patricia@speakeasy.com.br"
    
    },
    {
    "id": 2,
    "nome": "Gilberto",
    "email": "gilberto@speakeasy.com.br"
    }
]

```

**Códigos de resposta**

| codigo | descrição |
|--------|-----------|
| 200 | A requisição GET foi bem-sucedida e o servidor retornou os dados solicitados no corpo da resposta|
| 404 | O recurso solicitado na requisição GET não pode ser encontrado|
| 500 | Ocorreu um erro interno do servidor ao processar a requisição GET|

---

### Excluir colaborador

`DELETE` /api/colaborador/{id}

**Parâmetros de caminho**

id - código do colaborador a ser excluido

**Códigos de resposta**

| codigo | descrição |
|--------|-----------|
| 200 | este código é usado para indicar que a requisição DELETE foi bem-sucedida e o recurso foi excluído com sucesso. |
| 404  | este código é usado quando o recurso que a requisição DELETE está tentando excluir não pode ser encontrado| 
| 500  | este código é usado quando ocorre um erro interno do servidor ao processar a requisição DELETE|

---


