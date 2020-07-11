package com.bgamq.springboot.handler;


import com.bgamq.springboot.util.AjaxData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MySuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Value("${spring.security.loginType}")
    private String loginType;


    private static ObjectMapper object=new ObjectMapper();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {

        if(loginType.equals("JSON")){
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(object.writeValueAsString(AjaxData.success()));
        }else{
            //如果不是JSON就会返回到上次访问的页面
            super.onAuthenticationSuccess(request,response,authentication);
        }

    }
}
