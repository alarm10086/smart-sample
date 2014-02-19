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
    <div class="css-panel">
        <form id="product_upload_form" enctype="multipart/form-data" class="css-form">
            <input type="hidden" id="id" value="${product.id}">
            <div class="css-form-header">
                <h3><f:message key="common.upload"/></h3>
            </div>
            <div class="css-form-row">
                <label for="picture"><f:message key="product.picture"/>:</label>
                <c:set var="picture" value="www/upload/${product.picture}"/>
                <img id="picture_img" src="${BASE}/${not empty product.picture ? picture : 'www/img/s.gif'}" height="128"/>
            </div>
            <div class="css-form-row">
                <label></label>
                <input type="file" id="picture" name="picture">
            </div>
            <div class="css-form-footer">
                <button type="button" id="back"><f:message key="common.back"/></button>
            </div>
        </form>
    </div>
</div>

<%@ include file="common/footer.jsp" %>

<%@ include file="common/script.jsp" %>

<script type="text/javascript" src="${BASE}/www/js/product_upload.js"></script>

</body>
</html>