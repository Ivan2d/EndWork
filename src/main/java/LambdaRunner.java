import java.util.function.BiFunction;
import java.util.function.Function;

public class LambdaRunner
{
    public static Object stringRun(Function<String, ?> lambda, String str){
        return lambda.apply(str);
    }

    public static <T extends Human> Boolean biFunctionRun(BiFunction<? super Human, ? super Human, Boolean> lambda, Human human1, Human human2){
        return lambda.apply(human1, human2);
    }

    public static <T extends Human> Object functionRun(Function<? super Human, ?> lambda, Human human){
        return lambda.apply(human);
    }

    public static Human oldHumanRun(Function<Human, Human> lambda, Human human){
        return lambda.apply(human);
    }

    public static Boolean checkAgeRun(EqualsHumansAndMaxAge lambda, Human human1, Human human2, Human human3, int maxAge){
        return lambda.checkHumansAndMaxAge(human1, human2, human3, maxAge);
    }
}
