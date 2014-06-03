<%@ page pageEncoding="UTF-8" %>
<%@ include file="common/global.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="common/meta.jsp" %>
    <title><f:message key="common.title"/> - <f:message key="product"/></title>
    <%@ include file="common/style.jsp" %>
</head>
<body>

<%@ include file="common/header.jsp" %>

<div id="content">
    <form id="product_create_form" enctype="multipart/form-data" class="css-form">
        <div class="css-form-header">
            <h3><f:message key="product.create_product"/></h3>
        </div>
        <div class="css-form-row">
            <label for="productType"><f:message key="product.product_type"/>:</label>
            <select id="productType" name="productTypeId" class="ext-required">
                <c:forEach var="productType" items="${productTypeList}">
                    <option value="${productType.id}">${productType.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="css-form-row">
            <label for="name"><f:message key="product.name"/>:</label>
            <input type="text" id="name" name="name" class="ext-required">
            <span class="css-color-red">*</span>
        </div>
        <div class="css-form-row">
            <label for="code"><f:message key="product.code"/>:</label>
            <input type="text" id="code" name="code" class="ext-required">
            <span class="css-color-red">*</span>
        </div>
        <div class="css-form-row">
            <label for="price"><f:message key="product.price"/>:</label>
            <input type="text" id="price" name="price" class="ext-required">
            <span class="css-color-red">*</span>
        </div>
        <div class="css-form-row">
            <label for="description"><f:message key="product.description"/>:</label>
            <textarea id="description" name="description" rows="5"></textarea>
        </div>
        <div class="css-form-row">
            <label for="picture"><f:message key="product.picture"/>:</label>
            <input type="file" id="picture" name="picture">
        </div>
        <div class="css-form-footer">
            <button type="submit"><f:message key="common.save"/></button>
            <button type="button" id="back"><f:message key="common.back"/></button>
        </div>
    </form>
</div>

<%@ include file="common/footer.jsp" %>

<%@ include file="common/script.jsp" %>

<script type="text/javascript" src="${BASE}/www/js/product_create.js"></script>

</body>
</html>