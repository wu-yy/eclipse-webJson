

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JsonServlet
 */
@WebServlet("/JsonServlet")
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JsonService service;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		
		
		String jsonString="";
		String action_flag=request.getParameter("action-flag");
		Person person =service.getPerson();
		if(action_flag.equals("person"))
		{
			jsonString=JsonTools.createJsonString("person", service.getPerson());
		}
		else if(action_flag.equals("persons"))
		{
			jsonString=JsonTools.createJsonString("persons", service.getListPerson());
			
		}else if(action_flag.equals("listString"))
		{
			jsonString=JsonTools.createJsonString("listString", service.getListString());
		}else if(action_flag.equals("listMap"))
		{
			jsonString=JsonTools.createJsonString("listMap", service.getListMaps());
		}else
		{
			
		}
		out.println(jsonString);
		out.flush();
		out.close();
	}
	public void init() throws ServletException {
		service = new JsonService();
	}

}
