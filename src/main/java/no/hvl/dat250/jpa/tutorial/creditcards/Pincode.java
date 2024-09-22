package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Pincode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pincode;
    private Integer count;

    public Long getId() {
        return id;
    }


    public String getCode() {
        return this.pincode;
    }

    public Integer getCount() {
        return this.count;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pincode pincode1 = (Pincode) o;
        return Objects.equals(id, pincode1.id) && Objects.equals(pincode, pincode1.pincode) && Objects.equals(count, pincode1.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pincode, count);
    }
}
