<%@ page pageEncoding="UTF-8" %>
<%@ include file="common/global.jsp" %>

<c:set var="product" value="${productBean.product}"/>
<c:set var="productType" value="${productBean.productType}"/>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="common/meta.jsp" %>
    <title><f:message key="common.title"/> - <f:message key="product"/></title>
    <%@ include file="common/style.jsp" %>
</head>
<body>

<%@ include file="common/header.jsp" %>

<input type="hidden" id="id" value="${product.id}"/>

<div id="content">
    <div class="css-panel">
        <form class="css-form">
            <div class="css-form-header">
                <h3><f:message key="product.view_product"/></h3>
            </div>
            <div class="css-box">
                <div class="css-left">
                    <div class="css-form-row">
                        <label><f:message key="product.product_type"/>:</label>
                        <input type="text" value="${productType.name}" class="css-readonly" readonly>
                    </div>
                    <div class="css-form-row">
                        <label><f:message key="product.name"/>:</label>
                        <input type="text" value="${product.name}" class="css-readonly" readonly>
                    </div>
                    <div class="css-form-row">
                        <label><f:message key="product.code"/>:</label>
                        <input type="text" value="${product.code}" class="css-readonly" readonly>
                    </div>
                    <div class="css-form-row">
                        <label><f:message key="product.price"/>:</label>
                        <input type="text" value="${product.price}" class="css-readonly" readonly>
                    </div>
                    <div class="css-form-row">
                        <label><f:message key="product.description"/>:</label>
                        <textarea rows="5" class="css-readonly" readonly>${product.description}</textarea>
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
                        <security:hasRole name="admin">
                            <a href="${BASE}/product/upload_picture/${product.id}"><f:message key="common.upload"/></a>
                        </security:hasRole>
                        <a href="${BASE}/product/download_picture/${product.id}"><f:message key="common.download"/></a>
                    </div>
                </div>
            </div>
            <div class="css-form-footer">
                <security:hasPermission name="product.edit">
                    <button type="button" id="edit"><f:message key="common.edit"/></button>
                </security:hasPermission>
                <button type="button" id="back"><f:message key="common.back"/></button>
            </div>
        </form>
    </div>
</div>

<%@ include file="common/footer.jsp" %>

<%@ include file="common/script.jsp" %>

<script type="text/javascript" src="${BASE}/www/js/product_view.js"></script>

</body>
</html>