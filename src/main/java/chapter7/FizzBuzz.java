package chapter7;

public class FizzBuzz {

    public String[] execute(int num) {
        String[] result = new String[num];
        for (int i = 0; i < num; i++) {
            int n = i+1;
            if (n % 5 == 0 && n % 3 == 0) {
                result[i] = "FizzBuzz";
            } else if (n % 5 == 0) {
                result[i] = "Buzz";
            } else if (n % 3 == 0) {
                result[i] = "Fizz";
            } else {
                result[i] = String.valueOf(n);
            }
        }

        return result;
    }


}
