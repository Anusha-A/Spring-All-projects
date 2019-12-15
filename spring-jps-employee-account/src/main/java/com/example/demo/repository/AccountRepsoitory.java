package com.example.demo.repository;

import java.awt.print.Pageable;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Account;


@Repository
public interface AccountRepsoitory extends JpaRepository<Account, Long> {
	/*Page<Account> findByCustomerId(Integer customerId, Pageable pageable);

	Optional<Account> findByIdAndCustomerId(Long id, Integer customerId);*/

}
