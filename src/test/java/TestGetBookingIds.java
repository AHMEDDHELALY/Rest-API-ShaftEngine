import Utilities.RequestApi;
import org.testng.annotations.Test;

public class TestGetBookingIds {

    private static final String bookEndPoint = System.getProperty("bookEndPoint");

    @Test
    public void getBookingIds(){
        RequestApi.getRequest(bookEndPoint);
    }

}
