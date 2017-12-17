<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
    <h1>Add new user</h1>
        
    <form:form modelAttribute="form">
        <form:errors path="" element="div" />
        
        <div>
            <form:label path="firstName">First name</form:label>
            <form:input path="firstName" />
            <form:errors path="firstName" />
        </div>
        
        <div>
            <form:label path="lastName">Last name</form:label>
            <form:input path="lastName" />
            <form:errors path="lastName" />
        </div>
        
        <div>
            <form:label path="dob">DOB</form:label>
            <form:input path="dob" />
            <form:errors path="dob" />
        </div>
        
        <div>
            <form:label path="phone">Phone</form:label>
            <form:input path="phone" />
            <form:errors path="phone" />
        </div>
        
        <div>
            <form:label path="email">Email</form:label>
            <form:input path="email" />
            <form:errors path="email" />
        </div>
        
        <div>
            <form:label path="isEmployer">isEmployer</form:label>
            <form:input path="isEmployer" />
            <form:errors path="isEmployer" />
        </div>
        
        <div>
            <form:label path="accountName">Account name</form:label>
            <form:input path="accountName" />
            <form:errors path="accountName" />
        </div>
        
        <div>
            <form:label path="password">Password</form:label>
            <form:input path="password" />
            <form:errors path="password" />
        </div>
        
        <div>
            <input type="submit" />
        </div>
    </form:form>
</body>
</html>
