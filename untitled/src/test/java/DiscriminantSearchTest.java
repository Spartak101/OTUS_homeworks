import org.example.DiscriminantSearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("Тест класса DiscriminantSearch ")
public class DiscriminantSearchTest {
    double epsilon = 0.0000000001;

    @Test
    @DisplayName("Дискриминант меньше нулю")
    public void discriminantIsLessThanZero() {
        double a = 1.0;
        double b = 0.0;
        double c = 1.0;
        DiscriminantSearch discriminantSearch = new DiscriminantSearch(a, b, c, epsilon);

        double[] result = discriminantSearch.discriminantSearch(discriminantSearch.getA(),
                                                                discriminantSearch.getB(),
                                                                discriminantSearch.getC(),
                                                                discriminantSearch.getEpsilon());
        double[] expected = new double[]{};

        assertArrayEquals(expected, result, 0.001); // 0.001 - допустимая погрешность
    }

    @Test
    @DisplayName("Дискриминант больше нуля")
    public void discriminantIsGreaterThanZero() {
        double a = 1.0;
        double b = 0.0;
        double c = -1.0;
        double d = (b * b - 4 * a * c);
        DiscriminantSearch discriminantSearch = new DiscriminantSearch(a, b, c, epsilon);

        double[] result = discriminantSearch.discriminantSearch(discriminantSearch.getA(),
                                                                discriminantSearch.getB(),
                                                                discriminantSearch.getC(),
                                                                discriminantSearch.getEpsilon());
        double[] expected = new double[]{(-b+Math.sqrt(d))/(2*a),(-b-Math.sqrt(d))/(2*a)};

        assertArrayEquals(expected, result, 0.001); // 0.001 - допустимая погрешность
    }

    @Test
    @DisplayName("Дискриминант равен нулю")
    public void discriminantIsZero() {
        double a = 1.0;
        double b = 2.0;
        double c = 0.99999999998;
        DiscriminantSearch discriminantSearch = new DiscriminantSearch(a, b, c, epsilon);

        double[] result = discriminantSearch.discriminantSearch(discriminantSearch.getA(),
                                                                discriminantSearch.getB(),
                                                                discriminantSearch.getC(),
                                                                discriminantSearch.getEpsilon());
        double[] expected = new double[]{(-b)/(2*a),(-b)/(2*a)};

        assertArrayEquals(expected, result, 0.001); // 0.001 - допустимая погрешность
    }

    @Test
    @DisplayName("а не равен нулю")
    public void aIsNotEqualToZero() {
        double a = 0.0;
        double b = 1.0;
        double c = 1.0;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new DiscriminantSearch(a, b, c, epsilon);
        });
    }

}


