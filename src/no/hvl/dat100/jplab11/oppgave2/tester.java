package no.hvl.dat100.jplab11.oppgave2;

import no.hvl.dat100.jplab11.oppgave1.Innlegg;

public class tester {

	public static void main(String[] args) {
		Innlegg tarald = new Bilde(1, "Tarald Skaar", "23-04-2019", 0, "et bilde", "random url");
		
		System.out.println(tarald.toString());
	}

}
