package cn.tc.WS_Client.weather;

import cn.com.webxml.WeatherWS;
import cn.com.webxml.WeatherWSSoap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by 聪 on 2017/4/20.
 */
@WebServlet(urlPatterns = "/weatherServlet")
public class WeatherServlet extends HttpServlet {
    private WeatherWS ws;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String cityCode=request.getParameter("city");
        System.out.println("获取城市的id:"+cityCode);

        //通过webservice获取远程的天气信息
        WeatherWSSoap weatherWSSoap=ws.getWeatherWSSoap();
        List<String> weathers=weatherWSSoap.getWeather(cityCode,"").getString();
        String weather=weathers.get(8); //取得温度的信息

        //把结果回显页面
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter=response.getWriter();
        printWriter.write(weather);

        printWriter.flush();
        printWriter.close();
    }

    @Override
    public void init() throws ServletException {
        //put your code here
        ws=new WeatherWS();
    }
}
