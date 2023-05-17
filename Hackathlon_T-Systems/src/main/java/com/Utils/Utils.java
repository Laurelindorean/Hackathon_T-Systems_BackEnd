/**
 * 
 */
package com.Utils;

import com.security.service.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Palmira
 *
 */
public class Utils {
	public static UserDetailsImpl  getUserDetails() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return (UserDetailsImpl) authentication.getPrincipal();
	}

}
