package org.software.com;

import java.util.Date;


public class PassengerDetails {
    private int passengerId;
    private String passengerName;

    private Date passengerDob;

    private String passengerPhone;

    private String passengerEmail;

    public PassengerDetails() {}

    public PassengerDetails(String passengerName, Date passengerDob, String passengerPhone, String passengerEmail) {
        this.passengerName = passengerName;
        this.passengerDob = passengerDob;
        this.passengerPhone = passengerPhone;
        this.passengerEmail = passengerEmail;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public Date getPassengerDob() {
        return passengerDob;
    }

    public void setPassengerDob(Date passengerDob) {
        this.passengerDob = passengerDob;
    }

    public String getPassengerPhone() {
        return passengerPhone;
    }

    public void setPassengerPhone(String passengerPhone) {
        this.passengerPhone = passengerPhone;
    }

    public String getPassengerEmail() {
        return passengerEmail;
    }

    public void setPassengerEmail(String passengerEmail) {
        this.passengerEmail = passengerEmail;
    }

    @Override
    public String toString() {
        return "PassengerDetails{" +
                "passengerId=" + passengerId +
                ", passengerName='" + passengerName + '\'' +
                ", passengerDob=" + passengerDob +
                ", passengerPhone='" + passengerPhone + '\'' +
                ", passengerEmail='" + passengerEmail + '\'' +
                '}';
    }
}
