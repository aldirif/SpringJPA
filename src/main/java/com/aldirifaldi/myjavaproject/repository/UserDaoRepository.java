package com.aldirifaldi.myjavaproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aldirifaldi.myjavaproject.model.DAOUser;

@Repository
public interface UserDaoRepository extends JpaRepository<DAOUser,Long> {
    DAOUser findByUsername(String username);
}
