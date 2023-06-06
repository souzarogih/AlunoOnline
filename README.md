<p align="center">API REST com CRUD para serviço Aluno Online</p>

## Aplicação API para gerenciamento escolar de matriculas, alunos e professores  

- [x] API REST
- [x] SpringBoot
- [x] PostgreSQL
- [x] MongoDB

### Endpoints

#### Histórico de Estudantes
Endpoint para gerenciar o histórico de atividades processadas pela aplicação para o aluno.

| Método HTTP |Endpoint| Descrição                                                        |
|-------------|--|------------------------------------------------------------------|
|             |`/student-history`| Endpoint principal para consulta de histórico dos alunos.        |
| POST        |`/student-history`| Endpoint para criar um registro no histórico de um estudante. |
| GET         |`/student-history/647c8939109db5641a1ac725`| Endpoint para consultar um registro do histórico pelo id.        |
| GET         |`/student-history/student/3`| Endpoint para listar o histórico de um estudante pelo id.        |

#### Estudantes
Endpoint para gerenciar as atividades processadas para um aluno.

| Método HTTP |Endpoint| Descrição                                                        |
|-------------|--|------------------------------------------------------------------|
|             |`/student`| Endpoint principal para gerenciamento dos estudantes.            |
| POST        |`/student`| Endpoint principal para gerenciamento dos estudantes.            |
| GET         |`/student/list-all`| Endpoint principal para gerenciamento dos estudantes.            |
| GET         |`/student/3`| Endpoint principal para gerenciamento dos estudantes.            |
| GET         |`/student/name/Higor Souza`| Endpoint principal para gerenciamento dos estudantes.            |
| GET         |`/student/email/higor.souza@hotmail.com`| Endpoint principal para gerenciamento dos estudantes.            |

#### Professores
Endpoint para gerenciar as atividades processadas para um professor.

| Método HTTP |Endpoint| Descrição                                                        |
|-------------|--|------------------------------------------------------------------|
| GET         |`/teacher`| Endpoint principal para gerenciamento dos professores.           |


