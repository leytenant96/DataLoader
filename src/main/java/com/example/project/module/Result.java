package com.example.project.module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Result {
    private String message;
    private boolean status;
    private Object object;
    private String exception;

    public Result success(Object object) {
        return new Result("success", true, object, null);
    }

    public Result failed(String exception) {
        return new Result("error", false, null, exception);
    }
  }
