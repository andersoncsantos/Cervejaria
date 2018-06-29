package com.anderson.brewer.service.event.cerveja;

import org.springframework.util.StringUtils;

import com.anderson.brewer.model.Cerveja;

public class CervejaSalvaEvent {

	private Cerveja cerveja;

	/*Quick Access: gcu*/
	public CervejaSalvaEvent(Cerveja cerveja) {
		this.cerveja = cerveja;
	}

	/*Quick Access: gga*/
	public Cerveja getCerveja() {
		return cerveja;
	}
	
	public boolean temFoto(){
		return !StringUtils.isEmpty(cerveja.getFoto());
	}
}





