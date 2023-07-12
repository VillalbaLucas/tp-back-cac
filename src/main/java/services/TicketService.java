package services;

import com.google.gson.Gson;
import daos.TicketDao;
import java.sql.SQLException;
import java.util.List;
import models.Ticket;

public class TicketService {
    private static TicketService instance = null;
    private static final TicketDao ticketDao = TicketDao.getInstance();
    private static final Gson GSON = new Gson();
    
    public static TicketService getInstance(){
        if(instance == null )
            instance = new TicketService();
        return instance;
    }
    
    public Boolean postTicket(String ticket) throws SQLException, Exception{
        Ticket newTicket = GSON.fromJson(ticket, Ticket.class);
        Boolean response = ticketDao.postTicket(newTicket);
        return response; 
    }
    
    public String getTickets() throws Exception{
        List<Ticket> tickets = ticketDao.getTickets();
        String ticketsJson = GSON.toJson(tickets);
//        System.out.println("\nTicketService:\n"+tickets);
        return ticketsJson;
    }
    
}
