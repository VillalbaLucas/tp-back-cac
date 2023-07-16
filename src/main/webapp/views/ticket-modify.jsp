
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
        <h2>Hello World!</h2>
        <section>
            <form name="formulario" class="formContainer">
                <div class="row row-cols-md-2 px-2">
                    <div class="col-12 form-floating mb-3 px-1">
                        <input type="text" id="floatingInput" class="form-control" placeholder="Nombre" required >
                        <label for="floatingInput">Nombre</label>
                    </div>
                    <div class="form-floating col-12 mb-3 px-1">
                        <input type="text" id="floatingInput" class="form-control" placeholder="Apellido" required >
                        <label for="floatingInput" >Apellido</label>
                    </div>
                </div>
                <div class="col form-floating my-3">
                    <input type="email" id="floatingInput" class="form-control" placeholder="Email" required >
                    <label for="floatingInput" class="form-label">Correo</label>
                </div>
                <div id="containPrice" class="row row-col-2">
                    <div class="col">
                        <label for="" class="form-label">Cantidad</label>
                        <input type="number" value="1" class="form-control" required>
                    </div>
                </div>
                <div class="row row-cols-3 justify-content-around">
                    <button type="reset" class="btn btn-success" onclick="emptyInputs()" >Borrar</button>
                    <button id="btnBuy" type="button" class="btn btn-success" disabled onclick="buy()" ></i>Guardar</button>
                </div>
            </form>
        </section>
        
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
        <script src="./../js/services/ticketService.js"></script>
    </body>
</html>
