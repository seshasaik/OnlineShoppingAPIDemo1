package com.onlineShoping.demo.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineShoping.demo.entity.Account;
import com.onlineShoping.demo.entity.ShopingCart;
import com.onlineShoping.demo.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Override
	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		account.setOpen(LocalDate.now());
		account.setAccountClosed(false);
		ShopingCart cart = new ShopingCart();
		cart.setCreated(LocalDate.now());
		account.setCart(cart);
		return accountRepository.save(account);
	}

	@Override
	public void findAccountById(String id) {
		// TODO Auto-generated method stub

	}

}
