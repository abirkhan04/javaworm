package com.javaworm;

import javax.jws.WebService;

import com.google.gson.Gson;


@WebService(
		endpointInterface = "com.javaworm.CodeFirstService", 
		serviceName = "CodeFirstService")
public class CodeFirstServiceImpl implements CodeFirstService{

	@Override
	public String showPersonDetail(String arg0, Integer arg1) {
		// TODO Auto-generated method stub
		Person person = new Person();
		person.setAge(arg1);
		person.setCity("Dhaka");
		person.setCountry("Bangladesh");
		person.setName(arg0);

		Gson gson = new Gson();
		String jsonperson = gson.toJson(person);

		return jsonperson;
		
	}

}
