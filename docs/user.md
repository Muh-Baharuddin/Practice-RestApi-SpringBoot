# User Api Spec

## Register User
Endpoint : POST /api/users

Request Body :

```json
{
  "username": "aldi",
  "password": "123123",
  "name": "Baharuddin"
}
```

Response Body (Success) :
```json
{
  "data": "Create user success"
}
```

Response Body (Failed, 400) :
```json
{
  "errors" "username must not blank, ???"
}
```

## Login User
Endpoint : POST /api/auth/login

Request Body :

```json
{
  "username": "aldi",
  "password": "123123"
}
```

Response Body (Success) :
```json
{
  "data": {
    "token" : "TOKEN",
    "expiredAt" : 123142342341243 // milliseconds
  }
}
```

Response Body (Failed, 401) :
```json
{
  "errors" "username or password wrong"
}
```

## Get User
Endpoint : GET /api/users/current

Request Header :

- X-API-TOKEN : token(Mandatory)

Response Body (Success) :
```json
{
  "data": {
    "username" : "aldi",
    "name" : "Baharuddin"
  }
}
```

Response Body (Failed, 401) :
```json
{
  "errors" "unauthorized"
}
```

## Update User
Endpoint : PATCH /api/users/current

Request Header :

- X-API-TOKEN : token(Mandatory)

Request Body :

```json
{
  "name": "new name", // put if only want to update name
  "password": "new password" // put if only want to update password
}
```

Response Body (Success) :
```json
{
  "data": {
    "username" : "username",
    "name" : "new name"
  }
}
```

Response Body (Failed, 401) :
```json
{
  "errors" "unauthorized"
}
```

## Logout User
Endpoint : DELETE /api/auth/logout

Request Header :

- X-API-TOKEN : token(Mandatory)

Response Body (Success) :
```json
{
  "data": "Logout success"
}
```