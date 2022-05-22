package section6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaxCharacterTest {
    @Test
    public void shouldReturnMax9(){
        MaxCharacter maxCharacter = new MaxCharacter();
        Assertions.assertEquals("9",maxCharacter.getMaxWithCharArray("1213214125432499999"));
        Assertions.assertEquals("9",maxCharacter.getMaxWithCharMap("1213214125432499999"));
    }
    @Test
    public void shouldReturnMax1(){
        MaxCharacter maxCharacter = new MaxCharacter();
        Assertions.assertEquals("1",maxCharacter.getMaxWithCharArray("111234"));
        Assertions.assertEquals("1",maxCharacter.getMaxWithCharMap("111234"));

    }
    @Test
    public void shouldReturnE(){
        MaxCharacter maxCharacter = new MaxCharacter();
        Assertions.assertEquals("e",maxCharacter.getMaxWithCharArray("the quick brown fox jumped over the lazy dog"));
        Assertions.assertEquals("e",maxCharacter.getMaxWithCharMap("the quick brown fox jumped over the lazy dog"));
    }
}