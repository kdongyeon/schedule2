

## API 명세서

### Schedule
| **Method** | **Endpoint**      | **Description** | **Parameters**                                             | **Request Body**                                               | **Response**                                                                                                      | **Status Code** |
|------------|-------------------|-----------------|------------------------------------------------------------|----------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------|-----------------|
| `POST`     | `/schedules`      | 일정 생성           | 없음                                                         | `{ "title": string, "content": string, "writerUser": string }` | `{ "id": long, "title": string, "content": string, "createdAt": string, "updatedAt": string }` | `200 OK`        |
| `GET`      | `/schedules/{id}` | 일정 단건 조회        | Path: <br> - `id`                                          | 없음                                                             | `{ "id": long, "title": string, "content": string,  "createdAt": string, "updatedAt": string }` | `200 OK`        |
| `GET`      | `/schedules/{id}` | 일정 단건 조회        | Path: <br> - `id`                                          | 없음                                                             | `{ "id": long, "title": string, "content": string,  "createdAt": string, "updatedAt": string }` | `200 OK`        |
`PUT`      | `/schedules/{id}` | 일정 수정           | Path: <br> - `id`                                          | `{ "title": string, "password": string }`                      | `{ "id": long, "title": string, "content": string, "createdAt": string, "updatedAt": string }` | `200 OK`        |
| `DELETE`   | `/schedules/{id}` | 일정 삭제           | Path: <br> - `id` | 없음                                                             | 없음                                                                                                                | `200 OK`        |

### User
 **Method** | **Endpoint**      | **Description** | **Parameters**                                              | **Request Body**                                              | **Response**                                                                                                         | **Status Code** |
|------------|-------------------|-----------------|-------------------------------------------------------------|---------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------|-----------------|
| `POST`     | `/users`          | 유저 생성           | 없음                                                          | `{ "username": string, "password": string, "email": string }` | `{ "id": long, "username": string, "content": string, "createdAt": string, "updatedAt": string }` | `200 OK`        |
| `GET`      | `/users/{id}` | 유저 단건 조회        | Path: <br> - `id`                                           | 없음                                                            | `{ "id": long, "username": string, "content": string,"createdAt": string, "updatedAt": string }`   | `200 OK`        |
| `GET`      | `/users/{id}` | 유저 단건 조회        | Path: <br> - `id`                                           | 없음                                                            | `{ "id": long, "username": string, "content": string,"createdAt": string, "updatedAt": string }`   | `200 OK`        |
`PUT`      | `/users/{id}` | 유저 수정           | Path: <br> - `id`                                           | `{ "username": string, "password": string }`                  | `{ "id": long, "username": string, "content": string,"createdAt": string, "updatedAt": string }`   | `200 OK`        |
| `DELETE`   | `/users/{id}` | 유저 삭제           | Path: <br> - `id`   | 없음                                                            | 없음                                                                                                                   | `200 OK`        |

### Schedule
| **Method** | **Endpoint**      | **Description** | **Parameters**                                             | **Request Body**                                               | **Response**                                                                                                      | **Status Code** |
|------------|-------------------|-----------------|------------------------------------------------------------|----------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------|-----------------|
| `POST`     | `/schedules`      | 일정 생성           | 없음                                                         | `{ "title": string, "content": string, "writerUser": string }` | `{ "id": long, "title": string, "content": string, "createdAt": string, "updatedAt": string }` | `200 OK`        |
| `GET`      | `/schedules/{id}` | 일정 단건 조회        | Path: <br> - `id`                                          | 없음                                                             | `{ "id": long, "title": string, "content": string,  "createdAt": string, "updatedAt": string }` | `200 OK`        |
| `GET`      | `/schedules/{id}` | 일정 단건 조회        | Path: <br> - `id`                                          | 없음                                                             | `{ "id": long, "title": string, "content": string,  "createdAt": string, "updatedAt": string }` | `200 OK`        |
`PUT`      | `/schedules/{id}` | 일정 수정           | Path: <br> - `id`                                          | `{ "title": string, "password": string }`                      | `{ "id": long, "title": string, "content": string, "createdAt": string, "updatedAt": string }` | `200 OK`        |
| `DELETE`   | `/schedules/{id}` | 일정 삭제           | Path: <br> - `id` | 없음                                                             | 없음                                                                                                                | `200 OK`        |


### Login
| **Method** | **Endpoint**      | **Description** | **Parameters**                                             | **Request Body**                                             | **Response**                                                                                 | **Status Code** |
|------------|-------------------|-----------------|------------------------------------------------------------|--------------------------------------------------------------|----------------------------------------------------------------------------------------------|-----------------|
| `POST`     | `/login`          | 로그인             | 없음                                                         | `{ "email": string, "content": string, "password": string }` | `{ "id": long,"username": string }`                  | `200 OK`        |
