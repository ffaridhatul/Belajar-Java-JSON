package enigma_camp.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import enigma_camp.json.entity.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.fasterxml.jackson.databind.MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES;

public class MapperFeatureTest {
    @Test
    void mapperFeature() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

        String json = """
                {"ID":"1","Name":"Eko"}
                """;

        Person person = objectMapper.readValue(json, Person.class);
        Assertions.assertEquals("1", person.getId());
        Assertions.assertEquals("Eko", person.getName());
    }

}
