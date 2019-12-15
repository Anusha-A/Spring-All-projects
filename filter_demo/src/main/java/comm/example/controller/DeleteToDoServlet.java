package comm.example.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.example.model.Todo;
import comm.example.service.ToDoService;

/**
 * Servlet implementation class DeleteToDoServlet
 */
@WebServlet("/delete-todo.do")
public class DeleteToDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ToDoService todoService = new ToDoService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		todoService.deleteTodo(new Todo(request.getParameter("todo")));
		response.sendRedirect("list-todos.do");
	}

}
