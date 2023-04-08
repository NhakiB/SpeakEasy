# SpeakEasy

O SpeakEasy é um assistente de reuniões baseado em software que utiliza tecnologia de Processamento de Linguagem Natural (NLP) para transcrever e resumir automaticamente as informações discutidas nas reuniões. Ele é capaz de reconhecer vozes, identificar informações importantes e organizar as informações em uma ata de reunião clara e concisa, que pode ser facilmente editada e compartilhada com os participantes da reunião.

Nesta documentação, você encontrará informações detalhadas sobre as rotas disponíveis, os parâmetros necessários e as respostas retornadas pela API.

## Contribuidores

- Caio Henrique Martins
- Felipe Miguel Ortega
- Gabriela Vieira
- Isadora Antunes
- Maria Eduarda Herrera

## Endpoints
- Usuario
    - [Cadastrar]
    - [Listar]
    - [Detalhar]
    - [Alterar]
    - [Excluir]

- Reuniao
    - [Cadastrar]
    - [Listar]
    - [Detalhar]
    - [Alterar]
    - [Excluir]

### Cadastrar usuario

`POST` /api/usuarios

| campo | tipo | obrigatório | descrição
|-------|------|-------------|-----------
| userName | string | sim | userName do usuário |
| email | string | sim | email de acesso e comunicação do usuário |
| senha | string | sim | senha de acesso do usuário |
| pais | string | sim | país de origem do usuário |

**Exemplo de corpo de requisição**

```json
{
    "userName": "DevAll",
    "email": "empresarial@devall.com.br",
    "senha": "DevAll123",
    "pais": "Brasil"
}
```

**Exemplo de corpo de resposta**

```json
{
    "id": 1,
    "userName": "DevAll",
    "email": "empresarial@devall.com.br",
    "senha": "DevAll123",
    "pais": "Brasil"
}

```

**Códigos de resposta**




| codigo | descrição |
|--------|-----------|
| 201 | Indica que a requisição POST foi bem-sucedida e o servidor criou um novo recurso como resultado |
| 400 | Indica que a requisição POST foi malformada ou inválida |
| 401 | Indica que a requisição POST requer autenticação e o cliente não forneceu as credenciais corretas ou não possui autorização para acessar o recurso solicitado |
| 403 | Indica que o cliente não possui permissão para acessar o recurso solicitado, mesmo que tenha fornecido autenticação correta |
| 404 | Indica que o recurso solicitado na requisição POST não foi encontrado no servidor |
| 500 | Indica que ocorreu um erro interno no servidor ao processar a requisição POST |

---

    
### Listar usuarios
`GET` /api/usuarios

**Exemplo de Corpo de resposta**

```json
[
    {
    "id": 1,
    "userName": "DevAll",
    "email": "empresarial@devall.com.br",
    "senha": "DevAll123",
    "pais": "Brasil"
    },
    {
    "id": 2,
    "userName": "SpeakEasy",
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
| 400 | A requisição GET não pode ser processada devido a um erro no formato ou na sintaxe da requisição|
| 401 | A requisição GET requer autenticação, mas as credenciais fornecidas não são válidas ou não foram fornecidas|
| 403 | A requisição GET é proibida pelo servidor, geralmente porque o usuário não tem permissão para acessar o recurso solicitado|
| 404 | O recurso solicitado na requisição GET não pode ser encontrado|
| 500 | Ocorreu um erro interno do servidor ao processar a requisição GET|

---


### Detalhar usuario
`GET` /api/usuarios/{id}
  
    
    **Parâmetros de caminho**

id - código do usuario a ser detalhado

**Exemplo de Corpo de resposta** 

```json
{
    "id": 1,
    "userName": "DevAll",
    "email": "empresarial@devall.com.br",
    "senha": "DevAll123",
    "pais": "Brasil"
}

