![Logo Universidade Estadual de Ponta Grossa](https://github.com/user-attachments/assets/093a1753-5555-4ef6-92a4-0d6ace536b42)

API GameHub desenvolvido para a disciplina de Desenvolvimento Web 

## Alunos

* Bernardo de Macedo Steffens
* Luis Gustavo Vieira Carneiro
* Vinicius Denega D'Alves

##  Requisições da API
|  **Método** |  **Endpoint**   |  **Descrição**                                                                                                    |  **Códigos HTTP**                                                                       |
| :---------: | :-------------- | :---------------------------------------------------------------------------------------------------------------- | :-------------------------------------------------------------------------------------- |
|    **GET**  | `/games/`       | Lista todos os jogos, pode ser usados vários parâmetros de filtro ou ordenação (`?genero=, ?plataforma=, ?nome=`).| `200 OK`, `204 NO CONTENT`, `500 INTERNAL SERVER ERROR`                                 |
|    **POST** | `/games/`       | Cria um novo jogo com validação de dados.                                                                         | `201 CREATED`, `400 BAD REQUEST`, `500 INTERNAL SERVER ERROR`                           |
|    **PUT**  | `/{id}`         | Atualiza os dados de um jogo existente.                                                                           | `200 OK`, `400 BAD REQUEST`, `404 NOT FOUND`, `500 INTERNAL SERVER ERROR`               |
|   **DELETE**| `/{id}`         | Remove um jogo pelo ID.                                                                                           | `204 NO CONTENT`, `500 INTERNAL SERVER ERROR`                                           |
