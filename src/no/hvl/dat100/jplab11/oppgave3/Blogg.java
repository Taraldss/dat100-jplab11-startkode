package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;


import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {
	private Innlegg[] innleggTabell;
	private int nesteLedige;
	
	public Blogg() {
		innleggTabell = new Innlegg[20];
		nesteLedige = getAntall();
	}

	public Blogg(int lengde) {
		innleggTabell = new Innlegg[lengde];
		nesteLedige = getAntall();
		
	}

	public int getAntall() {
		int antallObjekt = 0;
		
		for(int i = 0; i < innleggTabell.length; i++) {
			if(innleggTabell[i] != null) {
				antallObjekt++;
			}
		}
		
		return antallObjekt;

	}

	public Innlegg[] getSamling() {

		return innleggTabell;

	}

	public int finnInnlegg(Innlegg innlegg) {
		int posisjonInnlegg = 0;
		
		for(int i = 0; i < innleggTabell.length; i++) {
			if(innleggTabell[i].erLik(innlegg)) {
				posisjonInnlegg = i;
			}else {
				posisjonInnlegg = -1;
			}
		}
		
		return posisjonInnlegg;
		
	}

	public boolean finnes(Innlegg innlegg) {
		boolean finnesInnlegg = false;
		
		for(int i = 0; i < innleggTabell.length; i++) {
			if(innleggTabell[i].erLik(innlegg)) {
				finnesInnlegg = true;
			}
		}
		
		return finnesInnlegg;
	}

	public boolean ledigPlass() {
		boolean ledigPlass = false;
		
		for(int i = 0; i < innleggTabell.length; i++) {
			if(innleggTabell[i] == null) {
				ledigPlass = true;
			}
		}
		
		return ledigPlass; 

	}

	public boolean leggTil(Innlegg innlegg) {
		boolean lagtTil = false;
		
		
		if(nesteLedige < innleggTabell.length) {
			innleggTabell[nesteLedige] = innlegg;
			nesteLedige++;
			lagtTil = true;
		}
		
		
		return lagtTil;
	}

	public String toString() {
		throw new UnsupportedOperationException(TODO.method());
	}

	// valgfrie oppgaver nedenfor

	public void utvid() {
		throw new UnsupportedOperationException(TODO.method());
	}

	public boolean leggTilUtvid(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());

	}

	public boolean slett(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());
	}

	public int[] search(String keyword) {

		throw new UnsupportedOperationException(TODO.method());

	}

}