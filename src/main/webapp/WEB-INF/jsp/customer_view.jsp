<%@ page pageEncoding="UTF-8" %>
<%@ include file="common/global.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="common/meta.jsp" %>
    <title><f:message key="common.title"/> - <f:message key="customer"/></title>
    <%@ include file="common/css.jsp" %>
</head>
<body>

<%@ include file="common/header.jsp" %>

<div id="content">
    <form id="customer_view_form" class="css-form">
        <input type="hidden" id="id" value="${customer.id}"/>
        <div class="css-form-header">
            <h3><f:message key="customer.view_customer"/></h3>
        </div>
        <div class="css-box">
            <div class="css-left">
                <div class="css-form-row">
                    <label for="customer_name"><f:message key="customer.customer_name"/>:</label>
                    <input type="text" id="customer_name" name="customerName" value="${customer.customerName}" class="css-readonly" readonly/>
                </div>
                <div class="css-form-row">
                    <label for="description"><f:message key="customer.description"/>:</label>
                    <textarea id="description" name="description" rows="5" class="css-readonly" readonly>${customer.description}</textarea>
                </div>
            </div>
            <div class="css-left">
                <div class="css-form-row">
                    <label><f:message key="customer.photo"/>:</label>
                    <c:set var="photo" value="www/upload/${customer.photo}"/>
                    <c:set var="default" value="'www/img/default.jpg'"/>
                    <img src="${BASE}/${not empty photo ? photo : default}" width="64"/>
                </div>
            </div>
        </div>
        <div class="css-form-footer">
            <button type="button" id="edit"><f:message key="common.edit"/></button>
            <button type="button" id="cancel"><f:message key="common.cancel"/></button>
        </div>
    </form>
</div>

<%@ include file="common/footer.jsp" %>

<%@ include file="common/js.jsp" %>
<script type="text/javascript" src="${BASE}/www/js/customer_view.js"></script>

</body>
</html>