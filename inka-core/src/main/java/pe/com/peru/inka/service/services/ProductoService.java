package pe.com.peru.inka.service.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import pe.com.peru.inka.service.util.Producto;

@Service("productoService")
public class ProductoService {

	public static List<Producto> list = new ArrayList<Producto>();

	public void save(Producto p) {
		list.add(p);
	}

	public List<Producto> findAll() {
		return list;
	}

	public void update(Producto Producto) {
		List<Producto> listTemp = new ArrayList<Producto>();

		for (Producto p : list) {
			if (Producto.getId().compareTo(p.getId()) == 0) {
				listTemp.add(Producto);
			} else {
				listTemp.add(p);
			}
		}
		list = new ArrayList<Producto>();
		list.addAll(listTemp);

	}

	public Producto search(Long id) {
		Producto Producto = new Producto();
		for (Producto p : list) {
			if (id.compareTo(p.getId()) == 0) {
				Producto = p;
				continue;
			}
		}
		return Producto;
	}

	public void delete(Long id) {
		List<Producto> listTemp = new ArrayList<Producto>();

		for (Producto p : list) {
			if (id.compareTo(p.getId()) != 0) {
				listTemp.add(p);
			}
		}
		list = new ArrayList<Producto>();
		list.addAll(listTemp);
	}
}
