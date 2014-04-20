$(function() {
    $('#product_edit_form').ajaxForm({
        type: 'put',
        url: BASE + '/product/update/' + $('#id').val(),
        dataType: 'json',
        beforeSubmit: function() {
            return Smart4J.Validator.checkRequired('product_edit_form');
        },
        success: function(result) {
            if (result.success) {
                location.href = BASE + '/product';
            }
        }
    });

    $('#save').click(function() {
        $('#product_edit_form').submit();
    });

    $('#back').click(function() {
        location.href = BASE + '/product';
    });
});