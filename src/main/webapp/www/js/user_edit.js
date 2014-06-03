$(function() {
    $('#user_edit_form').ajaxForm({
        type: 'put',
        url: BASE + '/user/' + $('#id').val(),
        dataType: 'json',
        beforeSubmit: function() {
            return Smart.Validator.checkRequired('user_edit_form');
        },
        success: function(result) {
            if (result.success) {
                location.href = BASE + '/users';
            }
        }
    });

    $('#save').click(function() {
        $('#user_edit_form').submit();
    });

    $('#back').click(function() {
        location.href = BASE + '/users';
    });
});