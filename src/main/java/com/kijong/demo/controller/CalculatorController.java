package com.kijong.demo.controller;

import com.kijong.demo.dto.CalculatorDTO;
import com.kijong.demo.service.CalculatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CalculatorController {

    CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "I'm alive !!";
    }

//    @GetMapping("/plus")
//    public ResponseEntity<CalculatorDTO> plusTwoNumbers(CalculatorDTO calculatorDTO){
//
//        // CalculatorDTO는 프론트엔드의 값을 담으면서 num1, num2를 모두 담을 수 있는 매개변수의 역할도 해야함
//
//        log.info("calcultatorDTO: {}", calculatorDTO);
//        int result = calculatorService.plusTwoNumbers(calculatorDTO);
//        calculatorDTO.setSum(result);
//
//        return ResponseEntity.ok().body(calculatorDTO);
//    }

    @PostMapping("/plus")
    public ResponseEntity<CalculatorDTO> plusTwoNumbers(@RequestBody CalculatorDTO calculatorDTO){
        // reuqest body는 json문자열로 넘어온 값을 자바의 객체로 바꿔준다.

        // CalculatorDTO는 프론트엔드의 값을 담으면서 num1, num2를 모두 담을 수 있는 매개변수의 역할도 해야함

        log.info("calcultatorDTO: {}", calculatorDTO);
        int result = calculatorService.plusTwoNumbers(calculatorDTO);
        calculatorDTO.setSum(result);

        return ResponseEntity.ok().body(calculatorDTO);
    }
}
