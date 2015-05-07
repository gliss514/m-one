package com.mone.sales.contract.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mone.core.data.ProjGRepository;
import com.mone.core.data.ProjGService;

@Service
public class SalesContractService extends ProjGService<SalesContract>{
	
	@Autowired
	private SalesContractRepository salesContractRepository;

	@Override
	protected ProjGRepository<SalesContract> getRepository() {
		return salesContractRepository;
	}

}
