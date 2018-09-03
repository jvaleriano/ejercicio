FROM openjdk:8-jre
MAINTAINER David Flemström <dflemstr@spotify.com>

ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/ipContextInfo/ipContextInfo.jar"]

# Make port 8080 available to the world outside this container
EXPOSE 8080

ARG JAR_FILE
ADD target/${JAR_FILE} /usr/share/ipContextInfo/ipContextInfo.jar