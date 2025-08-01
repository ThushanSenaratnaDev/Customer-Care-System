package ViewFAQ;
//Inquiry Model
public class Inquiry {
	

	 
		private int inId;
		private String category;
		private String inquiry;
		private int CusID;
		private String Answer;
		
		public Inquiry(int inId, String category, String inquiry,int CusID) {
			super();
			this.inId = inId;
			this.category = category;
			this.inquiry = inquiry;
			this.CusID = CusID;
			
		}
		
		public Inquiry(int inId, String category, String inquiry,int CusID, String Answer) {
			super();
			this.inId = inId;
			this.category = category;
			this.inquiry = inquiry;
			this.CusID = CusID;
			this.Answer= Answer;
			
		}
		
		

		public int getInId() {
			return inId;
		}

		public void setInId(int inId) {
			this.inId = inId;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public String getInquiry() {
			return inquiry;
		}

		public void setInquiry(String inquiry) {
			this.inquiry = inquiry;
		}

		public int getCusID() {
			return CusID;
		}

		public void setCusID(int cusID) {
			CusID = cusID;
		}

		public String getAnswer() {
			return Answer;
		}

		public void setAnswer(String answer) {
			Answer = answer;
		}
		
		

		
		
		
		
		
		
	}


