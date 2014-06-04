<%@ tag import="org.smart4j.framework.util.CollectionUtil" %>
<%@ tag import="org.smart4j.sample.entity.Role" %>
<%@ tag pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/global.jsp" %>

<%@ attribute name="roleList" required="true" type="java.util.List<org.smart4j.sample.entity.Role>" %>
<%@ attribute name="userRoleList" required="false" type="java.util.List<org.smart4j.sample.entity.Role>" %>

<%
    String template = "<label class=\"css-checkbox\"><input type=\"checkbox\" name=\"roleId\" value=\"%d\"%s>%s</label>";
    for (Role role : roleList) {
        long id = role.getId();
        String roleName = role.getRoleName();
        String checked = "";
        if (CollectionUtil.isNotEmpty(userRoleList)) {
            for (Role userRole : userRoleList) {
                if (userRole.getId() == id) {
                    checked = "checked";
                    break;
                }
            }
        }
        String html = String.format(template, id, checked, roleName);
        out.write(html);
    }
%>