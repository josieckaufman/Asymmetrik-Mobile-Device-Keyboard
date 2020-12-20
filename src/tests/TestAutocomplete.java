package tests;

import static org.junit.Assert.*;

import autocomplete.AutocompleteImpl;
import autocomplete.CandidateImpl;

import org.junit.Test;

import autoInterfaces.AutocompleteProvider;
import autoInterfaces.Candidate;

/*JUnit Test cases for the program.*/
public class TestAutocomplete {

	@Test
	public void testAddCandidate() {
		Candidate candidate = new CandidateImpl("Josie");
		assertEquals("josie", candidate.getWord());
		assertEquals((Integer) 1, candidate.getConfidence());
	}
	@Test
	public void testSingleStr1() {
		AutocompleteProvider auto = new AutocompleteImpl();
		
		String train1 = "The third thing that I need to tell you is that this thing does not think thoroughly.";
		String input1 = "thi";
		auto.train(train1);
		
		assertEquals("\"thing\" (2), \"think\" (1), \"third\" (1), \"this\" (1)", auto.toString(auto.getWords(input1)));
	}
	@Test
	public void testSingleStr2() {
		AutocompleteProvider auto = new AutocompleteImpl();
		
		String train2 = "The third thing that I need to tell you is that this thing does not think thoroughly.";
		String input2 = "nee";
		auto.train(train2);
		assertEquals("\"need\" (1)", auto.toString(auto.getWords(input2)));
	}
	@Test
	public void testSingleStr3() {
		AutocompleteProvider auto = new AutocompleteImpl();
		
		String train3 = "The third thing that I need to tell you is that this thing does not think thoroughly.";
		String input3 = "th";
		auto.train(train3);
		assertEquals("\"that\" (2), \"thing\" (2), \"the\" (1), \"think\" (1), \"third\" (1), \"this\" (1), \"thoroughly\" (1)", auto.toString(auto.getWords(input3)));
	}
	@Test
	public void testPuncCapital() {
		AutocompleteProvider auto = new AutocompleteImpl();
		
		String train4 = "aSyMmetrIk i.s. such a .cool! place to work!!!";
		String input4 = "a";
		auto.train(train4);
		assertEquals("\"a\" (1), \"asymmetrik\" (1)", auto.toString(auto.getWords(input4)));
	}
	@Test
	public void testAddingToTrain() {
		AutocompleteProvider auto = new AutocompleteImpl();

		String train5 = "This is the first string.";
		String train6 = "This is the second string we are going to add.";
		String train7 = "This is the third string.";
		
		String input5 = "th";
		
		auto.train(train5);
		auto.train(train6);
		auto.train(train7);
		assertEquals("\"the\" (3), \"this\" (3), \"third\" (1)", auto.toString(auto.getWords(input5)));
	}

}
