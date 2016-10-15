package com.pi.skfwq.service;

import javax.jws.WebService;

@WebService
public interface IPInvWebService {
	public String process(String requestXml);
}
