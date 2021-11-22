package dsa.section11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PrintingStepsTest {

    @Test
    public void noStep(){
        Assertions.assertArrayEquals(new PrintingSteps().executeWithArrayUsingStringFormat(0),new String[]{});
        Assertions.assertEquals(List.of(), new PrintingSteps().executeWithListUsingStringFormat(0));
        Assertions.assertArrayEquals(new PrintingSteps().executeWithStringArrayUsingNestedForLoops(0),new String[]{});
        Assertions.assertArrayEquals(new PrintingSteps().executeWithCharArrayUsingNestedForLoops(0),new String[]{});
    }

    @Test
    public void noStepRecursive(){
        Assertions.assertArrayEquals(new PrintingSteps().executeRecursive(0),new String[]{});
        Assertions.assertArrayEquals(new PrintingSteps().executeRecursive(1),new String[]{"#"});
        Assertions.assertArrayEquals(new PrintingSteps().executeRecursive(2),new String[]{"# ","##"});
        Assertions.assertArrayEquals(new PrintingSteps().executeRecursive(3),new String[]{"#  ","## ","###"});
        Assertions.assertArrayEquals(new PrintingSteps().executeRecursive(4),new String[]{"#   ","##  ","### ","####"});

    }

    @Test
    public void oneStep(){
        Assertions.assertArrayEquals(new PrintingSteps().executeWithArrayUsingStringFormat(1),new String[]{"#",});
        Assertions.assertArrayEquals(new PrintingSteps().executeWithStringArrayUsingNestedForLoops(1),new String[]{"#",});
        Assertions.assertEquals(List.of("#"), new PrintingSteps().executeWithListUsingStringFormat(1));
        Assertions.assertArrayEquals(new PrintingSteps().executeWithCharArrayUsingNestedForLoops(1),new String[]{"#",});
    }


    @Test
    public void twoStep(){
        Assertions.assertArrayEquals(new PrintingSteps().executeWithArrayUsingStringFormat(2),new String[]{"# ","##"});
        Assertions.assertArrayEquals(new PrintingSteps().executeWithStringArrayUsingNestedForLoops(2),new String[]{"# ","##"});
        Assertions.assertEquals(List.of("# ","##"), new PrintingSteps().executeWithListUsingStringFormat(2));
        Assertions.assertArrayEquals(new PrintingSteps().executeWithCharArrayUsingNestedForLoops(2),new String[]{"# ","##"});
    }

    @Test
    public void threeStep(){
        Assertions.assertArrayEquals(new PrintingSteps().executeWithArrayUsingStringFormat(3),new String[]{"#  ","## ","###"});
        Assertions.assertArrayEquals(new PrintingSteps().executeWithStringArrayUsingNestedForLoops(3),new String[]{"#  ","## ","###"});
        Assertions.assertEquals(List.of("#  ","## ","###"), new PrintingSteps().executeWithListUsingStringFormat(3));
        Assertions.assertArrayEquals(new PrintingSteps().executeWithArrayUsingStringFormat(3),new String[]{"#  ","## ","###"});
    }

    @Test
    public void fourStep(){
        Assertions.assertArrayEquals(new PrintingSteps().executeWithStringArrayUsingNestedForLoops(4),new String[]{"#   ","##  ","### ","####"});
        Assertions.assertArrayEquals(new PrintingSteps().executeWithArrayUsingStringFormat(4),new String[]{"#   ","##  ","### ","####"});
        Assertions.assertEquals(List.of("#   ","##  ","### ","####"), new PrintingSteps().executeWithListUsingStringFormat(4));
        Assertions.assertArrayEquals(new PrintingSteps().executeWithArrayUsingStringFormat(4),new String[]{"#   ","##  ","### ","####"});

    }

}