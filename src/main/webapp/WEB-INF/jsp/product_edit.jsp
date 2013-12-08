<%@ page pageEncoding="UTF-8" %>
<%@ include file="common/global.jsp" %>

<c:set var="product" value="${productBean.product}"/>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="common/meta.jsp" %>
    <title><f:message key="common.title"/> - <f:message key="product"/></title>
    <%@ include file="common/css.jsp" %>
</head>
<body>

<%@ include file="common/header.jsp" %>

<div id="content">
    <div class="css-panel">
        <div class="css-form-header">
            <h3><f:message key="product.edit_product"/></h3>
        </div>
        <div class="css-box">
            <input type="hidden" id="id" value="${product.id}"/>
            <div class="css-left">
                <form id="product_edit_form" class="css-form">
                    <div class="css-form-row">
                        <label for="productType"><f:message key="product.product_type"/>:</label>
                        <select id="productType" name="productTypeId" class="ext-required">
                            <c:forEach var="productType" items="${productTypeList}">
                                <option value="${productType.id}" ${product.productTypeId == productType.id ? 'selected' : ''}>${productType.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="css-form-row">
                        <label for="product_name"><f:message key="product.product_name"/>:</label>
                        <input type="text" id="product_name" name="productName" value="${product.productName}" class="ext-required"/>
                        <span class="css-color-red">*</span>
                    </div>
                    <div class="css-form-row">
                        <label for="product_code"><f:message key="product.product_code"/>:</label>
                        <input type="text" id="product_code" name="productCode" value="${product.productCode}" class="ext-required"/>
                        <span class="css-color-red">*</span>
                    </div>
                    <div class="css-form-row">
                        <label for="price"><f:message key="product.price"/>:</label>
                        <input type="text" id="price" name="price" value="${product.price}" class="ext-required"/>
                        <span class="css-color-red">*</span>
                    </div>
                    <div class="css-form-row">
                        <label for="description"><f:message key="product.description"/>:</label>
                        <textarea id="description" name="description" rows="5">${product.description}</textarea>
                    </div>
                </form>
            </div>
            <div class="css-left">
                <form id="product_upload_form" enctype="multipart/form-data" class="css-form">
                    <div class="css-form-row">
                        <label for="picture"><f:message key="product.picture"/>:</label>
                        <input type="file" id="picture" name="picture"/>
                    </div>
                    <div class="css-form-row">
                        <label></label>
                        <c:set var="picture" value="www/upload/${product.picture}"/>
                        <img id="picture_img" src="${BASE}/${not empty product.picture ? picture : 'www/img/s.gif'}" height="128"/>
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
<script type="text/javascript" src="${BASE}/www/js/product_edit.js"></script>

</body>
</html>