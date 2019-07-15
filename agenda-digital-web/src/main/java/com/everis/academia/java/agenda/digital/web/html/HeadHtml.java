package com.everis.academia.java.agenda.digital.web.html;

public class HeadHtml {
	
	private String head;
	
	private static final String CHARSET_TAG = "<meta charset=\"utf-8\">";
	private static final String VIEWPORT_TAG = "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">";
	private static final String CSS_TAG = "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css\">";
	
	public HeadHtml() {
		super();
		this.head = "<head>\n" +
					"\t" + CHARSET_TAG + "\n" +
					"\t" + VIEWPORT_TAG + "\n" +
					"\t" + CSS_TAG + "\n" +
					"</head>";
	}
	
	public HeadHtml(String title) {
		super();
		this.head = "<head>\n" +
					"\t" + CHARSET_TAG + "\n" +
					"\t" + VIEWPORT_TAG + "\n" +
					"\t<title>" + title + "</title>\n" +
					"\t" + CSS_TAG + "\n" +
					"</head>";
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}
}
