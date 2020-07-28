# Find Computer

A REST API server for FindComputer website.

Server hosted in https://desolate-hamlet-69047.herokuapp.com/

Frontend hosted in https://alvinfebriando.github.io/find-computer

Username: john  
Password: john123

## Routes:

### GET /api/v1/users/

Get an user data

request

```bash
curl --location --request GET '{API_HOST}/api/v1/users/{USERNAME}'
--header 'Authorization: {TOKEN}'
```

response

```json
{
  "name": "{NAME}",
  "username": "{USERNAME}",
  "email": "{EMAIL}"
}
```

### POST /api/v1/login/

Login to api server

request

```bash
curl --location --request POST '{API_HOST}/login' \
--header 'Content-Type: application/json' \
--data-raw '{
    "username": "{USERNAME}",
    "password": "{PASSWORD}"
}'
```

response

```
JWT TOKEN returned at Authorization header
```

### POST /api/v1/users/

Add a new user

request

```bash
curl --location --request POST '{API_HOST}/api/v1/users' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "{NAME}",
    "username": "{USERNAME}",
    "password": "{PASSWORD}",
    "email": "{EMAIL}"
}'
```

response

```json
{
  "name": "{NAME}",
  "username": "{USERNAME}",
  "email": "{EMAIL}"
}
```

### PUT /api/v1/users/{USERNAME}

Update user

request

```bash
curl --location --request PUT '{API_HOST}/api/v1/users/{USERNAME}' \
--header 'Authorization: {TOKEN}' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "{NAME}",
    "username": "{USERNAME}",
    "email": "{EMAIL}",
    "password": "{PASSWORD}"
}'
```

response

```json
{
  "name": "{NAME}",
  "username": "{USERNAME}",
  "email": "{EMAIL}"
}
```

### POST /api/v1/items/

Add an item

request

```bash
curl --location --request POST '{API_HOST}/api/v1/items' \
--header 'Authorization: {TOKEN}' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "{NAME}",
    "description": "{DESCRIPTION}",
    "category": "{CATEGORY}",
    "price": {PRICE},
    "owner": {
        "username": "{USERNAME}"
    }
}'
```

response

```json
{
  "id": "{ITEM_ID}",
  "name": "{ITEM_NAME}",
  "description": "{DESCRIPTION}",
  "category": "{CATEGORY}",
  "price": { PRICE },
  "owner": {
    "name": "{USER_NAME}",
    "username": "{USERNAME}",
    "email": "{EMAIL}"
  }
}
```

### GET /api/v1/items/{ITEM_ID}

Get an item

request

```bash
curl --location --request GET '{API_HOST}/api/v1/items/{ITEM_ID}' \
--header 'Authorization: Bearer {TOKEN}'
```

response

```json
{
  "id": "{ITEM_ID}",
  "name": "{ITEM_NAME}",
  "description": "{DESCRIPTION}",
  "category": "{CATEGORY}",
  "price": { PRICE },
  "owner": {
    "name": "{USER_NAME}",
    "username": "{USERNAME}",
    "email": "{EMAIL}"
  }
}
```

### GET /api/v1/items

Get all items

request

```bash
curl --location --request GET '{API_HOST}/api/v1/items' \
--header 'Authorization: Bearer {TOKEN}'
```

response

```json
[
  {
    "id": "{ITEM_ID}",
    "name": "{ITEM_NAME}",
    "description": "{DESCRIPTION}",
    "category": "{CATEGORY}",
    "price": { PRICE },
    "owner": {
      "name": "{USER_NAME}",
      "username": "{USERNAME}",
      "email": "{EMAIL}"
    }
  }
]
```

### GET /api/v1/items?username={USERNAME}

Get all username's items

request

```bash
curl --location --request GET '{API_HOST}/api/v1/items?username={USERNAME}'
--header 'Authorization: Bearer {TOKEN}'
```

response

```json
[
  {
    "id": "{ITEM_ID}",
    "name": "{ITEM_NAME}",
    "description": "{DESCRIPTION}",
    "category": "{CATEGORY}",
    "price": { PRICE },
    "owner": {
      "name": "{USER_NAME}",
      "username": "{USERNAME}",
      "email": "{EMAIL}"
    }
  }
]
```

### GET /api/v1/items?category={CATEGORY}

Get all items in specific category

request

```bash
curl --location --request GET '{API_HOST}/api/v1/items?category={CATEGORY}'
--header 'Authorization: Bearer {TOKEN}'
```

response

```json
[
  {
    "id": "{ITEM_ID}",
    "name": "{ITEM_NAME}",
    "description": "{DESCRIPTION}",
    "category": "{CATEGORY}",
    "price": { PRICE },
    "owner": {
      "name": "{USER_NAME}",
      "username": "{USERNAME}",
      "email": "{EMAIL}"
    }
  }
]
```

### PUT /api/v1/items/{ITEM_ID}

Update item

request

```bash
curl --location --request PUT '{API_HOST}/api/v1/items/{ITEM_ID}' \
--header 'Authorization: Bearer {TOKEN}' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": "{ITEM_ID}",
    "name": "{UPDATED_ITEM_NAME}",
    "description": "{UPDATED_DESCRIPTION}",
    "category": "{UPDATED_CATEGORY}",
    "price": {UPDATED_PRICE},
    "owner": {
        "username": "{USERNAME}"
    }
}'
```

response

```json
{
  "id": "{ITEM_ID}",
  "name": "{UPDATED_ITEM_NAME}",
  "description": "{UPDATED_DESCRIPTION}",
  "category": "{UPDATED_CATEGORY}",
  "price": { UPDATED_PRICE },
  "owner": {
    "name": "{USER_NAME}",
    "username": "{USERNAME}",
    "email": "{EMAIL}"
  }
}
```

### DELETE /api/v1/items/{ITEM_ID}

Delete item

request

```bash
curl --location --request DELETE '{API_HOST}/api/v1/items/{ITEM_ID}'
--header 'Authorization: Bearer {TOKEN}'
```

response

```

```

### POST /api/v1/items/{ITEM_ID}/{USERNAME}

Buy item (change ownership of item to a new user)

request

```bash
curl --location --request POST '{API_HOST}/api/v1/items/{ITEM_ID}/{USERNAME}' \
--header 'Authorization: Bearer {TOKEN}'
```

response

```json
{
  "id": "{ITEM_ID}",
  "name": "{ITEM_NAME}",
  "description": "{DESCRIPTION}",
  "category": "{CATEGORY}",
  "price": { PRICE },
  "owner": {
    "name": "{NEW_USER_NAME}",
    "username": "{NEW_USERNAME}",
    "email": "{NEW_EMAIL}"
  }
}
```
