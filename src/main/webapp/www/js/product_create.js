$(function() {
    $('#product_create_form').ajaxForm({
        type: 'post',
        url: Smart.BASE + '/product/create',
        dataType: 'json',
        beforeSubmit: function() {
            return Smart.Validator.checkRequired('product_create_form');
        },
        success: function(result) {
            if (result.success) {
                location.href = Smart.BASE + '/product';
            }
        }
    });

    $('#cancel').click(function() {
        location.href = Smart.BASE + '/product';
    });
});