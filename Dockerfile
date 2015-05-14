FROM maven:3-jdk-8

EXPOSE 8080
# Serve using jetty
CMD ["mvn", "jetty:run"]