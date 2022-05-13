clean-win:
	mvnw.cmd clean

clean-nix:
	./mvnw clean

run:
	./mvnw clean compile exec:java -Dexec.mainClass="com.mishinyura.books.Main"
