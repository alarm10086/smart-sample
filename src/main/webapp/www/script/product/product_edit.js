$(function() {
    var validator = new Validator();

    $('#cancel').click(function() {
        location.href = 'product.html';
    });

    var productId = window.sessionStorage.getItem('product.id');
    $.ajax({
        url: '/product/' + productId,
        type: 'get',
        success: function(result) {
            if (result.success) {
                var product = result.data;
                $('#product_type_id').val(product.productTypeId);
                $('#product_name').val(product.productName);
                $('#product_code').val(product.productCode);
                $('#price').val(product.price);
                $('#description').val(product.description);
            } else {
                switch (result.error) {
                    case 10:
                        alert('The parameter is error!');
                        break;
                    case 20:
                        alert('The data is error!');
                        break;
                }
            }
        }
    });

    $('#product_edit_form').ajaxForm({
        url: '/product/' + productId,
        type: 'put',
        beforeSubmit: function() {
            return validator.required('product_edit_form');
        },
        success: function(result) {
            if (result.success) {
                location.href = 'product.html';
            }
        }
    });
});