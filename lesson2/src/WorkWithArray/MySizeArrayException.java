package WorkWithArray;

public class MySizeArrayException extends Exception {
    private String message;

    public MySizeArrayException(String params, Integer size) {
        if(params == null || size == null)
            throw new NullPointerException("Укажите params, size");
        this.message = "Размер " + params + " должен быть равен "+ size;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
