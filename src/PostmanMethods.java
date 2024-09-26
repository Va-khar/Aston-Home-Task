import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostmanMethods {
    @Test
    public void TestGet() {
        RestAssured.baseURI = "https://postman-echo.com";

        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then().log().body()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));
    }

    @Test
    public void testPostText() {
        RestAssured.baseURI = "https://postman-echo.com";

        String requestBody = "This is expected to be sent back as part of response body.";

        given()
                .contentType("text/plain")
                .body(requestBody)
                .when()
                .post("/post")
                .then().log().body()
                .statusCode(200)
                .body("args.isEmpty()", equalTo(true))
                .body("data", equalTo(requestBody))
                .body("files.isEmpty()", equalTo(true))
                .body("form.isEmpty()", equalTo(true));
    }

    @Test
    public void testPostFormData() {
        RestAssured.baseURI = "https://postman-echo.com";
        String foo1 = "bar1";
        String foo2 = "bar2";

        given()
                .contentType(ContentType.URLENC.withCharset("UTF-8"))
                .formParam("foo1", foo1)
                .formParam("foo2", foo2)
                .when()
                .post("/post")
                .then().log().body()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("args.isEmpty()", equalTo(true))
                .body("data.isEmpty()", equalTo(true))
                .body("files.isEmpty()", equalTo(true))
                .body("form.foo1", equalTo(foo1))
                .body("form.foo2", equalTo(foo2));
    }

    @Test
    public void testPutText() {
        RestAssured.baseURI = "https://postman-echo.com";

        String requestBody = "This is expected to be sent back as part of response body.";

        given()
                .contentType("text/plain")
                .body(requestBody)
                .when()
                .put("/put")
                .then().log().body()
                .statusCode(200)
                .body("args.isEmpty()", equalTo(true))
                .body("data", equalTo(requestBody))
                .body("files.isEmpty()", equalTo(true))
                .body("form.isEmpty()", equalTo(true));
    }

    @Test
    public void testPatchText() {
        RestAssured.baseURI = "https://postman-echo.com";

        String requestBody = "This is expected to be sent back as part of response body.";

        given()
                .contentType("text/plain")
                .body(requestBody)
                .when()
                .patch("/patch")
                .then().log().body()
                .statusCode(200)
                .body("args.isEmpty()", equalTo(true))
                .body("data", equalTo(requestBody))
                .body("files.isEmpty()", equalTo(true))
                .body("form.isEmpty()", equalTo(true));
    }

    @Test
    public void testDeleteText() {
        RestAssured.baseURI = "https://postman-echo.com";

        String requestBody = "This is expected to be sent back as part of response body.";

        given()
                .contentType("text/plain")
                .body(requestBody)
                .when()
                .delete("/delete")
                .then().log().body()
                .statusCode(200)
                .body("args.isEmpty()", equalTo(true))
                .body("data", equalTo(requestBody))
                .body("files.isEmpty()", equalTo(true))
                .body("form.isEmpty()", equalTo(true));
    }
}
