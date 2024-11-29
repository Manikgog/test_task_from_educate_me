import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int number1;
        int number2;
        char operation;
        String[] input;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            input = reader.readLine().strip().split(" ");
        }
        checkInput(input);

        number1 = Integer.parseInt(input[0]);
        number2 = Integer.parseInt(input[2]);
        operation = input[1].charAt(0);

        System.out.println(performOperation(number1, number2, operation));
    }

    public static int performOperation(int number1, int number2, char operation) {
        switch (operation) {
            case '+' -> {
                return number1 + number2;
            }
            case '-' -> {
                return number1 - number2;
            }
            case '*' -> {
                return number1 * number2;
            }
            case '/' -> {
                return number1 / number2;
            }
        }
        return 0;
    }

    public static void checkInput(String[] input) {
        if(input.length != 3){
            throw new RuntimeException("Input error");
        }
        int number1 = Integer.parseInt(input[0]);
        int number2 = Integer.parseInt(input[2]);
        char operation = input[1].charAt(0);
        StringBuilder errorMessage = new StringBuilder();
        if(operation != '+' && operation != '-' && operation != '*' && operation != '/' || input[1].length() > 1){
            errorMessage.append("Invalid operation. ");
        }
        if(number1 < 0 || number1 > 10){
            errorMessage.append("First number is out of range (1-10). ");
        }
        if(number2 < 0 || number2 > 10){
            errorMessage.append("Second number is out of range (1-10).");
        }
        if(!errorMessage.isEmpty()){
            throw new RuntimeException(errorMessage.toString());
        }
    }
}
