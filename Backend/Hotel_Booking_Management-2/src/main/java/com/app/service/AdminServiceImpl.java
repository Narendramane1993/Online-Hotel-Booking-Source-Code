package com.app.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.dao.IAdminDao;
import com.app.pojos.Admin;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService{
	
	@Autowired
	IAdminDao adminDao;
	
	@Override
	public Admin authenticateAdmin(String email, String password) {
		return adminDao.findByEmailAndPassword(email, password)
				.orElseThrow(() -> new RuntimeException("Admin login failed : Invalid Credentials"));
	}

}
