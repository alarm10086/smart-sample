$(function() {
    var validator = new Validator();

    $('#cusotmer_edit_form').ajaxForm({
        type: 'post',
        url: BASE + '/customer/update/' + $('#id').val(),
        dataType: 'json',
        beforeSubmit: function() {
            return validator.required('customer_edit_form');
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