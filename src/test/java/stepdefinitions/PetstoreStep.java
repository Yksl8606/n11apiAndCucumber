package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.ApiPetstore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PetstoreStep {
    Response response;

    ApiPetstore pojo =new ApiPetstore("admin","user","galatasaray","admin@gmail.com","1234","5554443322","100");

    @Given("user post request icin gerekli pathprams ayarlarini yapar")
    public void user_post_request_icin_gerekli_pathprams_ayarlarini_yapar() {
        HashMap<String,Object> body =new HashMap<>();
        body.put("id",1000);
        body.put("username","admin");
        body.put("firstname","user");
        body.put("lastname","galatasaray");
        body.put("email","admin@gmail.com");
        body.put("password","1234");
        body.put("phone","5554443322");
        body.put("status","100");
        List<HashMap<String,Object>> ary=new ArrayList<>();
        ary.add(body);
        response = given().contentType(ContentType.JSON).auth().basic("api_key", "abc123").body(ary)
                .when().post("https://petstore.swagger.io/#/user/createUsersWithListInput");


    }
    @Then("user post sonrası aldıgı responsu ekrana yazdirir")
    public void user_post_sonrası_aldıgı_responsu_ekrana_yazdirir() {
        response.prettyPrint();
    }
    @Then("user gelen veriyi dogrular")
    public void user_gelen_veriyi_dogrular() {
        JsonPath json = response.jsonPath();
        Assert.assertEquals(200, json.getInt("code"));
        Assert.assertEquals("unknown", json.get("type"));
        Assert.assertEquals("ok", json.get("message"));


    }
        @Given("user get request icin pathparams ayarlarini yapar")
    public void user_get_request_icin_pathparams_ayarlarini_yapar() {
            response = given().contentType(ContentType.JSON).auth().basic("api_key", "abc123")
                    .when().get("https://petstore.swagger.io/v2/user/Erkan");

    }
    @Given("user get isleminden sonra  aldigi responsu yazdırır")
    public void user_get_isleminden_sonra_aldigi_responsu_yazdırır() {
        response.prettyPrint();
    }
    @Given("user response ile aldiği gercek actual cevabi expected  ile karsilastirir")
    public void user_response_ile_aldiği_gercek_actual_cevabi_expected_ile_karsilastirir() {
        JsonPath json = response.jsonPath();
        Assert.assertEquals("admin", json.get("username"));
        Assert.assertEquals("user", json.get("firstName"));
        Assert.assertEquals("galatasaray", json.get("lastName"));
        Assert.assertEquals("admin@gmail.com", json.get("email"));
        Assert.assertEquals("1234", json.get("password"));
        Assert.assertEquals("5554443322", json.get("phone"));
        Assert.assertEquals(0, json.getInt("userStatus"));

    }


    @Given("user put islemi icin request yollar")
    public void user_put_islemi_icin_request_yollar() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("password", 1234);

        response = given().contentType(ContentType.JSON).auth().basic("api_key", "1234").body(map)
                .when().put("https://petstore.swagger.io/v2/user/user");

    }
    @Given("user put sonrasi aldigi responsu yazdirir")
    public void user_put_sonrasi_aldigi_responsu_yazdirir() {
        response.prettyPrint();
    }
    @Given("user put dan gelen veriyi dogrular")
    public void user_put_dan_gelen_veriyi_dogrular() {
        JsonPath json = response.jsonPath();
        Assert.assertEquals(200, json.getInt("code"));
        Assert.assertEquals("unknown", json.get("type"));
        Assert.assertEquals("0", json.get("message"));

    }
    @Given("user delete islemi icin request yollar")
    public void user_delete_islemi_icin_request_yollar() {
        response = given().contentType(ContentType.JSON).auth().basic("api_key", "1234")
                .when().delete("https://petstore.swagger.io/#/user/createUsersWithListInput");

    }
    @Given("user delete sonrasi aldigi responsu yazdirir")
    public void user_delete_sonrasi_aldigi_responsu_yazdirir() {
        response.prettyPrint();
    }
    @Given("user silme isleminin yapildigini dogrular")
    public void user_silme_isleminin_yapildigini_dogrular() {
        JsonPath json = response.jsonPath();
        Assert.assertEquals(200, json.getInt("code"));
        Assert.assertEquals("unknown", json.get("type"));
        Assert.assertEquals("user", json.get("message"));

    }
}
