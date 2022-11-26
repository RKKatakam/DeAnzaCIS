package Main.People;

import java.util.Objects;
import java.util.UUID;

public class Person {
    private final String name;
    private final String id;

    public Person(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }


    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getName().equals(person.getName()) && getId().equals(person.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getId());
    }
}
