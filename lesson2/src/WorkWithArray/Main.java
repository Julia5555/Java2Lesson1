package WorkWithArray;

enum ElementArray{
    ROW(4),
    COLUMN(4);
    private Integer count;

    ElementArray(Integer count) {
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }
}

public class Main {

    private static Integer rowLength = ElementArray.ROW.getCount();
    private static Integer columnLength = ElementArray.COLUMN.getCount();

    public static void checkedArrayIsNotNull(String[][] myArray) throws MySizeArrayException, MyArrayDataException {
        if (myArray == null)
            throw new MyArrayDataException();

        if (myArray.length != rowLength)
            throw new MySizeArrayException("массива", rowLength);

        for (int i = 0; i < myArray.length; i++) {
            String[] row = myArray[i];
            if (row == null)
                throw new MyArrayDataException("массивом", i);

            if (row.length != columnLength)
                throw new MySizeArrayException("строки", columnLength);
        }
    }

    public static Integer getSumElements(String[][] myArray) throws MyArrayDataException, MySizeArrayException {
        checkedArrayIsNotNull(myArray);
        Integer sum = 0;
        Integer i = 0;
        Integer j = 0;
        try {
            for (i = 0; i < myArray.length; i++) {
                String[] row = myArray[i];
                for (j = 0; j < row.length; j++) {
                    sum += Integer.valueOf(row[j]);
                }
            }
        }catch(NumberFormatException e){
            throw new MyArrayDataException("числом",i,j);
        }
        return sum;
    }

    public static void main(String[] args) {
        String[][] matrixB = {
                {"1","2","3","4"},
                {"1","2","3", "4"},
                {"1","2","3", "4"},
                {"1","2","3", "4"}
        };

        Integer sum = 0;
        try {
            sum = getSumElements(matrixB);
            System.out.println("Сумма элементов массива равна "+ sum);
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        } catch (MySizeArrayException ex) {
            ex.printStackTrace();
        }
    }
}
