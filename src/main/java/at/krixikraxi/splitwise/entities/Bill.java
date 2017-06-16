package at.krixikraxi.splitwise.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String billName;
    private String billDescription;

    public Bill() {
    }

    public Bill(String billDescription, String billName) {
        this.billDescription = billDescription;
        this.billName = billName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, billDescription, billName);
    }

}
