import org.example.DiscriminantSearch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("Тест класса DiscriminantSearch ")
public class DiscriminantSearchTest {

    @Test
    @DisplayName("b равен нулю")
    public void bIsEqualToZero() {
        double a = 1.0;
        double b = 0.0;
        double c = 1.0;
        DiscriminantSearch discriminantSearch = new DiscriminantSearch(a, b, c);

        double[] result = discriminantSearch.discriminantSearch(discriminantSearch.getA(),
                                                                discriminantSearch.getB(),
                                                                discriminantSearch.getC());
        double[] expected = new double[]{};

        assertArrayEquals(expected, result, 0.001); // 0.001 - допустимая погрешность
    }

}


