<%@ page pageEncoding="UTF-8" %>
<%@ include file="common/global.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="common/meta.jsp" %>
    <title>Smart Smaple - Customer</title>
    <link rel="stylesheet" href="${BASE}/www/asset/style/global.css"/>
</head>
<body>

<%@ include file="common/header.jsp" %>

<div id="content">
    <form id="customer_create_form" class="css-form">
        <div class="css-form-header">
            <h3>Create Customer</h3>
        </div>
        <div class="css-form-row">
            <label for="customer_name">Customer Name:</label>
            <input type="text" id="customer_name" name="customerName" class="ext-required"/>
            <span class="css-color-red">*</span>
        </div>
        <div class="css-form-row">
            <label for="description">Description:</label>
            <textarea id="description" name="description" rows="5"></textarea>
        </div>
        <div class="css-form-footer">
            <button type="submit">Save</button>
            <button type="button" id="cancel">Cancel</button>
        </div>
    </form>
</div>

<%@ include file="common/footer.jsp" %>

<%@ include file="common/script.jsp" %>
<script type="text/javascript" src="${BASE}/www/script/customer_create.js"></script>

</body>
</html>