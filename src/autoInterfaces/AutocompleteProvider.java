package autoInterfaces;
import java.util.List;

/*Interface for AutocompleteProvider*/
public interface AutocompleteProvider {

	public List<Candidate> getWords(String fragment);
	public void train(String passage);
	public String toString(List<Candidate> lst);
}
