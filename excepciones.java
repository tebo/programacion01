// ejemplo de manejo de excepciones

public class excepciones {
    public static void main(String[] args) {
        try {
            int a = 0;
            int b = 10;
            int c = b / a;
            System.out.println("El resultado es: " + c);
        } catch (ArithmeticException e) {
            System.out.println("Error -> " + e.getMessage());
        }
        try {
            int[] array = new int[5];
            array[10] = 50;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error -> " + e.getMessage());
        }

        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("Error -> " + e.getMessage());
        }

        try {
            int num = Integer.parseInt("XYZ");
            System.out.println(num);
        } catch (NumberFormatException e) {
            System.out.println("Error -> " + e.getMessage());
        }

        try {
            int[] arr = new int[-5];
        } catch (NegativeArraySizeException e) {
            System.out.println("Error -> " + e.getMessage());
        }
    }
}