package com.mone.customer.model;

import org.springframework.stereotype.Repository;
import com.mone.core.data.ProjGRepository;


public interface CustomerRepository extends ProjGRepository<Customer>{
	
	Customer findByCode(String code);

}
