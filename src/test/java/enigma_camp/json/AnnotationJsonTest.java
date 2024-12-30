package enigma_camp.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import enigma_camp.json.entity.Address;
import enigma_camp.json.entity.Person;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AnnotationJsonTest {

    @Test
    void annotation() throws JsonProcessingException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        ObjectMapper objectMapper = new ObjectMapper()
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .setDateFormat(dateFormat); // Mengubah date format dari milis ke String yyyy-MM-dd HH:mm:ss

        Person person = getPerson();

        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        String json = objectMapper.writeValueAsString(person);
        System.out.println(json);
    }

    private static Person getPerson() {
        Person person = new Person();

        person.setId("1");
        person.setName("Eko");
        person.setFullName("Eko Kurniawan");
        person.setPassword("123456");
        Address address = new Address();
        address.setStreet("Jl. Merdeka");
        address.setCity("Jakarta");
        address.setCountry("Indonesia");
        person.setAddress(address);
        person.setHobbies(List.of("Coding", "Reading"));
        person.setCreatedAt(new Date());
        person.setUpdatedAt(new Date());
        return person;
    }
}
