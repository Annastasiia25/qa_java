import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestCat {

    @Mock
    private Cat cat;
    private Feline feline;

    @Before
    public void run() {
        feline = new Feline();
        cat = new Cat(feline);
    }

    @Test
    public void testGetFood() throws Exception {
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), cat.getFood());
    }

    @Test
    public void testGetSoundCat() {
        Assert.assertEquals("Мяу", cat.getSound());
    }

}
