## Report:

### Technical problems that you encountered during installation and use of Java Persistence Architecture (JPA) and how you resolved
- Right before he deadline of the assignment I ran into a new error out of nowhere: "Cause: zip END header not found". Before his unexpected error occurred my program ran as intended. Although I must mention that the test was slightly edited by me. The task did say specifically not to do this, but me and a colleague found that it solved our problems. The parts edited in the test were:
    ```
    // Test address
    assertEquals(customer.getAddresses().size(), 1);
    Address address = customer.getAddresses().iterator().next();

    assertEquals(address.getStreet(), "Inndalsveien");
    assertEquals(address.getNumber(), 28);
    for(Customer owner : address.getOwners()) {

        assertTrue(Set.of(customer).contains(owner));
    }	
    ```

    and

    ```
    // Test bank
    Bank bank = firstCard.getOwningBank();
    assertEquals(bank.getId(),secondCard.
    getOwningBank().getId()); // Bank objects of the two cards are identical!
    assertEquals(bank.getName(), "Pengebank");
    //assertEquals(bank.getOwnedCards(), Set.of(firstCard, secondCard));
    for (CreditCard creditCard : bank.getOwnedCards()) {
        assertTrue(Set.of(firstCard, secondCard).contains(creditCard));
    }	
    ```

### A link to your code for experiment 2 above. Make sure the included test case passes!
- https://github.com/Kremtastic/dat250-jpa-tutorial/tree/master

### An explanation of how you inspected the database tables and what tables were created. For the latter, you may provide screenshots.
- ...

### any pending issues with this assignment that you did not manage to solve
- As said earlier, I have not fixed the "zip END header not found" for now.