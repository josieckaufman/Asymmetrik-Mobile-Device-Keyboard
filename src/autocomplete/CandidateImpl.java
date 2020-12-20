package autocomplete;
import autoInterfaces.Candidate;

/*Implementation class for candidate*/
public class CandidateImpl implements Candidate, java.lang.Comparable<Candidate> {

	private String word;
	private Integer occurrences = 1;
	
	/*Constructor to make a Candidate object*/
	public CandidateImpl(String word) {
		this.word = word;
	}
	
	/*Getters and setters*/
	public String getWord() {
		return word.toLowerCase();
	}

	public Integer getConfidence() {
		return occurrences;
	}
	
	public void increaseConfidenceBy1() {
		occurrences++;
	}
	
	/*toString to print out a single candidate object*/
	@Override
	public String toString() {
		return "\"" + this.getWord() + "\" (" + this.getConfidence() + ")";
	}
	
	/*Candidates with higher confidence will come first.*/
	@Override
	public int compareTo(Candidate comparestu) {
	     int compareage=((Candidate)comparestu).getConfidence();
	     return compareage-this.getConfidence();
	}

	
}
