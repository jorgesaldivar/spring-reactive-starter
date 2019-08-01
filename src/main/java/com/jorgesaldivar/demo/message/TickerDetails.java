package com.jorgesaldivar.demo.message;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TickerDetails {

    private String ticker;
    private String price;

}