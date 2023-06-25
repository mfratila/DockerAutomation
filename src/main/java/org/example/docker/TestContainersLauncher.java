package org.example.docker;

import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.containers.wait.strategy.Wait;

import java.io.File;

public class TestContainersLauncher {

    public static void main(String[] args) {
        try (DockerComposeContainer<?> container = new DockerComposeContainer<>(new File("path/to/docker-compose.yml"))
                .withExposedService("mysqldb", 3306)
                .withTailChildContainers(true)
                .withLocalCompose(true)
                .waitingFor("mysqldb", Wait.forLogMessage("started", 1))
                .withExposedService("mywebapp", 6858, (Wait.forHttp("/").forStatusCode(200)))
                .withExposedService("selenium", 4444, Wait.forListeningPort())) {


            container.start();

            // Perform any actions or operations with the running container

        } // The container will be stopped and removed after the try block
    }
}
