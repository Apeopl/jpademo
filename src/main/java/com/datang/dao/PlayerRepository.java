package com.datang.dao;

import com.datang.entity.NBAPlayer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<NBAPlayer, Long> {
    NBAPlayer findByLoginName(String loginName);
}
