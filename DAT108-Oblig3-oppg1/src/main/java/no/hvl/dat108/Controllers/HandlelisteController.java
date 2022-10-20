package no.hvl.dat108.Controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import no.hvl.dat108.util.LoginUtil;

@Controller
public class HandlelisteController {

@Value("${app.message.requiresLogin}") private String REQUIRES_LOGIN_MESSAGE;
	
	@GetMapping("/${app.url.handleliste}")
    public String visHandleliste(HttpSession session, RedirectAttributes ra) {
		
		if (!LoginUtil.erBrukerInnlogget(session)) {
			ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
			return "redirect:" + "login";
		}
		
		synchronized(this) {
			List<String> varer = (List <String>) session.getAttribute("varer");
			if(varer == null) {
				varer = new ArrayList<>();
				session.setAttribute("varer", varer);
			}
		}

		return "handlelisteView";
    }
	
	@PostMapping("/leggtil")
    public String leggTilVarer(@RequestParam String vare, HttpSession session, RedirectAttributes ra) {
		
		if (!LoginUtil.erBrukerInnlogget(session)) {
			ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
			return "redirect:" + "login";
		}
		
		List<String> varer = (List<String>) session.getAttribute("varer");
		varer.add(vare);
		
		return "redirect:" + "login";
    }
	
	@PostMapping("/remove")
    public String removeVarer(@RequestParam String vare, HttpSession session, RedirectAttributes ra) {
		
		if (!LoginUtil.erBrukerInnlogget(session)) {
			ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN_MESSAGE);
			return "redirect:" + "login";
		}
		
		List<String> varer = (List<String>) session.getAttribute("varer");
		varer.remove(vare);
		
		return "redirect:" + "login";
    }
}
