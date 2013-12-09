$(function() {
    $('#product_upload_form').ajaxForm({
        type: 'post',
        url: Smart.BASE + '/product/upload_picture/' + $('#id').val(),
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

    $('#picture').change(function() {
        $('#product_upload_form').submit();
    });

    $('#back').click(function() {
        location.href = Smart.BASE + '/product';
    });
});