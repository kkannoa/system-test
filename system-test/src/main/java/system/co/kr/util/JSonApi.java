package system.co.kr.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonArray;

public class JSonApi {

	private static final String apiUrl = "https://smartami.kr:18513/api";
	private static final String workApiUrl = "https://www.egservice.co.kr:18613/api";
	
	
	public static JSONObject GetSiteListForReport(int Decor) throws Exception {

		String targetUrl = apiUrl + "/GetSiteListForReport";
		String parameters = "Decor=" + 0;

		return sendPost2(targetUrl, parameters);
	}
	
	
	
	/**
	 * HashMap<String, Object> �� ������ ����
	 * ����Ʈ ��û
	 * @param targetUrl
	 * @param parameters
	 * @return
	 * @throws Exception
	 */
	private static JSONObject sendPost(String targetUrl, String parameters) throws Exception {
		
		//logger.info(targetUrl);
		//logger.info(parameters);
		
		JSONObject returnMap = null;
		
		URL url = new URL(targetUrl);
		HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

		con.setRequestMethod("POST"); // HTTP POST �޼ҵ� ����

		con.setRequestProperty("content-type", "application/json");
		con.setRequestProperty("Accept-Charset", "UTF-8");

		con.setDoOutput(true); // POST �Ķ���� ������ ���� ���� // Send post request

		OutputStream os = con.getOutputStream();
		os.write(parameters.getBytes());
		//System.out.println(parameters);
		os.flush();
		os.close();
		
		if (con.getResponseCode() == 200) {
			
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			String inputLine;

			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}

			in.close();

			ObjectMapper mapper = new ObjectMapper();
			//	ajax ȣ��� �� �����Ͱ� �ʿ� ��ȯ �Ǿ� �������.
			
			returnMap = mapper.readValue(response.toString(), new TypeReference<JSONObject>() {});
			System.out.println("gg = " + returnMap.toString());
			
		}
		
		return returnMap;
	}
	
	private static JSONObject sendPost2(String targetUrl, String parameters) throws Exception {

		JSONObject jsonObj = null;

		URL url = new URL(targetUrl);
		HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

		con.setRequestMethod("POST"); // HTTP POST �޼ҵ� ����

		con.setRequestProperty("content-type", "application/x-www-form-urlencoded");
		con.setRequestProperty("Accept-Charset", "UTF-8");

		con.setDoOutput(true); // POST �Ķ���� ������ ���� ���� // Send post request
		
//		System.out.println("con = " + con);

		OutputStream os = con.getOutputStream();
		os.write(parameters.getBytes());
		//System.out.println(parameters);
		os.flush();
		os.close();
		
//		System.out.println("코드 : " + con.getResponseCode());

		if (con.getResponseCode() == 200) {

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			String returnMsg = in.readLine();
			String inputLine;
//			System.out.println("응답메시지 : " + returnMsg);
			
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(returnMsg);
			jsonObj = (JSONObject) obj;
			
//			System.out.println("jsonObj1 = " + jsonObj);

//			StringBuffer response = new StringBuffer();
//			while ((inputLine = in.readLine()) != null) {
//				response.append(returnMsg);
//			}
			
//			System.out.println("response= " + response);

			in.close();

		}
		
		
		return jsonObj;

	}

}
