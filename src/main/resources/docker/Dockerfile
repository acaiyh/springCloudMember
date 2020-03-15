FROM java:8
VOLUME /usr/tmp
ADD springcloudmember-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]