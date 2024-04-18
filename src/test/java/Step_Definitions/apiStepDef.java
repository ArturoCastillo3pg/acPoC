package Step_Definitions;

import helpers.apiHelper;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.json.JSONObject;

import static configuration.configProperties.*;
import static helpers.constants.clientId;
import static commons.ElementEvents.*;
public class apiStepDef extends apiHelper {
    static  String baseURI = "";
    Response callResponse;
    private String bodyContent;

    @Given("setting the endpoint")
    public void settingTheEndpoint() {
        try {
            baseURI = getProperty("jsonPlaceholderGet") + "/" + clientId;
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @When("endpoint is called")
    public void endpointIsCalled() {
        try {
            callResponse = callGet(baseURI);
            System.out.println(callResponse.getStatusCode());

            bodyContent = callResponse.getBody().asString();
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    @Then("response code is 200")
    public void responseCodeIs() {
        try {
            JSONObject bodyJson = new JSONObject(bodyContent);
            String name = bodyJson.getString("name");
            System.out.println(name);
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    @Given("setting API endpoint")
    public void settingAPIEndpoint() {
        try{
            baseURI = getProperty("regresPost");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @When("I send a POST request with valid data")
    public void iSendAPOSTRequestWithValidData() {
        try{
            String body = loadFile();

            callResponse = callPost(baseURI, body);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Then("I received a successful response")
    public void iReceivedASuccessfulResponse() {
        try{
            System.out.println(callResponse.getStatusCode());
            System.out.println(callResponse.asString());
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
