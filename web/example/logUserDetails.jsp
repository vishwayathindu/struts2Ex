<%-- 
    Document   : logUserDetails
    Created on : Sep 29, 2020, 9:43:23 AM
    Author     : vishwa_p
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/struts-jquery-tags" prefix="sj" %>
<%@taglib uri="/struts-jquery-grid-tags" prefix="sjg" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <sj:head jqueryui="true" jquerytheme="redmond" />
        
        <style>
            table, th, td {    
                border: 1px solid black;
                width: 50%;
            }
           
            
        </style>

        <script type="text/javascript">
            function editformatter(cellvalue, options, rowObject) {
                return "<a href='javascript:void(0)' title='Edit' onClick='javascript:editjUser(&#34;" + cellvalue + "&#34;)'><img class='ui-icon ui-icon-pencil' style='display:inline-table;border:none;'/></a>";
            }

            function deleteformatter(cellvalue, options, rowObject) {
                return "<a href='javascript:void(0)' title='Delete' onClick='javascript:deletejUser(&#34;" + cellvalue + "&#34;)'><img class='ui-icon ui-icon-trash' style='display:inline-table;border:none;' /></a>";
            }

            function editjUser(keyval) {
                alert(keyval);

                $.ajax({

                    url: '${pageContext.request.contextPath}/example/FindDashBoard.blb',

                    data: {userId: keyval},
                    dataType: "json",
                    type: "POST",
                    success: function (data) {
                        $('#editj').empty();
                        var msg = data.message;
                        if (msg) {
                            alert(msg);
                        } else {
                            $('#editform').show();
                            $('#id').val(keyval);
                            $('#username').val(data.userName);
                            $('#nic').val(data.nic);
                            $('#gender').val(data.gender);

                        }
                    }

                });
            }

            function deletejUser(keyval) {
                $('#message').empty();
                $("#deletedialog").data('keyval', keyval).dialog('open');
                $("#deletedialog").html('Are you sure you want to delete agent ' + keyval + ' ?');
                return false;
            }

            function deleteUserAjax(keyval) {
                $.ajax({
                    url: '${pageContext.request.contextPath}/example/DeleteJDashBoard.blb',
                    data: {userId: keyval},
                    dataType: "json",
                    type: "POST",
                    success: function (data) {
                        $('#message').empty();
                        if (data.delsuccess == 1) {
                            $("#deletesuccdialog").dialog('open');
                            $("#deletesuccdialog").html(data.message);
                        } else {
                            $("#deleteerrordialog").dialog('open');
                            $("#deleteerrordialog").html(data.message);
                        }
                        location.reload(true);

                    },
                    error: function (data) {}

                });
            }



        </script>
    </head>
    <body>
        <h1>Log User Details</h1>
        <s:set var="vupdate"><s:property value="vupdate" default="true"/></s:set>
        <s:set var="vdelete"><s:property value="vdelete" default="true"/></s:set>
            <div id="formstyle">

            <s:form action="DashBoard" theme="simple" method="post" id="editform"  cssStyle="display:none">
                <table>
                    <tr><td></td></tr>
                    <tr><td>User ID </td><td><s:textfield id="id" name="userId" maxLength="15" readonly="true"/></td></tr>                 
                    <tr><td>User Name <span style="color: red">*</span></td><td><s:textfield id="username" name="userName" maxLength="64" onkeyup="$(this).val($(this).val().replace(/[^a-zA-Z0-9 ]/g,''))" /></td></tr>
                    <tr><td>User Mobile Number <span style="color: red">*</span></td><td><s:textfield id="nic" name="nic" maxLength="64" onkeyup="$(this).val($(this).val().replace(/[^a-zA-Z0-9 ]/g,''))" /></td></tr>
                    <tr><td>User Gender <span style="color: red">*</span></td><td><s:select  id="gender" list="#{'male':'male', 'female':'female'}"  name="gender" headerKey="" headerValue="--Select Gender--" /></td></tr>

                    <tr>
                        <td></td>
                        <td>
                            <s:url var="editurl" action="EditJDashBoard"/>

                            <sj:submit 
                                button="true" 
                                value="Update" 
                                href="%{editurl}" 
                                targets="message" 
                                onclick="location.reload(true)"
                                />

                            <sj:dialog 

                                id="deletedialog" 
                                buttons="{ 
                                'OK':function() { deleteUserAjax($(this).data('keyval'));$( this ).dialog( 'close' ); },
                                'Cancel':function() { $( this ).dialog( 'close' );} 
                                }" 
                                autoOpen="false" 
                                modal="true" 
                                title="Delete Agent"
                                position="center"
                                width="400"
                                height="250"
                                onclick="location.reload(true)" 
                                />


                        </td>
                    </tr>

                </table>
            </s:form>
        </div>
        <s:url var="dataList" action="jRetriveDashBoard" />
        <sjg:grid
            id="gridtable"
            caption="User Details"
            dataType="json"
            href="%{dataList}"
            pager="true"
            gridModel="gridModel2"
            rowList="10,15,20"
            rowNum="10"
            autowidth="true"
            rownumbers="true"
            rowTotal="false"
            viewrecords="true"
            
            >
            <sjg:gridColumn name="userId" index="userId" title="userId" />
            <sjg:gridColumn name="userName" index="userName" title="userName"  />
            <sjg:gridColumn name="nic" index="nic" title="nic"    />
            <sjg:gridColumn name="gender" index="gender" title="gender"   />
            <sjg:gridColumn name="userId" index="userId" title="Edit"  align="center"  formatter="editformatter"   />
            <sjg:gridColumn name="userId" index="userId" title="Delete"  align="center"  formatter="deleteformatter"  />


        </sjg:grid>




    </body>
</html>
