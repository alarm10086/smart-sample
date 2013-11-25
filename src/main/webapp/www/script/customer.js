$(function() {
    $('.ext-customer-delete').click(function() {
        var $tr = $(this).closest('tr');
        var customerId = $tr.data('id');
        var customerName = $tr.data('name');
        if (confirm($.i18n('customer.delete_confirm', customerName))) {
            $.ajax({
                type: 'delete',
                url: BASE + '/customer/delete/' + customerId,
                success: function(result) {
                    if (result.success) {
                        $tr.remove();
                    }
                }
            });
        }
    });
});