import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TestCat {

    // private Cat cat;
    @Mock
    Feline feline;

    /* @Before
    public void run() {
        feline = new Feline();
        cat = new Cat(feline);
    } */

    @Test
    public void testGetFood() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        List<String> expectedGetFood = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actualGetFood = cat.getFood();
        assertEquals("The list of food is not the same", expectedGetFood, actualGetFood);
    }

    @Test
    public void testGetSoundCat() {
        Cat cat = new Cat(feline);
        String extendedGetSound = "Мяу";
        String actualGetSound = cat.getSound();
        Assert.assertEquals("The cat sound should not be as expected", extendedGetSound, actualGetSound);
    }

}
