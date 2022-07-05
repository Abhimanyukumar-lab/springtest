package com.flight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.flight.entity.AuthGroup;
import com.flight.entity.User;
import com.flight.repo.AuthGroupRepository;
import com.flight.repo.UserRepository;
import com.flight.sec.UserDetailsPrincipal;

@Service
public class FlightUserDetailsService implements UserDetailsService {

    private UserRepository userRespository;
    
    @Autowired
    AuthGroupRepository authGroupRepository;


    
    public FlightUserDetailsService(UserRepository userRespository,  AuthGroupRepository authGroupRepository){
        super();
     this.userRespository = userRespository;
     this.authGroupRepository= authGroupRepository;
    }



    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user= this.userRespository.findByUserName(userName);

        if (user == null) {
            throw new UsernameNotFoundException("User name not found");
        }

        List<AuthGroup> authGroups = this.authGroupRepository.findByUserName(userName);

        return new UserDetailsPrincipal(user, authGroups);
    }
}
