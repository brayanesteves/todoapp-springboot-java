package com.halconbit.todo.app.helper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    Map<String, Object> data;

    private Map<String, Object> initObject(HttpStatus status, String message, Object responseObj){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("timestamp", new Date());
        map.put("status", status.value());
        map.put("message", message);
        map.put("data", responseObj);
        return map;
    }

    private Map<String, Object> initObject(HttpStatus status, String message){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("timestamp", new Date());
        map.put("status", status.value());
        map.put("message", message);
        return map;
    }

    private Map<String, Object> initObjectPageable(HttpStatus status, String message, Object responseObj){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("timestamp", new Date());
        map.put("status", status.value());
        map.put("message", message);
        map.put("pageable", responseObj);
        return map;
    }

    public ResponseEntity<Object> response(HttpStatus status, String message, Object responseObj) {
        try {
            this.setData(this.initObject(status,message,responseObj));
            return new ResponseEntity<>(this.getData(),status);
        } catch (Exception e) {
            return this.errorCatchResponse(data,e);
        }
    }

    public ResponseEntity<Object> response(HttpStatus status, String message) {
        try {
            this.setData(this.initObject(status,message));
            return new ResponseEntity<>(this.getData(),status);
        } catch (Exception e) {
            return this.errorCatchResponse(data,e);
        }
    }

    public ResponseEntity<Object> responsePaginate(HttpStatus status, String message, Object responseObj) {
        try {
            this.setData(this.initObjectPageable(status,message,responseObj));
            return new ResponseEntity<Object>(this.getData(),status);
        } catch (Exception e) {
            return this.errorCatchResponse(this.getData(),e);
        }
    }
    
    public ResponseEntity<Object> errorCatchResponse(Map<String, Object> map, Exception e) {
        map.clear();
        map.put("timestamp", new Date());
        map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        map.put("message", e.getMessage());
        map.put("data", null);
        return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<Object> errorException(Exception e) {
        this.setData(this.initObject(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage(),null));
        return new ResponseEntity<Object>(this.getData(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> map) {
        this.data = map;
    }
}