```

**Códigos de resposta**

| codigo | descrição |
|--------|-----------|
| 200 | A requisição GET foi bem-sucedida e o servidor retornou os dados solicitados no corpo da resposta|
| 400 | A requisição GET não pode ser processada devido a um erro no formato ou na sintaxe da requisição|
| 401 | A requisição GET requer autenticação, mas as credenciais fornecidas não são válidas ou não foram fornecidas|
| 403 | A requisição GET é proibida pelo servidor, geralmente porque o usuário não tem permissão para acessar o recurso solicitado|
| 404 | O recurso solicitado na requisição GET não pode ser encontrado|
| 500 | Ocorreu um erro interno do servidor ao processar a requisição GET|


---

### Alterar usuario

`PUT` /api/usuarios/{id}

        
    **Parâmetros de caminho**

id - código do usuario a ser alterado
    
**Exemplo de corpo de requisição**

```json
{
    "userName": "DevAll",
    "email": "empresarial@devall.com.br",
    "senha": "DevAll321",
    "pais": "Marrocos"
}

```

**Exemplo de corpo de resposta**

```json
{
    "id": 1,
    "userName": "DevAll",
    "email": "empresarial@devall.com.br",
    "senha": "DevAll321",
    "pais": "Marrocos"
}
```

**Códigos de resposta**

| codigo | descrição |
|--------|-----------|
| 200 | A requisição PUT foi bem-sucedida e o recurso foi atualizado com sucesso|
| 201 | A requisição PUT foi bem-sucedida e um novo recurso foi criado|
| 400 | A requisição PUT não pode ser processada devido a um erro no formato ou na sintaxe da requisição|
| 401 | A requisição PUT requer autenticação, mas as credenciais fornecidas não são válidas ou não foram fornecidas|
| 403 | A requisição PUT é proibida pelo servidor, geralmente porque o usuário não tem permissão para atualizar o recurso|
| 404 | O recurso que a requisição PUT está tentando atualizar não pode ser encontrado|
| 500 | Ocorreu um erro interno do servidor ao processar a requisição PUT|

---

### Excluir usuario

`DELETE` /api/usuarios/{id}

**Parâmetros de caminho**

id - código do usuario a ser excluido

**Códigos de resposta**

| codigo | descrição |
|--------|-----------|
| 200 | este código é usado para indicar que a requisição DELETE foi bem-sucedida e o recurso foi excluído com sucesso. |
| 202 | este código é usado quando a requisição DELETE foi aceita pelo servidor, mas a exclusão do recurso ainda não foi concluída. Isso pode acontecer quando a exclusão leva algum tempo para ser concluída|
| 400  | ste código é usado quando a requisição DELETE não pode ser processada devido a um erro no formato ou na sintaxe da requisição| 
| 401  | este código é usado quando a requisição DELETE requer autenticação, mas as credenciais fornecidas não são válidas ou não foram fornecidas|
| 404  | este código é usado quando o recurso que a requisição DELETE está tentando excluir não pode ser encontrado| 
| 500  | este código é usado quando ocorre um erro interno do servidor ao processar a requisição DELETE|

---

### Cadastrar reuniao

`POST` /api/reuniao

| campo | tipo | obrigatório | descrição
|-------|------|:-------------:|----------
| titulo | string | sim | título do video para identificação do próprio usuário|
| descricao | string | nao | descrição da reunião preenchida pelo próprio sistema |
| duracao | string | sim | tempo de duração da reunião |
| data | ZonedDateTime  | sim | data da reunião |
| audio | byte | sim | áudio da reunião que será usado para transcrição |


**Exemplo de corpo de requisição**

```json
{
    "titulo": "Reunião sobre X assunto",
    "descricao": "Reunião feita para tomada de decisão sobre X coisas, reunião entimada pelo diretos geral, etc...",
    "tamanho": "00:27:15",
    "data": "01/01/2023 10:12 -04:00",
    "audio": [0x52, 0x49, 0x46, 0x46, 0x24, 0x08, 0x00, 0x00, 0x41, 0x56, 0x49, 0x20, 0x4C, 0x49, 0x53, 0x54, 0x08, 0x00, 0x00, 0x00, 0x57, 0x41, 0x56, 0x45, 0x66, 0x6D, 0x74, 0x20, 0x10, 0x00, 0x00, 0x00, 0x01, 0x00, 0x02, 0x00, 0x44, 0xAC, 0x00, 0x00, 0x10, 0xB1, 0x02, 0x00, 0x04, 0x00, 0x10, 0x00, 0x64, 0x61, 0x74, 0x61, 0x00, 0x08, 0x00, 0x00, 0x00, 0x48, 0x65, 0x6C, 0x6C, 0x6F, 0x20, 0x57, 0x6F, 0x72, 0x6C, 0x64]
}
```

**Exemplo de corpo de resposta**

```json
{
    "id": 1,
    "titulo": "Reunião sobre X assunto",
    "descricao": "Reunião feita para tomada de decisão sobre X coisas, reunião entimada pelo diretos geral, etc...",
    "tamanho": "00:27:15",
    "data": "01/01/2023 10:12 -04:00",
    "audio": [0x52, 0x49, 0x46, 0x46, 0x24, 0x08, 0x00, 0x00, 0x41, 0x56, 0x49, 0x20, 0x4C, 0x49, 0x53, 0x54, 0x08, 0x00, 0x00, 0x00, 0x57, 0x41, 0x56, 0x45, 0x66, 0x6D, 0x74, 0x20, 0x10, 0x00, 0x00, 0x00, 0x01, 0x00, 0x02, 0x00, 0x44, 0xAC, 0x00, 0x00, 0x10, 0xB1, 0x02, 0x00, 0x04, 0x00, 0x10, 0x00, 0x64, 0x61, 0x74, 0x61, 0x00, 0x08, 0x00, 0x00, 0x00, 0x48, 0x65, 0x6C, 0x6C, 0x6F, 0x20, 0x57, 0x6F, 0x72, 0x6C, 0x64]
}

