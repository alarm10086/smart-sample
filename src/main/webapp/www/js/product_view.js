$(function() {
    $('#edit').click(function() {
        var productId = $('#id').val();
        location.href = BASE + '/product/edit/' + productId;
    });

    $('#back').click(function() {
        location.href = BASE + '/products';
    });
});