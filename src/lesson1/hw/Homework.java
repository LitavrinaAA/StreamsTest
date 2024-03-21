package lesson1.hw;


import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Homework {


    /**
     * Реалзиовать методы, описанные ниже:
     */

    /**
     * Вывести на консоль отсортированные (по алфавиту) имена персонов
     */
    public  void printNamesOrdered(List<Person> persons) {
        // ...
        persons.stream()
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);
    }

    /**
     * В каждом департаменте найти самого взрослого сотрудника.
     * Вывести на консоль мапипнг department -> personName
     * Map<Department, Person>
     */
    public Map<Department, Person> printDepartmentOldestPerson(List<Person> persons) {

        Map<Department, Person> oldestInDepartment =  persons.stream().
                collect(Collectors.toMap(
                        Person::getDepartment,
                        Function.identity(),
                        BinaryOperator.maxBy(Comparator.comparing(Person::getAge))
                ))
                ;
        oldestInDepartment.forEach((department, person) ->
                System.out.println("Department: " + department.getName() + ", Oldest Employee: " + person.getName())
        );
        return oldestInDepartment;

    }

    /**
     * Найти 10 первых сотрудников, младше 30 лет, у которых зарплата выше 50_000
     */
    public List<Person> findFirstPersons(List<Person> persons) {
        return persons.stream()
                .filter(p -> p.getAge() < 30 && p.getSalary() > 50000)
                .limit(10)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    /**
     * Найти депаратмент, чья суммарная зарплата всех сотрудников максимальна
     */
    public Optional<Department> findTopDepartment(List<Person> persons) {
        Map<Department, Double> salariesDepartment = persons.stream()
                .collect(Collectors.groupingBy(
                        Person::getDepartment,
                        Collectors.summingDouble(Person::getSalary)
                ));
        Department departmentWithMaxTotalSalary = salariesDepartment.entrySet().stream()
                .max(Comparator.comparingDouble(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse(null);

        System.out.println("Department with the highest total salary: " + departmentWithMaxTotalSalary.getName());
        return Optional.of(departmentWithMaxTotalSalary);
    }

}
