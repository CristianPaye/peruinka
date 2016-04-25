package pe.com.peru.inka.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pe.com.peru.inka.service.services.ClienteService;
import pe.com.peru.inka.service.util.Cliente;

@Controller
@RequestMapping(value = "home/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@RequestMapping(method = RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("lista", clienteService.findAll());

		return "home/clientes";
	}

	@RequestMapping(value = "/registro", method = RequestMethod.GET)
	public String getForm(Model model) {
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("opc", "new");

		return "home/formCliente";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveForm(HttpServletRequest request, @ModelAttribute("cliente") Cliente cliente, Model model) {
		String opc = request.getParameter("opc");
		if ("new".equals(opc)) {
			clienteService.save(cliente);
		} else {
			clienteService.update(cliente);
		}

		return "redirect:../clientes";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String getFormEdit(@RequestParam("id_") Long id, Model model) {
		model.addAttribute("cliente", clienteService.search(id));
		model.addAttribute("opc", "update");

		return "home/formCliente";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("id_") Long id) {
		clienteService.delete(id);
		return "redirect:../clientes";
	}

}
