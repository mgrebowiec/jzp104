package pl.sda.mg.jav104.jzp.streamssample;

public class Person {
    private final String name;
    private final String surname;
    private final int age;
    private final Sex sex;

    public Person(String name, String surname, int age, Sex sex) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