```

**Códigos de resposta**


| codigo | descrição |
|--------|-----------|
| 201 | Indica que a requisição POST foi bem-sucedida e o servidor criou um novo recurso como resultado |
| 400 | Indica que a requisição POST foi malformada ou inválida |
| 401 | Indica que a requisição POST requer autenticação e o cliente não forneceu as credenciais corretas ou não possui autorização para acessar o recurso solicitado |
| 403 | Indica que o cliente não possui permissão para acessar o recurso solicitado, mesmo que tenha fornecido autenticação correta |
| 404 | Indica que o recurso solicitado na requisição POST não foi encontrado no servidor |
| 500 | Indica que ocorreu um erro interno no servidor ao processar a requisição POST |

---

### Listar reuniões
`GET` /api/reuniões

**Exemplo de Corpo de resposta**

```json
[
    {
    "id": 1,
    "titulo": "Reunião sobre X assunto",
    "descricao": "Reunião feita para tomada de decisão sobre X coisas, reunião entimada pelo diretos geral, etc...",
    "tamanho": "00:27:15",
    "data": "01/01/2023 10:12 -04:00",
    "audio": [0x52, 0x49, 0x46, 0x46, 0x24, 0x08, 0x00, 0x00, 0x41, 0x56, 0x49, 0x20, 0x4C, 0x49, 0x53, 0x54, 0x08, 0x00, 0x00, 0x00, 0x57, 0x41, 0x56, 0x45, 0x66, 0x6D, 0x74, 0x20, 0x10, 0x00, 0x00, 0x00, 0x01, 0x00, 0x02, 0x00, 0x44, 0xAC, 0x00, 0x00, 0x10, 0xB1, 0x02, 0x00, 0x04, 0x00, 0x10, 0x00, 0x64, 0x61, 0x74, 0x61, 0x00, 0x08, 0x00, 0x00, 0x00, 0x48, 0x65, 0x6C, 0x6C, 0x6F, 0x20, 0x57, 0x6F, 0x72, 0x6C, 0x64]
    },
    {
    "id": 2,
    "titulo": "Reunião sobre Y assunto",
    "descricao": "Reunião feita para tomada de decisão sobre Y coisas, reunião entimada pelo gerente de marketing, etc...",
    "tamanho": "01:12:19",
    "data": "01/01/2023 10:12 -04:00",
    "audio": [0x52, 0x49, 0x46, 0x46, 0x24, 0x08, 0x00, 0x00, 0x41, 0x56, 0x49, 0x20, 0x4C, 0x49, 0x53, 0x54, 0x08, 0x00, 0x00, 0x00, 0x57, 0x41, 0x56, 0x45, 0x66, 0x6D, 0x74, 0x20, 0x10, 0x00, 0x00, 0x00, 0x01, 0x00, 0x02, 0x00, 0x44, 0xAC, 0x00, 0x00, 0x10, 0xB1, 0x02, 0x00, 0x04, 0x00, 0x10, 0x00, 0x64, 0x61, 0x74, 0x61, 0x00, 0x08, 0x00, 0x00, 0x00, 0x48, 0x65, 0x6C, 0x6C, 0x6F, 0x20, 0x57, 0x6F, 0x72, 0x6C, 0x64]
    }
]

