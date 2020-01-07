package com.javaworm.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface ITicketService {
	@WebMethod
	public Integer ticketPrice();
}
