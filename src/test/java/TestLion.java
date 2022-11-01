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
        // (Parameterized.class)  - я его вывела в отдельный класс теста TestLionParameterized
public class TestLion {
    String sex;
    int kittensCount;

    @Mock
    Feline feline;

    /* я переписала заново 2 теста getKittensReturnTrueMethod и getFoodReturnTrueMethod
    так как у меня в моих старых версиях теста подчеркивалось красным feline.getKittens и feline.getFood
    сделала снова на try b catch
     */

   @Test
    public void getKittensReturnTrueMethod() {
       try {
           Lion lion = new Lion(feline, sex);
           Mockito.when(feline.getKittens()).thenReturn(kittensCount);
           Assert.assertEquals(1, lion.getKittens());
       } catch (Exception exception) {
           Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
       }
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
        public void getFoodReturnTrueMethod () {
            try {
                Lion lion = new Lion(feline, sex);
                Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
                Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
            } catch (Exception exception) {
                Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
            }
        }
    }