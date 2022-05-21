FROM maven:3.8.1-openjdk-17-slim


#COPY katas/src/main/java/lazyscheduler /usr/src/myapp
#RUN javac Work.java
#RUN mvn clean
WORKDIR /usr/silvade/main
COPY ../pom.xml /usr/silvade/main
COPY katas/ /usr/silvade/main/katas

CMD ["mvn","test"]
