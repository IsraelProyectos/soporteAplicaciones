package cat.israel.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cat.israel.spring.model.Usuarios;
import cat.israel.spring.repo.IUsuarios;
import cat.israel.spring.servicios.ConvertirAmd5;

@Controller
public class LoginController {

	@Autowired
	private IUsuarios usuarios;
	
	@RequestMapping(value="/GestionTareasSoporte", method = RequestMethod.POST)
	public String login(@RequestParam("usuario") String usuario, @RequestParam("password") String password, Model model) {
		ConvertirAmd5 convertirAmd5 = new ConvertirAmd5();
		String passwordMD5 = convertirAmd5.getMD5(password);
		List<Usuarios> user = usuarios.findByUsuario(usuario,passwordMD5);
		if (user == null || user.isEmpty()) {
			model.addAttribute("errorLogin", "El usuario no está registrado");
			return "index";
		} else {
			return "menuPrincipal";
		}
		
	}
}
