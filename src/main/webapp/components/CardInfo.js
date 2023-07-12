const CardInfo = (monto, inputs) => {
    const card = document.createElement('div')

    let date = new Date
    let hora = date.getHours() + ':' + date.getMinutes() + ':' + date.getSeconds() + 'hs'
    let fecha = date.getDate() + '/' + (Number(date.getMonth()) + 1) + '/' + date.getFullYear()

    card.id = 'cardInfo'
    card.innerHTML = `
        <div class="py-2 border rounded-2 fs-2 bg-success"><i class="bi bi-check2-circle"></i></div>
        <h5 class="py-3 border-bottom" >¡Gracias por su compra!</h5>
        <div  class="px-2">
            <span class="px-2"><b>Nombre:</b> ${inputs[0].value}</span>
            <span class="px-2"><b>Apellido:</b> ${inputs[1].value}</span>
            <p><b>Email:</b> ${inputs[2].value}</p>
            <p><b>Fecha de compra:</b> ${fecha}</p>
            <p><b>Hora de compra:</b> ${hora}</p>
            <p><b>Monto total pagado:</b> $${monto}</p>
            <button class="btn btn-success px-3" onClick="removeCard(cardInfo)" >Okey!</button>
        </div>
    `
    card.classList.add('card-info')
    return card
}