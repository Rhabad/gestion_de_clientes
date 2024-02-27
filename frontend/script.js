function abrirFormulario() {
    let htmlModal = document.getElementById('modal');
    htmlModal.setAttribute('class', 'modale opened');
}

function cerrarModal() {
    let htmlModal = document.getElementById('modal');
    htmlModal.setAttribute('class', 'modale');
}

function clean() {
    document.getElementById('txtId').value = '';
    document.getElementById('txtNombre').value = '';
    document.getElementById('txtApellido').value = '';
    document.getElementById('txtEmail').value = '';
    document.getElementById('txtTelefono').value = '';
}

function agregar() {
    clean();
    abrirFormulario();
}