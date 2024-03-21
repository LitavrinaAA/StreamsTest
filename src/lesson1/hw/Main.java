package lesson1.hw;

import lesson1.Streams;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = List.of(
                new Person("Dik", 25, 60000, new Department("IT")),
                new Person("Bob", 25, 60000, new Department("IT1")),
                new Person("Alice", 30, 50000, new Department("IT")),
                new Person("Charlie", 35, 70000, new Department("IT1")),
                new Person("Evgeniya", 49, 160000, new Department("IT2")),
                new Person("Greg", 25, 260000, new Department("IT3")),
                new Person("Zachar", 18, 590000, new Department("IT2")),
                new Person("Nastya", 35, 700000, new Department("IT3"))

        );
        Homework hw = new Homework();
        hw.printNamesOrdered(persons);
        hw.printDepartmentOldestPerson(persons);
        hw.findFirstPersons(persons);
        hw.findTopDepartment(persons);

    }
}
