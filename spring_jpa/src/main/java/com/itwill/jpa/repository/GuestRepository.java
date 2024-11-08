package com.itwill.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.jpa.entity.Guest;

public interface GuestRepository extends JpaRepository<Guest, Long>{

}