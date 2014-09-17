<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<form class="form-narrow form-horizontal" action='<s:url value="/j_spring_security_check"/>' method="post">
    <c:if test="${not empty param['error']}">
        <div class="alert alert-error">
            Błąd. Spróbuj jeszcze raz.
        </div>
    </c:if>
    <fieldset>
        <legend>Zaloguj</legend>
        <div class="form-group">
            <label for="inputEmail" class="col-lg-2 control-label">Email</label>
            <div class="col-lg-10">
                <input type="text" class="form-control" id="inputEmail" placeholder="Email" name="j_username" maxlength="64">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword" class="col-lg-2 control-label">Hasło</label>
            <div class="col-lg-10">
                <input type="password" class="form-control" id="inputPassword" placeholder="Password" name="j_password" maxlength="20">
            </div>
        </div>
        <div class="form-group">
            <div class="col-lg-offset-2 col-lg-10">
                <div class="checkbox">
                    <label>
                        <input type="checkbox" name="_spring_security_remember_me"> Zapamiętaj mnie
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-lg-offset-2 col-lg-10">
                <button type="submit" class="btn btn-default">Zaloguj</button>
            </div>
        </div>
        <div class="form-group">
            <div class="col-lg-offset-2 col-lg-10">
                <p>Nie masz jeszcze konta? <a href='<s:url value="/signup"/>'>Utwórz konto</a></p>
            </div>
        </div>
    </fieldset>
</form>
