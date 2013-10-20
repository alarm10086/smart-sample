$(function() {
    var mainURL = 'product.html';

    var storage = window.sessionStorage;
    if (storage.auth) {
        location.href = mainURL;
    }

    $('#login_form').ajaxForm({
        type: 'post',
        url: '/login',
        beforeSubmit: function() {
            $('#login_form').find(':input').prop('disabled', true);
        },
        success: function(result) {
            switch (result.error) {
                case 0:
                    storage.auth = true;
                    location.href = mainURL;
                    break;
                default:
                    alert('Login failure!');
                    $('#login_form').find(':input').prop('disabled', false);
            }
        }
    });
});