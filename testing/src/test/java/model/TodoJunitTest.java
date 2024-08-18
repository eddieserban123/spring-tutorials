package model;

import com.example.model.Todo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TodoJunitTest {

    @Test
    void shouldCreateNewTodo(){
        var test = new Todo("TEST", true);
        assertEquals("TEST", test.name(), "todo name not equal to TEST");
        assertFalse(test.completed());
    }


}
