import model.Person;
import model.PersonService;

import java.rmi.Naming;
import java.util.List;

public class Main {
    public static void main1(String[] args) throws Exception {
        PersonService personService = (PersonService) Naming.lookup("//localhost/personService");
        Person person = new Person();
        person.setId(999);
        person.setName("Reza");
        person.setFamily("Bahram");
        person.setSalary(100);
        personService.register(person);

    }
    public static void main(String[] args) throws Exception {
        PersonService personService = (PersonService) Naming.lookup("//localhost/personService");

        List<Person> personList = personService.getAll();

        for (Person person : personList) {
            System.out.println(person.getId());
            System.out.println(person.getName());
            System.out.println(person.getFamily());
            System.out.println(person.getSalary());
            System.out.println("******************");
        }


    }
}