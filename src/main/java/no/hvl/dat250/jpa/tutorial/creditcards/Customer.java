package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    private Collection<Address> addresses;
    @ManyToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    private Collection<CreditCard> creditCards;
    public Customer() {}
    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Collection<Address> getAddresses() {
        return this.addresses;
    }

    public Collection<CreditCard> getCreditCards() {
        return this.creditCards;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddresses(Collection<Address> addresses) {
        this.addresses = addresses;
    }

    public void setCreditCards(Collection<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && Objects.equals(addresses, customer.addresses) && Objects.equals(creditCards, customer.creditCards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, addresses, creditCards);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
