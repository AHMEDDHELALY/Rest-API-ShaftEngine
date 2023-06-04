import Utilities.RequestApi;
import Utilities.Resolver;
import com.shaft.tools.io.JSONFileManager;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class TestGetBookingIds {

    private static final String bookEndPoint = System.getProperty("bookEndPoint");

    @Test
    public void getBookingIds(){
        RequestApi.getRequest(bookEndPoint);
    }


}
