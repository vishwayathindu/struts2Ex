<%-- 
    Document   : dashBoard
    Created on : Sep 21, 2020, 3:05:31 PM
    Author     : vishwa_p
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/struts-jquery-tags" prefix="sj" %>
<%@taglib uri="/struts-jquery-grid-tags" prefix="sjg" %>

<!DOCTYPE html>
<html>
    <head>
        <sj:head jqueryui="true" jquerytheme="redmond" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table,tr,td {
                width: 75%;
                margin-left:auto; 
                margin-right:auto;
                border: 1px solid black;
                border-collapse:collapse;
                text-align: center;
            }
            td,th{
                border: 1px solid black;
                border-collapse:collapse;
                width: 50px;
            }
        </style>



    </head>
    <body>

        <h3>All Records:</h3>  
        <table>
            <tr>
                <th>studentId</th>
                <th>studentName</th>
                <th>nic</th>
                <th>gender</th>
                <th>edit</th>
                <th>delete</th>

            </tr>
            <s:iterator  value="getGridModel()">  
                <tr>
                    <td><s:property value="userId"/></td>
                    <td><s:property  value="userName"/></td>
                    <td><s:property value="nic"/></td>
                    <td><s:property value="gender"/></td>
                    <td>
                        <s:a action="EditUsers"><s:param name="userId"><s:property value="userId"/></s:param>Edit</s:a>
                            <td>
                        <s:a action="DeleteUsers" onclick="return confirm('Deletel');"><s:param name="userId"><s:property value="userId"/></s:param>Delete</s:a>
                            </td>

                        </tr>
            </s:iterator>
            <tr>
                <td colspan="6"></td>
            </tr>

        </table>
        <s:a action="jReDashBoard">jRetrive</s:a>

        <s:a action="LogOutUsers">Log Out</s:a>




    </body>
</html>
