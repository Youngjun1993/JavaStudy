import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class URLTest {

	public URLTest() {
		try {
			URL url = new URL("https://www.nate.com");
			//URL url = new URL("http://item.gmarket.co.kr/Item?goodsCode=1650114827");
			System.out.println("protocol-->"+url.getProtocol());
			System.out.println("hostname-->"+url.getHost());
			System.out.println("port-->"+url.getPort());
			System.out.println("filename-->"+url.getFile());
			System.out.println("path-->"+url.getPath());
			
			//URLConnection 객체를 구해 Header의 contentType을 구하면 한글코드를 알아낼 수 있다.
			URLConnection con = url.openConnection();
			con.connect();//header정보를 얻기 전에 통신채널을 확보해야된다.
			
			//Header의 contentType가져오기
			String contentType = con.getContentType();
			System.out.println("contentType="+contentType);
			
			//text/html; charset=utf-8에서 substring으로 utf-8만 담기
			String encode = contentType.substring(contentType.indexOf("=")+1);
			System.out.println("substring="+encode);
			//split으로 utf-8문자열만 담기
			String encoed[] = contentType.split("=");
			System.out.println("split="+encoed[1]);
			
			//URL 객체를 통해 리소스 가져오기
			InputStream is = url.openStream(); //코드값 리턴
			InputStreamReader isr = new InputStreamReader(is, encode);//한char를 읽어서 코드값 리턴
			BufferedReader br = new BufferedReader(isr);//String으로 리턴
			
			while(true){
				String inData = br.readLine();
				if(inData==null) break;
				System.out.println(inData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		 new URLTest();
	}

}
