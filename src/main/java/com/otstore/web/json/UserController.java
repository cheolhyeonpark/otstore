package com.otstore.web.json;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.otstore.domain.User;
import com.otstore.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping("/join")
	public Object createUser(User user) throws Exception {
		return userService.insertUser(user);
	}

	@RequestMapping("/login")
	public Object login(User user, HttpServletRequest request) throws Exception {
		Object ret = userService.login(user);
		if (ret != null) {
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("userNumber", ret);
			return 1;
		}
		return 0;
	}

	@GetMapping("/logout")
	public int logout(HttpServletRequest request) throws Exception {
		HttpSession httpSession = request.getSession();
		httpSession.invalidate();
		return 1;
	}

	@GetMapping("/check")
	public Object check(HttpServletRequest request) throws Exception {
		HttpSession httpSession = request.getSession();
		if (httpSession.getAttribute("userNumber") == null)
			return 0;
		else
			return httpSession.getAttribute("userNumber");
	}
}
