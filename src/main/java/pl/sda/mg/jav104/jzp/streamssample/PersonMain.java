package pl.sda.mg.jav104.jzp.streamssample;

import java.util.*;
import java.util.stream.Collectors;

public class PersonMain {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("aadam", "kowalski", 21, Sex.MALE),
                new Person("jacek", "kowalski", 51, Sex.MALE),
                new Person("gaacek", "suri", 16, Sex.MALE),
                new Person("iwona", "kowalska", 21, Sex.FEMALE),
                new Person("judyta", "kowalska", 16, Sex.FEMALE),
                new Person("iwonaa", "bedzin", 21, Sex.FEMALE),
                new Person("ewa", "lis", 53, Sex.FEMALE)
        );

        List<Person> personsWithAge = getPersonsWithAge(persons, 21);
        System.out.println("Osoby majace 21 lat:\n" + personsWithAge);

        List<Person> personsWithDoubledCharacter = getPersonsWithNameContainingDoubleCharacter(persons, "a");
        System.out.println("Osoby ze zdublowanym a:\n" + personsWithDoubledCharacter);

        List<String> personsFullName = getPersonsFullNameWithAgeAndSex(persons, 16, Sex.MALE);
        System.out.println("Nazwy osob spelniajace kryteria:\n" + personsFullName);

        Person person = getPersonWithGivenCriteria(persons, 16, Sex.FEMALE, "a");
        System.out.println("Znaleziona osoba:\n" + person);

        List<String> personsNames = getPersonsFullNameWithSexAndSortedByAgeAsc(persons, Sex.FEMALE);
        System.out.println("Osoby przefiltrowane, posortowane i zmapowane:\n" + personsNames);

        int ageOfAllPeople = countAge(persons);
        System.out.println("Wiek wszystkich: " + ageOfAllPeople);
    }

    private static int countAge(List<Person> persons) {
        return persons.stream()
                .map(person -> person.getAge())
                .reduce(0, Integer::sum);
//                .collect(Collectors.summingInt(Integer::intValue));

    }

    private static List<String> getPersonsFullNameWithSexAndSortedByAgeAsc(List<Person> persons, Sex sex) {
        return persons.stream()
                .filter(person -> person.getSex() == sex)
                .sorted(Comparator.comparing(Person::getAge))
                .map(person -> mapToString(person))
                .collect(Collectors.toList());
    }

    private static List<Person> getWomens(List<Person> persons) {
        return persons.stream()
                .filter(person -> person.getSex() == Sex.FEMALE && person.getName().endsWith("a"))
                .collect(Collectors.toList());
    }

    private static List<Person> getAdults(List<Person> persons) {
        return persons.stream()
                .filter(person -> person.getAge() > 18)
                .collect(Collectors.toList());
    }

    private static Person getPersonWithGivenCriteria(List<Person> persons, int age, Sex sex, String partOfName) {
        return persons.stream()
                .filter(person -> person.getAge() == age && person.getSex() == sex && person.getName().contains(partOfName))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Nie znaleziono osoby spelniajacej podane kryteria!"));
    }

    private static List<String> getPersonsFullNameWithAgeAndSex(List<Person> persons, int age, Sex sex) {
        return persons.stream()
                .filter(person -> person.getAge() == age && person.getSex() == sex)
//                .map(PersonMain::mapToString) // mapowanie Person na String
//                .map(person -> person.getName() + " " + person.getSurname()) // mapowanie Person na String
                .map(person -> mapToString(person))
                .collect(Collectors.toList());
    }

    private static String mapToString(Person person) {
        return person.getName() + " " + person.getSurname();
    }

    private static List<Person> getPersonsWithAge(List<Person> persons, int age) {
        return persons.stream()
                .filter(person -> person.getAge() == age)
                .collect(Collectors.toList());
    }

    private static List<Person> getPersonsWithNameContainingDoubleCharacter(List<Person> persons, String charToSearch) {
        return persons.stream()
                .filter(person -> containsDoubleCharacter(person, charToSearch))
                .collect(Collectors.toList());
    }

    private static boolean containsDoubleCharacter(Person person, String charToSearch) {
        int lastIndex = -2;
        int actualIndex = 0;

        actualIndex = person.getName().indexOf(charToSearch, lastIndex);
        while (actualIndex >= 0) {
            if (actualIndex - 1 == lastIndex) {
                return true;
            }

            lastIndex = actualIndex;
            actualIndex = person.getName().indexOf(charToSearch, lastIndex + 1);
        }

        return false;
    }
}
