package com.gov.configuration.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gov.configuration.entity.Committee;
import com.gov.configuration.repository.CommitteeRepository;

@Service
public class CommitteeService {

	@Autowired
	private CommitteeRepository<Committee> committeeReposiotry;

	public Committee Save(Committee committee) {
		return committeeReposiotry.save(committee);
	}

	public List<Committee> committees() {
		return (List<Committee>) committeeReposiotry.findAll();
	}

	public Committee Delete(Long id) {
		Committee committee = committeeReposiotry.findById(id).get();
		committeeReposiotry.deleteById(id);
		return committee;
	}
}
