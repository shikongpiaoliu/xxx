import java.io.IOException;
import java.util.*;

@javax.servlet.annotation.WebServlet(name = "LoginServlet")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(password.equals(RegJDBC.getPasswordByUsername(username))){
            List wenjuans=new ArrayList();
            RegJDBC regjdbc=new RegJDBC();
            wenjuans=regjdbc.selectByUsername(username);
            //传回问卷
        }
        else
            //传回用户名或密码错误
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
