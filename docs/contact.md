# Contact Api Spec

## Create Contact
Endpoint : POST /api/contacts

Request Header :

- X-API-TOKEN : token(Mandatory)

Request Body :
```json
{
  "firstName" : "Muhammad Baharuddin",
  "lastName" : "Mansur",
  "email" : "bahr@example.com",
  "phone" : "089922993399"
}
```

Response Body (Success) :
```json
{
  "data": {
    "id" : "random-string",
    "firstName" : "Muhammad Baharuddin",
    "lastName" : "Mansur",
    "email" : "bahr@example.com",
    "phone" : "089922993399"
  }
}
```

Response Body (Failed) :
```json
{
  "errors" "Email format invalid, phone format invalid, ..."
}
```

## Get Contact
Endpoint : GET /api/contacts/{idContact}

Request Header :

- X-API-TOKEN : token(Mandatory)

Response Body (Success) :
```json
{
  "data": {
    "id" : "random-string",
    "firstName" : "Muhammad Baharuddin",
    "lastName" : "Mansur",
    "email" : "bahr@example.com",
    "phone" : "089922993399"
  }
}
```

Response Body (Failed, 404) :
```json
{
  "errors" "Contact is not found"
}
```

## Update Contact
Endpoint : PUT /api/contacts/{idContact}

Request Header :

- X-API-TOKEN : token(Mandatory)

Request Body :

```json
{
  "firstName" : "Muhammad Baharuddin",
  "lastName" : "Mansur",
  "email" : "bahr@example.com",
  "phone" : "089922993399"
}
```

Response Body (Success) :
```json
{
  "data": {
    "id" : "random-string",
    "firstName" : "Muhammad Baharuddin",
    "lastName" : "Mansur",
    "email" : "bahr@example.com",
    "phone" : "089922993399"
  }
}
```

Response Body (Failed, 400) :
```json
{
  "errors" "Email format invalid, phone format invalid, ..."
}
```

## Search Contact
Endpoint : GET /api/contacts

Request Header :

- X-API-TOKEN : token(Mandatory)

Query Param : 

- name : String, contact first name or last name, using like query, optional
- phone : String, contact phone, using like query, optional
- email : String, contact email, using like query, optional
- page : Integer, start from 0, default 0
- size : Integer, default 10

Response Body (Success) :
```json
{
  "data": [
    {
      "id" : "random-string",
      "firstName" : "Muhammad Baharuddin",
      "lastName" : "Mansur",
      "email" : "bahr@example.com",
      "phone" : "089922993399"
    },
    {
      "id" : "random-string",
      "firstName" : "Dean",
      "lastName" : "Firmansyah",
      "email" : "dean@example.com",
      "phone" : "089966779922"
    }
  ],
  "paging" : {
    "currentPage" : 0,
    "totalPage" : 10,
    "size" : 10
  }
}
```

Response Body (Failed, 401) :
```json
{
  "errors" "unauthorized"
}
```

## Remove Contact
Endpoint : DELETE /api/contacts/{idContact}

Request Header :

- X-API-TOKEN : token(Mandatory)

Response Body (Success) :
```json
{
  "data": "Remove contact success"
}
```

Response Body (Failed, 404) :
```json
{
  "errors" "Contact is not found"
}
```