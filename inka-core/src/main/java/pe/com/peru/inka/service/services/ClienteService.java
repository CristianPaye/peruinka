package pe.com.peru.inka.service.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import pe.com.peru.inka.service.util.Cliente;

@Service("clienteService")
public class ClienteService {

	public static List<Cliente> list = new ArrayList<Cliente>();

	public void save(Cliente sucursal) {
		list.add(sucursal);
	}

	public List<Cliente> findAll() {
		return list;
	}

	public void update(Cliente sucursal) {
		List<Cliente> listTemp = new ArrayList<Cliente>();

		for (Cliente s : list) {
			if (sucursal.getId().compareTo(s.getId()) == 0) {
				listTemp.add(sucursal);
			} else {
				listTemp.add(s);
			}
		}
		list = new ArrayList<Cliente>();
		list.addAll(listTemp);

	}

	public Cliente search(Long id) {
		Cliente sucursal = new Cliente();
		for (Cliente s : list) {
			if (id.compareTo(s.getId()) == 0) {
				sucursal = s;
				continue;
			}
		}
		return sucursal;
	}

	public void delete(Long id) {
		List<Cliente> listTemp = new ArrayList<Cliente>();

		for (Cliente s : list) {
			if (id.compareTo(s.getId()) != 0) {
				listTemp.add(s);
			}
		}
		list = new ArrayList<Cliente>();
		list.addAll(listTemp);
	}

}
