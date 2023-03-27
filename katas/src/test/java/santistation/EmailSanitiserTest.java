package santistation;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import santistation.decorator.EmailSanitiserDecorator;

class EmailSanitiserTest {
    @Test
    public void sanitiseEmail_WhenContainsEmailReturnsSanitised() {
        // chris@tescointerview.co.uk
        // chris@tescointerview.org

        String testEmail = "The is my test with email chris@tescointerview.co.uk, and some other text";
        String expected = "The is my test with email REDACTED, and some other text";

        MatcherAssert.assertThat(new EmailSanitiserDecorator(new BaseSanitiser(testEmail)).sanitise(testEmail), Matchers.equalTo(expected));

    }
}