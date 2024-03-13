package com.company;

import files.ReUsableMethods;
import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.hamcrest.Matchers;
import org.testng.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class Basic {
    public static void main (String[] args) throws IOException {
//     RestAssured.baseURI ="https://rahulshettyacademy.com";
//     String response = RestAssured.given().log().all()
//         .queryParam("key","qaclick123")
//         .header("Content-Type","Application/json")
//         .body(payload.addPlace())
//     .when().post("maps/api/place/add/json")
//     .then().assertThat().statusCode(200)
//             .body("scope", Matchers.equalTo("APP"))
//             .header("server", "Apache/2.4.52 (Ubuntu)")
//             .extract().response().asString();
//     System.out.println(response);
//     JsonPath js = new JsonPath(response);
//     String placeId =js.getString("place_id");
//     System.out.print(placeId);
//
//
//    //update place
//    String newAddress ="Summer Walk, Africa";
//
//    String response2 = RestAssured.given().log().all()
//            .queryParam("key", "qaclick123")
//            .header("Content-Type","Application/json")
//            .body(payload.updatePlace(placeId, newAddress))
//    .when().put("/maps/api/place/update/json")
//    .then().assertThat().log().all().statusCode(200)
//            .body("msg",Matchers.equalTo("Address successfully updated"))
//            .extract().response().asString();
//
//    //get new place
//    String response3 = RestAssured.given().log().all()
//            .queryParam("key","qaclick123")
//            .queryParam("place_id",placeId)
//    .when().get(" /maps/api/place/get/json")
//    .then().assertThat().log().all().statusCode(200)
//            //.body("address", Matchers.equalTo(newAddress))
//            .extract().response().asString();
//    JsonPath js2 = ReUsableMethods.rawToJson(response3);
//    String address = js2.getString("address");
//    Assert.assertEquals(address,newAddress);
    RestAssured.baseURI ="https://rahulshettyacademy.com";
    String response = RestAssured.given().log().all()
            .queryParam("key","qaclick123")
            .header("Content-Type","Application/json")
            .body(GenerateStringFromResource("/Users/chloephan/DemoProject/src/main/java/files/addPlace.json"))
            .when().post("maps/api/place/add/json")
            .then().assertThat().statusCode(200)
            .body("scope", Matchers.equalTo("APP"))
            .header("server", "Apache/2.4.52 (Ubuntu)")
            .extract().response().asString();
    System.out.println(response);
    JsonPath js = new JsonPath(response);
    String placeId =js.getString("place_id");
    System.out.print(placeId);
}
    public static String GenerateStringFromResource(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

}

