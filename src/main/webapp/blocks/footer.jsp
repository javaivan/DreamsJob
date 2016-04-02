<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    for (Cookie cookie :request.getCookies()){
        if("selectedItems".equals(cookie.getName())){
            %>
                <%=cookie.getValue()%>
            <%
        }
    }
%>