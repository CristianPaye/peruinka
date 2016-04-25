package pe.com.peru.inka.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pe.com.peru.inka.service.services.SucursalService;
import pe.com.peru.inka.service.util.Sucursal;

@Controller
@RequestMapping(value = "home/sucursales")
public class SucursalController {

	@Autowired
	private SucursalService sucursalService;

	@RequestMapping(method = RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("lista", sucursalService.findAll());

		return "home/sucursales";
	}

	@RequestMapping(value = "/registro", method = RequestMethod.GET)
	public String getForm(Model model) {
		model.addAttribute("sucursal", new Sucursal());
		model.addAttribute("opc", "new");

		return "home/formSucursal";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveForm(HttpServletRequest request, @ModelAttribute("sucursal") Sucursal sucursal, Model model) {
		String opc = request.getParameter("opc");
		if ("new".equals(opc)) {
			sucursalService.save(sucursal);
		} else {
			sucursalService.update(sucursal);
		}

		return "redirect:../sucursales";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String getFormEdit(@RequestParam("id_") Long id, Model model) {
		model.addAttribute("sucursal", sucursalService.search(id));
		model.addAttribute("opc", "update");

		return "home/formSucursal";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("id_") Long id) {
		sucursalService.delete(id);
		return "redirect:../sucursales";
	}

}
