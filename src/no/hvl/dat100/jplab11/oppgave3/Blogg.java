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

		for (int i = 0; i < innleggTabell.length; i++) {
			if (innleggTabell[i] != null) {
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

		while (i < getAntall()) {
			if (innleggTabell[i].erLik(innlegg)) {
				return i;
			}
			i++;
		}

		return -1;

	}

	public boolean finnes(Innlegg innlegg) {

		int i = 0;

		while (i < getAntall()) {
			if (innleggTabell[i].erLik(innlegg)) {
				return true;
			}
			i++;
		}

		return false;
	}

	public boolean ledigPlass() {
		boolean ledigPlass = false;

		for (int i = 0; i < innleggTabell.length; i++) {
			if (innleggTabell[i] == null) {
				ledigPlass = true;
			}
		}

		return ledigPlass;

	}

	public boolean leggTil(Innlegg innlegg) {
		boolean lagtTil = false;

		if (!finnes(innlegg) && ledigPlass()) {
			innleggTabell[nesteLedige] = innlegg;
			nesteLedige++;
			lagtTil = true;
		}

		return lagtTil;
	}

	public String toString() {
		String innleggStr = getAntall() + "\n";

		for (int i = 0; i < getAntall(); i++) {
			innleggStr += innleggTabell[i].toString();
		}

		return innleggStr;
	}

	// valgfrie oppgaver nedenfor

	public void utvid() {
		Innlegg[] nyInnTab = new Innlegg[2*innleggTabell.length];
		
		for(int i = 0; i < innleggTabell.length; i++) {
			nyInnTab[i] = innleggTabell[i];
		}
		innleggTabell = nyInnTab;
	}

	public boolean leggTilUtvid(Innlegg innlegg) {
		boolean fullført = false;
		

		return fullført;

	}

	public boolean slett(Innlegg innlegg) {
		boolean erSlettet = false;
		for(int i = 0; i < innleggTabell.length; i++) {
			if(innleggTabell[i].getId() == innlegg.getId()) {
				innleggTabell[i] = null;
				erSlettet = true;
			}
		}
		
		return erSlettet;
	}

	public int[] search(String keyword) {

		throw new UnsupportedOperationException(TODO.method());

	}

	public int nesteLedige() {
		int nesteLedige = 0;
		int i = 0;
		boolean erNull = false;

		while (i < innleggTabell.length && !erNull) {
			if (innleggTabell[i] == null) {
				nesteLedige = i;
				erNull = true;
			}
		}

		return nesteLedige;
	}

	public static void main(String[] args) {
		Blogg nyBlogg = new Blogg(2);

		Tekst innlegg1 = new Tekst(1, "Ole Olsen", "23-10-2019", "en tekst");
		Bilde innlegg2 = new Bilde(2, "Oline Olsen", "24-10-2019", "et bilde", "http://www.picture.com/oo.jpg");
		
		System.out.println("forventa svar finnInnlegg1: -1: " + nyBlogg.finnInnlegg(innlegg1));
		System.out.println("forventa svar finnInnlegg2: -1: " + nyBlogg.finnInnlegg(innlegg2));
		
		nyBlogg.leggTil(innlegg1);
		nyBlogg.leggTil(innlegg2);

		System.out.println("Forventa Svar: 2 :: " + nyBlogg.getAntall());
		System.out.println("Foventa Svar: False :: " + nyBlogg.ledigPlass());

		nyBlogg.utvid();

		System.out.println("Forventa Svar finnes innlegg1: True :: " + nyBlogg.finnes(innlegg1));
		System.out.println("Forventa Svar finnes innlegg2: True :: " + nyBlogg.finnes(innlegg2));
		System.out.println("Forventa Svar: 2 :: " + nyBlogg.getAntall());
		System.out.println("Forventa Svar: True :: " + nyBlogg.ledigPlass());

	}

}