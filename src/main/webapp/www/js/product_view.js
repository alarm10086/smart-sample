$(function() {
    $('#edit').click(function() {
        var productId = $('#id').val();
        location.href = Smart.BASE + '/product/edit/' + productId;
    });

    $('#back').click(function() {
        location.href = Smart.BASE + '/product';
    });
});