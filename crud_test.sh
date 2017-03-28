#create a new record
curl -X POST http://localhost:8080/api/movies -d '{"title": "Pirates of the Caribbean", "year": 2003, "producer": "Jerry Bruckheimer"}' -H "Content-Type: application/json"

#read a record
curl -X GET http://localhost:8080/api/movies/The-Shining

#update the year for the shining
curl -X PUT http://localhost:8080/api/movies/The-Shining -d '{"title": "The Shining", "year": 1980, "producer": "Stanley Kubrick"}' -H "Content-Type: application/json"

#verify the update worked
curl -X POST http://localhost:8080/api/movies -d '{"title": "Pirates of the Caribbean", "year": 2003, "producer": "Jerry Bruckheimer"}' -H "Content-Type: application/json"

#delete the shining from the database
curl -X DELETE http://localhost:8080/api/movies/The-Shining

#verify the delete worked
curl -X POST http://localhost:8080/api/movies -d '{"title": "Pirates of the Caribbean", "year": 2003, "producer": "Jerry Bruckheimer"}' -H "Content-Type: application/json"