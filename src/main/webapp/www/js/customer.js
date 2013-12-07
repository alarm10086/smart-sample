$(function() {
    $('#customer_search_form').ajaxForm({
        type: 'post',
        url: BASE + '/customer/search',
        dataType: 'html',
        success: function(html) {
            $('#customer_table').replaceWith(html);
        }
    });

    $('.ext-customer-delete').click(function() {
        var $tr = $(this).closest('tr');
        var customerId = $tr.data('id');
        var customerName = $tr.data('name');
        if (confirm($.i18n('customer.delete_confirm', customerName))) {
            $.ajax({
                type: 'delete',
                url: BASE + '/customer/delete/' + customerId,
                dataType: 'json',
                success: function(result) {
                    if (result.success) {
                        $tr.remove();
                    }
                }
            });
        }
    });
});