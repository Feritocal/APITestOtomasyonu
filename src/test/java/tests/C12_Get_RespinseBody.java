package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import java.awt.geom.RectangularShape;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.*;

public class C12_Get_RespinseBody {
    @Test
    public void test01(){

        String url =" http://dummy.restapiexample.com/api/v1/employees";

        JSONObject employeesJsonObj= new JSONObject();


        Response response = given()
                            .when()
                            .get(url);


        response.then().assertThat().statusCode(200)
                .contentType(ContentType.JSON)
                .body("data.id",  hasSize(24),
                "data.employee_name",containsString("Ashton Cox"),
        "data.employee_age", hasItems(61,21,35));


    }
}
