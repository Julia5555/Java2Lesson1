public class Main {
    static final int size = 10000000;
    static final int h = size / 2;

   public static void printTime(String text, long timeOn, long timeOff){
       System.out.println(String.format(text+ "%s", (timeOff-timeOn)));
   }


   public static void methodFirst(){
       float[] arr = new float[size];

       for (int i = 0; i < size; i++) {
           arr[i] = 1;
       }

       long timeOn = System.currentTimeMillis();
       fillArray(arr);
       printTime("Время заполнения массива последовательно: ", timeOn, System.currentTimeMillis());
   }

   public static void fillArray(float[] array){
       for (int i = 0; i < array.length; i++) {
           array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
       }
   }

    public static void methodSecond(){
        float[] arr = new float[size];
        float[] a1 = new float[h];
        float[] a2 = new float[h];

        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        long timeStart = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread t1 = new Thread(() -> fillArray(a1));
        Thread t2 = new Thread(() -> fillArray(a2));
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.println("Время работы массива параллельно: " + (System.currentTimeMillis()-timeStart));
    }

    public static void main(String[] args) {
       methodFirst();
       methodSecond();
    }

}
