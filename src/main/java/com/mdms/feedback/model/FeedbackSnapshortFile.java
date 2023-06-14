package com.mdms.feedback.model;

import javax.persistence.Column;

import org.springframework.http.ResponseEntity;

public class FeedbackSnapshortFile {
	@Column(name="letterFile")
	private  ResponseEntity<byte[]> letterFile;

	public ResponseEntity<byte[]> getLetterFile() {
		return letterFile;
	}

	public void setLetterFile(ResponseEntity<byte[]> letterFile) {
		this.letterFile = letterFile;
	}
	
	
	
	

}
