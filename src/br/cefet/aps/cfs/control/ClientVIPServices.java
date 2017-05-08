package br.cefet.aps.cfs.control;

import br.cefet.aps.cfs.model.Client;
import br.cefet.aps.cfs.model.ClientVIP;

class ClientVIPServices extends ClientServices {

	@Override
	Client newClient(Long id, String name) {
		return new ClientVIP(id, name);
	}

	

}
