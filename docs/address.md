# Address Api Spec

## Create Address
Endpoint : POST /api/contacts/{idContact}/addresses

Request Header :

- X-API-TOKEN : token(Mandatory)

Request Body :
```json
{
  "street" : "Jl. mangga",
  "city" : "Depok",
  "province" : "Jawa Barat",
  "country": "Indonesia",
  "postalCode" : "132331"
}
```

Response Body (Success) :
```json
{
  "data": {
    "id" : "random-string",
    "street" : "Jl. mangga",
    "city" : "Depok",
    "province" : "Jawa Barat",
    "country": "Indonesia",
    "postalCode" : "132331"
  }
}
```

Response Body (Failed) :
```json
{
  "errors" "Contact is not found"
}
```

## Get Address
Endpoint : GET /api/contacts/{idContact}/addresses/{idAddress}

Request Header :

- X-API-TOKEN : token(Mandatory)

Response Body (Success) :
```json
{
  "data": {
    "id" : "random-string",
    "street" : "Jl. mangga",
    "city" : "Depok",
    "province" : "Jawa Barat",
    "country": "Indonesia",
    "postalCode" : "132331"
  }
}
```

Response Body (Failed, 404) :
```json
{
  "errors" "Address is not found"
}
```

## Update Address
Endpoint : PUT /api/addresses/{idAddress}/addresses/{idAddress}

Request Header :

- X-API-TOKEN : token(Mandatory)

Request Body :
```json
{
  "street" : "Jl. mangga",
  "city" : "Depok",
  "province" : "Jawa Barat",
  "country": "Indonesia",
  "postalCode" : "132331"
}
```

Response Body (Success) :
```json
{
  "data": {
    "id" : "random-string",
    "street" : "Jl. mangga",
    "city" : "Depok",
    "province" : "Jawa Barat",
    "country": "Indonesia",
    "postalCode" : "132331"
  }
}
```

Response Body (Failed, 404) :
```json
{
  "errors" "Address is not found"
}
```

## Remove Address
Endpoint : DELETE /api/contacts/{idContact}/addresses/{idAddress}

Request Header :

- X-API-TOKEN : token(Mandatory)

Response Body (Success) :
```json
{
  "data": "Remove address success"
}
```

Response Body (Failed, 404) :
```json
{
  "errors" "Address is not found"
}
```

## List Address
Endpoint : GET /api/contacts/{idContact}/addresses

Request Header :

- X-API-TOKEN : token(Mandatory)

Response Body (Success) :
```json
{
  "data": [
    {
      "id" : "random-string",
      "street" : "Jl. mangga",
      "city" : "Depok",
      "province" : "Jawa Barat",
      "country": "Indonesia",
      "postalCode" : "132331"
    },
    {
      "id" : "random-string",
      "street" : "Jl. rambutan",
      "city" : "Bandung",
      "province" : "Jawa Barat",
      "country": "Indonesia",
      "postalCode" : "324551"
    }
  ]
}
```

Response Body (Failed, 404) :
```json
{
  "errors" "Contact is not found"
}
```