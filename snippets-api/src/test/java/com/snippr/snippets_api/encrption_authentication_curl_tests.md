// 1. Test Account Creation

curl -X POST http://localhost:8080/users \
-H "Content-Type: application/json" \
-d '{
"email": "user1@example.com",
"passwordHash": "password123"
}'

// 2. Test User Authentication

curl -G http://localhost:8080/users \
--data-urlencode "email=user1@example.com" \
--data-urlencode "password=password123"


