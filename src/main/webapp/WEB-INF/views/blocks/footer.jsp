<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    if(session.getAttribute("sessionItems")!=null){
        %>
        <%=session.getAttribute("sessionItems")%>
        <%
    }
%>