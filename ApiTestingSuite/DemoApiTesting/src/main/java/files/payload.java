package files;

//import static org.codehaus.groovy.runtime.DefaultGroovyMethods.;

public class payload {
    public static String AddPlace() {
        return "{\r\n" +
                "  \"location\": {\r\n" +
                "    \"lat\": -38.383494,\r\n" +
                "    \"lng\": 33.427362\r\n" +
                "  },\r\n" +
                "  \"accuracy\": 50,\r\n" +
                "  \"name\": \"Rahul Shetty Academy\",\r\n" +
                "  \"phone_number\": \"(+91) 983 893 3937\",\r\n" +
                "  \"address\": \"29, side layout, cohen 09\",\r\n" +
                "  \"types\": [\r\n" +
                "    \"shoe park\",\r\n" +
                "    \"shop\"\r\n" +
                "  ],\r\n" +
                "  \"website\": \"http://rahulshettyacademy.com\",\r\n" +
                "  \"language\": \"French-IN\"\r\n" +
                "}\r\n" +
                "";


    }

    public static String email(String email) {
        return "{\r\n" +
                "    \"email\": "+email+"\r\n" +
                "}\r\n" +
                "";
    }

    public static String otp(String email,int otp) {
        return "{\r\n" +
                "    \"email\": "+email+"\r\n" +
                "}\r\n" +
                "  \"otp\": "+otp+"\r\n" +
                "}\r\n" +
                "";
    }

//    public static String TenantId(String username,int password){
//
//
//    }

    public static String schemaCreation() {
        return "{\n" +
                "    \"entityName\": \"Wallet Entikty Detials\",\n" +
                "    \"description\": \"Wallet Entikty Detials Schema\",\n" +
                "    \"attributes\": [\n" +
                "        {\n" +
                "            \"name\": \"deleted\",\n" +
                "            \"type\": {\n" +
                "                \"type\": \"boolean\"\n" +
                "            },\n" +
                "            \"required\": true\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"walletBalance\",\n" +
                "            \"type\": {\n" +
                "                \"type\": \"number\"\n" +
                "            },\n" +
                "            \"required\": true\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"walletType\",\n" +
                "            \"type\": {\n" +
                "                \"type\": \"string\"\n" +
                "            },\n" +
                "            \"required\": true\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"email\",\n" +
                "            \"type\": {\n" +
                "                \"type\": \"string\"\n" +
                "            },\n" +
                "            \"required\": true\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"walletId\",\n" +
                "            \"type\": {\n" +
                "                \"type\": \"string\"\n" +
                "            },\n" +
                "            \"required\": true\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"name\",\n" +
                "            \"type\": {\n" +
                "                \"type\": \"string\"\n" +
                "            },\n" +
                "            \"required\": false\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"mobile\",\n" +
                "            \"type\": {\n" +
                "                \"type\": \"string\"\n" +
                "            },\n" +
                "            \"required\": false\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"currency\",\n" +
                "            \"type\": {\n" +
                "                \"type\": \"string\"\n" +
                "            },\n" +
                "            \"required\": false\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"createdDate\",\n" +
                "            \"type\": {\n" +
                "                \"type\": \"integer\"\n" +
                "            },\n" +
                "            \"required\": true\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"updatedDate\",\n" +
                "            \"type\": {\n" +
                "                \"type\": \"integer\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"primaryKey\": [\n" +
                "        \"email\"\n" +
                "    ]\n" +
                "}";
    }

    public static String CoursePrice() {

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

    public static String SchemaCreation() {
    return "{\n" +
            "  \"entityName\": \"Employee Detials\",\n" +
            "  \"description\": \"Employee Detials Schema\",\n" +
            "  \"attributes\": [\n" +
            "    {\n" +
            "      \"name\": \"name\",\n" +
            "      \"type\": {\n" +
            "        \"type\": \"string\"\n" +
            "      },\n" +
            "      \"required\": true\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"mobilenumber\",\n" +
            "      \"type\": {\n" +
            "        \"type\": \"integer\"\n" +
            "      },\n" +
            "      \"required\": true\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"address\",\n" +
            "      \"type\": {\n" +
            "        \"type\": \"string\"\n" +
            "      },\n" +
            "      \"required\": true\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"email\",\n" +
            "      \"type\": {\n" +
            "        \"type\": \"string\"\n" +
            "      },\n" +
            "      \"required\": true\n" +
            "    }\n" +
            "  ],\n" +
            "  \"primaryKey\": [\n" +
            "    \"email\"\n" +
            "  ]\n" +
            "}";
    }
}
