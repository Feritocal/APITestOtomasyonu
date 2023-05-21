package tests;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_GetApiSorgulama {
    @Test
    public void get01(){

        //https://restful booker.herokuapp.com/booking/57 url’ine bir GET request
        //gonderdigimizde donen Response’un,
        //status code’unun 200,
        //ve content type’inin application/json; charset=utf-8,
        //ve Server isimli Header’in degerinin Cowboy,
        //ve status Line’in HTTP/1.1 200 OK
        //ve response suresinin 5 sn’den kisa oldugunu   test ediniz.

        String url ="http://restful-booker.herokuapp.com/booking/57";

        Response response = given().when().get(url);

        response.then().assertThat().statusCode(200)
                .contentType("application/json; charset=utf-8")
                .statusLine("HTTP/1.1 200 OK")
                .header("Server", "Cowboy")
                        .body("firstname", Matchers.equalTo("John"));

        //Assert.assertEquals(200, response.statusCode());
        //Assert.assertEquals("application/json; charset=utf-8", response.contentType());
        //Assert.assertEquals("Cowboy", response.header("Server"));
        //Assert.assertEquals("HTTP/1.1 200 OK", response.getStatusLine());
        //Assert.assertTrue(response.getTime()<5);




    }
}
