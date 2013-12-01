<%@ page pageEncoding="UTF-8" %>
<%@ include file="common/global.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="common/meta.jsp" %>
    <title><f:message key="common.title"/> - <f:message key="customer"/></title>
    <link rel="stylesheet" href="${BASE}/www/asset/style/global.css"/>
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
                <table id="customer_table" class="css-table">
                    <thead>
                        <tr>
                            <td><f:message key="customer.customer_name"/></td>
                            <td><f:message key="customer.description"/></td>
                            <td class="css-width-75"><f:message key="common.action"/></td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="customer" items="${customerList}">
                            <tr data-id="${customer.id}" data-name="${customer.customerName}">
                                <td>
                                    <a href="${BASE}/customer/view/${customer.id}">${customer.customerName}</a>
                                </td>
                                <td>
                                    ${customer.description}
                                </td>
                                <td>
                                    <a href="${BASE}/customer/edit/${customer.id}"><f:message key="common.edit"/></a>
                                    <a href="#" class="ext-customer-delete"><f:message key="common.delete"/></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<%@ include file="common/footer.jsp" %>

<%@ include file="common/script.jsp" %>
<script type="text/javascript" src="${BASE}/www/script/customer.js"></script>

</body>
</html>