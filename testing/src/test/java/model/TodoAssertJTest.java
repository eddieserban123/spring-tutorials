package model;

import com.example.model.Todo;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TodoAssertJTest {

    @Test
    void shouldCreateNewTodo() {
        var todo = new Todo("TEST", true);

        assertThat(todo.name())
                .startsWith("T")
                .endsWith("T")
                .contains("ES")
                .isEqualToIgnoringCase("TEst");

    }
}
