/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */

function fetchPostTicket(inputs, select){
    const ticket = {
        name: inputs[0].value,
        lastname: inputs[1].value,
        email: inputs[2].value,
        quantity: inputs[3].value,
        category: select
    }
    const config = {
        method : 'POST',
        body: JSON.stringify(ticket)
    }
    fetch('/api/ticket', config)
            .then(res => console.log(res)
            .catch(err => console.log(err)));
}

function fetchGetTicket(){
    fetch('/api/ticket')
            .then(res => res.json())
            .then(data => console.log(data))
}

