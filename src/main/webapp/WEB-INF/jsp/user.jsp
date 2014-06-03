<%@ page pageEncoding="UTF-8" %>
<%@ include file="common/global.jsp" %>
<%@ taglib prefix="security" uri="/security" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="common/meta.jsp" %>
    <title><f:message key="common.title"/> - <f:message key="user"/></title>
    <%@ include file="common/style.jsp" %>
</head>
<body>

<%@ include file="common/header.jsp" %>

<div id="content">
    <div id="main">
        <div class="css-panel">
            <div class="css-panel-header">
                <h3><f:message key="user.user_list"/></h3>
            </div>
            <div class="css-panel-content">
                <div class="css-row">
                    <div class="css-left">
                        <form id="user_search_form">
                            <div class="css-search">
                                <input type="text" name="username" placeholder="<f:message key="user.username"/>">
                                <span class="css-search-button">
                                    <button type="submit"><f:message key="common.search"/></button>
                                </span>
                            </div>
                        </form>
                    </div>
                    <div class="css-right">
                        <a href="${BASE}/user/create"><f:message key="user.create_user"/></a>
                    </div>
                </div>
                <table class="css-table">
                    <thead>
                        <tr>
                            <td><f:message key="user.username"/></td>
                            <td class="css-width-75"><f:message key="common.action"/></td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="user" items="${userList}">
                            <tr data-id="${user.id}" data-name="${user.username}">
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
            </div>
        </div>
    </div>
</div>

<%@ include file="common/footer.jsp" %>

<%@ include file="common/script.jsp" %>

<script type="text/javascript" src="${BASE}/www/js/user.js"></script>

</body>
</html>