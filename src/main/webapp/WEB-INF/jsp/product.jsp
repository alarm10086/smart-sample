<%@ page pageEncoding="UTF-8" %>
<%@ include file="common/global.jsp" %>
<%@ taglib prefix="security" uri="/security" %>

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
    <div id="main">
        <div class="css-panel">
            <div class="css-panel-header">
                <h3><f:message key="product.product_list"/></h3>
            </div>
            <div class="css-panel-content">
                <div class="css-row">
                    <div class="css-left">
                        <form id="product_search_form">
                            <div class="css-search">
                                <input type="text" name="name" placeholder="<f:message key="product.name"/>">
                                <span class="css-search-button">
                                    <button type="submit"><f:message key="common.search"/></button>
                                </span>
                            </div>
                        </form>
                    </div>
                    <div class="css-right">
                        <security:hasPermission name="product.create">
                            <a href="${BASE}/product/create"><f:message key="product.create_product"/></a>
                        </security:hasPermission>
                    </div>
                </div>
                <div id="product_list">
                    <%@ include file="product_list.jsp" %>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="common/footer.jsp" %>

<%@ include file="common/script.jsp" %>

<script type="text/javascript" src="${BASE}/www/js/product.js"></script>

</body>
</html>