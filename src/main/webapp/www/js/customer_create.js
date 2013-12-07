$(function() {
    $('#customer_create_form').ajaxForm({
        type: 'post',
        url: BASE + '/customer/create',
        dataType: 'json',
        beforeSubmit: function() {
            return Smart.Validator.checkRequired('customer_create_form');
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