package br.cefet.aps.cfs.control;

import br.cefet.aps.cfs.model.Client;
import br.cefet.aps.cfs.model.ClientCommon;

class ClientCommonServices extends ClientServices {

	@Override
	Client newClient(Long id, String name) {
		return new ClientCommon(id, name);
	}
}
