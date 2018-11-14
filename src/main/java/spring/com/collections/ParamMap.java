
package spring.com.collections;

import java.io.File;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * request에 담겨오는 parameter를(file포함) 자동으로 collection에 담아서 개발자는
 * 꺼내 쓰기만 하면 되도록 하기 위한 목적으로 만든 클래스이다.
 */
public class ParamMap extends HashMap implements Serializable {
    /**
     * 일반적인 get, post 방식인 request인가? 파일처리를 위한 request인가를 판단하여
     * ParamMap에 담는 메쏘드 이다.
     */
    public void setRequest(HttpServletRequest req) throws Exception {
        String contentType = req.getContentType();

        if (contentType != null && contentType.toLowerCase().indexOf("multipart/form-data;") >= 0){
//            //파일처리  multipart/form-data;
//            MultiPartParser multipart = new MultiPartParser( (String) get(
//                "_TARGET_DIR"), req);
//
//            Enumeration parmNames = multipart.getParameterNames();
//            while (parmNames.hasMoreElements()) {
//                String key = (String) parmNames.nextElement();
//                if (multipart.getFile(key) == null) {
//                    this.put(key, multipart.getParameterValues(key));
//                }
//                else {
//                    //파일넣기
//                    this.put(key, multipart.getFile(key));
//                }
//            }
        }else if (contentType == null ||
                 (contentType != null &&
                  contentType.equals("application/x-www-form-urlencoded"))){
            //일반 파라메터 처리
            Enumeration attNames = req.getParameterNames();
            
    		Log logger = LogFactory.getLog(this.getClass());
    		StringBuffer buf = new StringBuffer();
    		if (logger.isDebugEnabled()){
    			buf.append("\n============== Request Parameters ==============");
    			while(attNames.hasMoreElements()){
    				String key = (String) attNames.nextElement();
    				String[] values = req.getParameterValues(key);
    				if(values.length>1)
    					for(String value: values)
    						buf.append("\n<PARAM><"+key+">"+value+"</"+key+"></PARAM>");
    				else
    					buf.append("\n<PARAM><"+key+">"+req.getParameter(key)+"</"+key+"></PARAM>");
    			}
    			buf.append("\n================================================");
    			logger.debug(buf.toString());
    		}

            Enumeration e = req.getParameterNames();
            while(e.hasMoreElements()){
            	String key = (String)e.nextElement();
    			String[] values = req.getParameterValues(key);
    			if(values.length>1)
    				this.put(key, values);
    			else
    				this.put(key, values[0]);
            }
            
            
//            String key;
//            for (Enumeration e = req.getParameterNames(); e.hasMoreElements();
//                 this.put(key, req.getParameterValues(key))) {
//                key = (String) e.nextElement();
//            }
        }
        //원격지 주소IP 넣는다
		String sIpAddr = StringUtils.defaultIfEmpty(req.getHeader("RLNCLIENTIPADDR"), "");
		if("".equals( sIpAddr ))
			sIpAddr = req.getRemoteAddr();
        this.put("_REMOTE_ADDR", sIpAddr);
    }

    /**
     * request요청이 발생한 원격지 주소를ip 리턴한다.</p>
     * @return String request요청이 발생한 ip주소
     */
    public String getRemoteAddr(){
        return (String)get("_REMOTE_ADDR");
    }

    /**
     * 파라메터로 발생한 데이터 처럼 ParamMap에 저장한다.</p>
     */
//    public void setParam(Object key, Object value) throws Exception {
//    	Object[] obj = new Object[1];
//        if (key == null || key.equals("")) {
//            throw new Exception("setParam: key is not available");
//        }
//        obj[0] = value == null ? "" : value;
//        this.put(key, obj);
//    }
//
//    /**
//     * 파라메터 이름에 해당하는 값을 리턴한다.</p>
//     * @return 파라메터 이름에 해당하는 값을 리턴한다.
//     */
//    public Object getParam(Object key) {
//        Object value = get(key);
//        if(value == null){
//            return "";
//        }else{
//            return ((Object[])value)[0] == null ? null:((Object[])value)[0];
//        }
//    }

    /**
     * 파라메터로 발생한 array데이터 처럼 ParamMap에 저장한다.</p>
     */
    public void setParamValues(String key, String[] values) throws Exception {
        Object value = get(key);

        if (key == null || key.equals("")) {
            throw new Exception("setParamValues: key is not available");
        }
        this.put(key, values);
    }

//    /**
//     * 파라메터 이름에 해당하는 값이 array데이터인 경우(체크박스등 동일한 이름의 파라메터) String[]로 리턴한다.</p>
//     * @return 파라메터 이름에 해당하는 String[]값을 리턴한다.
//     */
//    public String[] getParamValues(String key) {
//        Object value = get(key);
//        if (value == null) {
//            return null;
//        }
//        else {
//            return (String[]) value;
//        }
//    }

    /**
     * 파라메터 이름에 해당하는 값이 File인 경우 File로 리턴한다.</p>
     * @return 파라메터 이름에 해당하는 File을 리턴한다.
     */
    public File getFile(String fileName) {
        Object value = get(fileName);
        if (value != null && value instanceof File) {
            return (File) value;
        }
        else {
            return null;
            //throw new EXException(" No MultiPart File !!");
        }
    }

// 삭제대상
//    public String getString(String key) {
//        return get(key) == null ? "" : (String) get(key);
//    }

}
