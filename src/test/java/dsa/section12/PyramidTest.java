package dsa.section12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PyramidTest {

    @Test
    public void noStep(){
        Assertions.assertEquals(List.of(), new Pyramid().buildIterative(0));
        Assertions.assertEquals(List.of(), new Pyramid().buildRecursive(0));
    }

    @Test
    public void oneStep(){
        Assertions.assertEquals(List.of("#"), new Pyramid().buildIterative(1));
        Assertions.assertEquals(List.of("#"), new Pyramid().buildRecursive(1));
    }

    @Test
    public void twoStep(){
        Assertions.assertEquals(List.of(" # ","###"), new Pyramid().buildIterative(2));
        Assertions.assertEquals(List.of(" # ","###"), new Pyramid().buildRecursive(2));
    }

    @Test
    public void threeStep(){
        Assertions.assertEquals(List.of("  #  "," ### ","#####"), new Pyramid().buildIterative(3));
        Assertions.assertEquals(List.of("  #  "," ### ","#####"), new Pyramid().buildRecursive(3));
    }

    @Test
    public void fourStep(){
        Assertions.assertEquals(List.of("   #   ","  ###  "," ##### ","#######"), new Pyramid().buildIterative(4));
        Assertions.assertEquals(List.of("   #   ","  ###  "," ##### ","#######"), new Pyramid().buildRecursive(4));
    }

}