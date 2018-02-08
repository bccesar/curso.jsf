package br.com.caelum.notasfiscais.listener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class CiclodeVidaListener implements PhaseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent pe) {
		
		System.out.println("Depois da fase " + pe.getPhaseId());
	}

	@Override
	public void beforePhase(PhaseEvent pe) {

		System.out.println("Depois da fase " + pe.getPhaseId());
		
	}

	@Override
	public PhaseId getPhaseId() {

		return PhaseId.ANY_PHASE;
		
	}

}
