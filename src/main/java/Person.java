import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="person")
@XmlRootElement
public class Person {
    public String firstname;
    public String lastname;
    public Integer age;
    public String email;

    public Person(){

    }
}
