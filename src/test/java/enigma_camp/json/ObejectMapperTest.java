package enigma_camp.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ObejectMapperTest {

    @Test
    void createObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        Assertions.assertNotNull(objectMapper);
    }
}
