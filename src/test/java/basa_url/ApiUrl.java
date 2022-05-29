package basa_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class ApiUrl {
    protected RequestSpecification spec01;

    @Before
    public void setUp(){
        spec01=new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/").build();
    }
}
