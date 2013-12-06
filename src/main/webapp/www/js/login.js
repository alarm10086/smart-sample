$(function() {
    var mainURL = BASE + '/customer';

    $('#login_form').ajaxForm({
        type: 'post',
        url: BASE + '/login',
        dataType: 'json',
        beforeSubmit: function() {
            $('#login_form').find(':input').prop('disabled', true);
        },
        success: function(result) {
            switch (result.error) {
                case 0:
                    location.href = mainURL;
                    break;
                default:
                    alert($.i18n('login.failure'));
                    $('#login_form').find(':input').prop('disabled', false);
            }
        }
    });
});