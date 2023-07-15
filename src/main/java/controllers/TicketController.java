
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import static jakarta.servlet.http.HttpServletResponse.SC_CREATED;
import static jakarta.servlet.http.HttpServletResponse.SC_NOT_FOUND;

import java.io.InputStream;
import java.util.Scanner;
import services.TicketService;

@WebServlet(name = "TicketController", urlPatterns = {"/api/ticket"})
public class TicketController extends HttpServlet {
    
    private static final TicketService ticketServ = TicketService.getInstance();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TicketController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TicketController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            System.out.println("Ticket GET Controller;");
            System.out.println(ticketServ.getTickets());
        }catch(Exception e){
            System.out.print(e.toString());
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Boolean respuesta = null;
        String body = bodyToString(request.getInputStream());
        try {
            respuesta = ticketServ.postTicket(body);
        } catch (Exception ex) {
            System.err.print("ERROR, Exception in TicketController" + ex.toString());
            respuesta = false;
        }finally{
            if(respuesta)
                response.setStatus(SC_CREATED);
            else
                response.setStatus(SC_NOT_FOUND);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

     private String bodyToString(InputStream inputStream){
        Scanner scanner = new Scanner(inputStream, "UTF-8");
        return scanner.hasNext() 
                ? scanner.useDelimiter("\\A").next()
                : "";
    }

}
