package com.example.RegisterLogin.repond;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateRepondRequest {

    private long userId;
    private long questionId;
    private double note;

}
