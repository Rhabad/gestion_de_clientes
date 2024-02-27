document.addEventListener("DOMContentLoaded", init);

const url_api = 'http://localhost:8080/api/v1';

let clientes = [];

function init() {
    search();
}


async function search() {
    let url = `${url_api}/clientes`;
    let response = await fetch(url, {
        "method": 'GET',
        "headers": {
            "Content-Type": 'application/json'
        }
    });
    //tenemos que convertilo a json
    clientes = await response.json();

    let html = '';
    for (cliente of clientes) {
        let row = `
    <tr>
        <td>${cliente.nombre}</td>
        <td>${cliente.apellido}</td>
        <td>${cliente.email}</td>
        <td>${cliente.telefono}</td>
        <td>
            <button onclick="edit(${cliente.id})" class="button button-editar">Editar</button>
            <button onclick="remove(${cliente.id})" class="button button-eliminar">Eliminar</button>
        </td>
    </tr>`;

        html = html + row;
    }

    document.querySelector('#customers > tbody').outerHTML = html;
}

async function remove(id) {
    let response = confirm('¿Estas seguro de eliminarlo?');
    if (response) {
        let url = `${url_api}/cliente/` + id;
        await fetch(url, {
            "method": 'DELETE',
            "headers": {
                "Content-Type": 'application/json'
            }
        });
    }
    window.location.reload();
}

async function save() {

    let data = {
        nombre: document.getElementById('txtNombre').value,
        apellido: document.getElementById('txtApellido').value,
        email: document.getElementById('txtEmail').value,
        telefono: document.getElementById('txtTelefono').value
    }

    let url = `${url_api}/cliente`;
    await fetch(url, {
        "method": 'POST',
        "body": JSON.stringify(data),
        "headers": {
            "Content-Type": 'application/json'
        }
    });
    window.location.reload();
}


function edit(id) {
    abrirFormulario();
    let cliente = clientes.find(x => x.id == id);

    document.getElementById('txtNombre').value = cliente.nombre;
    document.getElementById('txtApellido').value = cliente.apellido;
    document.getElementById('txtEmail').value = cliente.email;
    document.getElementById('txtTelefono').value = cliente.telefono;
}
