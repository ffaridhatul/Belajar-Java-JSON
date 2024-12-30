package enigma_camp.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import enigma_camp.json.entity.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JsonToObject {

    @Test
    void createObjectFromJson() throws JsonProcessingException {
        String json = """
    {"id":"1","name":"Eko","hobbies":["Coding","Reading"],"address":{"street":"Jalan Belum Jadi","city":"Jakarta","country":"Indonesia"}}
    """;

        ObjectMapper objectMapper = new ObjectMapper();
        Person person = objectMapper.readValue(json, Person.class);

        Assertions.assertEquals("1", person.getId());
        Assertions.assertEquals("Eko", person.getName());
        Assertions.assertEquals("Jalan Belum Jadi", person.getAddress().getStreet());
        Assertions.assertEquals("Jakarta", person.getAddress().getCity());
        Assertions.assertEquals("Indonesia", person.getAddress().getCountry());
        Assertions.assertEquals(List.of("Coding", "Reading"), person.getHobbies());
    }

}
