$(function() {
    $('#user_create_form').ajaxForm({
        type: 'post',
        url: BASE + '/user',
        dataType: 'json',
        beforeSubmit: function() {
            return Smart.Validator.checkRequired('user_create_form');
        },
        success: function(result) {
            if (result.success) {
                location.href = BASE + '/users';
            }
        }
    });

    $('#back').click(function() {
        history.back();
    });
});