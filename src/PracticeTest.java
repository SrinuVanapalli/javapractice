import java.util.*;

public class PracticeTest {

    static class MyException extends Exception {

        MyException(String message) {
            super(message);
        }
    }


    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};

        try {
            int index = 5;
            if (index >= arr.length) {
                throw new MyException(" Index " + index + " is not present");
            }
            System.out.println(arr[index]);

        } catch (MyException e) {
            System.out.println(e.getMessage());
        }

    }

}
