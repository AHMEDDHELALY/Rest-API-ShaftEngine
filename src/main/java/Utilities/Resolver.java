package Utilities;

import org.json.simple.JSONObject;

public class Resolver {

    //Json Object body to use in creating token
    public JSONObject authentication(String userName, String password) {

        JSONObject createToken = new JSONObject();
        createToken.put("username", userName);
        createToken.put("password", password);

        return createToken;
    }

    //Json Object body to use in Create Booking
    public JSONObject createBookingBody(String firstname, String lastname, int totalprice, boolean depositpaid,
                                        String checkin, String checkout, String additionalneeds) {

        JSONObject createBookingBody = new JSONObject();
        createBookingBody.put("firstname", firstname);
        createBookingBody.put("lastname", lastname);
        createBookingBody.put("totalprice", totalprice);
        createBookingBody.put("depositpaid", depositpaid);
        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin", checkin);
        bookingDates.put("checkout", checkout);
        createBookingBody.put("bookingdates", bookingDates);
        createBookingBody.put("additionalneeds", additionalneeds);

        return createBookingBody;


    }
}
