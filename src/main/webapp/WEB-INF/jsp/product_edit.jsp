<%@ page pageEncoding="UTF-8" %>
<%@ include file="common/global.jsp" %>

<c:set var="product" value="${productBean.product}"/>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="common/meta.jsp" %>
    <title><f:message key="common.title"/> - <f:message key="product"/></title>
    <%@ include file="common/style.jsp" %>
</head>
<body>

<%@ include file="common/header.jsp" %>

<input type="hidden" id="id" value="${product.id}">

<div id="content">
    <div class="css-panel">
        <form id="product_edit_form" class="css-form">
            <div class="css-form-header">
                <h3><f:message key="product.edit_product"/></h3>
            </div>
            <div class="css-box">
                <div class="css-left">
                    <div class="css-form-row">
                        <label for="productType"><f:message key="product.product_type"/>:</label>
                        <select id="productType" name="productTypeId" class="ext-required">
                            <c:forEach var="productType" items="${productTypeList}">
                                <option value="${productType.id}" ${product.productTypeId == productType.id ? 'selected' : ''}>${productType.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="css-form-row">
                        <label for="name"><f:message key="product.name"/>:</label>
                        <input type="text" id="name" name="name" value="${product.name}" class="ext-required"/>
                        <span class="css-color-red">*</span>
                    </div>
                    <div class="css-form-row">
                        <label for="code"><f:message key="product.code"/>:</label>
                        <input type="text" id="code" name="code" value="${product.code}" class="ext-required">
                        <span class="css-color-red">*</span>
                    </div>
                    <div class="css-form-row">
                        <label for="price"><f:message key="product.price"/>:</label>
                        <input type="text" id="price" name="price" value="${product.price}" class="ext-required">
                        <span class="css-color-red">*</span>
                    </div>
                    <div class="css-form-row">
                        <label for="description"><f:message key="product.description"/>:</label>
                        <textarea id="description" name="description" rows="5">${product.description}</textarea>
                    </div>
                </div>
                <div class="css-left">
                    <div class="css-form-row">
                        <label><f:message key="product.picture"/>:</label>
                        <c:set var="picture" value="www/upload/${product.picture}"/>
                        <img src="${BASE}/${not empty product.picture ? picture : 'www/img/s.gif'}" height="128"/>
                    </div>
                    <div class="css-form-row">
                        <label></label>
                        <a href="${BASE}/product/upload_picture/${product.id}"><f:message key="common.upload"/></a>
                        <a href="${BASE}/product/download_picture/${product.id}"><f:message key="common.download"/></a>
                    </div>
                </div>
            </div>
            <div class="css-form-footer">
                <button type="button" id="save"><f:message key="common.save"/></button>
                <button type="submit" id="back"><f:message key="common.back"/></button>
            </div>
        </form>
    </div>
</div>

<%@ include file="common/footer.jsp" %>

<%@ include file="common/script.jsp" %>

<script type="text/javascript" src="${BASE}/www/js/product_edit.js"></script>

</body>
</html>