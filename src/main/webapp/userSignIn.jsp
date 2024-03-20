
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp" />

<form class="form" method="post" action="userSignIn">
    <table>
        <tr>
            <td>Email: </td>
            <td><input type="email" name="email"></td>
        </tr>
        <tr>
            <td>Şifre: </td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>
                <input class="button" type="submit" value="Giriş Yap">
            </td>
        </tr>
    </table>

</form>
<div>
    <c:if test="${not empty userSignInErrorMessage}">
        <b>${userSignInErrorMessage}</b>
    </c:if>

</div>

<jsp:include page="footer.jsp" />

