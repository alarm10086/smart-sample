$(function() {
    $('#product_edit_form').ajaxForm({
        type: 'put',
        url: Smart.BASE + '/product/update/' + $('#id').val(),
        dataType: 'json',
        beforeSubmit: function() {
            return Smart.Validator.checkRequired('product_edit_form');
        },
        success: function(result) {
            if (result.success) {
                location.href = Smart.BASE + '/product';
            }
        }
    });

    $('#save').click(function() {
        $('#product_edit_form').submit();
    });

    $('#back').click(function() {
        history.back();
    });
});