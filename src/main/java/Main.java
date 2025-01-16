import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Person person = new Person("Jonas Jonaitis", 30, "jonasjon@jovalas.com");

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File("rezultatas.json"), person);

            System.out.println("Serialized JSON written to 'rezultatas.json'");

            Person deserializedPerson = objectMapper.readValue(new File("rezultatas.json"), Person.class);

            System.out.println("Deserialized Person: " + deserializedPerson);
            System.out.println("Objects match: " + person.equals(deserializedPerson));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
