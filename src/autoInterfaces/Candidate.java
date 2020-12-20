package autoInterfaces;

/*Interface for Candidate*/
public interface Candidate extends java.lang.Comparable<Candidate>{

	public String getWord();
	public Integer getConfidence();
	public void increaseConfidenceBy1 ();
	public int compareTo(Candidate comparestu); 
}
