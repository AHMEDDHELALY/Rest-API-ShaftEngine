import Utilities.RequestApi;
import Utilities.Resolver;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class TestCreateBooking {

    private static final String bookEndPoint = System.getProperty("bookEndPoint");

    Resolver resolver = new Resolver();
    JSONFileManager jsonFileManager = new JSONFileManager("src/test/resources/testDataFiles/createBooking.json");

    @Test
    public void testCreateBooking() {
        JSONObject bookBody = resolver.createBookingBody(
                jsonFileManager.getTestData("validData.firstname"),
                jsonFileManager.getTestData("validData.lastname"),
                Integer.parseInt(String.valueOf(111)),
                Boolean.parseBoolean(String.valueOf(true)),
                jsonFileManager.getTestData("validData.bookingdates.checkin"),
                jsonFileManager.getTestData("validData.bookingdates.checkout"),
                jsonFileManager.getTestData("validData.additionalneeds")
        );

        Response response = RequestApi.postRequest(bookEndPoint, bookBody);

        Validations.verifyThat().response(response).extractedJsonValue(bookBody.toString()).doesNotMatchRegex(bookBody);
    }
}
