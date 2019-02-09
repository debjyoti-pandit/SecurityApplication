package com.example.security.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "document")
@GenericGenerator(name = "pkgen", strategy = "increment")
public class DocumentEntity {

	@Id
	@GeneratedValue(generator = "pkgen")
	private Integer documentID;
	private Byte [] document;

	public Integer getDocumentID() {
		return documentID;
	}

	public void setDocumentID(Integer documentID) {
		this.documentID = documentID;
	}

	public Byte[] getDocument() {
		return document;
	}

	public void setDocument(Byte[] document) {
		this.document = document;
	}
	
}
