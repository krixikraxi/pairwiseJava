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
    private User fromUser;
    private User toUser;

    //public Bill() {
    //}

    public Bill(String billName, String billDescription, User fromUser) {
        this.billName = billName;
        this.billDescription = billDescription;
        this.fromUser = fromUser;
    }

    public Bill(String billName, String billDescription, User fromUser, User toUser) {
        this.billName = billName;
        this.billDescription = billDescription;
        this.fromUser = fromUser;
        this.toUser = toUser;
    }

    @Override
    public String toString() {
        return String.format(
                "Bill[id=%d, billName='%s', billDescription='%s', fromUser='%s', toUser='%s']",
                id, billName, billDescription, fromUser, toUser);
    }

    public enum User {
        ALEX,MANU;
    }
}
