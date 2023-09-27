package com.springboot.customdbsecurity.resource;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rest/hello")
@RestController
public class HelloResource {
	
	//http:localhost:8080/rest/hello/all
	//http:localhost:8080/rest/hello/secured/control
	//http:localhost:8080/rest/hello/secured/all
	@GetMapping("/all")
	public String hello() {
		return "No Security..You can see this page";
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/secured/control")
	public String securedAdmin() {
		return "Its secured Page ..And only Admin can view this";
	}
	
	@PreAuthorize("hasAnyRole('ADMIN','GUEST')")
	@GetMapping("/secured/all")
	public String securedGuest() {
		return "Its secured Page ..Both admin and Guest can view this";
	}
	
}
