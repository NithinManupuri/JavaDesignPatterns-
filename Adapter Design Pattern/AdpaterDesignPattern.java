import java.util.Scanner;

public class AdapterDesignPattern {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String paymentOption = sc.next();
        PaymentGateway paymentGateway = createPaymentService(paymentOption);
        paymentGateway.processPayment();
    }

    public static PaymentGateway createPaymentService(String payment) {
        switch (payment) {
            case "GooglePay":
                return new GooglePayAdapter(new GooglePay());
            case "PhonePay":
                return new PhonePayAdapter(new PhonePay());
            default:
                throw new IllegalArgumentException("Unsupported payment gateway type");
        }
    }
}

interface PaymentGateway {
    void processPayment();
}

class GooglePay implements PaymentGateway {

    @Override
    public void processPayment() {
        System.out.println("Processing payment via Google Pay");
    }
}

class PhonePay implements PaymentGateway {

    @Override
    public void processPayment() {
        System.out.println("Processing payment via PhonePe");
    }
}

// Adapter for Google Pay
class GooglePayAdapter implements PaymentGateway {
    private GooglePay googlePay;

    public GooglePayAdapter(GooglePay googlePay) {
        this.googlePay = googlePay;
    }

    @Override
    public void processPayment() {
        googlePay.processPayment();
    }
}

// Adapter for PhonePe
class PhonePayAdapter implements PaymentGateway {
    private PhonePay phonePay;

    public PhonePayAdapter(PhonePay phonePay) {
        this.phonePay = phonePay;
    }

    @Override
    public void processPayment() {
        // Convert data to XML format if needed
        // phonePay.convertToXml();
        phonePay.processPayment();
    }
}
