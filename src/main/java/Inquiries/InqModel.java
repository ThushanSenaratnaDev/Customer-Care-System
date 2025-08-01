package Inquiries;

public class InqModel {
	
	private int InID;
	private String Inquiry;
	private int CusID;
	private String Category;
	private String IAnswer;
	private int InAnsID;
	
	
	public InqModel(int inID, String inquiry, int cusID, String category) {
		super();
		this.InID = inID;
		this.Inquiry = inquiry;
		this.CusID = cusID;
		this.Category = category;
	}
	
	public InqModel(int inID, String inquiry, int cusID, String category,String IAnswer,int InAnsID) {
		super();
		this.InID = inID;
		this.Inquiry = inquiry;
		this.CusID = cusID;
		this.Category = category;
		this.IAnswer = IAnswer;
		this.InAnsID = InAnsID;
	}
	
	

	public int getInAnsID() {
		return InAnsID;
	}

	public void setInAnsID(int inAnsID) {
		InAnsID = inAnsID;
	}

	public String getIAnswer() {
		return IAnswer;
	}

	public void setIAnswer(String iAnswer) {
		IAnswer = iAnswer;
	}

	public int getInID() {
		return InID;
	}

	public void setInID(int inID) {
		InID = inID;
	}

	public String getInquiry() {
		return Inquiry;
	}

	public void setInquiry(String inquiry) {
		Inquiry = inquiry;
	}

	public int getCusID() {
		return CusID;
	}

	public void setCusID(int cusID) {
		CusID = cusID;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

}
	