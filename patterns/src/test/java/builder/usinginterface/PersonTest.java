package builder.usinginterface;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PersonTest {

    @Test
    public void shouldBuildUser() {
        Person person = new DefaultPerson.Builder("Steve", "de Silva")
                .address("Somewhere over the rainbow")
                .age(90)
                .phoneNumber("999-999-999")
                .build();

        Assertions.assertEquals("Steve", person.getFirstName());
        Assertions.assertEquals("de Silva", person.getLastName());
        Assertions.assertEquals(90, person.getAge());
        Assertions.assertEquals("999-999-999", person.getPhoneNumber());
        Assertions.assertEquals("Somewhere over the rainbow", person.getAddress());
    }

}