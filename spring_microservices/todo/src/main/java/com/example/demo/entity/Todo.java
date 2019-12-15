package com.example.demo.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection="todo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Todo {
	
	private ObjectId _id;
	private String title;
	private String description;
	
	@SuppressWarnings("unused")
	private String get_id() {
		return _id.toHexString();
	}

}
