package com.aloha.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
	
	private int no;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private Date updDate;
	private int view;
	
	
	public Board(String title, String writer, String content) {
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regDate = new Date();
		this.updDate = new Date();
		this.view = 0;
	}
	
	
}


