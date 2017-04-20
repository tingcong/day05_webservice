通过wsimport生成本地代理来访问已经发布的webservice

通过wsimport生成Java代码：
Wsimport http://webservice.webxml.com.cn/WebServices/MobileCodeWS.asmx?WSDL   // 只能生成 class格式
wsimport –s . http://webservice.webxml.com.cn/WebServices/MobileCodeWS.asmx?WSDL   // 能生成 class格式和Java源文件
Wsimport –s . –p a.b.c
http://webservice.webxml.com.cn/WebServices/MobileCodeWS.asmx?WSDL // 能生成 class格式和Java源文件  并且可以自定义包名



jar -cvf mobile.jar .  // 把当前路径打包成jar文件, 包名为mobile.jar