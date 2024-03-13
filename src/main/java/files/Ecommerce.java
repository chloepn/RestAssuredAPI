package files;

import POJO.LoginRequest;
import POJO.LoginResponse;
import POJO.Product;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;



import static io.restassured.RestAssured.given;

public class Ecommerce {
    public static void main (String[] args){
        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com")
                .setContentType(ContentType.JSON)
                .build();
        ResponseSpecification res = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();

        //1- POST create login request
        LoginRequest loginReq = new LoginRequest();
        loginReq.setUserEmail("chloep@gmail.com");
        loginReq.setUserPassword("Chloenguyen123");
        LoginResponse loginResponse = given().spec(req).body(loginReq).log().all()
                .when().post("/api/ecom/auth/login")
                .then().spec(res).extract().response().as(LoginResponse.class);
        String token = loginResponse.getToken();
        String userId= loginResponse.getUserId();

        //2- POST create product
        Product product = new Product();

        RequestSpecification addProductReq = new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com")
                .addHeader("authorization", token)
                .build();
        ResponseSpecification addProductRes = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();


        String addProductResponse =given().spec(addProductReq)
                .param("productName","wqerty")
                .param("productAddedBy",userId)
                .param("productCategory","fashion")
                .param("productSubCategory","shirts")
                .param("productPrice","11500")
                .param("productDescription","Addias Originals")
                .param("productFor","women").log().all()
        .when().post("/api/ecom/product/add-product")
        .then().spec(addProductRes).extract().response().toString();
        JsonPath js = new JsonPath(addProductResponse);
        System.out.println(js.getString("productId"));
        System.out.println(js.getString("message"));
    }

}
