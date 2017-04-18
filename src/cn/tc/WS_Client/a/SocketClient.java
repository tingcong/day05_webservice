package cn.tc.WS_Client.a;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Socket客户端
 *
 * Created by 聪 on 2017/4/19.
 */
public class SocketClient {
    public static void main(String[] args) throws Exception{
        //获取用户输入的数据
        Scanner input=new Scanner(System.in);
        String inputData=input.nextLine();
        System.out.println("用户输出的数据："+inputData);

        //开启一个socket端口
        Socket sc=new Socket("127.0.0.1",6666);
        OutputStream os=sc.getOutputStream();
        os.write(inputData.getBytes());

        //获取服务端回传的数据
        InputStream is=sc.getInputStream();
        byte[] buffer=new byte[10240];
        int len=-1;
        len=is.read(buffer);
        String getData=new String(buffer,0,len);
        System.out.println("从服务端获取的数据："+getData);

        //释放流
        is.close();
        os.close();
        sc.close();
    }
}
