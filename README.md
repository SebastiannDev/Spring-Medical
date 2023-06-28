# API REST - Control Medic

## Overview
This System is an api rest that includes:
    - Http GET
    - Http POST
    - Http PUT
    - Htpp Delete

In architecture folder has:
    - Exeptions: managed for AOP when server trhow an especific exception.
    - Service: Take the responsabily to transform DTO to Entity model and response to the controller with the database.
    - Model: Used to interact with the DB MySQL with repository JPA.
    - Dto: Used to map entities and response the servlet with class Record.
    - Controller: The servlet endpoint that intercept the request Http.

## Rules to interact with the endpoint.

### When use *HTTP GET* in the endpoint "v1/medic" you retrive an json array empty or:

```json
    [{
        "id": 1,
            "nombre": "John Doe",
            "email": "john@mail.to",
            "identificacion": "111222333444",
            "telefono": "333222111",
            "activo": true,
            "direccionDto": {
            "calle": "11",
            "numero": "22-33",
            "pais": "Country",
            "ciudad": "City"
            },
            "especialidad": "CARDIOLOGIA"
    }]
```

### You can send an especific id in "v1/medic/{id}" to retrive an specific data.

### When you use *HTTP POST* may send body json:
```json
    {
        "nombre": "John Doe",
        "email": "john@mail.to",
        "identificacion": "111222333444",
        "telefono": "333222111",
        "activo": true,
        "direccionDto": {
        "calle": "11",
        "numero": "22-33",
        "pais": "Country",
        "ciudad": "City"
        },
        "especialidad": "CARDIOLOGIA"
    }
```

### *HTTP PUT* need send the especific id and body json to "v1/medic/{id}"
### *HTTP DELETE* need only send in path variable the id to delete "v1/medic/{id}"