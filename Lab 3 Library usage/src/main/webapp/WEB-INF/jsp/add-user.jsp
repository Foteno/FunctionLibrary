<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="container">
    <p>Add/Update user:</p>
    <form:form method="post" modelAttribute="user">


        <div><form:label path="name">Name:</form:label></div>
        <div><form:input path="name" type="text" required="required" /></div>
        <form:errors path="name" />
        <br>

        <div><form:label path="surname">Surname:</form:label></div>
        <div><form:input path="surname" type="text" required="required" /></div>
        <form:errors path="surname" />
        <br>

        <div><form:label path="phoneNr">Phone number:</form:label></div>
        <div><form:input path="phoneNr" type="text" required="required" /></div>
        <form:errors path="phoneNr" />
        <br>

        <div><form:label path="email">Email:</form:label></div>
        <div><form:input path="email" type="text" required="required" /></div>
        <form:errors path="email" />
        <br>

        <div><form:label path="address">Address:</form:label></div>
        <div><form:input path="address" type="text" required="required" /></div>
        <form:errors path="address" />
        <br>

        <div><form:label path="password">Password:</form:label></div>
        <div><form:input path="password" type="text" required="required" /></div>
        <form:errors path="password" />

        <button type="submit">OK</button>
    </form:form>
</div>