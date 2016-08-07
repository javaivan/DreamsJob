package com.ivanmix.util;

import com.ivanmix.models.CurrentUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public final class SecurityUtil {

    public static CurrentUser getCurrentMember() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null) {
            return null;
        }
        Object principal = authentication.getPrincipal();
        if (principal instanceof CurrentUser) {
            return ((CurrentUser)principal);
        } else {
            return null;
        }
    }

    public static Long getCurrentUserId(){
        CurrentUser currentUser = getCurrentMember();
        return currentUser != null ? currentUser.getId() : null;
    }
}
