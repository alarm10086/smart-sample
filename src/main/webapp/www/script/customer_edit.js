$(function() {
    var validator = new Validator();

    $('#cusotmer_edit_form').ajaxForm({
        type: 'put',
        url: BASE + '/customer/update/' + $('#id').val(),
        beforeSubmit: function() {
            return validator.required('customer_edit_form');
        },
        success: function(result) {
            console.log(result);
            if (result.success) {
                location.href = BASE + '/customer';
            }
        }
    });

    $('#cancel').click(function() {
        location.href = BASE + '/customer';
    });
});