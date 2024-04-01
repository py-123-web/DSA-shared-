package entity;

/**
 *
 * @author LWY
 * 
 * 
paymentId
Amount
paymentDateTime
(Description)
 */
public class RegisterCourse {
    private int registerId;
    private double amount;
    private int registerDate;

    public RegisterCourse() {
    }

    public RegisterCourse(int registerId, double amount, int registerDate) {
        this.registerId = registerId;
        this.amount = amount;
        this.registerDate = registerDate;
    }

    public int getRegisterId() {
        return registerId;
    }

    public void setRegisterId(int registerId) {
        this.registerId = registerId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(int registerDate) {
        this.registerDate = registerDate;
    }
    
    @Override
    public String toString() {
        return  "Register ID = " + registerId + 
                ", Amount = " + amount + 
                ", Register Date = " + registerDate;
    }
}
