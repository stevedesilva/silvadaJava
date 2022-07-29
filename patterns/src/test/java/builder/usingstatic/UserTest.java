package builder.usingstatic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    public void shouldBuildUser(){
        final User.Builder builder = new User.Builder("Steve","de Silva");
        builder.age(90);
        builder.address("Somewhere over the rainbow");
        builder.phoneNumber("999-999-999");


        User user = builder.build();


        Assertions.assertEquals("Steve", user.getFirstName());
        Assertions.assertEquals("de Silva", user.getLastName());
        Assertions.assertEquals(90, user.getAge());
        Assertions.assertEquals("999-999-999", user.getPhoneNumber());
        Assertions.assertEquals("Somewhere over the rainbow", user.getAddress());
    }

    @Test
    public void shouldBuildUserWithSingleConstructor(){
        final User.Builder builder = new User.Builder();
        builder.firstName("Steve");
        builder.lastName("de Silva");
        builder.age(90);
        builder.address("Somewhere over the rainbow");
        builder.phoneNumber("999-999-999");


        User user = builder.build();


        Assertions.assertEquals("Steve", user.getFirstName());
        Assertions.assertEquals("de Silva", user.getLastName());
        Assertions.assertEquals(90, user.getAge());
        Assertions.assertEquals("999-999-999", user.getPhoneNumber());
        Assertions.assertEquals("Somewhere over the rainbow", user.getAddress());
    }

}