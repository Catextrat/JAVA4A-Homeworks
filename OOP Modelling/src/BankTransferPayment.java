public class BankTransferPayment extends PaymentMethod {
    private String iban;
    private String bankName;

    // Getter and setter methods
    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public boolean makePayment(Cart cart) {
        // Perform payment via bank transfer
        return true;
    }
}