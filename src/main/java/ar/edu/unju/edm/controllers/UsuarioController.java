package ar.edu.unju.edm.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ar.edu.unju.edm.models.Usuario;
import ar.edu.unju.edm.service.IUsuarioService;
import jakarta.validation.Valid;

@Controller
@SessionAttributes("usuario")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo","Listado de usuarios");
		model.addAttribute("usuarios", usuarioService.findAll());
		return "listar";
	}
	
	@RequestMapping(value="/form")
	public String crearUsuario(Map<String, Object> model) {
		
		Usuario usuario = new Usuario();
		model.put("usuario", usuario);
		model.put("titulo", "Formulario de Usuario");
		return "form";
	}
	
	@RequestMapping(value="/form/{dni}")
	public String editarUsuario(@PathVariable(value="dni") Long dni, Map<String, Object> model) {
		
		Usuario usuario = null;
		
		if(dni>0) {
			usuario = usuarioService.findOne(dni);
		}else {
			return "redirect:/listar";
		}
		model.put("usuario", usuario);
		model.put("titulo", "Editar Usuario");
		return "form";
	}
	
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String guardar(@Valid Usuario usuario, BindingResult resultado, Model model, SessionStatus status) {
		
		if(resultado.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Usuario");
			return "form";
		}
		
		usuarioService.save(usuario);
		status.setComplete();
		return "redirect:listar";
	}
	
	@RequestMapping(value="/eliminar/{dni}")
	public String eliminarUsuario(@PathVariable(value="dni") Long dni) {
		
		if(dni > 0) {
			usuarioService.delete(dni);
		}
		return "redirect:/listar";
	}

}
