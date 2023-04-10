# SpeakEasy

O SpeakEasy é um assistente de reuniões baseado em software que utiliza tecnologia de Processamento de Linguagem Natural (NLP) para transcrever e resumir automaticamente as informações discutidas nas reuniões. Ele é capaz de reconhecer vozes, identificar informações importantes e organizar as informações em uma ata de reunião clara e concisa, que pode ser facilmente editada e compartilhada com os participantes da reunião.

Nesta documentação, você encontrará informações detalhadas sobre as rotas disponíveis, os parâmetros necessários e as respostas retornadas pela API.

## Contribuidores

- [Caio Henrique Martins](https://github.com/Caiohrqm)
- [Felipe Miguel Ortega](https://github.com/Felipe-Miguel)
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

- Telefone
    - [Cadastrar](#cadastrar-telefone)
    - [Detalhar](#detalhar-telefone)
    - [Alterar](#alterar-telefone)
    - [Excluir](#excluir-telefone)

- Colaborador
    - [Cadastrar](#cadastrar-colaborador)
    - [Listar](#listar-colaboradores)
    - [Excluir](#excluir-colaborador)

- Tópicos
    - [Cadastrar](#cadastrar-topico)
    - [Listar](#listar-topicos)
    - [Alterar](#alterar-topico)
    - [Excluir](#excluir-topico)

- Categorias
    - [Cadastrar](#cadastrar-categoria)
    - [Listar](#listar-categorias)
    - [Detalhar](#detalhar-categoria)

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
    "senha": "DevAll123",
    "pais": "Brasil"
}
```

**Exemplo de corpo de resposta**

```json
{
    "id": 1,
    "nome": "DevAll",
    "email": "empresarial@devall.com.br",
    "senha": "DevAll123",
    "pais": "Brasil"
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
    "senha": "DevAll123",
    "pais": "Brasil"
    },
    {
    "id": 2,
    "nome": "SpeakEasy",
    "email": "empresarial@SpeakEasy.com.br",
    "senha": "SpeakEasy123",
    "pais": "Paraguai"
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
    "senha": "DevAll123",
    "pais": "Brasil"
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
    "senha": "DevAll321",
    "pais": "Marrocos"
}

```

**Exemplo de corpo de resposta**

```json
{
    "id": 1,
    "nome": "DevAll",
    "email": "empresarial@devall.com.br",
    "senha": "DevAll321",
    "pais": "Marrocos"
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
    "duracao": "00:27:15",
    "data": "01/01/2023 10:12 -04:00",
    "dataAlteracao": "Null",
    "audio": [0x52, 0x49, 0x46, 0x46, 0x24, 0x08, 0x00, 0x00, 0x41, 0x56, 0x49, 0x20, 0x4C, 0x49, 0x53, 0x54, 0x08, 0x00, 0x00, 0x00, 0x57, 0x41, 0x56, 0x45, 0x66, 0x6D, 0x74, 0x20, 0x10, 0x00, 0x00, 0x00, 0x01, 0x00, 0x02, 0x00, 0x44, 0xAC, 0x00, 0x00, 0x10, 0xB1, 0x02, 0x00, 0x04, 0x00, 0x10, 0x00, 0x64, 0x61, 0x74, 0x61, 0x00, 0x08, 0x00, 0x00, 0x00, 0x48, 0x65, 0x6C, 0x6C, 0x6F, 0x20, 0x57, 0x6F, 0x72, 0x6C, 0x64]
}
```

**Exemplo de corpo de resposta**

```json
{
    "id": 1,
    "titulo": "Reunião sobre X assunto",
    "descricao": "Reunião feita para tomada de decisão sobre X coisas, reunião entimada pelo diretos geral, etc...",
    "duracao": "00:27:15",
    "data": "01/01/2023 10:12 -04:00",
    "dataAlteracao": "Null",
    "audio": [0x52, 0x49, 0x46, 0x46, 0x24, 0x08, 0x00, 0x00, 0x41, 0x56, 0x49, 0x20, 0x4C, 0x49, 0x53, 0x54, 0x08, 0x00, 0x00, 0x00, 0x57, 0x41, 0x56, 0x45, 0x66, 0x6D, 0x74, 0x20, 0x10, 0x00, 0x00, 0x00, 0x01, 0x00, 0x02, 0x00, 0x44, 0xAC, 0x00, 0x00, 0x10, 0xB1, 0x02, 0x00, 0x04, 0x00, 0x10, 0x00, 0x64, 0x61, 0x74, 0x61, 0x00, 0x08, 0x00, 0x00, 0x00, 0x48, 0x65, 0x6C, 0x6C, 0x6F, 0x20, 0x57, 0x6F, 0x72, 0x6C, 0x64]
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
    "duracao": "00:27:15",
    "data": "01/01/2023 10:12 -04:00",
    "dataAlteracao": "Null",
    "audio": [0x52, 0x49, 0x46, 0x46, 0x24, 0x08, 0x00, 0x00, 0x41, 0x56, 0x49, 0x20, 0x4C, 0x49, 0x53, 0x54, 0x08, 0x00, 0x00, 0x00, 0x57, 0x41, 0x56, 0x45, 0x66, 0x6D, 0x74, 0x20, 0x10, 0x00, 0x00, 0x00, 0x01, 0x00, 0x02, 0x00, 0x44, 0xAC, 0x00, 0x00, 0x10, 0xB1, 0x02, 0x00, 0x04, 0x00, 0x10, 0x00, 0x64, 0x61, 0x74, 0x61, 0x00, 0x08, 0x00, 0x00, 0x00, 0x48, 0x65, 0x6C, 0x6C, 0x6F, 0x20, 0x57, 0x6F, 0x72, 0x6C, 0x64]
    },
    {
    "id": 2,
    "titulo": "Reunião sobre Y assunto",
    "descricao": "Reunião feita para tomada de decisão sobre Y coisas, reunião entimada pelo gerente de marketing, etc...",
    "duracao": "01:12:19",
    "data": "01/01/2023 10:12 -04:00",
    "dataAlteracao": "04/07/2023 10:12 -04:00",
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
    "duracao": "00:27:15",
    "data": "01/01/2023 10:12 -04:00",
    "dataAlteracao": "Null",
    "audio": [0x52, 0x49, 0x46, 0x46, 0x24, 0x08, 0x00, 0x00, 0x41, 0x56, 0x49, 0x20, 0x4C, 0x49, 0x53, 0x54, 0x08, 0x00, 0x00, 0x00, 0x57, 0x41, 0x56, 0x45, 0x66, 0x6D, 0x74, 0x20, 0x10, 0x00, 0x00, 0x00, 0x01, 0x00, 0x02, 0x00, 0x44, 0xAC, 0x00, 0x00, 0x10, 0xB1, 0x02, 0x00, 0x04, 0x00, 0x10, 0x00, 0x64, 0x61, 0x74, 0x61, 0x00, 0x08, 0x00, 0x00, 0x00, 0x48, 0x65, 0x6C, 0x6C, 0x6F, 0x20, 0x57, 0x6F, 0x72, 0x6C, 0x64]
    
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
    "duracao": "00:27:15",
    "data": "01/01/2023 10:12 -04:00",
    "dataAlteracao": "04/01/2023 10:12 -04:00",
    "audio": [0x52, 0x49, 0x46, 0x46, 0x24, 0x08, 0x00, 0x00, 0x41, 0x56, 0x49, 0x20, 0x4C, 0x49, 0x53, 0x54, 0x08, 0x00, 0x00, 0x00, 0x57, 0x41, 0x56, 0x45, 0x66, 0x6D, 0x74, 0x20, 0x10, 0x00, 0x00, 0x00, 0x01, 0x00, 0x02, 0x00, 0x44, 0xAC, 0x00, 0x00, 0x10, 0xB1, 0x02, 0x00, 0x04, 0x00, 0x10, 0x00, 0x64, 0x61, 0x74, 0x61, 0x00, 0x08, 0x00, 0x00, 0x00, 0x48, 0x65, 0x6C, 0x6C, 0x6F, 0x20, 0x57, 0x6F, 0x72, 0x6C, 0x64]
    }

```

**Exemplo de corpo de resposta**

```json
{
    "id": 1,
    "titulo": "Reunião sobre Y assunto",
    "descricao": "Reunião feita para tomada de decisão sobre Y coisas, reunião entimada pelo gerente de marketing, etc...",
    "duracao": "01:12:19",
    "data": "2023-04-09 15:30 -02:00",
    "dataAlteracao": "04/01/2023 10:12 -04:00",
    "audio": [0x52, 0x49, 0x46, 0x46, 0x24, 0x08, 0x00, 0x00, 0x41, 0x56, 0x49, 0x20, 0x4C, 0x49, 0x53, 0x54, 0x08, 0x00, 0x00, 0x00, 0x57, 0x41, 0x56, 0x45, 0x66, 0x6D, 0x74, 0x20, 0x10, 0x00, 0x00, 0x00, 0x01, 0x00, 0x02, 0x00, 0x44, 0xAC, 0x00, 0x00, 0x10, 0xB1, 0x02, 0x00, 0x04, 0x00, 0x10, 0x00, 0x64, 0x61, 0x74, 0x61, 0x00, 0x08, 0x00, 0x00, 0x00, 0x48, 0x65, 0x6C, 0x6C, 0x6F, 0x20, 0x57, 0x6F, 0x72, 0x6C, 0x64],
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


### Cadastrar telefone

`POST` /api/telefone

| campo | tipo | obrigatório | descrição
|-------|------|:-------------:|----------
| numeroDDD | int | sim | número do DDD do telefone do usuário|
| numeroDDI | int | sim | número do DDD do telefone do usuário |
| nrTelefone | int | sim | número do telefone do usuário |

**Exemplo de corpo de requisição**

```json

{
    "numeroDDD": 55,
    "numeroDDI": 1,
    "nrTelefone": 987654321
}

```

**Exemplo de corpo de resposta**

```json
{
    "id": 1,
    "numeroDDD": 55,
    "numeroDDI": 1,
    "nrTelefone": 987654321
}

```

**Códigos de resposta**


| codigo | descrição |
|--------|-----------|
| 201 | Indica que a requisição POST foi bem-sucedida e o servidor criou um novo recurso como resultado |
| 404 | Indica que o recurso solicitado na requisição POST não foi encontrado no servidor |
| 500 | Indica que ocorreu um erro interno no servidor ao processar a requisição POST |

---

### Detalhar telefone
`GET` /api/telefones/{id}
  
    
**Parâmetros de caminho**

id - código do telefone a ser detalhado

**Exemplo de Corpo de resposta** 

```json
{
        "id": 1,
        "numeroDDD": 11,
        "numeroDDI": 55,
        "nrTelefone": 987654321
    }

```

**Códigos de resposta**

| codigo | descrição |
|--------|-----------|
| 200 | A requisição GET foi bem-sucedida e o servidor retornou os dados solicitados no corpo da resposta|
| 404 | O recurso solicitado na requisição GET não pode ser encontrado|
| 500 | Ocorreu um erro interno do servidor ao processar a requisição GET|

---

### Alterar telefone

`PUT` /api/telefones/{id}

        
**Parâmetros de caminho**

id - código do telefone a ser alterado
    
**Exemplo de corpo de requisição**

```json
{
    {
    "numeroDDD": 55,
    "numeroDDI": 212,
    "nrTelefone": 987654321
}
}

```

**Exemplo de corpo de resposta**

```json
{
    "id": 1,
    "numeroDDD": 55,
    "numeroDDI": 212,
    "nrTelefone": 987654321
}
```

**Códigos de resposta**

| codigo | descrição |
|--------|-----------|
| 200 | A requisição PUT foi bem-sucedida e o recurso foi atualizado com sucesso|
| 404 | O recurso que a requisição PUT está tentando atualizar não pode ser encontrado|
| 500 | Ocorreu um erro interno do servidor ao processar a requisição PUT|

---

### Excluir telefone

`DELETE` /api/telefones/{id}

**Parâmetros de caminho**

id - código do telefone a ser excluido

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
| cargo | string | sim | cargo do colaborador |
| status | string | não | serve para armazenar o status do colaborador, caso seja ativo deve ser preenchido com "A" caso esteja inativo deve ser preenchido com "I" |


**Exemplo de corpo de requisição**

```json
{
    "nome": "Patricia",
    "email": "patricia@speakeasy.com.br",
    "cargo": "desenvolvedor back-end",
    "status": "A"
}
```

**Exemplo de corpo de resposta**

```json
{
    "id": 1,
    "nome": "Patricia",
    "email": "patricia@speakeasy.com.br",
    "cargo": "desenvolvedor back-end",
    "status": "A"
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
    "email": "patricia@speakeasy.com.br",
    "cargo": "desenvolvedor back-end",
    "status": "A"
    
    },
    {
    "id": 2,
    "nome": "Gilberto",
    "email": "gilberto@speakeasy.com.br",
    "cargo": "desenvolvedor front-end",
    "status": "A"
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

### Cadastrar tópico

`POST` /api/topicos

| campo | tipo | obrigatório | descrição
|-------|------|-------------|-----------
| nome | string | sim | nome do tópico |
| descricao | string | sim | descrição do tópico |

**Exemplo de corpo de requisição**

```json
{
    "nome": "Definição de tarefas e responsabilidades",
    "descricao": "Com base nas discussões anteriores, a equipe definiu as tarefas e responsabilidades para as próximas semanas. Cada membro da equipe recebeu tarefas específicas e prazos para conclusão. João, o gerente de projeto, registrou as atribuições e os prazos em um documento compartilhado para acompanhamento.
"
}
```

**Exemplo de corpo de resposta**

```json
{
    "id": 1,
    "nome": "Definição de tarefas e responsabilidades",
    "descricao": "Com base nas discussões anteriores, a equipe definiu as tarefas e responsabilidades para as próximas semanas. Cada membro da equipe recebeu tarefas específicas e prazos para conclusão. João, o gerente de projeto, registrou as atribuições e os prazos em um documento compartilhado para acompanhamento."
}
```

**Códigos de resposta**



| codigo | descrição |
|--------|-----------|
| 201 | Indica que a requisição POST foi bem-sucedida e o servidor criou um novo recurso como resultado |
| 404 | Indica que o recurso solicitado na requisição POST não foi encontrado no servidor |
| 500 | Indica que ocorreu um erro interno no servidor ao processar a requisição POST |

---

### Listar tópicos
`GET` /api/topicos

**Exemplo de Corpo de resposta**

```json
[
    {
    "id": 1,
    "nome": "Definição de tarefas e responsabilidades",
    "descricao": "Com base nas discussões anteriores, a equipe definiu as tarefas e responsabilidades para as próximas semanas. Cada membro da equipe recebeu tarefas específicas e prazos para conclusão. João, o gerente de projeto, registrou as atribuições e os prazos em um documento compartilhado para acompanhamento."
    },
    {
    "id": 2,
    "nome": "Planejamento das próximas etapas do projeto",
    "descricao": "Carlos, o designer, compartilhou uma proposta de design atualizada e apresentou algumas ideias para melhorar a interface do usuário. Após uma discussão detalhada, a equipe concordou com as modificações propostas e definiu as próximas etapas do trabalho de design."
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

### Alterar tópico

`PUT` /api/topicos/{id}

        
**Parâmetros de caminho**

id - código do topico a ser alterado
    
**Exemplo de corpo de requisição**

```json

{
    "nome": "Discussão sobre o andamento do projeto",
    "descricao": "Maria, a desenvolvedora, apresentou um relatório sobre o andamento do projeto, destacando os marcos alcançados e os desafios enfrentados. Foram discutidos os principais obstáculos e possíveis soluções para manter o projeto dentro do cronograma."
}


```

**Exemplo de corpo de resposta**

```json

{
    "nome": "Discussão sobre o andamento do projeto",
    "descricao": "Maria, a desenvolvedora, apresentou um relatório sobre o andamento do projeto, destacando os marcos alcançados e os desafios enfrentados. Foram discutidos os principais obstáculos e possíveis soluções para manter o projeto dentro do cronograma."
}
```

**Códigos de resposta**

| codigo | descrição |
|--------|-----------|
| 200 | A requisição PUT foi bem-sucedida e o recurso foi atualizado com sucesso|
| 404 | O recurso que a requisição PUT está tentando atualizar não pode ser encontrado|
| 500 | Ocorreu um erro interno do servidor ao processar a requisição PUT|

---

### Excluir tópico

`DELETE` /api/topicos/{id}

**Parâmetros de caminho**

id - código do topico a ser excluido

**Códigos de resposta**

| codigo | descrição |
|--------|-----------|
| 200 | este código é usado para indicar que a requisição DELETE foi bem-sucedida e o recurso foi excluído com sucesso. |
| 404  | este código é usado quando o recurso que a requisição DELETE está tentando excluir não pode ser encontrado| 
| 500  | este código é usado quando ocorre um erro interno do servidor ao processar a requisição DELETE|

---

### Cadastrar categoria

`POST` /api/categorias

| campo | tipo | obrigatório | descrição
|-------|------|-------------|-----------
| nome | string | sim | categoria da reunião |

**Exemplo de corpo de requisição**

```json
{
    "nome": "Planejamento",
}
```

**Exemplo de corpo de resposta**

```json
{
    "id": 1,
    "nome": "Planejamento"
}

```

**Códigos de resposta**




| codigo | descrição |
|--------|-----------|
| 201 | Indica que a requisição POST foi bem-sucedida e o servidor criou um novo recurso como resultado |
| 404 | Indica que o recurso solicitado na requisição POST não foi encontrado no servidor |
| 500 | Indica que ocorreu um erro interno no servidor ao processar a requisição POST |

---

    
### Listar categorias
`GET` /api/categorias

**Exemplo de Corpo de resposta**

```json
[
    {
    "id": 1,
    "nome":"Planejamento"
    },
    {
    "id": 2,
    "nome":"Qualidade"
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


### Detalhar categoria
`GET` /api/categorias/{id}
  
    
**Parâmetros de caminho**

id - código do categorias a ser detalhado

**Exemplo de Corpo de resposta** 

```json
{
    "id": 1,
    "nome":"Planejamento"
}

```

**Códigos de resposta**

| codigo | descrição |
|--------|-----------|
| 200 | A requisição GET foi bem-sucedida e o servidor retornou os dados solicitados no corpo da resposta|
| 404 | O recurso solicitado na requisição GET não pode ser encontrado|
| 500 | Ocorreu um erro interno do servidor ao processar a requisição GET|