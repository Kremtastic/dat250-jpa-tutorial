package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.jpa.tutorial.creditcards.*;

import java.util.Collection;
import java.util.HashSet;

public class CreditCardsMain {

  static final String PERSISTENCE_UNIT_NAME = "jpa-tutorial";

  public static void main(String[] args) {
    try (EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        PERSISTENCE_UNIT_NAME); EntityManager em = factory.createEntityManager()) {
      em.getTransaction().begin();
      createObjects(em);
      em.getTransaction().commit();
    }

  }

  private static void createObjects(EntityManager em) {
    Address address = new Address();
    em.persist(address);
    address.setNumber(28);
    address.setStreet("Inndalsveien");

    Collection<Address> addresses = new HashSet<>();
    addresses.add(address);

    Pincode pincode = new Pincode();
    em.persist(pincode);
    pincode.setPincode("123");
    pincode.setCount(1);

    Customer customer = new Customer();
    em.persist(customer);
    customer.setName("Max Mustermann");
    customer.setAddresses(addresses);

    Collection<Customer> owners = new HashSet<>();
    owners.add(customer);
    address.setOwners(owners);

    //1:CreditCard
    CreditCard creditCard1 = new CreditCard();
    em.persist(creditCard1);
    creditCard1.setNumber(12345);
    creditCard1.setBalance(-5000);
    creditCard1.setCreditLimit(-10000);
    creditCard1.setPincode(pincode);

    //2:CreditCard
    CreditCard creditCard2 = new CreditCard();
    em.persist(creditCard2);
    creditCard2.setNumber(123);
    creditCard2.setBalance(1);
    creditCard2.setCreditLimit(2000);
    creditCard2.setPincode(pincode);

    Collection<CreditCard> creditCards = new HashSet<>();
    creditCards.add(creditCard1);
    creditCards.add(creditCard2);
    customer.setCreditCards(creditCards);

    Bank bank = new Bank();
    em.persist(bank);
    bank.setName("Pengebank");
    bank.setOwnedCards(creditCards);


    creditCard1.setBank(bank);
    creditCard2.setBank(bank);


  }
}
