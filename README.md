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
    - [Detalhar]
    - [Alterar]
    - [Excluir]

- Audio
    - [Cadastrar]
    - [Detalhar]
    - [Alterar]
    - [Excluir]

###Cadastrar usuario

`POST` /api/usuarios

| campo | tipo | obrigatório | descrição
|-------|------|-------------|-----------
| userName | string | sim | userName do usuário |
| email | string | sim | email de acesso e comunicação do usuário |
| senha | string | sim | senha de acesso do usuário |
| celular | string | sim | celular de contato do usuário |


**Exemplo de corpo de requisição**

```json
{
    "userName": "DevAll",
    "email": "empresarial@devall.com.br",
    "senha": "DevAll123",
    "celular": "+55 (99)99999-99990"
}
```

**Exemplo de corpo de resposta**

```json
{
    "id": 1,
    "userName": "DevAll",
    "email": "empresarial@devall.com.br",
    "senha": "DevAll123",
    "celular": "+55 (99)99999-99990"
}

```

**Códigos de resposta**


**Códigos de resposta**

| codigo | descricao |
|--------|-----------|
| 200 | A requisição GET foi bem-sucedida e o servidor retornou os dados solicitados no corpo da resposta|
| 400 | A requisição GET não pode ser processada devido a um erro no formato ou na sintaxe da requisição|
| 401 | A requisição GET requer autenticação, mas as credenciais fornecidas não são válidas ou não foram fornecidas|
| 403 | A requisição GET é proibida pelo servidor, geralmente porque o usuário não tem permissão para acessar o recurso solicitado|
| 404 | O recurso solicitado na requisição GET não pode ser encontrado|
| 500 | Ocorreu um erro interno do servidor ao processar a requisição GET|

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
    "celular": "+55 (99)99999-9999"
    },
    {
    "id": 2,
    "userName": "SpeakEasy",
    "email": "empresarial@SpeakEasy.com.br",
    "senha": "SpeakEasy123",
    "celular": "+55 (99)99999-9990"
    }
]

```

**Códigos de resposta**

| codigo | descricao |
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
    "celular": "+55 (99)99999-9999"
}

```

**Códigos de resposta**

| codigo | descricao |
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
    "celular": "+55 (88)88888-8888"
}

```

**Exemplo de corpo de resposta**

```json
{
    "id": 1,
    "userName": "DevAll",
    "email": "empresarial@devall.com.br",
    "senha": "DevAll321",
    "celular": "+55 (88)88888-8888"
}
```

**Códigos de resposta**

| codigo | descricao |
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

| codigo | descricao |
|--------|-----------|
| 200 | este código é usado para indicar que a requisição DELETE foi bem-sucedida e o recurso foi excluído com sucesso. |
| 202 | este código é usado quando a requisição DELETE foi aceita pelo servidor, mas a exclusão do recurso ainda não foi concluída. Isso pode acontecer quando a exclusão leva algum tempo para ser concluída|
| 400  | ste código é usado quando a requisição DELETE não pode ser processada devido a um erro no formato ou na sintaxe da requisição| 
| 401  | este código é usado quando a requisição DELETE requer autenticação, mas as credenciais fornecidas não são válidas ou não foram fornecidas|
| 404  | este código é usado quando o recurso que a requisição DELETE está tentando excluir não pode ser encontrado| 
| 500  | este código é usado quando ocorre um erro interno do servidor ao processar a requisição DELETE|

---

### Cadastrar audio

`POST` /api/audio

| campo | tipo | obrigatório | descricao
|-------|------|:-------------:|----------
| titulo | string | sim | título do video para identificação do próprio usuário
| audio | byte | sim | áudio que será usado para transcrição |
| tamanho | string | sim | tamanho do áudio depois de tratado e convertido pelo próprio sistema |
| data | date | sim | data em que o arquívo foi enviado |
| descricao | string | nao | o usuário pode inserir um descrição do áudio |

**Exemplo de corpo de requisição**

```json
{
    "titulo": "Reunião sobre X assunto",
    "audio": [0x52, 0x49, 0x46, 0x46, 0x24, 0x08, 0x00, 0x00, 0x41, 0x56, 0x49, 0x20, 0x4C, 0x49, 0x53, 0x54, 0x08, 0x00, 0x00, 0x00, 0x57, 0x41, 0x56, 0x45, 0x66, 0x6D, 0x74, 0x20, 0x10, 0x00, 0x00, 0x00, 0x01, 0x00, 0x02, 0x00, 0x44, 0xAC, 0x00, 0x00, 0x10, 0xB1, 0x02, 0x00, 0x04, 0x00, 0x10, 0x00, 0x64, 0x61, 0x74, 0x61, 0x00, 0x08, 0x00, 0x00, 0x00, 0x48, 0x65, 0x6C, 0x6C, 0x6F, 0x20, 0x57, 0x6F, 0x72, 0x6C, 0x64],
    "tamanho": "DevAll123",
    "data": "2022-04-07 09:30"
}
```

**Exemplo de corpo de resposta**

```json
{
    "id": 1,
    "titulo": "Reunião sobre X assunto",
    "audio": [0x52, 0x49, 0x46, 0x46, 0x24, 0x08, 0x00, 0x00, 0x41, 0x56, 0x49, 0x20, 0x4C, 0x49, 0x53, 0x54, 0x08, 0x00, 0x00, 0x00, 0x57, 0x41, 0x56, 0x45, 0x66, 0x6D, 0x74, 0x20, 0x10, 0x00, 0x00, 0x00, 0x01, 0x00, 0x02, 0x00, 0x44, 0xAC, 0x00, 0x00, 0x10, 0xB1, 0x02, 0x00, 0x04, 0x00, 0x10, 0x00, 0x64, 0x61, 0x74, 0x61, 0x00, 0x08, 0x00, 0x00, 0x00, 0x48, 0x65, 0x6C, 0x6C, 0x6F, 0x20, 0x57, 0x6F, 0x72, 0x6C, 0x64],
    "tamanho": "DevAll123",
    "data": "2022-04-07 09:30"
}

```

**Códigos de resposta**


**Códigos de resposta**

| codigo | descricao |
|--------|-----------|
| 200 | A requisição GET foi bem-sucedida e o servidor retornou os dados solicitados no corpo da resposta|
| 400 | A requisição GET não pode ser processada devido a um erro no formato ou na sintaxe da requisição|
| 401 | A requisição GET requer autenticação, mas as credenciais fornecidas não são válidas ou não foram fornecidas|
| 403 | A requisição GET é proibida pelo servidor, geralmente porque o usuário não tem permissão para acessar o recurso solicitado|
| 404 | O recurso solicitado na requisição GET não pode ser encontrado|
| 500 | Ocorreu um erro interno do servidor ao processar a requisição GET|

---
