package enigma_camp.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class CreateJson {

    @Test
    void crateJsonTest() throws JsonProcessingException {
        Map<String, Object> person = Map.of(
                "name", "John Doe",
                "age", 30,
                "email", "n2q7S@example.com"
        );
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(person);
        System.out.println(json);
    }
}
