REQUEST SERVICES
================

URL: http://localhost:8080/SpringRestService/rest/emp/
METHOD: GET
REQUEST: 1

URL: http://localhost:8080/SpringRestService/rest/emps
METHOD: GET
REQUEST: NOTHING

URL: http://localhost:8080/SpringRestService/rest/emp/create
METHOD: POST
REQUEST: (Raw)
{
"employeeId": 2,
"firstName": "Williams",
"lastName": "Manrique",
"phone": "999999999",
"address": "Chancay"
}

URL: http://localhost:8080/SpringRestService/rest/emp/update
METHOD: PUT
REQUEST: (Raw)
{
"employeeId": 2,
"firstName": "Williams",
"lastName": "Manrique",
"phone": "988888888",
"address": "Chancay"
}

URL: http://localhost:8080/SpringRestService/rest/emp/delete/
METHOD: DELETE
REQUEST: 1