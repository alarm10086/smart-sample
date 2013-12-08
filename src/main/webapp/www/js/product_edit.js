$(function() {
    var $id = $('#id');

    $('#product_edit_form').ajaxForm({
        type: 'put',
        url: Smart.BASE + '/product/update/' + $id.val(),
        dataType: 'json',
        beforeSubmit: function() {
            return Smart.Validator.checkRequired('product_edit_form');
        },
        success: function(result) {
            if (result.success) {
                location.href = Smart.BASE + '/product';
            }
        }
    });

    $('#product_upload_form').ajaxForm({
        type: 'post',
        url: Smart.BASE + '/product/upload/' + $id.val(),
        dataType: 'json',
        beforeSubmit: function() {
            return $('#picture').val().length > 0;
        },
        success: function(result) {
            if (result.success) {
                $('#picture_img').attr('src', Smart.BASE + '/www/upload/' + result.data);
            }
        }
    });

    $('#save').click(function() {
        $('#product_edit_form').submit();
    });

    $('#picture').change(function() {
        $('#product_upload_form').submit();
    });

    $('#cancel').click(function() {
        location.href = Smart.BASE + '/product';
    });
});