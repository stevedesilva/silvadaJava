package santistation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordSanitiserTest {
    @Test
    public void sanitiseProduct_WhenContainsSecretProductReturnsSanitisedString() {
        // "Secret X"
        // "Secret Y"

        String text = "The is my test with email Secret X, and some other text";
        String expected = "The is my test with email REDACTED, and some other text";

//        Sanitiser sanitiser = new SecretProductSanitiser();
//
//        String result = sanitiser.sanitise(text);
//        assertEquals(result,expected);

    }
}