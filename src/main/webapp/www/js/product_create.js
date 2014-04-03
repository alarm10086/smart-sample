$(function() {
    $('#product_create_form').ajaxForm({
        type: 'post',
        url: BASE + '/product/create',
        dataType: 'json',
        beforeSubmit: function() {
            return Smart.Validator.checkRequired('product_create_form');
        },
        success: function(result) {
            if (result.success) {
                location.href = BASE + '/product';
            }
        }
    });

    $('#back').click(function() {
        history.back();
    });
});