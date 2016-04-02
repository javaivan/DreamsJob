<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    if(session.getAttribute("selectedItems")!=null){
%>
    <%=session.getAttribute("selectedItems")%>
<%
    }
%>