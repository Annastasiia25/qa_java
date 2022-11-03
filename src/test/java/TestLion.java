import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class TestLion {

    @Mock
    Feline feline;

   @Test
    public void getKittensReturnTrueMethod() throws Exception {
       Lion lion = new Lion(feline, "Самец");
       int expected = 2;
       Mockito.when(feline.getKittens()).thenReturn(expected);
       int actual = lion.getKittens();
       Assert.assertEquals("Ожидаемый результат не соответствует", expected, actual);
   }

    @Test
    public void doesHaveManeReturnTrueField() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        boolean expectedLionMane = false;
        boolean actualLionMane = lion.doesHaveMane();
        assertEquals("У львицы по умолчанию нет гривы", expectedLionMane, actualLionMane);
    }

    @Test(expected = Exception.class)
    public void constructorThrowsExceptionUnsupportedSex() throws Exception {
        Lion lion = new Lion (feline, "Слон");
        lion.doesHaveMane();
    }
    @Test
    public void shouldBeException() {
        Feline feline = new Feline();
        Throwable exception = assertThrows(Exception.class, () -> new Lion(feline, "Оно"));
        Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

     @Test
        public void getFoodReturnTrueMethod () throws Exception {
             Lion lion = new Lion(feline, "Самец");
             List<String> expected = List.of("Животные", "Птицы", "Рыба");
             Mockito.when(feline.getFood("Хищник")).thenReturn(expected);
             List<String> actual = lion.getFood();
             Assert.assertEquals("Ожидаемый результат не соответствует", expected, actual);
         }
     }