```

**Códigos de resposta**

| codigo | descrição |
|--------|-----------|
| 200 | A requisição GET foi bem-sucedida e o servidor retornou os dados solicitados no corpo da resposta|
| 400 | A requisição GET não pode ser processada devido a um erro no formato ou na sintaxe da requisição|
| 401 | A requisição GET requer autenticação, mas as credenciais fornecidas não são válidas ou não foram fornecidas|
| 403 | A requisição GET é proibida pelo servidor, geralmente porque o usuário não tem permissão para acessar o recurso solicitado|
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
    "tamanho": "00:27:15",
    "data": "01/01/2023 10:12 -04:00",
    "audio": [0x52, 0x49, 0x46, 0x46, 0x24, 0x08, 0x00, 0x00, 0x41, 0x56, 0x49, 0x20, 0x4C, 0x49, 0x53, 0x54, 0x08, 0x00, 0x00, 0x00, 0x57, 0x41, 0x56, 0x45, 0x66, 0x6D, 0x74, 0x20, 0x10, 0x00, 0x00, 0x00, 0x01, 0x00, 0x02, 0x00, 0x44, 0xAC, 0x00, 0x00, 0x10, 0xB1, 0x02, 0x00, 0x04, 0x00, 0x10, 0x00, 0x64, 0x61, 0x74, 0x61, 0x00, 0x08, 0x00, 0x00, 0x00, 0x48, 0x65, 0x6C, 0x6C, 0x6F, 0x20, 0x57, 0x6F, 0x72, 0x6C, 0x64]
    
    }

```

**Códigos de resposta**

| codigo | descrição |
|--------|-----------|
| 200 | A requisição GET foi bem-sucedida e o servidor retornou os dados solicitados no corpo da resposta|
| 400 | A requisição GET não pode ser processada devido a um erro no formato ou na sintaxe da requisição|
| 401 | A requisição GET requer autenticação, mas as credenciais fornecidas não são válidas ou não foram fornecidas|
| 403 | A requisição GET é proibida pelo servidor, geralmente porque o usuário não tem permissão para acessar o recurso solicitado|
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
    "tamanho": "00:27:15",
    "data": "01/01/2023 10:12 -04:00",
    "audio": [0x52, 0x49, 0x46, 0x46, 0x24, 0x08, 0x00, 0x00, 0x41, 0x56, 0x49, 0x20, 0x4C, 0x49, 0x53, 0x54, 0x08, 0x00, 0x00, 0x00, 0x57, 0x41, 0x56, 0x45, 0x66, 0x6D, 0x74, 0x20, 0x10, 0x00, 0x00, 0x00, 0x01, 0x00, 0x02, 0x00, 0x44, 0xAC, 0x00, 0x00, 0x10, 0xB1, 0x02, 0x00, 0x04, 0x00, 0x10, 0x00, 0x64, 0x61, 0x74, 0x61, 0x00, 0x08, 0x00, 0x00, 0x00, 0x48, 0x65, 0x6C, 0x6C, 0x6F, 0x20, 0x57, 0x6F, 0x72, 0x6C, 0x64]
    }

