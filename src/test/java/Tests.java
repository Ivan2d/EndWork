import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.junit.Test;
import static org.junit.Assert.*;


public class Tests
{

    String s1 = "hello";
    String s2 = "hello world";
    String s3 = "Hi, my, name, is, Petr";

    Human human1 = new Human("Р", "Ай", "Оч", 19 , Gender.MAN);
    Student human2 = new Student("Иванов", "Иван", "Иванович", 23, Gender.MAN, "омгу", "имит", "мпб");

    Human human3 = new Human("Рой", "Ин", "ю", 19, Gender.MAN);
    Human human4 = new Human("Ач", "Нта", "ю", 19, Gender.MAN);

    @Test
    public void ITaskTest(){
        Function<String, Integer> lambda = LambdaDemo.getLengthOfString;
        assertEquals(Optional.of(5), Optional.ofNullable(LambdaRunner.run(lambda, s1)));
    }

    @Test
    public void IITaskTest(){
        Function<String, Character> lambda = LambdaDemo.getFirstElem;
        assertEquals(Optional.of('h'),Optional.ofNullable(LambdaRunner.run(lambda,s1)));
    }

    @Test
    public void IIITaskTest(){
        Function<String, Boolean> lambda = LambdaDemo.haveSpace;
        assertEquals(false, LambdaRunner.run(lambda,s2));
    }

    @Test
    public void IVTaskTest(){
        Function<String, Integer> lambda = LambdaDemo.countWordsInString;
        assertEquals(Optional.of(5), Optional.ofNullable(LambdaRunner.run(lambda,s3)));
    }

    @Test
    public void VTaskTest(){
        Function<? super Human, Integer> lambda = LambdaDemo.getAgeOfHuman;
        assertEquals(Optional.of(19), Optional.ofNullable(LambdaRunner.run(lambda,human1)));
        assertEquals(Optional.of(23), Optional.ofNullable(LambdaRunner.run(lambda,human2)));
    }

    @Test
    public void VITaskTest(){
        BiFunction<? super Human, ? super Human, Boolean> lambda = LambdaDemo.equalsLastName;
        assertEquals(false,LambdaRunner.biFunctionRun(lambda, human1, human2));
    }

    @Test
    public void VIITaskTest(){
        Function<? super Human, String> lambda = LambdaDemo.makeStringHuman;
        assertEquals("Р Ай Оч", LambdaRunner.run(lambda,human1));
        assertEquals("Иванов Иван Иванович", LambdaRunner.run(lambda, human2));
    }

    @Test
    public void VIIITaskTest(){
        Function<Human,Human> lambda = LambdaDemo.getOlder;
        assertEquals(20, LambdaRunner.run(lambda, human1).getAge());
        assertEquals(24, LambdaRunner.run(lambda, human2).getAge());
    }

    @Test
    public void IXTaskTest(){
        int maxAge1 = 20;
        int maxAge2 = 18;

        assertTrue(LambdaDemo.equalsAge.checkHumansAndMaxAge(human1, human3, human4, maxAge1));
        assertFalse(LambdaDemo.equalsAge.checkHumansAndMaxAge(human1, human3, human4, maxAge2));
    }

    @Test
    public void XTaskTest()
    {
        assertFalse(LambdaRunner.checkAgeRun(LambdaDemo.equalsAge, human1, human2, human3, 20));
    }
}
