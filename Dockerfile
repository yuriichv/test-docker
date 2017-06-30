FROM anapsix/alpine-java
RUN addgroup app -S && adduser -S -G app -h /home/app app
USER app
WORKDIR /home/app
#COPY target/testDockerHello-1.0.jar /home/app/
#при docker-builder артефает будет в tmp
COPY tmp/testDockerHello-1.0.jar /home/app/
#только для инфо, физически не выставляет Вероятно, полезно знать что слушает container
EXPOSE 38080
#PUBLISH 38080        #выставляет физически. Но снаружи будет выбран свободный начиная с 30000
#CMD java -jar testDocker-1.0.jar`
ENTRYPOINT ["/bin/bash", "-c", "java -jar testDockerHello-1.0.jar"]