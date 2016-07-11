package pe.com.dev.util;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtil {

	public static void main(String[] args) {
//		PaperInfoOutput paperOutput = getPaperInfo();
//		
//		String json = convertObjectToJsonString(paperOutput);
//		System.out.println("convertObjectToJsonString = "+json);
//
//		PaperInfoOutput result = (PaperInfoOutput) convertJsonStringToObject(json, PaperInfoOutput.class);
//		System.out.println("convertJsonStringToObject = "+result.toString());
	}

	public static String convertObjectToJsonString(Object obj) {
		String jsonStr ="";
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			jsonStr = objectMapper.writeValueAsString(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonStr;
	}

	public static Object convertJsonStringToObject(String str, Class<?> classType){
		Object obj = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			byte[] jsonData = str.getBytes();
			obj = mapper.readValue(jsonData, classType);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
//	public static PaperInfoOutput getPaperInfo(){
//		PaperInfoOutput paperOutput = new PaperInfoOutput();
//		paperOutput.setReturnCode(0);
//		paperOutput.setReasonCode("");
//		paperOutput.setErrorText("");
//		paperOutput.setSpSqlCode(0);
//		paperOutput.setSpSqlTokens("");
//		paperOutput.setSpSqlState("");
//		
//		List<PaperInfo> papers = new ArrayList<PaperInfo>();
//		papers.add(new PaperInfo("U0117101","00104932CG","PO","08/09/2015","08/09/2015","Y","N","N","N","N","N","N","N","N","N","N","","","N","N","OSID:PO","1192712191","0","Paper","Not Eligible - Paper"));
//		papers.add(new PaperInfo("JP0000000010","JP0000000010","07","31/12/9999","31/12/9999","Y","N","N","N","N","N","N","N","N","N","N","","","N","N","REMIT_IND:","3668439","0","Paper","Not Eligible - Paper"));
//		papers.add(new PaperInfo("JP44214717","00105719CG","PO","01/04/2015","01/04/2015","Y","N","N","N","N","N","N","N","N","N","N","","","N","N","PO_ELIGIBLE","47276382","2","Paperless","Not Eligible - Paperless"));
//		papers.add(new PaperInfo("JPZ1713713","X440214704","PO","01/05/2015","01/05/2015","Y","N","N","N","N","N","N","N","N","N","N","","","N","N","PO_ELIGIBLE","1300001236","0","Paper","Not Eligible - Paper"));
//		papers.add(new PaperInfo("AU33016189","AU33016189","MU","15/08/2015","15/08/2015","Y","N","N","N","N","N","N","N","N","N","N","","","N","N","OSID:MU","1104858343","0","Paper","Not Eligible - Paper"));
//		papers.add(new PaperInfo("9124123514","9124123514","03","01/01/2015","01/01/2015","Y","N","N","N","N","N","N","N","N","N","N","","","N","N","CBSS_VBB","1300015131","0","Paper","Not Eligible - Paper"));
//		papers.add(new PaperInfo("2831633656","2831633656","03","19/05/2015","19/05/2015","Y","Y","N","N","Y","N","N","N","N","N","N","","","N","Y","","1101487012","X","Paper","Failed Paperless"));
//		papers.add(new PaperInfo("1100194118","1100194118","03","19/06/2015","19/06/2015","Y","Y","N","N","N","N","N","N","N","N","N","","","Y","N","","1300015395","3","Paperless","Pending Paperless"));
//		papers.add(new PaperInfo("000126642975","000126642975","04","28/07/2015","28/07/2015","Y","Y","Y","N","Y","N","N","Y","N","N","N","","","N","N","","8138078","0","Paper","Full Invoice"));
//		papers.add(new PaperInfo("000806485202","000806485202","04","29/10/2015","29/10/2015","Y","Y","N","N","N","N","N","N","N","N","N","","","Y","N","","1300311943","3","Paperless","Pending Paperless"));
//		
//		paperOutput.setPapers(papers);
//		return paperOutput;
//	}
}
