package com.iotconnect.miband.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iotconnect.miband.models.Heartbeat;

@Repository
public interface HeartbeatRepository  extends JpaRepository<Heartbeat, Long>{

}
