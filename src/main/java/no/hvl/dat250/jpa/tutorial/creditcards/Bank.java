package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    private Collection<CreditCard> creditCards;

    public Long getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public Collection<CreditCard> getOwnedCards() {
        return this.creditCards;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwnedCards(Collection<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(id, bank.id) && Objects.equals(name, bank.name) && Objects.equals(creditCards, bank.creditCards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, creditCards);
    }
}
