package pe.com.peru.inka.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pe.com.peru.inka.service.services.ProductoService;
import pe.com.peru.inka.service.services.SucursalService;
import pe.com.peru.inka.service.util.Producto;

@Controller
@RequestMapping(value = "home/productos")
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	@Autowired
	private SucursalService sucursalService;

	@RequestMapping(method = RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("lista", productoService.findAll());

		return "home/productos";
	}

	@RequestMapping(value = "/registro", method = RequestMethod.GET)
	public String getForm(Model model) {
		model.addAttribute("producto", new Producto());
		model.addAttribute("sucursales", sucursalService.findAll());
		model.addAttribute("opc", "new");

		return "home/formProducto";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveForm(HttpServletRequest request, @ModelAttribute("producto") Producto producto, Model model) {
		String opc = request.getParameter("opc");
		if ("new".equals(opc)) {
			productoService.save(producto);
		} else {
			productoService.update(producto);
		}

		return "redirect:../productos";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String getFormEdit(@RequestParam("id_") Long id, Model model) {
		model.addAttribute("producto", productoService.search(id));
		model.addAttribute("sucursales", sucursalService.findAll());
		model.addAttribute("opc", "update");

		return "home/formProducto";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("id_") Long id) {
		productoService.delete(id);
		return "redirect:../productos";
	}

}
