package patterns.decorator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class DecoratorTest {
    @Test
    public void shouldAddTinsel(){
        Assertions.assertEquals("Tree with tinsel", new Tinsel(new ChristmasTreeImpl()).decorate());
    }
    @Test
    public void shouldAddTinselAndAnAngel(){
        Assertions.assertEquals("Tree with tinsel with an Angel", new Angel(new Tinsel(new ChristmasTreeImpl())).decorate());
    }
    @Test
    public void shouldAddTinselAndAnAngelAndLights(){
        Assertions.assertEquals("Tree with tinsel with an Angel with lights", new Lights(new Angel(new Tinsel(new ChristmasTreeImpl()))).decorate());
    }
}