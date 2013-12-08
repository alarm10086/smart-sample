<%@ page pageEncoding="UTF-8" %>
<%@ include file="common/global.jsp" %>

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
        <input type="hidden" id="id" value="${product.id}"/>
        <div class="css-form-header">
            <h3><f:message key="product.view_product"/></h3>
        </div>
        <div class="css-box">
            <div class="css-left">
                <div class="css-form-row">
                    <label><f:message key="product.product_name"/>:</label>
                    <input type="text" value="${product.productName}" class="css-readonly" readonly/>
                </div>
                <div class="css-form-row">
                    <label><f:message key="product.product_code"/>:</label>
                    <input type="text" value="${product.productCode}" class="css-readonly" readonly/>
                </div>
                <div class="css-form-row">
                    <label><f:message key="product.price"/>:</label>
                    <input type="text" value="${product.price}" class="css-readonly" readonly/>
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
            </div>
        </div>
        <div class="css-form-footer">
            <button type="button" id="edit"><f:message key="common.edit"/></button>
            <button type="button" id="back"><f:message key="common.back"/></button>
        </div>
    </div>
</div>

<%@ include file="common/footer.jsp" %>

<%@ include file="common/js.jsp" %>
<script type="text/javascript" src="${BASE}/www/js/product_view.js"></script>

</body>
</html>