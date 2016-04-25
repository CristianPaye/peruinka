package pe.com.peru.inka.service.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import pe.com.peru.inka.service.util.Sucursal;

@Service("sucursalService")
public class SucursalService {

	public static List<Sucursal> list = new ArrayList<Sucursal>();

	public void save(Sucursal sucursal) {
		list.add(sucursal);
	}

	public List<Sucursal> findAll() {
		return list;
	}

	public void update(Sucursal sucursal) {
		List<Sucursal> listTemp = new ArrayList<Sucursal>();

		for (Sucursal s : list) {
			if (sucursal.getId().compareTo(s.getId()) == 0) {
				listTemp.add(sucursal);
			} else {
				listTemp.add(s);
			}
		}
		list = new ArrayList<Sucursal>();
		list.addAll(listTemp);

	}

	public Sucursal search(Long id) {
		Sucursal sucursal = new Sucursal();
		for (Sucursal s : list) {
			if (id.compareTo(s.getId()) == 0) {
				sucursal = s;
				continue;
			}
		}
		return sucursal;
	}

	public void delete(Long id) {
		List<Sucursal> listTemp = new ArrayList<Sucursal>();

		for (Sucursal s : list) {
			if (id.compareTo(s.getId()) != 0) {
				listTemp.add(s);
			}
		}
		list = new ArrayList<Sucursal>();
		list.addAll(listTemp);
	}
}
