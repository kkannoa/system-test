package system.co.kr.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ManagerApi {

	private static final String apiUrl = "https://smartami.kr:18513/api";
	private static final String workApiUrl = "https://www.egservice.co.kr:18613/api";
	
	
	public static HashMap<String, Object> getDcuInfo(String SeqDcu) throws Exception{

		String targetUrl = apiUrl + "/GetDcuInfo";
		String parameters = "SeqDcu=" + SeqDcu;

		return sendPost(targetUrl, parameters);
	}
	
	
	// ����Ʈ ����
	public static HashMap<String, Object> GetSiteCount() throws Exception{

		String targetUrl = apiUrl + "/GetSiteCount";
		
		return sendPost(targetUrl, "");
	};
	
	public static HashMap<String, Object> GetSiteListForPaging(int IndexFrom, int IndexTo) throws Exception {

		String targetUrl = apiUrl + "/GetSiteListForPaging";
		String parameters = "IndexFrom=" + IndexFrom;
		parameters += "&IndexTo=" + IndexTo;

		return sendPost(targetUrl, parameters);
	}
	
	public static HashMap<String, Object> getDongHoCount(String SeqDong) throws Exception{

		String targetUrl = apiUrl + "/GetDongHoCount";
		String parameters = "SeqDong=" + SeqDong;

		return sendPost(targetUrl, parameters);
	}
	
	public static HashMap<String, Object> getHoCountByDong(String SeqDong) throws Exception{

		String targetUrl = workApiUrl + "/GetHoCountByDong";
		String parameters = "SeqDong=" + SeqDong;

		return sendPost(targetUrl, parameters);
	}
	
	//2023 0110
	public static HashMap<String, Object> getHoCountBySite(String SeqSite) throws Exception{

		String targetUrl = workApiUrl + "/GetHoCountBySite";
		String parameters = "SeqSite=" + SeqSite;

		return sendPost(targetUrl, parameters);
	}
	
	public static HashMap<String, Object> getHoListByDongForPaging(String SeqDong, int IndexFrom, int IndexTo) throws Exception{

		String targetUrl = workApiUrl + "/GetHoListByDongForPaging";
		String parameters = "SeqDong=" + SeqDong;
		parameters += "&IndexFrom=" + IndexFrom;
		parameters += "&IndexTo=" + IndexTo;

		return sendPost(targetUrl, parameters);
	}
	
	public static HashMap<String, Object> getHoListBySiteForPaging(String SeqSite, int IndexFrom, int IndexTo) throws Exception{

		String targetUrl = workApiUrl + "/GetHoListBySiteForPaging";
		String parameters = "SeqSite=" + SeqSite;
		parameters += "&IndexFrom=" + IndexFrom;
		parameters += "&IndexTo=" + IndexTo;

		return sendPost(targetUrl, parameters);
	}
	
	public static HashMap<String, Object> GetHoListByDong(String SeqDong) throws Exception {

		String targetUrl = apiUrl + "/GetHoListByDong";
		String parameters = "SeqDong=" + SeqDong;

		return sendPost(targetUrl, parameters);
	}
	
	public static HashMap<String, Object> GetUsageListHourly(String SeqAptHo, String DateTarget) throws Exception {

		String targetUrl = apiUrl + "/GetUsageListHourly";
		String parameters = "SeqAptHo=" + SeqAptHo;
		parameters += "&DateTarget=" + DateTarget;

		return sendPost(targetUrl, parameters);
	}
	
	
	public static HashMap<String, Object> getHoInfo(String SeqHo) throws Exception{

		String targetUrl = workApiUrl + "/GetHoInfo";
		String parameters = "SeqHo=" + SeqHo;

		return sendPost(targetUrl, parameters);
	}
	
	//mdms
	public static HashMap<String, Object> getMdmsCount() throws Exception{

		String targetUrl = apiUrl + "/GetMdmsCount";
		
		return sendPost(targetUrl, "");
	};
	
	public static HashMap<String, Object> getMdmsListForPaging(int IndexFrom, int IndexTo) throws Exception {

		String targetUrl = apiUrl + "/GetMdmsListForPaging";
		String parameters = "IndexFrom=" + IndexFrom;
		parameters += "&IndexTo=" + IndexTo;

		return sendPost(targetUrl, parameters);
	};
	
	// ���¾�ü
	public static HashMap<String, Object> getCompanyCount() throws Exception {

		String targetUrl = apiUrl + "/GetCompanyCount";

		return sendPost(targetUrl, "");
	};
	
	public static HashMap<String, Object> getCompanyListForPaging(int IndexFrom, int IndexTo) throws Exception {

		String targetUrl = apiUrl + "/GetCompanyListForPaging";
		String parameters = "IndexFrom=" + IndexFrom;
		parameters += "&IndexTo=" + IndexTo;

		return sendPost(targetUrl, parameters);
	};
	
	public static HashMap<String, Object> getSiteListByMdms(String SeqMdms) throws Exception {

		String targetUrl = apiUrl + "/GetSiteListByMdms";
		String parameters = "SeqMdms=" + SeqMdms;

		return sendPost(targetUrl, parameters);
	}
	
	//mdms
	public static HashMap<String, Object> getDcuCount(String SeqMdms, String SeqSite) throws Exception{

		String targetUrl = apiUrl + "/GetDcuCount";
		
		String parameters = "SeqMdms=" + SeqMdms;
		parameters += "&SeqSite=" + SeqSite;
			
		return sendPost(targetUrl, parameters);
	};

	public static HashMap<String, Object> getDcuListForPaging(String SeqMdms, String SeqSite, int IndexFrom, int IndexTo) throws Exception {

		String targetUrl = apiUrl + "/GetDcuListForPaging";
		String parameters = "SeqMdms=" + SeqMdms;
		parameters += "&SeqSite=" + SeqSite;
		parameters += "&IndexFrom=" + IndexFrom;
		parameters += "&IndexTo=" + IndexTo;

		return sendPost(targetUrl, parameters);
	};
	
	// ��
	public static HashMap<String, Object> getModemCount(String SeqSite, String SeqDong, String SeqDcu) throws Exception{

		String targetUrl = apiUrl + "/GetModemCount";
		String parameters = "SeqSite=" + SeqSite;
		parameters += "&SeqDong=" + SeqDong;
		parameters += "&SeqDcu=" + SeqDcu;
			
		return sendPost(targetUrl, parameters);
	};
	
	public static HashMap<String, Object> getModemListForPaging(String SeqSite, String SeqDong, String SeqDcu, int IndexFrom, int IndexTo) throws Exception {

		String targetUrl = apiUrl + "/GetModemListForPaging";
		String parameters = "SeqSite=" + SeqSite;
		parameters += "&SeqDong=" + SeqDong;
		parameters += "&SeqDcu=" + SeqDcu;
		parameters += "&IndexFrom=" + IndexFrom;
		parameters += "&IndexTo=" + IndexTo;

		return sendPost(targetUrl, parameters);
	};
	
	public static HashMap<String, Object> getDongListBySite(String SeqSite) throws Exception {

		String targetUrl = apiUrl + "/GetDongListBySite";
		String parameters = "SeqSite=" + SeqSite;

		return sendPost(targetUrl, parameters);
	};
	
	public static HashMap<String, Object> getDcuListBySite(String SeqSite) throws Exception {

		String targetUrl = apiUrl + "/GetDcuListBySite";
		String parameters = "SeqSite=" + SeqSite;

		return sendPost(targetUrl, parameters);
	};
	
	//�跮��
	public static HashMap<String, Object> getMeterCount(String SeqSite, String SeqDong, String SeqDcu) throws Exception{

		String targetUrl = apiUrl + "/GetMeterCount";
		String parameters = "SeqSite=" + SeqSite;
		parameters += "&SeqDong=" + SeqDong;
		parameters += "&SeqDcu=" + SeqDcu;
			
		return sendPost(targetUrl, parameters);
	};
	
	public static HashMap<String, Object> getMeterListForPaging(String SeqSite, String SeqDong, String SeqDcu, int IndexFrom, int IndexTo) throws Exception {

		String targetUrl = apiUrl + "/GetMeterListForPaging";
		String parameters = "SeqSite=" + SeqSite;
		parameters += "&SeqDong=" + SeqDong;
		parameters += "&SeqDcu=" + SeqDcu;
		parameters += "&IndexFrom=" + IndexFrom;
		parameters += "&IndexTo=" + IndexTo;

		return sendPost(targetUrl, parameters);
	};
	
	public static HashMap<String, Object> getUsageListDaily(String SeqAptHo, String DateFrom, String DateTo) throws Exception {

		String targetUrl = apiUrl + "/GetUsageListDaily";
		String parameters = "SeqAptHo=" + SeqAptHo;
		parameters += "&DateFrom=" + DateFrom;
		parameters += "&DateTo=" + DateTo;

		return sendPost(targetUrl, parameters);
	}
	
	public static HashMap<String, Object> getUsageListMonthly(String SeqAptHo, String MonthFrom, String MonthTo) throws Exception {

		String targetUrl = apiUrl + "/GetUsageListMonthly";
		String parameters = "SeqAptHo=" + SeqAptHo;
		parameters += "&MonthFrom=" + MonthFrom;
		parameters += "&MonthTo=" + MonthTo;

		return sendPost(targetUrl, parameters);
	}
	
	
	// ��ġ�۾���
	public static HashMap<String, Object> getWorkerCount(String SeqCompany) throws Exception {

		String targetUrl = apiUrl + "/GetWorkerCount";
		String parameters = "SeqCompany=" + SeqCompany;

		return sendPost(targetUrl, parameters);
	};
	
	public static HashMap<String, Object> getWorkerListForPaging(String SeqCompany, int IndexFrom, int IndexTo) throws Exception {

		String targetUrl = apiUrl + "/GetWorkerListForPaging";
		String parameters = "SeqCompany=" + SeqCompany;
		parameters += "&IndexFrom=" + IndexFrom;
		parameters += "&IndexTo=" + IndexTo;

		return sendPost(targetUrl, parameters);
	};
	
	//��ġ �۾��� ��� �ߺ�Ȯ��
	public static HashMap<String, Object> getWorkerIdCount(String WorkerId) throws Exception {

		String targetUrl = apiUrl + "/GetWorkerIdCount";
		String parameters = "WorkerId=" + WorkerId;

		return sendPost(targetUrl, parameters);
	};
	
	public static HashMap<String, Object> createWorker(String SeqCompany, String WorkerId, String Password, String Name, String Phone, String Mail) throws Exception {

		String targetUrl = apiUrl + "/CreateWorker";
		String parameters = "SeqCompany=" + SeqCompany;
		parameters += "&WorkerId=" + WorkerId;
		parameters += "&Password=" + Password;
		parameters += "&Name=" + Name;
		parameters += "&Phone=" + Phone;
		parameters += "&Mail=" + Mail;

		return sendPost(targetUrl, parameters);
	};
	
	public static HashMap<String, Object> getSiteList() throws Exception {

		String targetUrl = apiUrl + "/GetSiteList";

		return sendPost(targetUrl, "");
	};
	
	
	
//	==========	�α��� �� ����	==========	
	/**
	 * ���� ��� �α���
	 * @param Id
	 * @param Password
	 * @return
	 * @throws Exception
	 * 
		seq_admin == 0 �̸� ����
	 */
	public static HashMap<String, Object> checkAdminLogin(String Id, String Password) throws Exception{

		String targetUrl = apiUrl + "/CheckAdminLogin";
		String parameters = "Id=" + Id;
		parameters += "&Password=" + Password;
		
		return sendPost(targetUrl, parameters);
	};
	
	public static HashMap<String, Object> getSiteMeteringResult(String SeqSite, String To) throws Exception{

		String targetUrl = apiUrl + "/GetSiteMeteringResult";
		String parameters = "SeqSite=" + SeqSite;
		parameters += "&To=" + To;
		
		return sendPost(targetUrl, parameters);
	};
	
	public static HashMap<String, Object> getSiteMeteringState(String SeqSite, String Day) throws Exception{

		String targetUrl = apiUrl + "/GetSiteMeteringState";
		String parameters = "SeqSite=" + SeqSite;
		parameters += "&Day=" + Day;
		
		return sendPost(targetUrl, parameters);
	};
	
	
	public static HashMap<String, Object> GetSiteListForReport(int Decor) throws Exception {

		String targetUrl = apiUrl + "/GetSiteListForReport";
		String parameters = "Decor=" + 1;

		return sendPost(targetUrl, parameters);
	}
	
	/**
	 * ������� ����
	 * @param SeqAdmin
	 * @return
	 * @throws Exception
	 	
		seq_admin
		admin_id
		admin_name
		admin_rank ����
		admin_phone
		admin_mail
		time_created
		time_modified
		time_last_login = �ֱ� �α��� �ð�

	 */
	public static HashMap<String, Object> getAdminInfo(String SeqAdmin) throws Exception{

		String targetUrl = apiUrl + "/GetAdminInfo";
		String parameters = "SeqAdmin" +"=" + SeqAdmin;
		
		return sendPost(targetUrl, parameters);
	};
//	==========	�α��� �� ���� ��		==========
	
	
	/**
	 * HashMap<String, Object> �� ������ ����
	 * ����Ʈ ��û
	 * @param targetUrl
	 * @param parameters
	 * @return
	 * @throws Exception
	 */
	private static HashMap<String, Object> sendPost(String targetUrl, String parameters) throws Exception {
		
		//logger.info(targetUrl);
		//logger.info(parameters);
		
		HashMap<String, Object> returnMap = null;
		
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
		
//		System.out.println("os = " + os);
//		System.out.println("코드 : " + con.getResponseCode());
		
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
			
			returnMap = mapper.readValue(response.toString(), new TypeReference<HashMap<String, Object>>() {});
			//System.out.println(returnMap.toString());
			
		}
		
		return returnMap;
	}
	public static HashMap<String, Object> collectBadMeters() throws Exception{

		String targetUrl = apiUrl + "/CollectBadMeters";
		String parameters = "";
		
		return sendPost(targetUrl, parameters);
	};
	public static HashMap<String, Object> getLpListByMid(String Mid) throws Exception{
		System.out.println(Mid);
		String targetUrl = apiUrl + "/GetLpListByMid";
		String parameters = "Mid=" + Mid + "&MaxCount=10000";
		
		return sendPost(targetUrl, parameters);
	};
	

}
