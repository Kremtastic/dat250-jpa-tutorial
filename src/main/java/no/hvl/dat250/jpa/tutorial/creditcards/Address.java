package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private int number;
    public Address() {}
    public Address(String street, int number) {
        this.street = street;
        this.number = number;
    }
    @ManyToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    private Collection<Customer> owners;
    public String toString() {
        return "[id = " + this.id + ": " + this.street + "]";
    }

    public String getStreet() {
        return this.street;
    }

    public Integer getNumber() {
        return this.number;
    }

    public Collection<Customer> getOwners() {
        return this.owners;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setOwners(Collection<Customer> owners) {
        this.owners = owners;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return number == address.number && Objects.equals(id, address.id) && Objects.equals(street, address.street) && Objects.equals(owners, address.owners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, number, owners);
    }
}
