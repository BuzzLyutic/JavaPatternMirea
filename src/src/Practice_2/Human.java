package Practice_2;

import java.time.LocalDate;

public class Human {
    int age;
    String firstName;
    String lastName;
    LocalDate birthDate;
    int weight;

    public Human(int age, String firstName, String lastName, LocalDate birthDate, int weight) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void print() {
        System.out.println("Name: " + this.firstName + " " + this.lastName);
        System.out.println("age: " + this.age + " " + birthDate);
        System.out.println("Weight: " + this.weight);
        System.out.println();
    }
}
