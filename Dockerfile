
FROM openjdk:17

MAINTAINER Ashok <ashok@oracle.com>

COPY target/sbapp.jar /usr/app/

WORKDIR /usr/app/

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "z_Rtbtrtbt-0.0.1-SNAPSHOT.jar"]