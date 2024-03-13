package com.company;

import POJO.GetCourse;
import io.restassured.RestAssured;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class oAuthTest {
    public static void main (String[] args) throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "downloads/chromedriver.exec");
//        WebDriver driver = getWebDriver();
//        driver.findElement(By.cssSelector("input[type = 'email']")).sendKeys("anhpn97@gmail.com");
//        driver.findElement(By.cssSelector("input[type = 'email']")).sendKeys(Keys.ENTER);
//        Thread.sleep(3000);
//        driver.findElement(By.cssSelector("input[type = 'passwords']")).sendKeys("");
//        driver.findElement(By.cssSelector("input[type = 'passwords']")).sendKeys(Keys.ENTER);
//        Thread.sleep(3000);
//        String url = driver.getCurrentUrl();
//        //String code = url.split("&")[1].split("=")[1];
//        String code = url.split("code=")[1].split("&scope")[0];


//  Cant do this bz this need to redirect to 3rd party, log in , and redirect back
//  => must use Selenium
//        String response1 = RestAssured.given()
//                .queryParam("Scope","https://www.googleapis.com/auth/userinfo.email")
//                //.queryParam("Auth_url","https://accounts.google.com/o/oauth2/v2/auth")
//                .queryParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
//                .queryParam("response_type")
//                .queryParam("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
//                //.headers("oAuth","")
//        .when().get("https://accounts.google.co/o/oauth2/v2/auth")
//        .then().statusCode(200)
//                //.body("code","")
//                //header("code",")
//                .extract().response().asString();
//        String accessCode = files.ReUsableMethods.rawToJson(response1).getString("code");

        String response2 = RestAssured.given().urlEncodingEnabled(false)
                //.queryParam("Code",code)
                //.queryParam("Auth_url","https://accounts.google.com/o/oauth2/v2/auth")
                .queryParams("client_id","587594460880-u53ikl5ast2sup28098ofsm9iku8vvm6.apps.googleusercontent.com&code_challenge=AFqtI6O06J3tFjdPzwfKdnOEIId4DjrdSs3y7nuZZu0&code_challenge_method=S256&include_granted_scopes=true&prompt=select_account%20consent&redirect_uri=https%3A%2F%2Fsso.teachable.com%2Fidentity%2Fcallbacks%2Fgoogle%2Fcallback&response_type=code&scope=email%20https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email%20https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.profile%20openid%20profile&state=eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJnb29nbGUiLCJpYXQiOjE2OTI5MTA0OTEsImV4cCI6MTY5MjkxMjI5MSwianRpIjoiMTk0N2ZlNTEtYzZlZi00MTg2LWEwZWItNDMwYWQyZDg0NDQxIiwiaXNzIjoic2tfeno4dHc2ZGciLCJzdWIiOiJkRl93cHp1MXJaZWVWdXdfTzJHS2w0Mjl5UEFCQXpDQ1lrWVBqMDdzazRmOC1LR2JuX1d5OHUydGtTZXVReEFzMXFsRkNBSkU1czNLSnpGVHAxYTlBZyJ9.-MiNVs-gAzQkoywhF40KY_CkEPiIxmooSoJ8s-JHsF8&service=lso&o2v=2")
                .queryParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
                .queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
                .queryParams("grant_type","authorization_code")
                .when().log().all().post("https://www.googleapis.com/oauth2/v4/token").asString();
        String access_token = files.ReUsableMethods.rawToJson(response2).getString("access_token");

        GetCourse response3 = RestAssured.given().queryParam("access_token", access_token)
                .when().get("https://rahulshettyacademy.com/getCourse.php").as(GetCourse.class);
        response3.getLinkedIn();
        System.out.println(response3);




    }

    private static WebDriver getWebDriver() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://accounts.google.com/o/oauth2/v2/auth/oauthchooseaccount?access_type=offline&client_id=587594460880-u53ikl5ast2sup28098ofsm9iku8vvm6.apps.googleusercontent.com&code_challenge=AFqtI6O06J3tFjdPzwfKdnOEIId4DjrdSs3y7nuZZu0&code_challenge_method=S256&include_granted_scopes=true&prompt=select_account%20consent&redirect_uri=https%3A%2F%2Fsso.teachable.com%2Fidentity%2Fcallbacks%2Fgoogle%2Fcallback&response_type=code&scope=email%20https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email%20https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.profile%20openid%20profile&state=eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJnb29nbGUiLCJpYXQiOjE2OTI5MTA0OTEsImV4cCI6MTY5MjkxMjI5MSwianRpIjoiMTk0N2ZlNTEtYzZlZi00MTg2LWEwZWItNDMwYWQyZDg0NDQxIiwiaXNzIjoic2tfeno4dHc2ZGciLCJzdWIiOiJkRl93cHp1MXJaZWVWdXdfTzJHS2w0Mjl5UEFCQXpDQ1lrWVBqMDdzazRmOC1LR2JuX1d5OHUydGtTZXVReEFzMXFsRkNBSkU1czNLSnpGVHAxYTlBZyJ9.-MiNVs-gAzQkoywhF40KY_CkEPiIxmooSoJ8s-JHsF8&service=lso&o2v=2&flowName=GeneralOAuthFlow");
        return driver;
    }
}
