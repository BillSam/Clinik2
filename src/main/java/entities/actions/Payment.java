package entities.actions;

import java.util.HashMap;

/**
 * Created by error on 2/6/18.
 */

public class Payment {

    private String paymentId;
    private String patient;
    private String cashier;

    private HashMap<String, Double> payment;
    private String time;
    private String date;


    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

    public HashMap<String, Double> getPayment() {
        return payment;
    }

    public void setPayment(HashMap<String, Double> payment) {
        this.payment = payment;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
