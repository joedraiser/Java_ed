package UnmodCollections.dev.dto;

public class Transaction {
    private int routinNumber;
    private int customerId;
    private long transactionId;
    private double transactionAmount;

    public Transaction(int routinNumber, int customerId, long transactionId, double transactionAmount) {
        this.routinNumber = routinNumber;
        this.customerId = customerId;
        this.transactionId = transactionId;
        this.transactionAmount = transactionAmount;
    }

    public int getRoutinNumber() {
        return routinNumber;
    }

    public void setRoutinNumber(int routinNumber) {
        this.routinNumber = routinNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
}
