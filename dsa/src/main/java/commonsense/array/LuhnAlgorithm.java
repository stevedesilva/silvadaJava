package commonsense.array;

import java.util.Arrays;

/**
 * Given a positive integer of up to 16 digits, return true if it is a valid credit card number, and false if it is not.
 */
public class LuhnAlgorithm {
    // https://www.codewars.com/kata/5418a1dd6d8216e18a0012b2
    public static boolean isValidCreditCardNumber(long cardNumber) {
        long[] cardNumberMod = Long.toString(cardNumber).chars().map(c -> c - '0').asLongStream().toArray();
        boolean flip = false;
        for (int i = cardNumberMod.length - 1; i >= 0; i--){
            if (flip) {
                // double
                cardNumberMod[i] = cardNumberMod[i] * 2;
            }
            flip = !flip;
        }

        // If a resulting number is greater than 9, replace it with the sum of its own digits (which is the same as subtracting 9 from it)
        for (int i = 0; i < cardNumberMod.length; i++) {
            long val = cardNumberMod[i];
            if (val > 9 ) {
                final long[] tmp = Long.toString(val).chars().map(c -> c - '0').asLongStream().toArray();
                cardNumberMod[i] = tmp[0] + tmp[1];
            }
        }
        // Sum all of the final digits:
        final long sum = Arrays.stream(cardNumberMod).reduce(0,(a, b) -> a + b);
        // Finally, take that sum and divide it by 10. If the remainder equals zero, the original credit card number is valid.
        boolean result = (sum % 10 == 0);
        return result;
    }
}
