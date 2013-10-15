$(function() {
    var validator = new Validator();

    $('#cancel').click(function() {
        location.href = 'product.html';
    });

    $('#product_create_form').ajaxForm({
        url: '/product',
        beforeSubmit: function() {
            return validator.required('product_create_form');
        },
        success: function(result) {
            if (result.success) {
                location.href = 'product.html';
            }
        }
    });
});