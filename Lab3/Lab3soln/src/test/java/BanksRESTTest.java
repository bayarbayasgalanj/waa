import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import mvc.domain.BankAccount;
import mvc.domain.Book;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

public class BanksRESTTest {

    @BeforeClass
    public static void setup() {
        RestAssured.port = Integer.valueOf(8080);
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "";
    }

    @Test
    public void testGetAccount() {
        BankAccount bankAccount = new BankAccount(888999, "Bayar", 100.0);
        given()
                .contentType("application/json")
                .body(bankAccount)
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
    public void testCreateAccount() {
        BankAccount bankAccount = new BankAccount(888999, "Bayar", 100.0);
        given()
                .contentType("application/json")
                .body(bankAccount)
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
    public void testRemoveAccount() {
        BankAccount bankAccount = new BankAccount(888999, "Bayar", 100.0);
        given()
                .contentType("application/json")
                .body(bankAccount)
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
        BankAccount bankAccount = new BankAccount(888999, "Bayar", 100.0);
        given()
                .contentType("application/json")
                .body(bankAccount)
                .when().post("/createAccount").then()
                .statusCode(200);

        given()
                .contentType("application/json")
                .body(bankAccount)
                .when().put("/bankAccounts/deposit/" +bankAccount.getAccountNumber()+"/"+590.0).then()
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
        BankAccount bankAccount = new BankAccount(888999, "Bayar", 100.0);
        given()
                .contentType("application/json")
                .body(bankAccount)
                .when().post("/createAccount").then()
                .statusCode(200);

        given()
                .contentType("application/json")
                .body(bankAccount)
                .when().put("/bankAccounts/withdraw/" +bankAccount.getAccountNumber()+"/"+59.0).then()
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
