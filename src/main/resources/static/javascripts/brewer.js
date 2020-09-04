// var Vimo = Vimo || {};

// Vimo.MaskMoney = (function () {
//
//     function MaskMoney() {
//         this.decimal = $('.js-decimal');
//         this.plain = $('.js-plain');
//     }
//
//     MaskMoney.prototype.enable = function () {
//         this.decimal.maskMoney({decimal: ',', thousands: '.'});
//         this.plain.maskMoney({precision: 0, thousands: '.'});
//     };
//
//     return MaskMoney;
//
// })();
//
//
// $(function () {
//     var maskMoney = new Vimo.MaskMoney();
//     maskMoney.enable();
// });

$(function () {
    let decimal = $('.js-decimal');
    decimal.maskMoney({decimal: ',', thousands: '.'});

    let plain = $('.js-plain');
    plain.maskMoney({precision: 0, thousands: '.'});
});