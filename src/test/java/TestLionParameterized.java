import com.example.Feline;
import com.example.Lion;
import com.example.Predator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class TestLionParameterized {
    private final String lionGender;
    private final boolean expectedHasMane;

    public TestLionParameterized(String lionGender, boolean expectedHasMane) {
        this.lionGender = lionGender;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {

        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
                // {"Оно", false}
        };
    }

    @Test
    public void hasManeTest() throws Exception {
        Predator predator = new Feline();
        Lion lion = new Lion(predator, lionGender);
        boolean actualResult = lion.doesHaveMane();
        Assert.assertEquals("There should be another result of hasManeTest", expectedHasMane, actualResult);
    }
}

// код был таким
       /* try {
            Lion lion = new Lion(predator, lionGender);
            boolean actualHasMane = lion.doesHaveMane();
            assertEquals("Наличие гривы должно определяться полом льва.",
                    expectedHasMane, actualHasMane);
        } catch (Exception actualException) {
            assertEquals("Сообщение об исключении должно показывать, как выбрать пол льва.",
                    expectedException.getMessage(), actualException.getMessage());
        }
        */


