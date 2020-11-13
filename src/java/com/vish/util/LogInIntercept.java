/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vish.util;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.vish.controller.Login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.StrutsStatics;
import com.opensymphony.xwork2.interceptor.Interceptor;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import static org.apache.struts2.StrutsStatics.HTTP_REQUEST;

/**
 *
 * @author vishwa_p
 */
public class LogInIntercept implements Interceptor {

    public void init() {
        System.out.println("----------------------------Intializing LoginInterceptor----------------------------");
    }

    public void destroy() {
        System.out.println("------------------ Interceptor destroy-------------");

    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        Map<String, Object> sessionAttributes = invocation.getInvocationContext().getSession();
        System.out.println("------------------ interceptor start working-------------");
        
        String result = "";

        try {
            HttpServletResponse response = ServletActionContext.getResponse();

            // Set standard HTTP/1.1 no-cache headers.
            response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);

            //New Header to avoid MIME type sniffing
            response.setHeader("X-Content-Type-Options", "nosniff");
            

            if (sessionAttributes == null || sessionAttributes.get("loginId") == null) {
                System.out.println("-----------no session was created ----------");
                return result="login";
            } else {
                if (!((String) sessionAttributes.get("loginId")).equals(null)) {
                    System.out.println("----------- session created -----------------");
                    return result=invocation.invoke();
                } else {
                    System.out.println("-----------no session was created ----------");
                    return result="login";
                }

            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    
}
