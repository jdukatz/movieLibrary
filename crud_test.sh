echo "create a new record"
curl -X POST http://localhost:8080/api/movies -d '{"title": "Pirates of the Caribbean", "year": 2003, "producer": "Jerry Bruckheimer"}' -H "Content-Type: application/json"
echo -e "\n"

echo "read the record we just inserted"
curl -X GET http://localhost:8080/api/movies/Pirates-of-the-Caribbean
echo -e "\n"

echo "read a record that was already included"
curl -X GET http://localhost:8080/api/movies/The-Shining
echo -e "\n"

echo "the year is wrong for The Shining (it was made in 1980) so we'll update the year"
curl -X PUT http://localhost:8080/api/movies/The-Shining -d '{"title": "The Shining", "year": 1980, "producer": "Stanley Kubrick"}' -H "Content-Type: application/json"
echo -e "\n"

echo "verify the update worked"
curl -X GET http://localhost:8080/api/movies/The-Shining
echo -e "\n"

echo "view all the movies from 1980"
curl -X GET http://localhost:8080/api/movies/year/1980
echo -e "\n"

echo "delete the shining from the database"
curl -X DELETE http://localhost:8080/api/movies/The-Shining
echo -e "\n"

echo "verify the delete worked"
curl -X GET http://localhost:8080/api/movies/The-Shining
echo -e "\n"