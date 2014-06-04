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
    <form id="user_create_form" class="css-form">
        <div class="css-form-header">
            <h3><f:message key="user.create_user"/></h3>
        </div>
        <div class="css-form-row">
            <label for="username"><f:message key="user.username"/>:</label>
            <input type="text" id="username" name="username" class="ext-required">
        </div>
        <div class="css-form-row">
            <label for="password"><f:message key="user.password"/>:</label>
            <input type="text" id="password" name="password" class="ext-required">
        </div>
        <div class="css-form-row">
            <label><f:message key="user.role"/>:</label>
            <div class="css-form-cell">
                <tag:role roleList="${roleList}"/>
            </div>
        </div>
        <div class="css-form-footer">
            <button type="submit"><f:message key="common.save"/></button>
            <button type="button" id="back"><f:message key="common.back"/></button>
        </div>
    </form>
</div>

<%@ include file="common/footer.jsp" %>

<%@ include file="common/script.jsp" %>

<script type="text/javascript" src="${BASE}/www/js/user_create.js"></script>

</body>
</html>