package com.datang.service;

import com.datang.dao.PlayerRepository;
import com.datang.entity.NBAPlayer;
import com.datang.entity.NBARole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService implements UserDetailsService {

    @Autowired
    PlayerRepository playerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        NBAPlayer player = playerRepository.findByLoginName(username);
        if (player == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<NBARole> roles = player.getRoles();
        for (NBARole r : roles) {
            authorities.add(new SimpleGrantedAuthority(r.getAuthority()));
        }
        return new User(player.getUsername(), player.getPassword(), authorities);
    }
}
