var Brewer = Brewer || {};

Brewer.MaskCpfCnpj = (function () {

    function MaskCpfCnpj() {
        this.radioTipoPessoa = $('.js-radio-tipo-pessoa');
        this.labelTipoPessoa = $('[for=cpfOuCnpj]');
        this.inputTipoPessoa = $('#cpfOuCnpj');
    }

    MaskCpfCnpj.prototype.init = function () {
        this.radioTipoPessoa.on('change', onTipoPessoaAlterado.bind(this));
    }

    function onTipoPessoaAlterado(event) {
        let tipoPessoaSelecionada = $(event.currentTarget);
        let documento = tipoPessoaSelecionada.data('document');
        let mascara = tipoPessoaSelecionada.data('mascara');

        this.labelTipoPessoa.text(documento);
        this.inputTipoPessoa.removeAttr('disabled');
        this.inputTipoPessoa.mask(mascara);
    }

    return MaskCpfCnpj;

}());

$(function () {
    let maskCpfCnpj = new Brewer.MaskCpfCnpj();
    maskCpfCnpj.init();
});