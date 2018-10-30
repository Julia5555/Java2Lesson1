package WorkWithArray;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MyArrayDataException extends Exception {

    private String message;

    public MyArrayDataException(String message, Integer...indexes) {
        if(message == null)
            throw new NullPointerException("Необходимо указать требование к значению");
        List<Integer> indexesList = Arrays.stream(indexes).collect(Collectors.toList());
        if(!indexesList.stream().filter(Objects::isNull).collect(Collectors.toList()).isEmpty())
            throw new NullPointerException("Индексы не могут быть пустыми");
        String indexesToString = indexesList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        this.message = "Значение элемента массива в позиции " + indexesToString + " должно быть " + message;
    }

    public MyArrayDataException() {
        this.message = "Массив не может быть пустым";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