```

**Exemplo de corpo de resposta**

```json
{
    "id": 1,
    "titulo": "Reunião sobre Y assunto",
    "descricao": "Reunião feita para tomada de decisão sobre Y coisas, reunião entimada pelo gerente de marketing, etc...",
    "tamanho": "01:12:19",
    "data": "2023-04-09 15:30 -02:00",
    "audio": [0x52, 0x49, 0x46, 0x46, 0x24, 0x08, 0x00, 0x00, 0x41, 0x56, 0x49, 0x20, 0x4C, 0x49, 0x53, 0x54, 0x08, 0x00, 0x00, 0x00, 0x57, 0x41, 0x56, 0x45, 0x66, 0x6D, 0x74, 0x20, 0x10, 0x00, 0x00, 0x00, 0x01, 0x00, 0x02, 0x00, 0x44, 0xAC, 0x00, 0x00, 0x10, 0xB1, 0x02, 0x00, 0x04, 0x00, 0x10, 0x00, 0x64, 0x61, 0x74, 0x61, 0x00, 0x08, 0x00, 0x00, 0x00, 0x48, 0x65, 0x6C, 0x6C, 0x6F, 0x20, 0x57, 0x6F, 0x72, 0x6C, 0x64],
    }
```

**Códigos de resposta**

| codigo | descrição |
|--------|-----------|
| 200 | A requisição PUT foi bem-sucedida e o recurso foi atualizado com sucesso|
| 201 | A requisição PUT foi bem-sucedida e um novo recurso foi criado|
| 400 | A requisição PUT não pode ser processada devido a um erro no formato ou na sintaxe da requisição|
| 401 | A requisição PUT requer autenticação, mas as credenciais fornecidas não são válidas ou não foram fornecidas|
| 403 | A requisição PUT é proibida pelo servidor, geralmente porque o usuário não tem permissão para atualizar o recurso|
| 404 | O recurso que a requisição PUT está tentando atualizar não pode ser encontrado|
| 500 | Ocorreu um erro interno do servidor ao processar a requisição PUT|

---

### Excluir reuniões

`DELETE` /api/reunioes/{id}

**Parâmetros de caminho**

id - código da reunião a ser excluida

**Códigos de resposta**

| codigo | descrição |
|--------|-----------|
| 200 | este código é usado para indicar que a requisição DELETE foi bem-sucedida e o recurso foi excluído com sucesso. |
| 202 | este código é usado quando a requisição DELETE foi aceita pelo servidor, mas a exclusão do recurso ainda não foi concluída. Isso pode acontecer quando a exclusão leva algum tempo para ser concluída|
| 400  | ste código é usado quando a requisição DELETE não pode ser processada devido a um erro no formato ou na sintaxe da requisição| 
| 401  | este código é usado quando a requisição DELETE requer autenticação, mas as credenciais fornecidas não são válidas ou não foram fornecidas|
| 404  | este código é usado quando o recurso que a requisição DELETE está tentando excluir não pode ser encontrado| 
| 500  | este código é usado quando ocorre um erro interno do servidor ao processar a requisição DELETE|


---


### Cadastrar telefone

`POST` /api/telefone

| campo | tipo | obrigatório | descrição
|-------|------|:-------------:|----------
| numeroDDD | int | sim | número do DDD do telefone do usuário|
| numeroDDI | int | sim | número do DDD do telefone do usuário |
| nr_telefone | int | sim | número do telefone do usuário |

**Exemplo de corpo de requisição**

```json

{
    "numeroDDD": 55,
    "numeroDDI": 1,
    "nr_telefone": 987654321
}

```

**Exemplo de corpo de resposta**

```json
{
    "id": 1,
    "numeroDDD": 55,
    "numeroDDI": 1,
    "nr_telefone": 987654321
}

