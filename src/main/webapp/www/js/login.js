$(function() {
    var mainURL = Smart.BASE + '/product';

    $('#login_form').ajaxForm({
        type: 'post',
        url: Smart.BASE + '/login',
        dataType: 'json',
        beforeSubmit: function() {
            var result = false;
            if (Smart.Validator.checkRequired('login_form')) {
                $('#login_form').find(':input').prop('disabled', true);
                result = true;
            }
            return result;
        },
        success: function(result) {
            if (result.success) {
                var redirectURL = result.data;
                if (redirectURL) {
                    location.href = redirectURL;
                } else {
                    location.href = mainURL;
                }
            } else {
                if (result.data == 'captcha_error') {
                    alert(Smart.i18n('common.captcha.error'));
                } else {
                    alert(Smart.i18n('login.failure'));
                }
                $('#login_form').find(':input').prop('disabled', false);
                $('#captcha_img').click();
                $('#captcha').val('');
            }
        }
    });
});