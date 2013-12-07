<%@ page pageEncoding="UTF-8" %>
<%@ include file="common/global.jsp" %>

<table id="customer_table" class="css-table">
    <thead>
        <tr>
            <td><f:message key="customer.photo"/></td>
            <td><f:message key="customer.customer_name"/></td>
            <td><f:message key="customer.description"/></td>
            <td class="css-width-75"><f:message key="common.action"/></td>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="customer" items="${customerList}">
            <tr data-id="${customer.id}" data-name="${customer.customerName}">
                <td>
                    <c:set var="photo" value="www/upload/${customer.photo}"/>
                    <img src="${BASE}/${not empty customer.photo ? photo : 'www/img/default.jpg'}" height="32"/>
                </td>
                <td>
                    <a href="${BASE}/customer/view/${customer.id}">${customer.customerName}</a>
                </td>
                <td>${customer.description}</td>
                <td>
                    <a href="${BASE}/customer/edit/${customer.id}"><f:message key="common.edit"/></a>
                    <a href="#" class="ext-customer-delete"><f:message key="common.delete"/></a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
