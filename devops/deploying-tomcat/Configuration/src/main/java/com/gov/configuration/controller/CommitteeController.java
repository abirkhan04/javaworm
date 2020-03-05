package com.gov.configuration.controller;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.gov.configuration.entity.Committee;
import com.gov.configuration.service.CommitteeService;

@RestController
public class CommitteeController {

	@Autowired
	private CommitteeService committeeService;

	@GetMapping(value = "committees")
	public List<Committee> getCommittees() {
		return committeeService.committees();
	}

	@PostMapping(value = "committee")
	public Committee postCommittee(@RequestBody Committee committee) {
		committee.setOid(UUID.randomUUID());
		return committeeService.Save(committee);
	}

	@PutMapping(value = "committee")
	public Committee putCommittee(@RequestBody Committee committee) {
		return committeeService.Save(committee);
	}

	@DeleteMapping(value = "committee/{id}")
	public Committee deleteCommittee(@PathVariable("id") String id) {
		return committeeService.Delete(Long.valueOf(id));
	}
}
