package Practice_1;


import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Predicate<String> emailPredicate = new EmailPredicate() {
        };
        System.out.println(emailPredicate.test("vovik2012@mail.com"));
        System.out.println(emailPredicate.test("vovik2012mail.com"));

    }
}
