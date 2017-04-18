package cn.tc.WS_Service.a;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Socket通信的服务端，实现大小写转化
 *
 * Created by 聪 on 2017/4/19.
 */
public class SocketSer {
    public static void main(String[] args) throws Exception{

        ServerSocket ss= new ServerSocket(6666);
        boolean flag=true;
        while (flag) {
            System.out.println("监听客户端的数据：");
            //接收客户端的请求
            Socket sc = ss.accept();
            InputStream is = sc.getInputStream();
            byte[] buffer = new byte[1024];
            int len = -1;
            len = is.read(buffer);
            String getData = new String(buffer, 0, len);
            System.out.println(getData);
            //业务处理
            String outPutData = getData.toUpperCase();

            //向客户端写数据
            OutputStream os = sc.getOutputStream();
            os.write(outPutData.getBytes("UTF-8"));

            //释放资源
            os.close();
            is.close();
            sc.close();
        }
        ss.close();
    }
}
