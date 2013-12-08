<%@ page pageEncoding="UTF-8" %>
<%@ include file="common/global.jsp" %>

<c:set var="productList" value="${productPager.recordList}"/>

<table id="product_table" class="css-table">
    <thead>
        <tr>
            <td><f:message key="product.picture"/></td>
            <td><f:message key="product.product_name"/></td>
            <td><f:message key="product.product_code"/></td>
            <td><f:message key="product.price"/></td>
            <td><f:message key="product.description"/></td>
            <td class="css-width-75"><f:message key="common.action"/></td>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="product" items="${productList}">
            <tr data-id="${product.id}" data-name="${product.productName}">
                <td>
                    <c:set var="picture" value="www/upload/${product.picture}"/>
                    <img src="${BASE}/${not empty product.picture ? picture : 'www/img/s.gif'}" height="32"/>
                </td>
                <td>
                    <a href="${BASE}/product/view/${product.id}">${product.productName}</a>
                </td>
                <td>${product.productCode}</td>
                <td>${product.price}</td>
                <td>${product.description}</td>
                <td>
                    <a href="${BASE}/product/edit/${product.id}"><f:message key="common.edit"/></a>
                    <a href="#" class="ext-product-delete"><f:message key="common.delete"/></a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<tag:pager id="product_pager" pager="${productPager}"/>