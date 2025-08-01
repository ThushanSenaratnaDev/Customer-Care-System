package FAQ1;
//FAQ model
public class FAQ {
	private String Question;
	private String Answer;
	private int FAQID;
	
	public FAQ(String question, String answer, int fAQID) {
		super();
		Question = question;
		Answer = answer;
		FAQID = fAQID;
	}

	public String getQuestion() {
		return Question;
	}

	

	public String getAnswer() {
		return Answer;
	}

	

	public int getFAQID() {
		return FAQID;
	}

	
	
	
	
	
}
