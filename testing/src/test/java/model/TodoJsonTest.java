package model;

import com.jayway.jsonpath.JsonPath;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoJsonTest {

    @Test
    void shouldCompareJsons() throws JSONException {
        var data = getRestData();
        var expected = """
                {
                "todos": [
                   {
                    "name": "toddo1",
                    "completed": false
                   },
                   {
                    "name": "toddo2",
                    "completed": true                   
                    }
                ]
                }
                 """;

        JSONAssert.assertEquals(expected, data, false);

    }

    @Test
    void shouldCompareJsonPath() {
        var json = """
                {
                "todos": [
                   {
                    "name": "toddo1",
                    "completed": false
                   },
                   {
                    "name": "toddo2",
                    "completed": true                   
                    }
                ]
                }
                 """;

        Integer length =  JsonPath.read(json,"$.todos.length()");
        assertEquals(2, length);
        String name = JsonPath.read(json,"$.todos[0].name");
        assertEquals("toddo1", name);



    }


    private String getRestData() {

        return """
                {
                "todos": [
                   {
                    "completed": false,
                    "name": "toddo1"
                   },
                   {
                    "completed": true,
                    "name": "toddo2"                   
                    }
                ]
                }
                 """;
    }

}
