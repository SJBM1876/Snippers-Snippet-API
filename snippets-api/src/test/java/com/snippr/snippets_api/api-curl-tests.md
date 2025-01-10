# Snippr API - cURL Test Commands

## 1. Create a New Snippet
```bash
curl -X POST http://localhost:8080/snippets \
     -H "Content-Type: application/json" \
     -d '{"id": 9, "language": "Python", "code": "def subtract(a, b): return a - b"}'

## 2. Get all Snippets
curl http://localhost:8080/snippets

## 3. Get a snippet by id
curl http://localhost:8080/snippets/3

## 4. Filter snippets by language
curl "http://localhost:8080/snippets?lang=Python"

## 5. Invalid Snippet id
curl http://localhost:8080/snippets/100

## 6. Invalid language filter
curl "http://localhost:8080/snippets?lang=Go"

## 7. Duplicate snippet creation
curl -X POST http://localhost:8080/snippets \
     -H "Content-Type: application/json" \
     -d '{"id": 1, "language": "Python", "code": "print(\"Duplicate Snippet Test\")"}'
