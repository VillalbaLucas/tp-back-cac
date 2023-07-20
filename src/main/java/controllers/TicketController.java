package controllers;

import com.google.gson.Gson;
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

@WebServlet(name = "TicketController", urlPatterns = {"/api/ticket", "/api/ticket/*"})
public class TicketController extends HttpServlet {

    private static final TicketService ticketServ = TicketService.getInstance();
    private Boolean statusOk = null;
    private static final Gson GSON = new Gson();

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

        try {
            sendJson(response, ticketServ.getTickets());
            statusOk = true;

        } catch (Exception e) {
            System.out.print(e.toString());
            statusOk = false;
        } finally {
            if (statusOk) {
                response.setStatus(HttpServletResponse.SC_OK);
            } else {
                response.setStatus(SC_NOT_FOUND);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String body = bodyToString(request.getInputStream());
        try {
            ticketServ.postTicket(body);
            statusOk = true;
        } catch (Exception ex) {
            System.err.print("ERROR, Exception in TicketController" + ex.toString());
            statusOk = false;
        } finally {
            if (statusOk) {
                response.setStatus(SC_CREATED);
            } else {
                response.setStatus(SC_NOT_FOUND);
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {
        try {
            ticketServ.deletTicket(req.getPathInfo());
            statusOk = true;
        } catch (Exception e) {
            System.out.println(e.toString());
            statusOk = false;
        } finally {
            if (statusOk) {
                resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
            } else {
                resp.setStatus(SC_NOT_FOUND);
            }
        }
    }

    @Override
    protected void doPut(
            HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        String body = bodyToString(req.getInputStream());          
        try {
            ticketServ.modifyTicket(body);       
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String bodyToString(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream, "UTF-8");
        return scanner.hasNext()
                ? scanner.useDelimiter("\\A").next()
                : "";
    }

    private void sendJson(HttpServletResponse res, String json) throws IOException {
        PrintWriter out = res.getWriter();
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        out.print(json);
        out.flush();
    }

}
