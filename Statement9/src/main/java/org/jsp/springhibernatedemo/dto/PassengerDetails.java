package org.jsp.springhibernatedemo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "PassengerDetails")
public class PassengerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Passenger_id")
    private int passengerId;

    @Column(name = "Passenger_name", nullable = false)
    private String passengerName;

    @Column(name = "Passenger_dob", nullable = false)
    private Date passengerDob;

    @Column(name = "Passenger_phone", nullable = false, unique = true)
    private String passengerPhone;

    @Column(name = "Passenger_email", nullable = false, unique = true)
    private String passengerEmail;

    // Constructors
    public PassengerDetails() {}

    public PassengerDetails(String passengerName, Date passengerDob, String passengerPhone, String passengerEmail) {
        this.passengerName = passengerName;
        this.passengerDob = passengerDob;
        this.passengerPhone = passengerPhone;
        this.passengerEmail = passengerEmail;
    }

    // Getters and Setters
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
