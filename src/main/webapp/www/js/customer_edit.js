$(function() {
    var $id = $('#id');

    $('#customer_edit_form').ajaxForm({
        type: 'put',
        url: BASE + '/customer/update/' + $id.val(),
        dataType: 'json',
        beforeSubmit: function() {
            return Smart.Validator.checkRequired('customer_edit_form');
        },
        success: function(result) {
            if (result.success) {
                location.href = BASE + '/customer';
            }
        }
    });

    $('#customer_upload_form').ajaxForm({
        type: 'post',
        url: BASE + '/customer/upload/' + $id.val(),
        dataType: 'json',
        success: function(result) {
            if (result.success) {
                $('#photo_img').attr('src', BASE + '/www/upload/' + result.data);
            }
        }
    });

    $('#save').click(function() {
        $('#customer_edit_form').submit();
    });

    $('#photo').change(function() {
        $('#customer_upload_form').submit();
    });

    $('#cancel').click(function() {
        location.href = BASE + '/customer';
    });
});