package no.hvl.dat108.Controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import no.hvl.dat108.util.LoginUtil;

@Controller
@RequestMapping("/${app.url.login}")
public class LoginController {

	@Value("${app.message.invalidPassword}") private String INVALID_PASSWORD_MESSAGE;
	@Value("${app.message.password}") private String correctPassword;
	
	@GetMapping
    public String hentLoginSkjema() {
		return "loginView";
    }

	@PostMapping
    public String provAaLoggeInn(@RequestParam String password, HttpServletRequest request,	RedirectAttributes ra) {
		
		if (!password.equals(correctPassword)) {
			ra.addFlashAttribute("redirectMessage", INVALID_PASSWORD_MESSAGE);
			return "redirect:" + "login";
		}
		
		LoginUtil.loggInnBruker(request, password);
		
		return "redirect:" + "handleliste";
	}
}
