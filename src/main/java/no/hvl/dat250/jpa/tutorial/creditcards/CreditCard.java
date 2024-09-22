package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer number;
    private Integer creditLimit;
    private Integer balance;
    @ManyToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    private Pincode pincode;
    @ManyToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    private Bank bank;

    public Integer getNumber() {
        return this.number;
    }

    public Integer getBalance() {
        return this.balance;
    }

    public Integer getCreditLimit() {
        return this.creditLimit;
    }

    public Pincode getPincode() {
        return this.pincode;
    }

    public Bank getOwningBank() {
        return this.bank;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setCreditLimit(Integer creditLimit) {
        this.creditLimit = creditLimit;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public void setPincode(Pincode pincode) {
        this.pincode = pincode;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditCard that = (CreditCard) o;
        return Objects.equals(id, that.id) && Objects.equals(number, that.number) && Objects.equals(creditLimit, that.creditLimit) && Objects.equals(balance, that.balance) && Objects.equals(pincode, that.pincode) && Objects.equals(bank, that.bank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, creditLimit, balance, pincode, bank);
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "id=" + id +
                ", number=" + number +
                ", creditLimit=" + creditLimit +
                ", balance=" + balance +
                '}';
    }
}
