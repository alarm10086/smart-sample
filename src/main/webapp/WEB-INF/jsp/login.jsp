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

<%@ include file="common/header_none.jsp" %>

<div id="content">
    <form id="login_form" class="css-form" style="width: 400px; margin: 0 auto;">
        <div class="css-form-header">
            <h3><f:message key="login"/></h3>
        </div>
        <div class="css-form-row">
            <label for="username"><f:message key="login.username"/>:</label>
            <input type="text" id="username" name="username" value="admin"/>
        </div>
        <div class="css-form-row">
            <label for="password"><f:message key="login.password"/>:</label>
            <input type="password" id="password" name="password" value="admin"/>
        </div>
        <div class="css-form-footer css-text-center">
            <button type="submit"><f:message key="login"/></button>
        </div>
    </form>
</div>

<%@ include file="common/footer.jsp" %>

<%@ include file="common/js.jsp" %>
<script type="text/javascript" src="${BASE}/www/js/login.js"></script>

</body>
</html>