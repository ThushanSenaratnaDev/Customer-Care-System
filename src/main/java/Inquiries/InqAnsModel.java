package Inquiries;

public class InqAnsModel {
	
	private int InAnsID;
	private int InID;
	private String IAnswers;
	
	public InqAnsModel(int inAnsID, int inID, String iAnswers) {
		super();
		InAnsID = inAnsID;
		InID = inID;
		IAnswers = iAnswers;
	}

	public int getInAnsID() {
		return InAnsID;
	}

	public void setInAnsID(int inAnsID) {
		InAnsID = inAnsID;
	}

	public int getInID() {
		return InID;
	}

	public void setInID(int inID) {
		InID = inID;
	}

	public String getIAnswers() {
		return IAnswers;
	}

	public void setIAnswers(String iAnswers) {
		IAnswers = iAnswers;
	}

}
