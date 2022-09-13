<%--
  Created by IntelliJ IDEA.
  User: Shaldryn
  Date: 24.08.2022
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--<%@ include file="index.html" %>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Купленные билеты:</h1>
<ul>
    <c:if test="${not empty requestScope.tickets}">
        <c:forEach var="ticket" items="${requestScope.tickets}">
            <li>${fn:toLowerCase(ticket.seatNo)}</li>
        </c:forEach>
    </c:if>
    <%--    <%--%>
    <%--        Long flightId = Long.valueOf(request.getParameter("flightId"));--%>
    <%--        List<TicketDto> tickets = TicketService.getInstance().findAllByFlightId(flightId);--%>
    <%--        for (TicketDto ticket : tickets) {--%>
    <%--            out.write(String.format("<li>%s</li>", ticket.getSeatNo()));--%>
    <%--        }--%>
    <%--    %>--%>
</ul>
</body>
</html>

<%--<%!--%>
<%-- public void jspInit() {--%>
<%--     System.out.println("Hello world!");--%>
<%-- }--%>
<%--%>--%>