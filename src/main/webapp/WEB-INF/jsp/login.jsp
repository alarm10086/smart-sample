<%@ page pageEncoding="UTF-8" %>
<%@ include file="common/global.jsp" %>
<%@ taglib prefix="security" uri="/security" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="common/meta.jsp" %>
    <title><f:message key="common.title"/> - <f:message key="login"/></title>
    <%@ include file="common/style.jsp" %>
</head>
<body>

<security:user>
    <c:redirect context="/${BASE}" url="/products"/>
</security:user>

<div id="header">
    <div class="logo">
        <a href="${BASE}/"><f:message key="common.title"/></a>
    </div>
</div>

<div id="content">
    <form id="login_form" class="css-form" style="width: 400px; margin: 0 auto;">
        <div class="css-form-header">
            <h3><f:message key="login"/></h3>
        </div>
        <div class="css-form-row">
            <label for="username"><f:message key="login.username"/>:</label>
            <input type="text" id="username" name="username" class="css-width-150 ext-required">
        </div>
        <div class="css-form-row">
            <label for="password"><f:message key="login.password"/>:</label>
            <input type="password" id="password" name="password" class="css-width-150 ext-required">
        </div>
        <div class="css-form-row">
            <label for="captcha"><f:message key="common.captcha"/>:</label>
            <input type="text" id="captcha" name="captcha" class="css-width-50 ext-required">
            <img id="captcha_img" src="${BASE}/captcha" title="<f:message key="common.captcha.change"/>" class="css-cursor-pointer ext-captcha">
        </div>
        <div class="css-form-footer css-text-center">
            <button type="submit"><f:message key="login"/></button>
        </div>
    </form>
</div>

<%@ include file="common/footer.jsp" %>

<%@ include file="common/script.jsp" %>

<script type="text/javascript" src="${BASE}/www/js/login.js"></script>

</body>
</html>