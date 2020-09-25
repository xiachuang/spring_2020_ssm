package com.xia.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/*
        .and().exceptionHandling().accessDeniedPage("/403");  // 处理异常，拒绝访问就重定向到 403 页面
        http.csrf().ignoringAntMatchers("/h2-console/**"); // 禁用 H2 控制台的 CSRF 防护
        http.headers().frameOptions().sameOrigin(); // 允许来自同一来源的H2 控制台的请求
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,proxyTargetClass = true)
public class MySecurityConfig  extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/*","/druid/*","/insert/**","/asserts/**","/css/**","/img/**").permitAll()
                .antMatchers("/webjars/bootstrap/**","/register").permitAll()
                .antMatchers("/spring/vip/*").hasRole("VIP")
                .anyRequest().authenticated();
//                .antMatchers("/user/**").hasAnyRole("VIP1","ADMIN");
        http.formLogin()
                .usernameParameter("user")
                .passwordParameter("pwd")
                .loginPage("/userLogin");//指定登录页面 默认post方式的/logi
        http.logout().logoutSuccessUrl("/");
        http.rememberMe().rememberMeParameter("remember");
         /*
         anyRequest().authenticated()  //anyRequest表示其他任何请求，authenticated表示需要认证
                .and() //过渡作用，返回一个对象（与http.authorizeRequests()返回的对象相同）
          */
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
}
