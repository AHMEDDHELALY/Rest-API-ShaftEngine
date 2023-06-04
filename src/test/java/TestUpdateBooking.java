import Utilities.RequestApi;
import Utilities.Resolver;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class TestUpdateBooking {

    private static final String bookEndPoint = System.getProperty("bookEndPoint");

    Resolver resolver = new Resolver();

    JSONFileManager jsonFileManager = new  JSONFileManager("src/test/resources/testDataFiles/updateBooking.json");


    @Test
    public void testUpdateBooking(){

        JSONObject updateBookingBody = resolver.updateBookingBody(
                jsonFileManager.getTestData("validData.firstname"),
                jsonFileManager.getTestData("validData.lastname"),
                Integer.parseInt(String.valueOf(111)),
                Boolean.parseBoolean(String.valueOf(true)),
                jsonFileManager.getTestData("validData.bookingdates.checkin"),
                jsonFileManager.getTestData("validData.bookingdates.checkout"),
                jsonFileManager.getTestData("validData.additionalneeds")
        );
        Response response = RequestApi.postRequest(bookEndPoint, updateBookingBody);

        Validations.verifyThat().response(response).extractedJsonValue("booking.firstname").isNotNull().perform();
        Validations.verifyThat().response(response).extractedJsonValue("booking.lastname").isNotNull().perform();
        Validations.verifyThat().response(response).extractedJsonValue("booking.totalprice").isNotNull().perform();
        Validations.verifyThat().response(response).extractedJsonValue("booking.depositpaid").isNotNull().perform();
        Validations.verifyThat().response(response).extractedJsonValue("booking.bookingdates.checkin").isNotNull().perform();
        Validations.verifyThat().response(response).extractedJsonValue("booking.bookingdates.checkout").isNotNull().perform();
        Validations.verifyThat().response(response).extractedJsonValue("booking.additionalneeds").isNotNull().perform();
    }
}
