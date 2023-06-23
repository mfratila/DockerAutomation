package org.example.docker;

import org.testcontainers.containers.DockerComposeContainer;

import java.io.File;

public class DockerComposeLauncher {
    public static void main(String[] args) {
        String composeFilePath = "C:\\Dev Stuff\\Java\\Spring\\DockerProj\\app\\docker-compose.yml";

        DockerComposeContainer<?> composeContainer = new DockerComposeContainer<>(new File(composeFilePath))
                .withLocalCompose(true);

        // Start the Docker Compose containers
        composeContainer.start();

        // Run your tests or perform operations on the containers

        // Stop and remove the Docker Compose containers
       // composeContainer.stop();
    }
}