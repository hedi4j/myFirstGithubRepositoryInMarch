package cn.mldn.util;

import java.util.ResourceBundle;

public class ResourceUtil {
	private ResourceBundle resb = null ;
	public ResourceUtil(String baseName) {
		this.resb = ResourceBundle.getBundle(baseName) ;
	} 
	public String getMessage(String key) { 
		try {
			String value = this.resb.getString(key) ;
			return value ;
		} catch (Exception e) {
			return null ;
		}
	}
}
