package strategy.example.payment.method;

public class PayPal implements Payment {
    private String email;
    private String password;

    public PayPal(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String pay(int amount) {
        return String.format("PayPal %s paid £%d.", email, amount);
    }
}
