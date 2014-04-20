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
        url: BASE + '/product/search',
        data: searchFormData,
        dataType: 'html',
        success: function(html) {
            $('#product_list').html(html);
        }
    });

    var deleteFn = function() {
        var $tr = $(this).closest('tr');
        var productId = $tr.data('id');
        var name = $tr.data('name');
        if (confirm(Smart.i18n('product.delete_confirm', name))) {
            $.ajax({
                type: 'delete',
                url: BASE + '/product/delete/' + productId,
                dataType: 'json',
                success: function(result) {
                    if (result.success) {
                        location.reload();
                    }
                }
            });
        }
    };
    $('.ext-product-delete').click(deleteFn);
    $(document).on('click', '.ext-product-delete', deleteFn);
});