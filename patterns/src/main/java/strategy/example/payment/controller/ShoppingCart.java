package strategy.example.payment.controller;

import strategy.example.payment.model.Product;
import strategy.example.payment.method.Payment;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> products;

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }
    public void removeProduct(Product product) {
        products.remove(product);
    }
    public int calculateTotalAlt() {
        int sum = 0;
        for(Product p : products) {
            sum += p.getPrice();
        }
        return sum;
    }

    public int calculateTotal() {
        return products.stream()
                .map(p -> p.getPrice())
                .reduce(0, (a,b)-> a+b);
    }

    public Result pay(Payment payment) {
        final int amount = calculateTotal();
        final String paidMessage = payment.pay(amount);
        return new Result(paidMessage, amount, true);
    }

    public static class Result {
        String message;
        int total;
        boolean paid;

        public Result(String message, int total, boolean paid) {
            this.message = message;
            this.total = total;
            this.paid = paid;
        }

        public String getMessage() {
            return message;
        }

        public int getTotal() {
            return total;
        }

        public boolean isPaid() {
            return paid;
        }
    }

}
