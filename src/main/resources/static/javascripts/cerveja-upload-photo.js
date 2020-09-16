// var Brewer = Brewer || {};
//
// Brewer.PhotoUpload = (function () {
//     function PhotoUpload() {
//         this.inputPhotoName = $('input[name=foto]');
//         this.inputContentType = $('input[name=contentType]');
//
//         this.htmlFotoCervejaTemplate = $("#foto-cerveja").html();
//         this.template = Handlebars.compile(this.htmlFotoCervejaTemplate);
//
//         this.containerPhotoCerveja = $('.js-container-photo-cerveja');
//
//         this.uploadDrop = $('#upload-drop');
//     }
//
//     PhotoUpload.prototype.init = function () {
//         let settings = {
//             type: 'json',
//             filelimit: 1,
//             allow: '*.(jpg|jpeg|png)',
//             action: this.containerPhotoCerveja.data('url-photo'),
//             complete: onUploadComplete.bind(this)
//         }
//
//         UIkit.uploadSelect($('#upload-select'), settings);
//         UIkit.uploadDrop($(this.uploadDrop), settings);
//
//         if (this.inputPhotoName.val()) {
//             onUploadComplete.call(this, {nome: this.inputPhotoName.val(), contentType: this.inputContentType.val()});
//         }
//     }
//
//     function onUploadComplete(response) {
//         this.inputPhotoName.val(response.nome);
//         this.inputContentType.val(response.contentType);
//
//         this.uploadDrop.addClass('hidden');
//         let htmlFotoCerveja = this.template({photoName: response.nome})
//
//         this.containerPhotoCerveja.append(htmlFotoCerveja);
//
//         $('.js-remove-photo').on('click', onRemovePhoto.bind(this));
//     }
//
//     function onRemovePhoto() {
//         $('.js-photo-cerveja').remove();
//         this.uploadDrop.removeClass('hidden');
//         this.inputPhotoName.val('');
//         this.inputContentType.val('');
//     }
//
//     return PhotoUpload;
// })();
//
//
// $(function () {
//     let photoUpload = new Brewer.PhotoUpload();
//     photoUpload.init();
// });

$(function () {

    let settings = {
        type: 'json',
        filelimit: 1,
        allow: '*.(jpg|jpeg|png)',
        action: '/brewer/fotos',
        complete: function (response) {
            let inputNomeFoto = $('input[name=foto]');
            let inputContentType = $('input[name=contentType]');
            let htmlFotoCervejaTemplate = $("#foto-cerveja").html();
            let template = Handlebars.compile(htmlFotoCervejaTemplate);
            let htmlFotoCerveja = template({nomeFoto: response.nome});
            let containerPhotoCerveja = $('.js-container-foto-cerveja');
            let uploaDrop = $('#upload-drop');

            inputNomeFoto.val(response.nome);
            inputContentType.val(response.contentType);

            uploaDrop.addClass('hidden');

            containerPhotoCerveja.append(htmlFotoCerveja);

            $('.js-remove-foto').on('click', function () {
                $('.js-foto-cerveja').remove();
                uploaDrop.removeClass('hidden');
                inputNomeFoto.val('');
                inputContentType.val('');
            });
        }
    }

    UIkit.uploadSelect($('#upload-select'), settings);
    UIkit.uploadDrop($(this.uploadDrop), settings);

});







