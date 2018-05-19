package util;

public class FileUtil {

	/**
	 * 
	 * 
	* Method : getFileName
	* 최초작성일 : 2018. 5. 9.
	* 작성자 : "L.H.B"
	* 변경이력 :
	* @param contentDosposition
	* @return
	* Method 설명 : Content-disposition 헤더에서 파일명을 추출
	 */
	public static String getFileName(String contentDisposition) {
		// "form-data; name=\"profile\"; filename=\"Chrysanthemum.jpg\"";
		String[] headers = contentDisposition.split(";");
		//form-data
		// name="profile"
		// fileName = "Chrysanthemum.jpg"
		String fileName = "";
		for (String header : headers) {
			if(header.startsWith(" filename=")){
				fileName = header.substring(" filename=".length() + 1, header.length()-1);
				break;
			}
		}
		
		return fileName;
	}
}
