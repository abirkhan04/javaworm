package com.javaworm.springbootinmemoryauth.config;

import org.springframework.boot.actuate.audit.AuditEvent;
import org.springframework.boot.actuate.audit.listener.AuditApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

@Component
public class AuditConfig {

	@EventListener
	public void auditEventHappened(AuditApplicationEvent auditApplicationEvent) {
		AuditEvent auditEvent = auditApplicationEvent.getAuditEvent();
		System.out.println("Principal " + auditEvent.getPrincipal() + " - " + auditEvent.getType());

		WebAuthenticationDetails details = (WebAuthenticationDetails) auditEvent.getData().get("details");
		System.out.println("Remote IP address: " + details.getRemoteAddress());
		System.out.println("  Session Id: " + details.getSessionId());
	}
}
