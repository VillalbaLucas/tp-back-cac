package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @AllArgsConstructor
public class Ticket {
    private Long id;
    private String name;
    private String lastname;
    private String email;
    private int quantity;
    
    public Ticket(String name, String lastname, String email, int quantity){
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.quantity = quantity;
    }
}