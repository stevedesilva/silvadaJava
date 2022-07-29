package decorator.withabstractmethod;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class IceCreamTest {
    @Test
    public void shouldBasicIceCream() {
        Assertions.assertEquals(5, new BasicIceCream().cost());
    }
    @Test
    public void shouldBasicIceCreamWithMint() {
        Assertions.assertEquals(12, new MintIceCream(new BasicIceCream()).cost());
    }
    @Test
    public void shouldBasicIceCreamWithMintAndChoc() {
        Assertions.assertEquals(17, new ChocolateIceCream(new MintIceCream(new BasicIceCream())).cost());
    }


}