package com.itwill.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Entity
public class Question {

	private Long QuestionNo;
	
	private String QuestionTitle;
	private String QuestionContent;
	private Date QuestionTime;
	private String QuestionStatus;
	private String QuestionViews;
	
	private String categoryNo;
	private String userNo;
	
	
}
