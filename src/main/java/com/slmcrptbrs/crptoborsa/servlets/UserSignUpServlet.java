package com.slmcrptbrs.crptoborsa.servlets;

import com.slmcrptbrs.crptoborsa.dao.UserDao;
import com.slmcrptbrs.crptoborsa.dao.UserDaoImpl;
import com.slmcrptbrs.crptoborsa.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/userSignUp")
public class UserSignUpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       User user = new User(
        req.getParameter("userName"),
                req.getParameter("userSurname"),
                req.getParameter("email"),
                req.getParameter("password"));
        UserDao userDao = new UserDaoImpl();
        boolean b = userDao.addUser(user);

        if (b) {
            req.getSession().setAttribute("user", user);
            resp.sendRedirect(  "index.jsp");
        } else {
          String message = "Hatalı kayıt yaptınız";
          req.setAttribute("userSignUpErrorMessage", message);
          req.getRequestDispatcher("userSignUp.jsp").forward(req,resp);
        }
    }
}
