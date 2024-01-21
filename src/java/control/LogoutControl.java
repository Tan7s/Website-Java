/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nom
 */
@WebServlet(name="LogoutControl", urlPatterns={"/logout"})
public class LogoutControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false); // Lấy phiên làm việc hiện tại, nếu không có phiên làm việc tồn tại, trả về null
        if (session != null) {
            session.invalidate(); // Xóa phiên làm việc hiện tại
        }
        response.sendRedirect("home"); // Chuyển hướng đến trang đăng nhập
    }
}
