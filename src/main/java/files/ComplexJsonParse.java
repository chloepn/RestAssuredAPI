package files;

import files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {
    public static void main(String[] args){
        JsonPath js = new JsonPath(payload.CoursePrice());
//    1. Print No of courses returned by API
        int counts = js.getInt("courses.size()");
        System.out.println(counts);
//2.Print Purchase Amount
        System.out.println(js.getInt("dashboard.purchaseAmount"));
//3. Print Title of the first course
        System.out.println(js.getString("courses[0].title"));
//4. Print All course titles and their respective Prices
        for ( int i =0; i< js.getInt("courses.size()"); i++){
            System.out.println("Title " +js.getString("courses["+i+"].title") +" Price "+ js.getInt("courses["+i+"].price"));
        }

//5. Print no of copies sold by RPA Course
        for ( int j =0; j< js.getInt("courses.size()"); j++) {
            if (js.getString("courses["+j+"].title").equals("RPA")) {
                System.out.println("Number of copies " + js.getInt("courses["+j+"].copies"));
            }
        }

//6. Verify if Sum of all Course prices matches with Purchase Amount
        int coursesPrice =0;
        for ( int k =0; k< js.getInt("courses.size()"); k++) {
            coursesPrice = coursesPrice + js.getInt("courses["+k+"].price")*js.getInt("courses["+k+"].copies");
        }
        System.out.println(js.getInt("dashboard.purchaseAmount") == coursesPrice);
    }

}
