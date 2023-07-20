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
    
    public void postTicket(String body) throws SQLException, Exception{ 
        ticketDao.postTicket(parseTicket(body));
    }
    
    public String getTickets() throws Exception{
        List<Ticket> tickets = ticketDao.getTickets();
        String ticketsJson = GSON.toJson(tickets);
        return ticketsJson;
    }
    
    public void deletTicket(String id) throws Exception{
        ticketDao.deletTicket(parseId(id));
    }
    
    public void modifyTicket(String body) throws SQLException{
        ticketDao.modifyTicket(parseTicket(body));
    }
    
    private Ticket parseTicket(String body){
        return GSON.fromJson(body, Ticket.class);
    }
    
    private Long parseId(String id){
        return Long.valueOf(id.substring(1));
    }
    
}
