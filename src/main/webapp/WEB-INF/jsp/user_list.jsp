<%@ page pageEncoding="UTF-8" %>
<%@ include file="common/global.jsp" %>

<table class="css-table">
    <thead>
        <tr>
            <td><f:message key="user.username"/></td>
            <td><f:message key="user.role"/></td>
            <td><f:message key="user.permission"/></td>
            <td class="css-width-75"><f:message key="common.action"/></td>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="userBean" items="${userBeanList}">
            <c:set var="user" value="${userBean.user}"/>
            <c:set var="roleList" value="${userBean.roleList}"/>
            <c:set var="permissionList" value="${userBean.permissionList}"/>
            <tr data-id="${user.id}" data-username="${user.username}">
                <td>
                    <a href="${BASE}/user/${user.id}">${user.username}</a>
                </td>
                <td>
                    <c:forEach var="role" items="${roleList}" varStatus="stauts">
                        ${role.roleName}<c:if test="${not stauts.last}">, </c:if>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach var="permission" items="${permissionList}" varStatus="stauts">
                        ${permission.permissionName}<c:if test="${not stauts.last}">, </c:if>
                    </c:forEach>
                </td>
                <td>
                    <a href="${BASE}/user/${user.id}"><f:message key="common.edit"/></a>
                    <a href="${BASE}/user/${user.id}" class="ext-user-delete"><f:message key="common.delete"/></a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>