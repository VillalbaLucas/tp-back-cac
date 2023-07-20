<%@page import="daos.TicketDao"%>
<%@page import="java.util.List"%>
<%@page import="models.Ticket"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <link rel="stylesheet" href="../style.css">
        <title>JSP Page</title>
    </head>
    <body>
    <header>
        <article class="text-center p-4 bg-color ">
            <h2 class="text-light">Administracion de tickets</h2>
        </article>
    </header>
    <section>
        <article class="container-md p-4">
            <table class="table">
                <thead class="thead">
                    <tr class="text-center">
                        <th scope="col">Id</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Apellido</th>
                        <th scope="col">Correo</th>
                        <th scope="col">Cantidad</th>
                        <th scope="col">Categoria</th>
                        <th scope="col">Fecha de compra</th>
                        <th scope="col">Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Ticket> tickets = TicketDao.getInstance().getTickets();
                        for(Ticket t: tickets ){
                    %>
                    <tr class="text-center">
                        <th scope="row"><%= t.getId() %></th>
                        <td><%= t.getName() %></td>
                        <td><%= t.getLastname() %></td>
                        <td><%= t.getEmail() %></td>
                        <td><%= t.getQuantity() %></td>
                        <td><%= t.getCategory() %></td>
                        <td><%= t.getFecha() %></td>
                        <td>
                            <button class="btn btn-danger" onClick="deletTicket(<%= t.getId()%>)" >Borrar</button>
                            <button class="btn btn-primary" onClick="redirectPutTicket(<%= t.getId()%>)" >Editar</button>
                        </td>
                        
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </article>
    </section>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
        <script src="./../js/services/ticketService.js"></script>
</body>
</html>
