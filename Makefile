build:
	@javac -cp ".:libs/*" main.java

run: build
	@java -cp ".:libs/*" main
