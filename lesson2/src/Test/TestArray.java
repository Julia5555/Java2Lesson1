package Test;
import WorkWithArray.MyArrayDataException;
import WorkWithArray.MySizeArrayException;
import org.junit.Test;

import static WorkWithArray.Main.checkedArrayIsNotNull;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestArray {

    @Test
    public void testArray() throws MyArrayDataException{
        String[][] matrixB = {
                {"1","ss2","3"},
                {"1","2","3"},
                {"1","2","3"},
                {"1","2"}
        };

        try {
            checkedArrayIsNotNull(matrixB);
        } catch (MySizeArrayException e) {
            assertThat(e.getMessage(),is("Размер строки должен быть равен 4"));
        }
    }

    @Test
    public void testArray2() throws MyArrayDataException{
        String[][] matrixB = {
                {"1","ss2","3","4"},
                {"1","2","3","5"}
        };

        try {
            checkedArrayIsNotNull(matrixB);
        } catch (MySizeArrayException e) {
            assertThat(e.getMessage(),is("Размер массива должен быть равен 4"));
        }
    }

    @Test
    public void testArray3() throws MySizeArrayException {
        String[][] matrixB = null;

        try {
            checkedArrayIsNotNull(matrixB);
        } catch (MyArrayDataException e) {
            assertThat(e.getMessage(),is("Массив не может быть пустым"));
        }
    }

    @Test
    public void testArray4() throws MySizeArrayException {
        String[][] matrix = {
                {"1",null,"2","3"},
                {"1","2","3", "4"},
                {"1","2","3","4"},
                {"1","2","3","4"}
        };

        try {
            checkedArrayIsNotNull(matrix);
        } catch (MyArrayDataException e) {
            assertThat(e.getMessage(),is("Значение элемента массива в позиции 0, 1 должно быть числом"));
        }
    }

    @Test
    public void testArray5() throws MySizeArrayException {
        String[][] matrix = {
                {"1","4","2","3"},
                {"1","2","3", "4"},
                null,
                {"1","2","3","4"}
        };

        try {
            checkedArrayIsNotNull(matrix);
        } catch (MyArrayDataException e) {
            assertThat(e.getMessage(),is("Значение элемента массива в позиции 2 должно быть массивом"));
        }
    }
}
