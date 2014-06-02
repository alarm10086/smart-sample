<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="security" uri="/security" %>

<div id="header">
    <div class="logo">
        <a href="${BASE}/"><f:message key="common.title"/></a>
    </div>
    <div class="menu">
        <a href="${BASE}/product"><f:message key="product"/></a>
    </div>
    <div class="oper">
        <span><f:message key="common.user"/>: <security:principal/></span>
        <button type="button" id="logout"><f:message key="common.logout"/></button>
    </div>
</div>