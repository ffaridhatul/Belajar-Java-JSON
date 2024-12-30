package enigma_camp.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import enigma_camp.json.entity.Address;
import enigma_camp.json.entity.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.channels.SeekableByteChannel;
import java.util.List;

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

    @Test
    void deserializationFeature() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        String json = """
                    {"id":"1", "name":"Eko", "age":10, "hobbies":"Coding"}
                    """;


        Person person = objectMapper.readValue(json, Person.class);
        Assertions.assertEquals("1", person.getId());
        Assertions.assertEquals("Eko", person.getName());
        Assertions.assertEquals(List.of("Coding"), person.getHobbies());
    }

    @Test
    void serializationFeature() throws JsonProcessingException {
        Person person = new Person();

        person.setId("Indonesia");
        person.setName("Faridhatul Zikri");
        person.setHobbies(List.of("Coding", "Reading", "Traveling"));

        Address address = new Address();
        address.setStreet("Jalan Belum Jadi");
        address.setCity("Jakarta");
        address.setCountry("Indonesia");
        person.setAddress(address);

        ObjectMapper objectMapper = new ObjectMapper()
                .configure(SerializationFeature.INDENT_OUTPUT, true); //output Json menjadi lebih rapi bukan dalam 1 baris
        String json = objectMapper.writeValueAsString(person);

        System.out.println(json);

    }

    @Test
    void serializationInclusion() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper()
                .setSerializationInclusion(JsonInclude.Include.NON_NULL); // value null tidak akan di serialisasi

        Person person = new Person();
        person.setId("1");
        person.setName("Eko");

        String json = objectMapper.writeValueAsString(person);
        System.out.println(json);
    }


}
