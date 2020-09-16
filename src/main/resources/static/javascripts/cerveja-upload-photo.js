var Brewer = Brewer || {};

Brewer.UploadFoto = (function () {

    function UploadFoto() {
        this.inputNomeFoto = $('input[name=foto]');
        this.inputContentType = $('input[name=contentType]');

        this.htmlFotoCervejaTemplate = $("#foto-cerveja").html();
        this.template = Handlebars.compile(this.htmlFotoCervejaTemplate);

        this.containerPhotoCerveja = $('.js-container-foto-cerveja');
        this.uploaDrop = $('#upload-drop');
    }

    UploadFoto.prototype.init = function () {
        let settings = {
            type: 'json',
            filelimit: 1,
            allow: '*.(jpg|jpeg|png)',
            action: this.containerPhotoCerveja.data('url-fotos'),
            complete: onUploadComplete.bind(this)
        }

        UIkit.uploadSelect($('#upload-select'), settings);
        UIkit.uploadDrop($(this.uploadDrop), settings);

        // if (this.inputNomeFoto.val()) {
        //     onUploadComplete.call(this, {nome: this.inputNomeFoto.val(), contentType: this.inputContentType.val()});
        // }
    }

    function onUploadComplete(response) {
        this.inputNomeFoto.val(response.nome);
        this.inputContentType.val(response.contentType);

        this.uploadDrop.addClass('hidden');

        let htmlFotoCerveja = this.template({nomeFoto: this.response.nome});

        this.containerPhotoCerveja.append(htmlFotoCerveja);

        $('.js-remove-foto').on('click', onRemovePhoto.bind(this));
    }


    function onRemovePhoto() {
        $('.js-foto-cerveja').remove();
        this.uploaDrop.removeClass('hidden');
        this.inputNomeFoto.val('');
        this.inputContentType.val('');
    }

    return UploadFoto();
})();


$(function () {
    let uploadFoto = new Brewer.UploadFoto();
    uploadFoto.init();
});









