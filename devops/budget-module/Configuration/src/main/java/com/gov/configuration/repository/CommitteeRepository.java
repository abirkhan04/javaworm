package com.gov.configuration.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.gov.configuration.entity.Committee;

public interface CommitteeRepository<T> extends PagingAndSortingRepository<Committee, Long>{

}
