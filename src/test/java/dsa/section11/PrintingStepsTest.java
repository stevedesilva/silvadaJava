package dsa.section11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PrintingStepsTest {

    @Test
    public void noStep(){
        Assertions.assertArrayEquals(new PrintingSteps().executeWithArray(1),new String[]{"#\n",});
        Assertions.assertEquals(List.of("#\n"), new PrintingSteps().executeWithList(1));
    }

    @Test
    public void oneStep(){
        Assertions.assertArrayEquals(new PrintingSteps().executeWithArray(1),new String[]{"#\n",});
        Assertions.assertEquals(List.of("#\n"), new PrintingSteps().executeWithList(1));
    }


    @Test
    public void twoStep(){
        Assertions.assertArrayEquals(new PrintingSteps().executeWithArray(2),new String[]{"# \n","##\n"});
        Assertions.assertEquals(List.of("# \n","##\n"), new PrintingSteps().executeWithList(2));
    }

    @Test
    public void threeStep(){
        Assertions.assertArrayEquals(new PrintingSteps().executeWithArray(3),new String[]{"#  \n","## \n","###\n"});
        Assertions.assertEquals(List.of("#  \n","## \n","###\n"), new PrintingSteps().executeWithList(3));
    }

    @Test
    public void fourStep(){
        Assertions.assertArrayEquals(new PrintingSteps().executeWithArray(4),new String[]{"#   \n","##  \n","### \n","####\n"});
        Assertions.assertEquals(List.of("#   \n","##  \n","### \n","####\n"), new PrintingSteps().executeWithList(4));
    }

}