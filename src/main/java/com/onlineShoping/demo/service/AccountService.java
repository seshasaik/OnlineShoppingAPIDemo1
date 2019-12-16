package com.onlineShoping.demo.service;

import com.onlineShoping.demo.entity.Account;

public interface AccountService {

	Account createAccount(Account account);

	void findAccountById(String id);

}
