package com.github.heliomfdev.restful_ws.util;

import com.github.heliomfdev.restful_ws.dto.EmptyDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hélio Márcio Filho
 * @see <a href="https://github.com/heliomf-dev">Visit my GitHub</a>
 * @since 1.0
 * @version 1.0
 *
 * Creates and returns {@link ResponseEntity} objects containing JSON as response.
 * */
public class CreateResponseEntity {

    /**
     * Creates a {@link ResponseEntity} containing a single JSON object as response.
     *
     * @param responseObject object that will be included in response.
     * */
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

    /**
     * Creates a {@link ResponseEntity} containing a list of JSON object as response.
     *
     * @param responseObject list of object that will be included in response.
     * */
    @SuppressWarnings("unchecked")
    public static <T extends List<?>> ResponseEntity<T> createFromListDTO(T responseObject) {
        ResponseEntity<T> responseEntity;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");

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
