import java.util.function.BiFunction;
import java.util.function.Function;

@FunctionalInterface
interface EqualsHumansAndMaxAge{
    boolean checkHumansAndMaxAge(Human h1, Human h2, Human h3, int maxAge);
}

public class LambdaDemo
{
    public static final BiFunction<? super Human, ? super Human, Boolean> equalsLastName = (h1, h2) -> h1.getSurname().equals(h2.getSurname());
    public static final Function<String, Integer> getLengthOfString = String::length;
    public static final Function<String, Character> getFirstElem = (s) -> (s.isEmpty() ? null : s.charAt(0));
    public static final Function<String, Boolean> haveSpace = (s) -> (!s.contains(" "));
    public static final Function<String, Integer> countWordsInString = (s)-> s.split(",").length;
    public static final Function<? super Human, Integer> getAgeOfHuman = Human::getAge;
    public static final Function<? super Human, String> makeStringHuman = (h) -> String.format("%s %s %s",h.getSurname(), h.getName(), h.getPatronymic());
    public static final Function<Human, Human> getOlder = (h) -> new Human(h.getSurname(),h.getName(), h.getPatronymic(), h.getAge() + 1, h.getGender());
    public static final EqualsHumansAndMaxAge equalsAge = (h1,h2,h3,maxAge) -> (h1.getAge() < maxAge && h2.getAge() < maxAge && h3.getAge() < maxAge);

}

