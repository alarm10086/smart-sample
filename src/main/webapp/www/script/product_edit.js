$(function() {
    var validator = new Validator();

    $('#cancel').click(function() {
        location.href = 'product.html';
    });

    var productId = window.sessionStorage.getItem('product.id');
    $.ajax({
        type: 'get',
        url: '/product/' + productId,
        success: function(result) {
            if (result.success) {
                var productBean = result.data;
                $('#product_type_id').val(productBean.productType.id);
                $('#product_name').val(productBean.product.productName);
                $('#product_code').val(productBean.product.productCode);
                $('#price').val(productBean.product.price);
                $('#description').val(productBean.product.description);
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