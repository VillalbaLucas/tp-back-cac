package daos;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import models.Ticket;
import enums.Category;

public class TicketDao{
    
    private static TicketDao instance = null;
    Connection connect = new Conexion().getConnection();
    PreparedStatement ps;
    ResultSet rs;
    
    public static TicketDao getInstance(){
        if(instance == null)
            instance = new TicketDao();
        return instance;
    }
    
    public List<Ticket> getTickets() throws SQLException {
        List<Ticket> tickets = new LinkedList();
        ps = connect.prepareStatement("SELECT * FROM tickets;");
        rs = ps.executeQuery();
        
        while(rs.next()){
            Ticket ticket;
            ticket = new Ticket(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("lastname"),
                    rs.getString("email"),
                    rs.getInt("quantity"),
                    Category.valueOf(rs.getString("category")),
                    rs.getTimestamp("fecha")
            );
            tickets.add(ticket);
        }
//        System.out.println("\nTicketDao: \n"+tickets);
        return tickets;
    }
    
    public Boolean postTicket(Ticket ticket) throws Exception{
        ps = connect.prepareStatement("INSERT INTO tickets (name, lastname, email, quantity, category) VALUES (?,?,?,?,?)");
        
        try{
            ps.setString(1, ticket.getName());
            ps.setString(2, ticket.getLastname());
            ps.setString(3, ticket.getEmail());
            ps.setInt(4, ticket.getQuantity());
            ps.setString(5, ticket.getCategory().toString());
            ps.execute();
            return true;
        }catch(SQLException sql){
            System.out.println("ERROR, NOT CREATE TICKET: " + sql.toString());
            return false;
        }
    }
}