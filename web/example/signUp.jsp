<%-- 
    Document   : SignUp
    Created on : Sep 25, 2020, 11:07:19 AM
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
        <h1>register user</h1>
        <s:form action="SignUpUser">
        <table>
            
            <tr>
                <td><s:textfield key="studentName" label="User Name"/></td>
                
            <tr>
                <td><s:textfield key="nic" label="User NIC"/></td>
                
            </tr>
            <tr>
                <td><s:select key="gender" label="User Gender" list="#{'male':'male','female':'female'}"/></td>
                
            </tr>
            <tr>
                <td><s:password key="password" label="Password" /></td>
               
            </tr>
            <tr>
                <td><s:submit value="Sign Up"></s:submit></td>
            </tr>
            
        </table>
        </s:form>
        
        
    </body>
</html>
