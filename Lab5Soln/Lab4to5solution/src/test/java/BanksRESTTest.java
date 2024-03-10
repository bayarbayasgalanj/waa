import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import mvc.service.BankAccountDTO;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.hasEntry;

public class BanksRESTTest {

    @BeforeClass
    public static void setup() {
        RestAssured.port = Integer.valueOf(8080);
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "";
    }

    @Test
    public void testGetAccount() {
        BankAccountDTO bankAccountDTO = new BankAccountDTO(888999, "Bayar", 100.0);
        given()
                .contentType("application/json")
                .body(bankAccountDTO)
                .when().post("/createAccount").then()
                .statusCode(200);
        given()
                .when()
                .get("bankAccounts/888999")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("accountNumber",equalTo(888999))
                .body("accountHolder",equalTo("Bayar"))
                .body("balance",equalTo(100.0F));
        given()
                .when()
                .delete("bankAccounts/888999");
    }
    @Test
    public void testGetAllBankAccounts() {
        BankAccountDTO bankAccountDTO1 = new BankAccountDTO(888999, "Bayar", 100.0);
        BankAccountDTO bankAccountDTO2 = new BankAccountDTO(444555, "Solo", 690.0);
        given()
                .contentType("application/json")
                .body(bankAccountDTO1)
                .when().post("/createAccount").then()
                .statusCode(200);
        given()
                .contentType("application/json")
                .body(bankAccountDTO2)
                .when().post("/createAccount").then()
                .statusCode(200);

        given()
                .when()
                .get("/bankAccounts")
                .then()
                .statusCode(200)
                .and()
                .body("accountNumber", hasItems(888999, 444555))
                .body("accountHolder",hasItems("Bayar", "Solo"))
                .body("balance",hasItems(100.0F, 690.0F));
        //cleanup
        given()
                .when()
                .delete("bankAccounts/888999");
        given()
                .when()
                .delete("bankAccounts/444555");
    }
    @Test
    public void testCreateAccount() {
        BankAccountDTO bankAccountDTO = new BankAccountDTO(888999, "Bayar", 100.0);
        given()
                .contentType("application/json")
                .body(bankAccountDTO)
                .when().post("/createAccount").then()
                .statusCode(200);
        given()
                .when()
                .get("bankAccounts/888999")
                .then()
                .statusCode(200)
                .and()
                .body("accountNumber",equalTo(888999))
                .body("accountHolder",equalTo("Bayar"))
                .body("balance",equalTo(100.0F));
        given()
                .when()
                .delete("bankAccounts/888999");
    }
    @Test
    public void testValidationCreateAccount() {
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("accountNumber", "888999");
//        hashMap.put("accountHolder", "MDP");
        hashMap.put("balance", "450.0");

        given()
                .contentType("application/json")
                .body(hashMap)
                .when().post("/createAccount").then()
                .statusCode(400)
                .and()
                .body("data",equalTo(null))
                .body("fieldError", hasEntry("accountHolder", "must not be empty"))
                .body("isSuccess",equalTo(false)
                );
        //cleanup
        given()
                .when()
                .delete("books/888999");
    }
    @Test
    public void testRemoveAccount() {
        BankAccountDTO bankAccountDTO = new BankAccountDTO(888999, "Bayar", 100.0);
        given()
                .contentType("application/json")
                .body(bankAccountDTO)
                .when().post("/createAccount").then()
                .statusCode(200);

        given()
                .when()
                .delete("bankAccounts/888999");

        given()
                .when()
                .get("bankAccounts/888999")
                .then()
                .statusCode(404)
                .and()
                .body("errorMessage",equalTo("Bank Accounts with bankAccount= 888999 is not available"));
    }

    @Test
    public void testDeposit() {
        BankAccountDTO bankAccountDTO = new BankAccountDTO(888999, "Bayar", 100.0);
        given()
                .contentType("application/json")
                .body(bankAccountDTO)
                .when().post("/createAccount").then()
                .statusCode(200);

        given()
                .contentType("application/json")
                .body(bankAccountDTO)
                .when().put("/bankAccounts/deposit/" + bankAccountDTO.getAccountNumber()+"/"+590.0).then()
                .statusCode(200);

        given()
                .when()
                .get("bankAccounts/888999")
                .then()
                .statusCode(200)
                .and()
                .body("accountNumber",equalTo(888999))
                .body("accountHolder",equalTo("Bayar"))
                .body("balance",equalTo(690.0F));
        //cleanup
        given()
                .when()
                .delete("bankAccounts/888999");
    }

    @Test
    public void testWithdraw() {
        BankAccountDTO bankAccountDTO = new BankAccountDTO(888999, "Bayar", 100.0);
        given()
                .contentType("application/json")
                .body(bankAccountDTO)
                .when().post("/createAccount").then()
                .statusCode(200);

        given()
                .contentType("application/json")
                .body(bankAccountDTO)
                .when().put("/bankAccounts/withdraw/" + bankAccountDTO.getAccountNumber()+"/"+59.0).then()
                .statusCode(200);

        given()
                .when()
                .get("bankAccounts/888999")
                .then()
                .statusCode(200)
                .and()
                .body("accountNumber",equalTo(888999))
                .body("accountHolder",equalTo("Bayar"))
                .body("balance",equalTo(41.0F));
        //cleanup
        given()
                .when()
                .delete("bankAccounts/888999");
    }
}
