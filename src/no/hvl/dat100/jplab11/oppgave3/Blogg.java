package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;


import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.Bilde;
import no.hvl.dat100.jplab11.oppgave2.Tekst;


public class Blogg {
	private Innlegg[] innleggTabell;
	private int nesteLedige;
	
	public Blogg() {
		innleggTabell = new Innlegg[20];
		nesteLedige = nesteLedige();
	}

	public Blogg(int lengde) {
		innleggTabell = new Innlegg[lengde];
		nesteLedige = nesteLedige();
		
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
		int i = 0;
		
		while(i < getAntall()) {
			if(innleggTabell[i].erLik(innlegg)) {
				return i;
			}
			i++;
		}
		
		
		return -1;
		
	}

	public boolean finnes(Innlegg innlegg) {

		int i = 0;
		
		while(i < getAntall()) {
			if(innleggTabell[i].erLik(innlegg)) {
				return true;
			}
			i++;
		}
		
		return false;
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
		
		
		if(!finnes(innlegg) && nesteLedige < innleggTabell.length) {
			innleggTabell[nesteLedige] = innlegg;
			nesteLedige++;
			lagtTil = true;
		}
		
		
		return lagtTil;
	}
	
	public String toString() {
		String innleggStr = getAntall() + "\n";
		
		for(int i = 0; i < getAntall(); i++) {
			innleggStr += innleggTabell[i].toString();
		}
		
		return innleggStr;
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
	public int nesteLedige() {
		int nesteLedige = 0;
		int i = 0;
		boolean erNull = false;
		
		while(i < innleggTabell.length && !erNull) {
			if(innleggTabell[i] == null) {
				nesteLedige = i;
				erNull = true;
			}
		}
		
		return nesteLedige;
	}
	public static void main(String[] args) {
		Blogg nyBlogg = new Blogg(20);
		
		Tekst innlegg1 = new Tekst(1,"Ole Olsen","23-10-2019","en tekst");
		Bilde innlegg2 = new Bilde(2,"Oline Olsen","24-10-2019","et bilde","http://www.picture.com/oo.jpg");
		
		nyBlogg.leggTil(innlegg1);
		nyBlogg.leggTil(innlegg2);
		System.out.println(nyBlogg);
		
	}

}