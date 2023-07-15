package models;

import java.sql.Timestamp;
import enums.Category;
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
    private Category category; 
    private Timestamp fecha;
    
    public Ticket(String name, String lastname, String email, int quantity, Category category){
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.quantity = quantity;
        this.category = category;
    }
     public Ticket(String name, String lastname, String email, int quantity, Category category, Timestamp fecha){
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.quantity = quantity;
        this.category = category;
        this.fecha = fecha;
    }
}