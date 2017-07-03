package com.github.heliomfdev.restful_ws.util;

import com.github.heliomfdev.restful_ws.dto.EmptyDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class CreateResponseEntity {

    @SuppressWarnings("unchecked")
    public static <T> ResponseEntity<T> createFromDTO(T responseObject) {
        ResponseEntity<T> responseEntity;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        if (responseObject != null) {
            responseEntity = new ResponseEntity<>(responseObject, headers, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>((T) new EmptyDTO(), headers, HttpStatus.OK);
        }

        return responseEntity;
    }

    @SuppressWarnings("unchecked")
    public static <T extends List<?>> ResponseEntity<T> createFromListDTO(T responseObject) {
        ResponseEntity<T> responseEntity;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        if ((responseObject != null) && (responseObject.size() != 0)) {
            responseEntity = new ResponseEntity<>(responseObject, headers, HttpStatus.OK);
        } else {
            List<EmptyDTO> emptyList = new ArrayList<>();
            emptyList.add(new EmptyDTO());
            responseEntity = new ResponseEntity<>((T) emptyList, headers, HttpStatus.OK);
        }

        return responseEntity;
    }
}
