package com.stone.webapp.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

import com.alibaba.fastjson.JSON;

public class MyAuthenticationProvider extends DaoAuthenticationProvider{
	
	private Logger log = Logger.getLogger(this.getClass());
	
    @Autowired
    private MyUserDetailsService uds;

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        log.info(JSON.toJSONString(auth));
    	String requestName = auth.getName();
        String requestPass = auth.getCredentials().toString();
        UserDetails ud = uds.loadUserByUsername(requestName);

        //对比用户输入密码与数据库密码是否一致
        if (requestPass.equals(ud.getPassword())) {
            System.out.println("auth:user auth success");
            return new UsernamePasswordAuthenticationToken(auth.getPrincipal(), auth.getCredentials(),
                    ud.getAuthorities());
        }
        throw new BadCredentialsException("Bad credentials");
    }

    @Override
    public boolean supports(Class<?> arg0) {
        // TODO Auto-generated method stub
        return true;
    }
}