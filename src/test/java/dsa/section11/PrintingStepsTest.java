package dsa.section11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PrintingStepsTest {

    @Test
    public void noStep(){
        Assertions.assertArrayEquals(new PrintingSteps().executeWithArray(0),new String[]{});
        Assertions.assertEquals(List.of(), new PrintingSteps().executeWithList(0));
        Assertions.assertArrayEquals(new PrintingSteps().executeWithArrayNaive(0),new String[]{});
    }

    @Test
    public void oneStep(){
        Assertions.assertArrayEquals(new PrintingSteps().executeWithArray(1),new String[]{"#",});
        Assertions.assertArrayEquals(new PrintingSteps().executeWithArrayNaive(1),new String[]{"#",});
        Assertions.assertEquals(List.of("#"), new PrintingSteps().executeWithList(1));
    }


    @Test
    public void twoStep(){
        Assertions.assertArrayEquals(new PrintingSteps().executeWithArray(2),new String[]{"# ","##"});
        Assertions.assertArrayEquals(new PrintingSteps().executeWithArrayNaive(2),new String[]{"# ","##"});
        Assertions.assertEquals(List.of("# ","##"), new PrintingSteps().executeWithList(2));
    }

    @Test
    public void threeStep(){
        Assertions.assertArrayEquals(new PrintingSteps().executeWithArray(3),new String[]{"#  ","## ","###"});
        Assertions.assertArrayEquals(new PrintingSteps().executeWithArrayNaive(3),new String[]{"#  ","## ","###"});
        Assertions.assertEquals(List.of("#  ","## ","###"), new PrintingSteps().executeWithList(3));
    }

    @Test
    public void fourStep(){
        Assertions.assertArrayEquals(new PrintingSteps().executeWithArrayNaive(4),new String[]{"#   ","##  ","### ","####"});
        Assertions.assertArrayEquals(new PrintingSteps().executeWithArray(4),new String[]{"#   ","##  ","### ","####"});
        Assertions.assertEquals(List.of("#   ","##  ","### ","####"), new PrintingSteps().executeWithList(4));
    }

}