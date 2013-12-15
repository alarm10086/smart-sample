$(function() {
    var mainURL = Smart.BASE + '/product';

    $('#login_form').ajaxForm({
        type: 'post',
        url: Smart.BASE + '/login',
        dataType: 'json',
        beforeSubmit: function() {
            $('#login_form').find(':input').prop('disabled', true);
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
                alert(Smart.i18n('login.failure'));
                $('#login_form').find(':input').prop('disabled', false);
            }
        }
    });
});