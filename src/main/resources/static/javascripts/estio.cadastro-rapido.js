// var Vimo = Vimo || {};
//
// Vimo.EstiloCadastroRapido = (function () {
//
//     function EstiloCadastroRapido() {
//         this.modal = $('#modalCadastroRapidoEstilo');
//         this.btnSalvar = this.modal.find('.js-modal-cadastro-estilo-salvar');
//         this.form = this.modal.find('form');
//         this.containerMsgErro = $('.js-mensagem-cadastro-rapido-estilo');
//         this.url = this.form.attr('action');
//         this.inputNomeEstilo = $('#nomeEstilo');
//     }
//
//     EstiloCadastroRapido.prototype.iniciar = function () {
//         //don't submit the form when button clicked
//         this.form.on('submit', function (event) {
//             event.preventDefault();
//         });
//         this.modal.on('shown.bs.modal', onModalShow.bind(this));
//         this.modal.on('hide.bs.modal', onModalClose.bind(this))
//         this.btnSalvar.on('click', onBtnSalvarClick.bind(this));
//     }
//
//     //request the focus on input when we call the modal
//     function onModalShow() {
//         this.inputNomeEstilo.focus();
//     }
//
//     //clear the value of our input
//     function onModalClose() {
//         this.inputNomeEstilo.val('');
//         this.containerMsgErro.addClass('hidden');
//         this.form.find('.form-group').removeClass('has-error');
//     }
//
//     function onBtnSalvarClick() {
//         var nomeEstilo = this.inputNomeEstilo.val().trim();
//
//         $.ajax({
//             url: this.url,
//             method: 'POST',
//             contentType: 'application/json',
//             data: JSON.stringify({'nome': nomeEstilo}),
//             error: onErrorSalvadoEstilo.bind(this),
//             success: onEstiloSalvo.bind(this)
//         });
//     }
//
//     function onErrorSalvadoEstilo(obj) {
//         var mensagemErro = obj.responseText;
//         this.containerMsgErro.removeClass('hidden');
//         this.containerMsgErro.html('<span>' + mensagemErro + '</span>');
//         this.form.find('.form-group').addClass('has-error');
//
//     }
//
//     function onEstiloSalvo(estilo) {
//         var comboEstilo = $('#estilo');
//         comboEstilo.append('<option value=' + estilo.codigo + '>' + estilo.nome + '</option>')
//         comboEstilo.val(estilo.codigo);
//         this.modal.modal('hide');
//     }
//
//
//     return EstiloCadastroRapido;
//
// })();
//
// $(function () {
//     var estiloCadastroRapido = new Vimo.EstiloCadastroRapido();
//     estiloCadastroRapido.iniciar();
// });

$(function () {
    let modal = $('#modalCadastroRapidoEstilo');
    let btnSalvar = modal.find('.js-modal-cadastro-estilo-salvar');
    let form = modal.find('form');
    let containerMsgErro = $('.js-mensagem-cadastro-rapido-estilo');

    form.on('submit', function (event) {
        event.preventDefault();
    });
    let url = form.attr('action');
    let inputNomeEstilo = $('#nomeEstilo');

    modal.on('shown.bs.modal', onModalShow.bind(this));
    modal.on('hide.bs.modal', onModalClose.bind(this))
    btnSalvar.on('click', onBtnSalvarClick.bind(this));

    function onModalShow() {
        inputNomeEstilo.focus();
    }

    function onModalClose() {
        inputNomeEstilo.val('')
        containerMsgErro.addClass('hidden');
        form.find('.form-group').removeClass('has-error');
    }

    function onBtnSalvarClick() {
        let nomeEstilo = inputNomeEstilo.val().trim();

        $.ajax({
            url: url,
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({'nome': nomeEstilo}),
            error: onErrorSalvadoEstilo.bind(this),
            success: onEstiloSalvo.bind(this)
        });
    }

    function onErrorSalvadoEstilo(obj) {
        let mensagemErro = obj.responseText;
        containerMsgErro.removeClass('hidden');
        containerMsgErro.html('<span>' + mensagemErro + '</span>');
        form.find('.form-group').addClass('has-error');
    }

    function onEstiloSalvo(estilo) {
        let comboEstilo = $('#estilo');
        comboEstilo.append('<option value=' + estilo.codigo + '>' + estilo.nome + '</option>')
        comboEstilo.val(estilo.codigo);
        modal.modal('hide');
    }
});














