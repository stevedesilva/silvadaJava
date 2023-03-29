package santistation;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import santistation.decorator.SecretSanitiserDecorator;

class SecretSanitiserTest {
    @Test
    public void sanitiseProduct_WhenContainsSecretProductReturnsSanitisedString() {
        // "Secret X"
        // "Secret Y"

        String text = "The is my test with Secret:X, and some other text";
        String expected = "The is my test with REDACTED, and some other text";

//        String testEmail = "The is my test with email chris@tescointerview.co.uk, and some other text";
//        String expected = "The is my test with email REDACTED, and some other text";

        MatcherAssert.assertThat(new SecretSanitiserDecorator(new BaseSanitiser(text)).sanitise(text), Matchers.equalTo(expected));

    }
}