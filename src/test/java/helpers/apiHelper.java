package helpers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class apiHelper {
    Response response;

    public Response callGet(String URI){
        RequestSpecification httpReq = RestAssured.given();
        httpReq.baseUri(URI);

        response = httpReq.get();

        return response;
    }

    public Response callPost(String URL, String body){
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");
        request.body(body);
        response = request.post(URL);
        return response;
    }
}
