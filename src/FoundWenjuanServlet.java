import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FoundWenjuanServlet")
public class FoundWenjuanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String user= request.getParameter("user");
        /*我这里写的是错的。。。得改。。就是接收list表，然后分条插入问卷里（应该是还得创建新表）但是我改到一半发现不会了，还没查完就去开会了。。。
        while(wenjuan.next()){
        int tihao =  chuangjianwenjuan.toInt(request.getParameter("tihao"));
        String f= request.getParameter("f");
        int numofquestion = chuangjianwenjuan.toInt(request.getParameter("numofquestion"));
        int numofchoise = chuangjianwenjuan.toInt(request.getParameter("numofchoise"));
        String questioncontent = request.getParameter("questioncontent");
        String[] choise=request.getParameterValues("choise");
        String h = request.getParameter("h");
        boolean shifoutiankong,shifouqita;
        shifoutiankong=chuangjianwenjuan.duicuo(f);
        shifouqita=chuangjianwenjuan.duicuo(h);
        
        }*/

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

