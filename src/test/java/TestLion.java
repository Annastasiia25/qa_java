import com.example.Feline;
import com.example.Lion;
import com.example.Predator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestLion {

    private final String lionGender;
    private final boolean expectedHasMane;

    public TestLion(String lionGender, boolean expectedHasMane) {
        this.lionGender = lionGender;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {

        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
                {"Оно", false}
        };
    }

    @Test
    public void lionConstructorInitializesManeField() throws Exception {
        Exception expectedException = new Exception("Используйте допустимые значения пола животного - самец или самка");
        try {
            Lion lion = new Lion(lionGender);
            boolean actualHasMane = lion.doesHaveMane();
            assertEquals("Наличие гривы должно определяться полом льва.",
                    expectedHasMane, actualHasMane);
        } catch (Exception actualException) {
            assertEquals("Сообщение об исключении должно показывать, как выбрать пол льва.",
                    expectedException.getMessage(), actualException.getMessage());
        }

    }
// попробовала расписать тесты без assertThrows

    @Test
    public void getKittensReturnTrueMethod() {
        Predator predator = new Feline();
        Lion lion = new Lion(predator);
        int expectedLionKittens = predator.getKittens();
        int actualLionKittens = lion.getKittens();
        assertEquals("У льва должно быть столько же котят, сколько у хищника", expectedLionKittens, actualLionKittens);
    }

    @Test
    public void doesHaveManeReturnTrueField() {
        Predator predator = new Feline();
        Lion lion = new Lion(predator);
        boolean expectedLionMane = false;
        boolean actualLionMane = lion.doesHaveMane();
        assertEquals("У льва по умолчанию нет гривы", expectedLionMane, actualLionMane);
    }

    @Test
    public void getFoodReturnTrueMethod() throws Exception {
        Predator predator = new Feline();
        Lion lion = new Lion(predator);
        List<String> expectedLionFood = predator.eatMeat();
        List<String> actualLionFood = lion.getFood();
        assertEquals("A lion should eat the same food as a predator", expectedLionFood, actualLionFood);
    }
}