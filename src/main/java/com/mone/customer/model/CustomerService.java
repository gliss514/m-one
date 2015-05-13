package com.mone.customer.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mone.core.data.ProjGRepository;
import com.mone.core.data.ProjGService;

import java.util.HashMap;
import java.util.Map;

@Service
public class CustomerService extends ProjGService<Customer>{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer findByCode(String code){
		return customerRepository.findByCode(code);
	}
	
	public Map<String, String> getCustomerList(){
		Map<String, String> customerMap = new HashMap<>();
		
		Iterable<Customer> customerIter = findAll();
		for(Customer cust : customerIter){
			customerMap.put(cust.getName(), cust.getName());
		}
		return customerMap;
	}
	
	public Map<String, String> getTypeList(){
		Map<String, String> typeMap = new HashMap<>();
		
		typeMap.put("Consumer", "Consumer");
		typeMap.put("SME", "SME");
		return typeMap;
	}

	@Override
	protected ProjGRepository<Customer> getRepository() {
		return customerRepository;
	}

}
