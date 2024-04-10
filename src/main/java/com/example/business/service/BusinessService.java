package com.example.business.service;

import com.example.business.entity.Account;
import org.springframework.stereotype.Service;

@Service
public interface BusinessService {
    Account checkRole(Account account);
}
