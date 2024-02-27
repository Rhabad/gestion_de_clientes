function abrirFormulario() {
    let htmlModal = document.getElementById('modal');
    htmlModal.setAttribute('class', 'modale opened');
}

function cerrarModal() {
    let htmlModal = document.getElementById('modal');
    htmlModal.setAttribute('class', 'modale');
}