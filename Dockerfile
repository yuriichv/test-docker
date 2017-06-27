FROM anapsix/alpine-java
RUN addgroup app -S && adduser -S -G app -h /home/app app
USER app
WORKDIR /home/app
COPY target/testDockerHello-1.0.jar /home/app/
EXPOSE 38080
#CMD java -jar testDocker-1.0.jar`
ENTRYPOINT ["/bin/bash", "-c", "java -jar testDockerHello-1.0.jar"]