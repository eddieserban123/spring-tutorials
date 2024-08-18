package model;

import com.example.model.Todo;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TodoHamcrestTest {


    @Test
    public void test() {
        var todo = new Todo("",true);
        assertThat(todo.completed(), equalTo(true));
    }

}
