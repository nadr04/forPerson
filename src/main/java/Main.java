import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {

            List<Person> people = new ArrayList<>();
            people.add(new Person("Jonas", 25, "jonasjon@jovalas.com"));
            people.add(new Person("Ona", 30, "ona@shalambalam.com"));
            people.add(new Person("Petras", 35, "petras@one.lt"));

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(people);
            System.out.println("Serialized JSON String:\n" + jsonString);

            objectMapper.writeValue(new File("persons.json"), people);

            List<Person> deserializedPeople = objectMapper.readValue(
                    new File("persons.json"),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Person.class)
            );

            System.out.println("Deserialized List:");
            deserializedPeople.forEach(System.out::println);
            System.out.println("Lists match: " + people.equals(deserializedPeople));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}