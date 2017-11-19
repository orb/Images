package com.nostacktrace.images;

import java.io.InputStream;

public class Image {
	private int id;
	private String name;
	private String contentType;
	private InputStream contentStream;
	
	public Image(int id, String name, String contentType) {
		this.id = id;
		this.name = name;
		this.contentType = contentType;
	}

	public Image(int id, String name, String contentType, InputStream content) {
		this.id = id;
		this.name = name;
		this.contentType = contentType;
		this.contentStream = content;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getContentType() {
		return contentType;
	}
	
	public InputStream getContentStream() {
		return contentStream;
	}
	

}
