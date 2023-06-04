import Utilities.RequestApi;
import Utilities.Resolver;
import com.shaft.api.RestActions;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class TestCreateToken {

    private static final String authEndPoint = System.getProperty("authEndPoint");

    Resolver resolver = new Resolver();
    JSONFileManager jsonFileManager = new JSONFileManager("src/test/resources/testDataFiles/authentication.json");

    @Test
    public void testAuth() {

        JSONObject authBody = resolver.authentication(
                jsonFileManager.getTestData("auth.username"),
                jsonFileManager.getTestData("auth.password")
        );

        String token = RestActions.getResponseJSONValue(authBody,"token");

        RequestApi.postRequest(authEndPoint, authBody);

        System.out.println("FSDGHsdfghj$#%$6#%$^%&%$#CXVBNnvvbnvbnbvnbvnvbnertg%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println(authBody);
        System.out.println(token);
        System.out.println("FSDGHsdfghj$#%$6#%$^%&%$#CXVBNnvvbnvbnbvnbvnvbnertg%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");


    }
}
