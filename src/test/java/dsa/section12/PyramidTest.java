package dsa.section12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PyramidTest {

    @Test
    public void noStep(){
        Assertions.assertEquals(List.of(), new Pyramid().build(0));
    }

    @Test
    public void oneStep(){
        Assertions.assertEquals(List.of("#"), new Pyramid().build(1));
    }

    @Test
    public void twoStep(){
        Assertions.assertEquals(List.of(" # ","###"), new Pyramid().build(2));
    }

    @Test
    public void threeStep(){
        Assertions.assertEquals(List.of("  #  "," ### ","#####"), new Pyramid().build(3));
    }

    @Test
    public void fourStep(){
        Assertions.assertEquals(List.of("   #   ","  ###  "," ##### ","#######"), new Pyramid().build(4));
    }

}