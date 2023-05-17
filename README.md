# Hackathon_T-Systems_BackEnd


#Postman

# Project: HACKATHON

## End-point: LOG IN
### Method: POST
>```
>localhost:6752/api/auth/signin
>```
### Body (**raw**)

```json
{
        "username": "MariaUser",
        "password": "12345"
}
```

### Response: 200
```json
{
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJNYXJpYVVzZXIiLCJpYXQiOjE2ODQzMTc3OTMsImV4cCI6MTY4NDQwNDE5M30.tvyPkMiEtUIn_G1qSI85X5Vd2t7s0paKHAmxejWTa7JwFJvHT5_Zd4BRLgPVzeA2C7sMxbdZyq7ok27eJS3H8g",
    "type": "Bearer",
    "username": "MariaUser"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: REGISTER
### Method: POST
>```
>localhost:6752/api/auth/signup
>```
### Body (**raw**)

```json
    {
        "name": "Maria",
        "username": "MariaUser",
        "password": "12345"
    }
```

### Response: 200
```json
User created!
```


