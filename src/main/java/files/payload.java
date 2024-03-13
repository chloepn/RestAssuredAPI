package files;

public class payload {
    public static String  addPlace(){
      return "{\n" +
              "\t\"location\":{\n" +
              "\t\t\"lat\": -38.383494,\n" +
              "\t\t\"lng\": 33.427362\n" +
              "\t},\n" +
              "\t\"accuracy\": 50,\n" +
              "\t\"name\": \"Rahu Shetty Academy\",\n" +
              "\t\"phone_number\": \"29,side layout, cohen 09\",\n" +
              "\t\"types\": [\n" +
              "\t\t\"shoe park\",\n" +
              "\t\t\"shop\"\n" +
              "\t],\n" +
              "\t\"website\": \"https://rahulshettyacademy.com\",\n" +
              "\t\"language\": \"French-IN\"\n" +
              "}";
    }
    public static String  updatePlace(String placeId, String newAddress){
        return "{\n" +
                "\"place_id\":\""+placeId+"\",\n" +
                "\"address\":\""+newAddress+"\",\n" +
                "\"key\":\"qaclick123\"\n" +
                "}\n";
    }
    public static String CoursePrice()
    {
        return "{\r\n" +
                "  \"dashboard\": {\r\n" +
                "    \"purchaseAmount\": 1162,\r\n" +
                "    \"website\": \"rahulshettyacademy.com\"\r\n" +
                "  },\r\n" +
                "  \"courses\": [\r\n" +
                "    {\r\n" +
                "      \"title\": \"Selenium Python\",\r\n" +
                "      \"price\": 50,\r\n" +
                "      \"copies\": 6\r\n" +
                "    },\r\n" +
                "    {\r\n" +
                "      \"title\": \"Cypress\",\r\n" +
                "      \"price\": 40,\r\n" +
                "      \"copies\": 4\r\n" +
                "    },\r\n" +
                "    {\r\n" +
                "      \"title\": \"RPA\",\r\n" +
                "      \"price\": 45,\r\n" +
                "      \"copies\": 10\r\n" +
                "    },\r\n" +
                "     {\r\n" +
                "      \"title\": \"Appium\",\r\n" +
                "      \"price\": 36,\r\n" +
                "      \"copies\": 7\r\n" +
                "    }\r\n" +
                "    \r\n" +
                "    \r\n" +
                "    \r\n" +
                "  ]\r\n" +
                "}\r\n" +
                "";
    }
    public static String addBook(){
        return "{\n" +
                "\n" +
                "\n" +
                "\"name\":\"Learn Appium Automation with Java\",\n" +
                "\"isbn\":\"bcd\",\n" +
                "\"aisle\":\"227\",\n" +
                "\"author\":\"John foe\"\n" +
                "}\n";
    }
    public static String addBook(String isbn, String aisle){
        return "{\n" +
                "\n" +
                "\n" +
                "\"name\":\"Learn Appium Automation with Java\",\n" +
                "\"isbn\":\""+isbn+"\",\n" +
                "\"aisle\":\""+aisle+"\",\n" +
                "\"author\":\"John foe\"\n" +
                "}\n";
    }
}