<%@ tag pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/global.jsp" %>

<%@ attribute name="id" required="true" type="java.lang.String" %>
<%@ attribute name="pager" required="true" type="org.smart4j.framework.dao.bean.Pager" %>

<c:set var="pageNumber" value="${pager.pageNumber}"/>
<c:set var="pageSize" value="${pager.pageSize}"/>
<c:set var="totalRecord" value="${pager.totalRecord}"/>
<c:set var="totalPage" value="${pager.totalPage}"/>

<div class="css-row">
    <div class="css-right">
        <div id="${id}">
            <span><f:message key="common.pager.page_number"/>:</span>
            <input type="text" value="${pageNumber}" class="css-width-25 css-text-center ext-pager-pn">
            <span>/</span>
            <span class="ext-pager-tp">${totalPage}</span>
            <span class="css-blank-10"></span>
            <span><f:message key="common.pager.page_size"/>:</span>
            <input type="text" value="${pageSize}" class="css-width-25 css-text-center ext-pager-ps">
            <span class="css-blank-10"></span>
            <span><f:message key="common.pager.total_record"/>:</span>
            <span>${totalRecord}</span>
            <span class="css-blank-10"></span>
            <div class="css-button-group ext-pager-button">
                <c:choose>
                    <c:when test="${pageNumber > 1 && pageNumber <= totalPage}">
                        <button type="button" title="<f:message key="common.pager.first"/>" data-pn="1">|&lt;</button>
                        <button type="button" title="<f:message key="common.pager.pre"/>" data-pn="${pageNumber - 1}">&lt;</button>
                    </c:when>
                    <c:otherwise>
                        <button type="button" title="<f:message key="common.pager.first"/>" disabled>|&lt;</button>
                        <button type="button" title="<f:message key="common.pager.pre"/>" disabled>&lt;</button>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${pageNumber < totalPage}">
                        <button type="button" title="<f:message key="common.pager.next"/>" data-pn="${pageNumber + 1}">&gt;</button>
                        <button type="button" title="<f:message key="common.pager.last"/>" data-pn="${totalPage}">&gt;|</button>
                    </c:when>
                    <c:otherwise>
                        <button type="button" title="<f:message key="common.pager.next"/>" disabled>&gt;</button>
                        <button type="button" title="<f:message key="common.pager.last"/>" disabled>&gt;|</button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</div>