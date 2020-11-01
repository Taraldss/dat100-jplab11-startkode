package no.hvl.dat100.jplab11.oppgave5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave3.*;

public class LesBlogg {

	private static final String TEKST = "TEKST";
	private static final String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {

		Blogg samling = null;

		try (BufferedReader reader = new BufferedReader(new FileReader(mappe + filnavn))) {

			int antall = Integer.parseInt(reader.readLine());

			samling = new Blogg(antall);

			for (int i = 0; i < antall; i++) {

				String typeInnlegg = reader.readLine();

				switch (typeInnlegg) {
				case (TEKST):
					samling.leggTil(new Tekst(Integer.parseInt(reader.readLine()), reader.readLine(), reader.readLine(),
							Integer.parseInt(reader.readLine()), reader.readLine()));
					break;
				case (BILDE):
					samling.leggTil(new Bilde(Integer.parseInt(reader.readLine()), reader.readLine(), reader.readLine(),
							Integer.parseInt(reader.readLine()), reader.readLine(), reader.readLine()));
					break;
				default:
					throw new IllegalArgumentException("Bad file format");
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return samling;

	}
}
