var Brewer = Brewer || {};

Brewer.MaskMoney = (function () {

    function MaskMoney() {
        this.decimal = $('.js-decimal');
        this.plain = $('.js-plain');
    }

    MaskMoney.prototype.enable = function () {
        this.decimal.maskMoney({decimal: ',', thousands: '.'});
        this.plain.maskMoney({precision: 0, thousands: '.'});
    };

    return MaskMoney;

})();

Brewer.MaskPhoneNumber = (function () {
    function MaskPhoneNumber() {
        this.inputPhoneNumber = $('.js-phone-number');
    }

    MaskPhoneNumber.prototype.enable = function () {
        let maskBehavior = function (val) {
                return val.replace(/\D/g, '').length === 11 ? '(000) 000-000-000' : '(000) 0000-00009';
            },
            options = {
                onKeyPress: function (val, e, field, options) {
                    field.mask(maskBehavior.apply({}, arguments), options);
                }
            };

        this.inputPhoneNumber.mask(maskBehavior, options);
    }


    return MaskPhoneNumber;
}());

$(function () {
    let maskMoney = new Brewer.MaskMoney();
    let maskPhoneNumber = new Brewer.MaskPhoneNumber();


    maskMoney.enable();
    maskPhoneNumber.enable();
});

