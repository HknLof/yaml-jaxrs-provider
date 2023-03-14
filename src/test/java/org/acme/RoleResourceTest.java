package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;

@QuarkusTest
public class RoleResourceTest {

    public static final Header ACCEPT_JSON = new Header("Accept", "application/json");
    public static final Header ACCEPT_YAML = new Header("Accept", "application/x+yaml");
    public static final Header CONTENT_JSON = new Header("Content-Type", "application/json");
    public static final Header CONTENT_YAML = new Header("Content-Type", "application/x+yaml");

    @Test
    public void testHelloEndpoint() throws IOException, URISyntaxException {
        String roleJson = getStringFromFile("basic-role.json");
        given()
                .when().header(CONTENT_JSON).header(ACCEPT_JSON).body(roleJson)
                .post("/roles")
                .then().statusCode(200);
    }

    @Test
    public void testYamlEndpoint() throws IOException, URISyntaxException {
        String roleYaml = getStringFromFile("basic-role.yaml");
        given()
                // Configuration needed to avoid RestAssured complaining about incompatibilities.
                .config(RestAssured.config().encoderConfig(encoderConfig().encodeContentTypeAs("application/x+yaml", ContentType.TEXT)))
                .when().header(CONTENT_YAML).header(ACCEPT_YAML).body(roleYaml)
                .post("/roles")
                .then().statusCode(200);
    }

    static String getStringFromFile(String testResourcePath) throws IOException, URISyntaxException {
        URL streamJsonURL = ClassLoader.getSystemClassLoader().getResource(testResourcePath);

        return Files.readString(Paths.get(streamJsonURL.toURI()));
    }
}