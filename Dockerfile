FROM maven:3.8.1-openjdk-17-slim
#WORKDIR /usr/src/myapp
#COPY katas/pom.xml /usr/src/myapp
#COPY katas/src/main/java/lazyscheduler /usr/src/myapp
#RUN javac Work.java
#RUN mvn clean
CMD ["mvn", "clean","test"]
