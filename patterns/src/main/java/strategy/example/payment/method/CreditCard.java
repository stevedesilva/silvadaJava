package strategy.example.payment.method;

public class CreditCard implements Payment{
    private String name;
    private int cardNumber;

    public CreditCard(String name, int cardNumber) {
        this.name = name;
        this.cardNumber = cardNumber;
    }

    @Override
    public String pay(int amount) {
        return String.format("Credit card holder %s paid £%d.", name, amount);
    }
}
