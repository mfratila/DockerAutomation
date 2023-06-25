package org.example.docker;


import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.PullImageResultCallback;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientImpl;
import com.github.dockerjava.transport.DockerHttpClient;
import com.github.dockerjava.httpclient5.ApacheDockerHttpClient;

import java.io.IOException;
import java.time.Duration;

public class DockerComposeLauncher {
    public static void main(String[] args) throws InterruptedException, IOException {
        String composeFilePath = "/path/to/docker-compose.yml"; // Specify the path to your Docker Compose file

        DefaultDockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder().build();

        DockerHttpClient httpClient = new ApacheDockerHttpClient.Builder()
                .dockerHost(config.getDockerHost())
                .sslConfig(config.getSSLConfig())
                .maxConnections(100)
                .connectionTimeout(Duration.ofSeconds(30))
                .responseTimeout(Duration.ofSeconds(45))
                .build();

        DockerClient dockerClient = DockerClientImpl.getInstance(config, httpClient);

        dockerClient.pullImageCmd("docker/compose")
                .withTag("1.29.2") // Specify the desired version of Docker Compose
                .exec(new PullImageResultCallback())
                .awaitCompletion();

        dockerClient
                .createContainerCmd("docker/compose:1.29.2")
                .withCmd("-f", composeFilePath, "up", "-d")
                .exec();

        dockerClient.close();
    }
}