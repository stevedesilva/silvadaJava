package strategy.example.payment.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import strategy.example.payment.method.CreditCard;
import strategy.example.payment.method.PayPal;
import strategy.example.payment.model.Product;

class ShoppingCartTest {
    @Test
    public void shouldUseCreditCardPaymentMethod(){
        Product widgetA = new Product("123",12);
        Product widgetB = new Product("234",33);
        Product widgetC = new Product("345",42);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addProduct(widgetA);
        shoppingCart.addProduct(widgetB);
        shoppingCart.addProduct(widgetC);

        final ShoppingCart.Result result = shoppingCart.pay(new CreditCard("Tester", 999));
        Assertions.assertTrue(result.paid);
        Assertions.assertEquals(87, result.total);
        Assertions.assertEquals("Credit card holder Tester paid £87.", result.message);
    }

    @Test
    public void shouldUsePayPalPaymentMethod(){
        Product widgetA = new Product("123",12);
        Product widgetB = new Product("234",33);
        Product widgetC = new Product("345",42);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addProduct(widgetA);
        shoppingCart.addProduct(widgetB);
        shoppingCart.addProduct(widgetC);

        final ShoppingCart.Result result = shoppingCart.pay(new PayPal("tester@test.com","123"));
        Assertions.assertTrue(result.paid);
        Assertions.assertEquals(87, result.total);
        Assertions.assertEquals("PayPal tester@test.com paid £87.", result.message);
    }
}