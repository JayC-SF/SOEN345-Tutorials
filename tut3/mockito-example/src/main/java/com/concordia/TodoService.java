package com.concordia;
import java.util.List;

public interface TodoService {

	public List<String> retrieveTodos(String user);

	void deleteTodo(String todo);

}