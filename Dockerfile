#FROM ubuntu:latest
#LABEL authors="Denis.Iskhakov"
#
#ENTRYPOINT ["top", "-b"]

FROM openjdk:22
RUN useradd -ms /bin/bash spring
USER spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

#FROM openjdk:22
#RUN useradd -ms /bin/bash spring
#USER spring
#ARG DEPENDENCY=target/dependency
#COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
#COPY ${DEPENDENCY}/META-INF /app/META-INF
#COPY ${DEPENDENCY}/BOOT-INF/classes /app
#ENTRYPOINT ["java","-cp","app:app/lib/*","com.waveaccess.tacocloud.TacoCloudApplication"]