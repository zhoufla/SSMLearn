package servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ItemsDAO;
import entity.Cart;
import entity.Items;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String action;// 表示前台的动作
	// 商品业务逻辑类
	private ItemsDAO idao = new ItemsDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
		super();
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (null != request.getParameter("action") && !"".equals(request.getParameter("action"))) {
			this.action = request.getParameter("action");
			if ("add".equals(action)) {//添加商品进购物车
				if (addToCart(request))
					// 服务器内部跳转
					request.getRequestDispatcher("/success.jsp").forward(request, response);
				else
					request.getRequestDispatcher("/failure.jsp").forward(request, response);
			} else if ("show".equals(action)) {//显示购物车
				request.getRequestDispatcher("/cart.jsp").forward(request, response);
			} else if ("delete".equals(action)) {// 删除商品
				deleteFromCart(request);
				request.getRequestDispatcher("/cart.jsp").forward(request, response);
			}
		}
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	private boolean deleteFromCart(HttpServletRequest request) {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		int id = Integer.parseInt(request.getParameter("id"));
		Items item = idao.getItemByID(id);
		return cart.removeGoodsFromCart(item);
	}

	/**
	 * 将商品添加进购物车
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	private boolean addToCart(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		int num = Integer.parseInt(request.getParameter("num"));
		Items item = idao.getItemByID(id);
		Cart cart = null;

		HttpSession session = request.getSession();
		cart = (Cart) session.getAttribute("cart");
		
		if (cart == null) {// 表示第一次向购物车添加商品
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		
		return cart.addGoodsInCart(item, num);
	}

}
