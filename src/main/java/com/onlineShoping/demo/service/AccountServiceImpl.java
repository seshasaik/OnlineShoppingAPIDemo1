package com.onlineShoping.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineShoping.demo.entity.Account;
import com.onlineShoping.demo.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Override
	public void createAccount(Account account) {
		// TODO Auto-generated method stub

	}

	@Override
	public void findAccountById(String id) {
		// TODO Auto-generated method stub

	}

}
