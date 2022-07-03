[![Build](https://github.com/YuraMishin/books/actions/workflows/build.yaml/badge.svg?branch=main)](https://github.com/YuraMishin/books/actions/workflows/build.yaml)
# Books
## To launch app:

- git clone https://github.com/YuraMishin/books.git
- cd books
- chmod +x ./mvnw
- ./mvnw clean package -DskipTests
- docker-compose up
- Go to http://your_IP_host:8080/