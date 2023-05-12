package AcrossAPI;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetDevices extends AcrossToken {

    @Test
    public void getTest() {

        given()
                .header("Authorization","Bearer "+ jwtToken )
                .contentType(ContentType.JSON)
                .when()
                .get("stations/24/devices?grid_view=true&language_id=en")
                .then()
                .log().body()
                .statusCode(200);

    }
}