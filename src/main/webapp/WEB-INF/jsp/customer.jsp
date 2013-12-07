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
    <div id="main">
        <div class="css-panel">
            <div class="css-panel-header">
                <div class="css-left">
                    <h3><f:message key="customer.customer_list"/></h3>
                </div>
                <div class="css-right">
                    <a href="${BASE}/customer_create"><f:message key="customer.new_customer"/></a>
                </div>
            </div>
            <div class="css-panel-content">
                <div class="css-row">
                    <div class="css-left">
                        <form id="customer_search_form">
                            <div class="css-search">
                                <input type="text" name="customerName" placeholder="<f:message key="customer.customer_name"/>"/>
                                <span class="css-search-button">
                                    <button type="submit"><f:message key="common.search"/></button>
                                </span>
                            </div>
                        </form>
                    </div>
                    <div class="css-right">
                        <div id="product_pager"></div>
                    </div>
                </div>
                <%@ include file="customer_list.jsp" %>
            </div>
        </div>
    </div>
</div>

<%@ include file="common/footer.jsp" %>

<%@ include file="common/js.jsp" %>
<script type="text/javascript" src="${BASE}/www/js/customer.js"></script>

</body>
</html>