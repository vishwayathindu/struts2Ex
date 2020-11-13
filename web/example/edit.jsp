<%-- 
    Document   : edit
    Created on : Sep 24, 2020, 4:23:53 PM
    Author     : vishwa_p
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        <h1>Update user</h1>
        <s:form action="UpdateUsers">
            <s:iterator  value="getGridModel()">  
            <s:textfield key="userId" label="User Id" value="%{userId}"/>
            <s:textfield key="userName" label="User Name" value="%{userName}"/>
            <s:textfield key="nic" label="User NIC" value="%{nic}"/>
            <s:select key="gender" label="User" list="#{'male':'male','female':'female'}" value="%{gender}"/>
            <s:submit value="update"></s:submit>
            </s:iterator>
        </s:form>
        
   
    </body>
</html>
