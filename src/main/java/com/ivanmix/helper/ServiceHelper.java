package com.ivanmix.helper;

import org.springframework.data.domain.Sort;

public class ServiceHelper {

    public static Sort getSortById(){
        return  new Sort(Sort.Direction.DESC, "id");
    }
}
