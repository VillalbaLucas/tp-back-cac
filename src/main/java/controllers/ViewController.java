
package controllers;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import static jakarta.servlet.http.HttpServletResponse.SC_NOT_FOUND;

/**
 *
 * @author Andrea
 */
@WebServlet(name = "HelloController", urlPatterns = {"/administrar"})
public class ViewController extends HttpServlet {

    private Boolean statusOk = null;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
       protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            response.sendRedirect("./../views/ticket.jsp");
            statusOk = true;
            
        }catch(Exception e){
            System.out.print(e.toString());
            statusOk = false;
        }finally{
            if(statusOk)
                response.setStatus(HttpServletResponse.SC_SEE_OTHER);
            else
                response.setStatus(SC_NOT_FOUND);
        } 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest request,
            HttpServletResponse response) 
            throws ServletException, IOException {
        
//           try{
//               RequestDispatcher dispacher = request.getRequestDispatcher("./../views/ticket-modify.jsp");
//               System.out.println("dispacher"+ dispacher);
//               dispacher.forward(request, response);
//               statusOk = true;
//            
//        }catch(Exception e){
//            System.out.print(e.toString());
//            statusOk = false;
//        }finally{
//            if(statusOk)
//                response.setStatus(HttpServletResponse.SC_SEE_OTHER);
//            else
//                response.setStatus(SC_NOT_FOUND);
//        } 
    }
    
    

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
