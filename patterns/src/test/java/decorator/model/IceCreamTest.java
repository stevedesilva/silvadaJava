package decorator.model;

import decorator.withabstractmethod.BasicIceCream;
import decorator.withabstractmethod.ChocolateIceCream;
import decorator.withabstractmethod.MintIceCream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;


class IceCreamTest {
    @Test
    public void shouldBasicIceCreamWithMint() {
        Assertions.assertEquals(BigDecimal.valueOf(1.0), new BasicIceCream().cost());
    }
    @Test
    public void shouldBasicIceCreamWithMintAndChoc() {
        Assertions.assertEquals(BigDecimal.valueOf(36.0), new ChocolateIceCream(new MintIceCream(new BasicIceCream())).cost());
    }

}