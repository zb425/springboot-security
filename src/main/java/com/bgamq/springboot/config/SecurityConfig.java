package com.bgamq.springboot.config;


import com.bgamq.springboot.handler.MyFailureHandler;
import com.bgamq.springboot.handler.MySuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Resource
    private MySuccessHandler successHandler;

    @Resource
    private MyFailureHandler failureHandler;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()  //开启formloginmos
                .loginPage("/login.html")  //用户未登录，访问任何资源都转到该路径
                .loginProcessingUrl("/login") //登录表单form中的action地址
                .usernameParameter("username") //默认是username
                .passwordParameter("password") //默认是password
                .successHandler(successHandler)
//                .failureHandler(failureHandler)
                //.defaultSuccessUrl("/index")  //登录成功跳转到接口
                .failureUrl("/login.html") //登录失败跳转页面
             .and()  //and连接
             .authorizeRequests()  //配置权限
                .antMatchers("/login.html","/login").permitAll()  //用户可以任意访问
                .antMatchers("/order","/system/user")  //需要对外暴露的资源路径
                    .hasAnyAuthority("ROLE_user","ROLE_admin")  //user角色和admin角色都可以访问
                .antMatchers("/system/role","/system/menu")
                    .hasAnyRole("admin") //admin角色可以访问
                //除上面外的所有请求全部需要鉴权认证
                .anyRequest().authenticated()  //authenticated（）要求在执行该请求时，必须已经登录了应用
                .and()
                .csrf().disable();  //禁用跨站csrf攻击防御，否则无法登录成功

        http.logout().logoutUrl("/logout");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password(bCryptPasswordEncoder().encode("123456"))
                .roles("user")
                .and()
                .withUser("admin")
                .password(bCryptPasswordEncoder().encode("123456"))
                .roles("admin")
                .and()
                .passwordEncoder(bCryptPasswordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return  new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //放行以下的静态资源
        web.ignoring().mvcMatchers("/css/**","/js/**","/images/**","/font/**");
    }
}
