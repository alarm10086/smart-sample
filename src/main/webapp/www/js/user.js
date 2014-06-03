$(function() {
    $('#user_search_form').ajaxForm({
        type: 'post',
        url: BASE + '/users',
        dataType: 'html',
        success: function(html) {
            $('#user_list').html(html);
        }
    });

    $('.ext-user-delete').click(function() {
        var $tr = $(this).closest('tr');
        var username = $tr.data('username');
        if (confirm(Smart.i18n('user.delete_confirm', username))) {
            var url = $(this).attr('href');
            $.ajax({
                type: 'delete',
                url: url,
                dataType: 'json',
                success: function(result) {
                    if (result.success) {
                        location.reload();
                    }
                }
            });
        }
        return false;
    });
});