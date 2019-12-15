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
 * Servlet implementation class AddToDoServlet
 */
@WebServlet("/add-todo.do")
public class AddToDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ToDoService todoService = new ToDoService();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/view/add-todo.jsp").forward(
				request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String newTodo = request.getParameter("todo");
		todoService.addTodo(new Todo(newTodo));
		response.sendRedirect("list-todos.do");
	}
}
