package Practice_1;

import java.util.function.Predicate;
import java.util.regex.Pattern;


public interface EmailPredicate extends Predicate<String> {
    String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@(.+)$";

    @Override
    default boolean test(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        return pattern.matcher(email).matches();
    }
}
