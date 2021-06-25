import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class XMLDecifer {
    public static void readXML(String path) throws JAXBException, IOException {
        String content=new String(Files.readAllBytes(Path.of(path)));
        StringReader reader=new StringReader(content);

        JAXBContext context=JAXBContext.newInstance(Person.class);
        Unmarshaller unmarshaller=context.createUnmarshaller();

        Person person=(Person) unmarshaller.unmarshal(reader);

        System.out.println("Firstname: "+person.firstname+"\n" +
                "Lastname: "+person.lastname+"\n"+
                "Age "+person.age+"\n" +
                "Email: "+person.email);
    }
}
