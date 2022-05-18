FROM maven:3.8.1-openjdk-17-slim
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
RUN javac Work.java
RUN mvn clean validate compile test
