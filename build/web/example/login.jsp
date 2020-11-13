<%-- 
    Document   : login
    Created on : Sep 21, 2020, 10:14:02 AM
    Author     : vishwa_p
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>  


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table,tr,td {
                width: 50%;
                margin-left:auto; 
                margin-right:auto;
                margin-top: auto;
                margin-bottom: auto;
            }
            td{
                width: 50px;
            }
        </style>
    </head>
    <body>
        
        <table>
            <tr>
                <td><h1>login</h1></td>
            </tr>
            
        <s:form action="checkLogin">
            <tr>
                <td><s:textfield  label="User Name" key="userName"></s:textfield></td>
            </tr>
            <tr>
                <td><s:password  label="Password" key="Password"></s:password> </td>
            </tr>
            <tr>
                <td><s:submit value="Login"></s:submit> </td>
            </tr>
            <tr>
                <td><s:a action="signUpReq">Sign Up</s:a></td>
            </tr>
        </s:form>
        
        </table>
    </body>
</html>
