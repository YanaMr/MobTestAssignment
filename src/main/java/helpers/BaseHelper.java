package helpers;

import io.restassured.response.Response;

import static java.net.HttpURLConnection.HTTP_OK;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseHelper {
    public void checkStatusCodeIsOk(Response response) {
        assertEquals(response.getStatusCode(), HTTP_OK);
    }

}

