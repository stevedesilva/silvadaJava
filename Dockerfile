#FROM maven:3.8.1-openjdk-17-slim
#
#
#COPY src/main/java/lazyscheduler /usr/src/root/lazyscheduler
#COPY pom.xml /usr/src/lazyscheduler
#COPY ../pom.xml /usr/src/root/
#
#WORKDIR /usr/src/root/lazyscheduler
#
##RUN javac Work.java
#CMD ["mvn", "clean"]

FROM maven:alpine as build
ENV HOME=/usr/app
RUN mkdir -p $HOME
WORKDIR $HOME


ADD pom.xml $HOME
ADD katas/pom.xml $HOME/katas/pom.xml
RUN mvn -pl katas verify --fail-never
ADD katas $HOME/katas
#
#RUN mvn -pl katas install
#RUN mvn -pl katas package