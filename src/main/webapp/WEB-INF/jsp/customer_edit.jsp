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
    <div class="css-panel">
        <div class="css-form-header">
            <h3><f:message key="customer.edit_customer"/></h3>
        </div>
        <div class="css-box">
            <input type="hidden" id="id" value="${customer.id}"/>
            <div class="css-left">
                <form id="customer_edit_form" class="css-form">
                    <div class="css-form-row">
                        <label for="customer_name"><f:message key="customer.customer_name"/>:</label>
                        <input type="text" id="customer_name" name="customerName" value="${customer.customerName}" class="ext-required"/>
                        <span class="css-color-red">*</span>
                    </div>
                    <div class="css-form-row">
                        <label for="description"><f:message key="customer.description"/>:</label>
                        <textarea id="description" name="description" rows="5">${customer.description}</textarea>
                    </div>
                </form>
            </div>
            <div class="css-left">
                <form id="customer_upload_form" enctype="multipart/form-data" class="css-form">
                    <div class="css-form-row">
                        <label for="photo"><f:message key="customer.photo"/>:</label>
                        <input type="file" id="photo" name="photo"/>
                    </div>
                    <div class="css-form-row">
                        <label></label>
                        <c:set var="photo" value="www/upload/${customer.photo}"/>
                        <img id="photo_img" src="${BASE}/${not empty customer.photo ? photo : 'www/img/default.jpg'}" height="128"/>
                    </div>
                </form>
            </div>
        </div>
        <div class="css-form-footer">
            <button type="button" id="save"><f:message key="common.save"/></button>
            <button type="button" id="cancel"><f:message key="common.cancel"/></button>
        </div>
    </div>
</div>

<%@ include file="common/footer.jsp" %>

<%@ include file="common/js.jsp" %>
<script type="text/javascript" src="${BASE}/www/js/customer_edit.js"></script>

</body>
</html>