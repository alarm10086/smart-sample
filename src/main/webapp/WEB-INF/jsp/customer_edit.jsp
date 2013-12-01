<%@ page pageEncoding="UTF-8" %>
<%@ include file="common/global.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="common/meta.jsp" %>
    <title><f:message key="common.title"/> - <f:message key="customer"/></title>
    <link rel="stylesheet" href="${BASE}/www/asset/style/global.css"/>
</head>
<body>

<%@ include file="common/header.jsp" %>

<div id="content">
    <form id="cusotmer_edit_form" class="css-form">
        <input type="hidden" id="id" value="${customer.id}"/>
        <div class="css-form-header">
            <h3><f:message key="customer.edit_customer"/></h3>
        </div>
        <div class="css-form-row">
            <label for="customer_name"><f:message key="customer.customer_name"/>:</label>
            <input type="text" id="customer_name" name="customerName" value="${customer.customerName}" class="ext-required"/>
            <span class="css-color-red">*</span>
        </div>
        <div class="css-form-row">
            <label for="description"><f:message key="customer.description"/>:</label>
            <textarea id="description" name="description" rows="5">${customer.description}</textarea>
        </div>
        <div class="css-form-footer">
            <button type="submit"><f:message key="common.save"/></button>
            <button type="button" id="cancel"><f:message key="common.cancel"/></button>
        </div>
    </form>
</div>

<%@ include file="common/footer.jsp" %>

<%@ include file="common/js.jsp" %>
<script type="text/javascript" src="${BASE}/www/script/customer_edit.js"></script>

</body>
</html>