```

**Códigos de resposta**


| codigo | descrição |
|--------|-----------|
| 201 | Indica que a requisição POST foi bem-sucedida e o servidor criou um novo recurso como resultado |
| 400 | Indica que a requisição POST foi malformada ou inválida |
| 401 | Indica que a requisição POST requer autenticação e o cliente não forneceu as credenciais corretas ou não possui autorização para acessar o recurso solicitado |
| 403 | Indica que o cliente não possui permissão para acessar o recurso solicitado, mesmo que tenha fornecido autenticação correta |
| 404 | Indica que o recurso solicitado na requisição POST não foi encontrado no servidor |
| 500 | Indica que ocorreu um erro interno no servidor ao processar a requisição POST |

---

### Listar telefones
`GET` /api/telefones

**Exemplo de Corpo de resposta**

```json
[
    {
        "id": 1,
        "numeroDDD": 11,
        "numeroDDI": 55,
        "nr_telefone": 987654321
    },
    {
        "id": 2,
        "numeroDDD": 21,
        "numeroDDI": 1,
        "nr_telefone": 123456789
    }
]

```

**Códigos de resposta**

| codigo | descrição |
|--------|-----------|
| 200 | A requisição GET foi bem-sucedida e o servidor retornou os dados solicitados no corpo da resposta|
| 400 | A requisição GET não pode ser processada devido a um erro no formato ou na sintaxe da requisição|
| 401 | A requisição GET requer autenticação, mas as credenciais fornecidas não são válidas ou não foram fornecidas|
| 403 | A requisição GET é proibida pelo servidor, geralmente porque o usuário não tem permissão para acessar o recurso solicitado|
| 404 | O recurso solicitado na requisição GET não pode ser encontrado|
| 500 | Ocorreu um erro interno do servidor ao processar a requisição GET|

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
        "nr_telefone": 987654321
    }

```

**Códigos de resposta**

| codigo | descrição |
|--------|-----------|
| 200 | A requisição GET foi bem-sucedida e o servidor retornou os dados solicitados no corpo da resposta|
| 400 | A requisição GET não pode ser processada devido a um erro no formato ou na sintaxe da requisição|
| 401 | A requisição GET requer autenticação, mas as credenciais fornecidas não são válidas ou não foram fornecidas|
| 403 | A requisição GET é proibida pelo servidor, geralmente porque o usuário não tem permissão para acessar o recurso solicitado|
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
    "nr_telefone": 987654321
}
}

```

**Exemplo de corpo de resposta**

```json
{
    "id": 1,
    "numeroDDD": 55,
    "numeroDDI": 212,
    "nr_telefone": 987654321
}
```

**Códigos de resposta**

| codigo | descrição |
|--------|-----------|
| 200 | A requisição PUT foi bem-sucedida e o recurso foi atualizado com sucesso|
| 201 | A requisição PUT foi bem-sucedida e um novo recurso foi criado|
| 400 | A requisição PUT não pode ser processada devido a um erro no formato ou na sintaxe da requisição|
| 401 | A requisição PUT requer autenticação, mas as credenciais fornecidas não são válidas ou não foram fornecidas|
| 403 | A requisição PUT é proibida pelo servidor, geralmente porque o usuário não tem permissão para atualizar o recurso|
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
| 202 | este código é usado quando a requisição DELETE foi aceita pelo servidor, mas a exclusão do recurso ainda não foi concluída. Isso pode acontecer quando a exclusão leva algum tempo para ser concluída|
| 400  | ste código é usado quando a requisição DELETE não pode ser processada devido a um erro no formato ou na sintaxe da requisição| 
| 401  | este código é usado quando a requisição DELETE requer autenticação, mas as credenciais fornecidas não são válidas ou não foram fornecidas|
| 404  | este código é usado quando o recurso que a requisição DELETE está tentando excluir não pode ser encontrado| 
| 500  | este código é usado quando ocorre um erro interno do servidor ao processar a requisição DELETE|

---

