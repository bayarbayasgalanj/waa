import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import mvc.domain.Book;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

public class BooksRESTTest {

    @BeforeClass
    public static void setup() {
        RestAssured.port = Integer.valueOf(8080);
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "";
    }

    @Test
    public void testGetOneBook() {
        // add the Book to be fetched
        Book Book = new Book("888999", "Jones", "MDP", 450.0);
        given()
                .contentType("application/json")
                .body(Book)
                .when().post("/books").then()
                .statusCode(200);
        // test getting the Book
        given()
                .when()
                .get("books/888999")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("isbn",equalTo("888999"))
                .body("author",equalTo("Jones"))
                .body("title",equalTo("MDP"))
                .body("price",equalTo(450.0F));
        //cleanup
        given()
                .when()
                .delete("books/888999");
    }

    @Test
    public void testDeleteBook() {
        // add the Book to be deleted book
        Book Book = new Book("888999", "Smith", "MDP", 450.0);
        given()
                .contentType("application/json")
                .body(Book)
                .when().post("/books").then()
                .statusCode(200);

        given()
                .when()
                .delete("books/888999");

        given()
                .when()
                .get("books/888999")
                .then()
                .statusCode(404)
                .and()
                .body("errorMessage",equalTo("Book with isbn= 888999 is not available"));
    }

    @Test
    public void testAddBook() {
        // add the Book
        Book Book = new Book("888999", "Smith", "MDP", 450.0);
        double expectedPrice = 450.0;
        given()
                .contentType("application/json")
                .body(Book)
                .when().post("/books").then()
                .statusCode(200);
        // get the Book and verify
        given()
                .when()
                .get("books/888999")
                .then()
                .statusCode(200)
                .and()
                .body("isbn",equalTo("888999"))
                .body("author",equalTo("Smith"))
                .body("title",equalTo("MDP"))

                .body("price", equalTo(450.0F) );
        //cleanup
        given()
                .when()
                .delete("books/888999");
    }

    @Test
    public void testUpdateBook() {
        // add the Book
        Book Book = new Book("888999", "Smith", "MDP", 450.0);
        Book updateBook = new Book("888999", "Johnson", "WAA", 690.0);
        given()
                .contentType("application/json")
                .body(Book)
                .when().post("/books").then()
                .statusCode(200);
        //update Book
        given()
                .contentType("application/json")
                .body(updateBook)
                .when().put("/books/" +updateBook.getIsbn()).then()
                .statusCode(200);
        // get the Book and verify
        given()
                .when()
                .get("books/888999")
                .then()
                .statusCode(200)
                .and()
                .body("isbn",equalTo("888999"))
                .body("author",equalTo("Johnson"))
                .body("title",equalTo("WAA"))
                .body("price",equalTo(690.0F));
        //cleanup
        given()
                .when()
                .delete("books/888999");
    }

    @Test
    public void testGetAllbooks() {
        // add the books
        Book Book = new Book("888999", "Smith", "MDP", 450.0);
        Book Book2 = new Book("555000", "Johnson", "WAA", 690.0);
        given()
                .contentType("application/json")
                .body(Book)
                .when().post("/books").then()
                .statusCode(200);
        given()
                .contentType("application/json")
                .body(Book2)
                .when().post("/books").then()
                .statusCode(200);

        // get all books and verify
        given()
                .when()
                .get("/books")
                .then()
                .statusCode(200)
                .and()
                .body("books.isbn", hasItems("888999", "555000"))
                .body("books.author",hasItems("Smith", "Johnson"))
                .body("books.title",hasItems("MDP", "WAA"))
                .body("books.price",hasItems(450.0F, 690.0F));
        //cleanup
        given()
                .when()
                .delete("books/888999");
        given()
                .when()
                .delete("books/555000");
    }
    @Test
    public void testSearchBooks() {
        // add the Book to be fetched
        Book Book = new Book("888999", "Jones", "MDP", 450.0);
        given()
                .contentType("application/json")
                .body(Book)
                .when().post("/books").then()
                .statusCode(200);
        // test getting the Book
        given()
                .when()
                .get("books/author/Jones")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("isbn",equalTo("888999"))
                .body("author",equalTo("Jones"))
                .body("title",equalTo("MDP"))
                .body("price",equalTo(450.0F));
        //cleanup
        given()
                .when()
                .delete("books/888999");
    }
}
