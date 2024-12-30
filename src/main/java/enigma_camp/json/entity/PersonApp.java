package enigma_camp.json.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class PersonApp {
    public static void main(String[] args) throws JsonProcessingException {
        Person person = new Person();

        person.setId("Indonesia");
        person.setName("Faridhatul Zikri");
        person.setHobbies(List.of("Coding", "Reading", "Traveling"));
        person.setAddress(new Address("Jl. Merdeka", "Jakarta", "Indonesia"));

        System.out.println(person);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(person);
        System.out.println(json);

    }
}
