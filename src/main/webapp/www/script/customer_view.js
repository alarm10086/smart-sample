$(function() {
    $('#edit').click(function() {
        var customerId = $('#id').val();
        location.href = BASE + '/customer/edit/' + customerId;
    });

    $('#cancel').click(function() {
        location.href = BASE + '/customer';
    });
});