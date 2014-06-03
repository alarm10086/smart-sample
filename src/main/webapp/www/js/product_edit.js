$(function() {
    $('#product_edit_form').ajaxForm({
        type: 'put',
        url: BASE + '/product/update/' + $('#id').val(),
        dataType: 'json',
        beforeSubmit: function() {
            return Smart.Validator.checkRequired('product_edit_form');
        },
        success: function(result) {
            if (result.success) {
                location.href = BASE + '/products';
            }
        }
    });

    $('#save').click(function() {
        $('#product_edit_form').submit();
    });

    $('#back').click(function() {
        location.href = BASE + '/products';
    });
});