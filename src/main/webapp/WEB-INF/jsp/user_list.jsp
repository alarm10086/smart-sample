<%@ page pageEncoding="UTF-8" %>
<%@ include file="common/global.jsp" %>

<table class="css-table">
    <thead>
        <tr>
            <td><f:message key="user.username"/></td>
            <td class="css-width-75"><f:message key="common.action"/></td>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="user" items="${userList}">
            <tr data-id="${user.id}" data-username="${user.username}">
                <td>
                    <a href="${BASE}/user/${user.id}">${user.username}</a>
                </td>
                <td>
                    <a href="${BASE}/user/${user.id}"><f:message key="common.edit"/></a>
                    <a href="${BASE}/user/${user.id}" class="ext-user-delete"><f:message key="common.delete"/></a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>