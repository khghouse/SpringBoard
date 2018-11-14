package spring.com.collections;
 
import java.io.Serializable;
import java.util.HashMap;

/**
 * 대소문자 구분 없이 값을 가져오기 위한 Map
 * commons-collections.jar (3.0 부터)
 * 
 * @author sungj
 *
 */
//@DataTransferObject(
//		converter=BeanConverter.class,
//		params={
//			@Param(name="javascript",value="RSMap")
//		}
//)
public class RSMap extends HashMap implements Serializable{
	/******************************************************************
	 * public class RSMap extends CaseInsensitiveMap{
	 *     CaseInsensitiveMap 을 사용할 경우 jsp에서 일반적은것은 대소문자 구분없이 잘 되는데
	 *     DWR3.0 에서는 대문자 키로 넣은 값이 소문자로만 처리된다.  
	 *     - HashMap으로 사용합시다
	 ******************************************************************/
	//public class RSMap extends CaseInsensitiveMap{
	//private String menu_id;
	
    /**
     * 성공인가? 실패인가? 를 flag로 갖는다.
     */	
	private boolean isSuccessful;

    /**
     * 처리중 발생한 메세지를 담고 있다.(실패인경우 오류메세지를 담고 있다.)
     */
    public String resultMessage;

	public boolean isSuccessful() {
		return isSuccessful;
	}

	public void setSuccessful(boolean isSuccessful) {
		this.isSuccessful = isSuccessful;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
    
    
    
//	public String toString(){
//		return null;
//	}


 
}
