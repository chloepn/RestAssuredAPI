package files;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.print.attribute.standard.RequestingUserName;

import static io.restassured.RestAssured.given;

public class DynamicJson {
//    @Test
//    public void addBook(){
//        RestAssured.baseURI ="http://216.10.245.166";
//        String response = given().header("Content-Type", "application/json")
//                .body(payload.addBook())
//        .when().post("/Library/Addbook.php")
//        .then().assertThat().statusCode(200)
//                .extract().response().asString();
//
//        JsonPath js = ReUsableMethods.rawToJson(response);
//        String ID = js.getString("ID");
//        System.out.print(ID);
//    }
    @Test(dataProvider = "BookData")
    public void addBook(String isbn, String aisle){
        RestAssured.baseURI="http://216.10.245.166";
        String response = given().header("Content-Type", "application/json")
                .body(payload.addBook(isbn, aisle))
        .when().post("/Library/Addbook.php")
        .then().statusCode(200)
                .extract().response().asString();

        JsonPath js = ReUsableMethods.rawToJson(response);
        String ID = js.getString("ID");
        System.out.print(ID);

    }
    @DataProvider(name = "BookData")
    public Object[][] getData(){
        return new Object[][] {{"abc", "123"},{"asd", "345"},{"ergh", "4627"}};
    }
}
