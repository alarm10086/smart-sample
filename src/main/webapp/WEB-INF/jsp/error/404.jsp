<%@ page pageEncoding="UTF-8" %>
<%@ include file="../common/global.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="../common/meta.jsp" %>
    <title><f:message key="common.title"/> - <f:message key="error.page"/></title>
    <%@ include file="../common/style.jsp" %>
</head>
<body>

<div id="header">
    <div class="logo">
        <a href="${BASE}/"><f:message key="common.title"/></a>
    </div>
</div>

<div id="content">
    <div id="main">
        <h3>404 - <f:message key="error.page.404"/></h3>
        <a href="javascript:history.back();"><f:message key="common.back"/></a>
    </div>
</div>

<%@ include file="../common/footer.jsp" %>

<%@ include file="../common/script.jsp" %>

</body>
</html>