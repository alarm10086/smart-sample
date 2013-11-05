$(function() {
    var validator = new Validator();

    $('#customer_create_form').ajaxForm({
        type: 'post',
        url: BASE + '/customer/create',
        beforeSubmit: function() {
            return validator.required('customer_create_form');
        },
        success: function(result) {
            if (result.success) {
                location.href = BASE + '/customer';
            }
        }
    });

    $('#cancel').click(function() {
        location.href = BASE + '/customer';
    });
});