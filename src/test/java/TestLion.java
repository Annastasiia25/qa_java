import com.example.Feline;
import com.example.Lion;
import com.example.Predator;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
        // (Parameterized.class)  - я его вывела в отдельный класс теста TestLionParameterized
public class TestLion {

    @Mock
    Feline feline;
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void ConstructorThrowException() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("Используйте допустимые значения пола животного - самец или самка");
        Predator predator = new Feline();
        new Lion(predator, "Мясо");
    }

   @Test
    public void getKittensReturnTrueMethod() throws Exception {
       // Predator predator = new Feline();
        Lion lion = new Lion(feline, "Самец");
       // int expectedLionKittens = feline.getKittens();
        //int actualLionKittens = lion.getKittens();
        Mockito.when(feline.getKittens()).thenReturn(2);
        assertEquals("У льва должно быть столько же котят, сколько у кошачьих", 2, lion.getKittens());
    }

    @Test
    public void doesHaveManeReturnTrueField() throws Exception {
        Predator predator = new Feline();
        Lion lion = new Lion(predator, "Самка");
        boolean expectedLionMane = false;
        boolean actualLionMane = lion.doesHaveMane();
        assertEquals("У льва по умолчанию нет гривы", expectedLionMane, actualLionMane);
    }

    @Test
    public void getFoodReturnTrueMethod() throws Exception {
        Predator predator = new Feline();
        Lion lion = new Lion(predator, "Самец");
        List<String> expectedLionFood = predator.eatMeat();
        List<String> actualLionFood = lion.getFood();
        assertEquals("Лев есть такую же еду, что и хищник", expectedLionFood, actualLionFood);
    }
}