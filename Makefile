clean-win:
	mvnw.cmd clean

clean-nix:
	./mvnw clean

run:
	./mvnw clean compile exec:java -Dexec.mainClass="com.mishinyura.books.ApplicationRunner"

spring-run:
	mvnw clean spring-boot:run
