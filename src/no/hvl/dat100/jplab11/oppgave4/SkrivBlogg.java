package no.hvl.dat100.jplab11.oppgave4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {
		
		boolean erGyldig = false;

		try {

		File file = new File(mappe + filnavn);
		BufferedReader read = new BufferedReader(new FileReader(file));
		
		StringBuilder content = new StringBuilder();
		String line = samling.toString();

		while ((line = read.readLine()) != null) {
	        content.append(line);
	        content.append(System.lineSeparator());
	    }
		System.out.println(content);
		
		erGyldig = true;
		
		read.close();
		return erGyldig;
		}catch(Exception FileNotFoundException){
			System.out.println("This file does not exist");
			erGyldig = false;
			
			return erGyldig;
			
		}
		
	}
}
