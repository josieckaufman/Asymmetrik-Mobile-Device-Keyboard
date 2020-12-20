package autocomplete;
import java.util.*;

import autoInterfaces.AutocompleteProvider;
import autoInterfaces.Candidate;

/*This class implements the AutocompleteProvider,
 * It holds the functionality for the train
 * method and the getWords method.*/
public class AutocompleteImpl implements AutocompleteProvider {
	
	private Map<String, Candidate> runningTrain;
	private List<Candidate> words;	
	
	/*Constructor*/
	public AutocompleteImpl () {
		runningTrain = new TreeMap<String, Candidate>();
	}

	/*Return the possible candidates in a sorted list. 
	 * If the candidate starts with the fragment then add it to the list.*/
	public List<Candidate> getWords(String fragment) {
	
		String newFragment = fragment.toLowerCase().replaceAll("\\s+", " ").replaceAll("\\p{Punct}", "").trim();
		words = new ArrayList<Candidate>();

		for (Map.Entry<String, Candidate> keyString : runningTrain.entrySet()) {
			if (keyString.getKey().startsWith(newFragment)) {
				words.add(keyString.getValue());
			}
		}
	
		Collections.sort(words);
		return words;
	}

	/*Method to train a string. Tokenize each word and then if it 
	 * not added to the TreeMap yet, add it, and if it has been already,
	 *  increase the confidence by 1.*/
	public void train(String passage) {
		
		String[] tokens = passage.replaceAll("\\s+", " ").replaceAll("\\p{Punct}", "").toLowerCase().trim().split(" ");
		
		for (int i = 0; i < tokens.length; i++) {	
			if (!(runningTrain.containsKey(tokens[i]))) {
				Candidate candidate = new CandidateImpl(tokens[i]);
				runningTrain.put(tokens[i], candidate);
			}
			else {
				runningTrain.get(tokens[i]).increaseConfidenceBy1();
				runningTrain.put(tokens[i], runningTrain.get(tokens[i]));
			}	
		}
	}
	
	
	public String toString(List<Candidate> lst ) {
		StringBuilder toRet = new StringBuilder();
		
		for (Candidate cand: lst) {
		    toRet.append("\"" + cand.getWord() + "\" (" + cand.getConfidence() + "), ");
		}
		if (toRet.length() == 0) {
			return toRet.toString();
		}
		return toRet.delete(toRet.length()-2, toRet.length()).toString();
		}
	
	
}

	
	



