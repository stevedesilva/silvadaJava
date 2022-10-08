package commonsense.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Given a positive integer of up to 16 digits, return true if it is a valid credit card number, and false if it is not.
 */
public class LuhnAlgorithm {
    // https://www.codewars.com/kata/5418a1dd6d8216e18a0012b2
    public static boolean isValidCreditCardNumber(long cardNumber) {
        return isValidCreditCardNumber(Long.toString(cardNumber));
    }

    public static boolean isValidCreditCardNumber(String cardNumber) {
        final int[] cardNumberArray = cardNumber.chars().map(c -> c - '0').toArray();
        for (int i = cardNumberArray.length - 2; i >= 0; i = i - 2) {
            cardNumberArray[i] = cardNumberArray[i] * 2;
        }

        // If a resulting number is greater than 9, replace it with the sum of its own digits (which is the same as subtracting 9 from it)
        for (int i = 0; i < cardNumberArray.length; i++) {
            int val = cardNumberArray[i];
            if (val > 9) {
                final int[] tmp = Long.toString(val).chars().map(c -> c - '0').toArray();
                cardNumberArray[i] = tmp[0] + tmp[1];
            }
        }
        // Sum all of the final digits:
        final int sum = Arrays.stream(cardNumberArray).reduce(0, Integer::sum);
        // Finally, take that sum and divide it by 10. If the remainder equals zero, the original credit card number is valid.
        return (sum % 10 == 0);

    }
}
