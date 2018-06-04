package com.stone.webapp.config;

import org.apache.log4j.Logger;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService {

	private Logger log = Logger.getLogger(this.getClass());
	
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        log.info("UserDetails invoked");
        return new User("zcl","123456",true,true,true,true,null);
    }
}
