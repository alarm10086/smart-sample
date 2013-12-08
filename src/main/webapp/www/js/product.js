$(function() {
    var pager = new Smart.Pager(
        'product_pager',
        function (pageNumber) {
            searchFormData.pageNumber = pageNumber;
            $('#product_search_form').submit();
        },
        function(pageSize) {
            searchFormData.pageNumber = 1;
            searchFormData.pageSize = pageSize;
            $('#product_search_form').submit();
        }
    );

    var searchFormData = {
        'pageNumber': pager.getPageNumber(),
        'pageSize': pager.getPageSize()
    };

    $('#product_search_form').ajaxForm({
        type: 'post',
        url: Smart.BASE + '/product/search',
        data: searchFormData,
        dataType: 'html',
        success: function(html) {
            $('#product_list').html(html);
        }
    });

    $('.ext-product-delete').click(function() {
        var $tr = $(this).closest('tr');
        var productId = $tr.data('id');
        var productName = $tr.data('name');
        if (confirm(Smart.i18n('product.delete_confirm', productName))) {
            $.ajax({
                type: 'delete',
                url: Smart.BASE + '/product/delete/' + productId,
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