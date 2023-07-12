 function Form(){
    const article = document.createElement('article')
    article.id = 'formMain'

    article.innerHTML = `
        <section class="d-flex flex-column align-items-center section-container py-5">
            <div class="d-flex flex-column align-items-center">
                <div id="containDiscounts" class="d-flex flex-column flex-md-row gap-3">
                    <div class="p-5 border border-primary text-center" data-id="0" >
                        <h6>Estudiante</h6>
                        <p>Tiene un descuento</p>
                        <b>80%</b>
                        <p>presentar documentacion</p>
                    </div>
                    <div class=" p-5 border border-success text-center" data-id="1">
                        <h6>Trainee</h6>
                        <p>Tiene un descuento</p>
                        <b>50%</b>
                        <p>presentar documentacion</p>
                    </div>
                    <div class=" p-5 border border-warning text-center" data-id="2">
                        <h6>Junior</h6>
                        <p>Tiene un descuento</p>
                        <b>15%</b>
                        <p>presentar documentacion</p>
                    </div>
                </div>
                <span>
                    <p>VENTA</p>
                </span>
            </div>
            <h2>VALOR DEL TICKET $200</h2>
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
                    <div class="col">
                        <label for="" class="form-label">Categoria</label>
                        <select type="text" id="select" class="form-select">
                            <option value="Estudiante">Estudiante</option>
                            <option value="Trainee">Trainee</option>
                            <option value="Junior">Junior</option>
                        </select>
                    </div>
                </div>
                <div class="input-group col my-4">
                    <span class="input-group-text py-2">Total $</i></span>
                    <input disabled type="text" id="disabledTextInput" class="form-control bg-primary-subtle">
                </div>
                <div class="row row-cols-3 justify-content-around">
                    <button type="reset" class="btn btn-success" onclick="emptyInputs()" ><i class="bi bi-trash3"></i>Borrar</button>
                    <button id="btnBuy" type="button" class="btn btn-success" disabled onclick="buy()" ><i class="bi bi-cart"></i>Comprar</button>
                </div>
            </form>
        </section>
`
    return article
}