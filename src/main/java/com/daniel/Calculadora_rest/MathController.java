package com.daniel.Calculadora_rest;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.Calculadora_rest.converters.NumberConverter;
import com.daniel.Calculadora_rest.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {

    // Somar 
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}" ,method=RequestMethod.GET)
    public Double sum(
        @PathVariable(value = "numberOne") String numberOne,
        @PathVariable(value = "numberTwo") String numberTwo
        
        )throws Exception{
            if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)){ 
                throw new UnsupportedMathOperationException("Please set a numeric value!"); 
                
            }
            return (NumberConverter.convertToDouble(numberOne) + NumberConverter.convertToDouble(numberTwo));
        }
    // Subtrair
    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sub(
        @PathVariable(value = "numberOne") String numberOne,
        @PathVariable(value = "numberTwo") String numberTwo
    )throws Exception{
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!"); 
        }
        return (NumberConverter.convertToDouble(numberOne) - NumberConverter.convertToDouble(numberTwo));
    }

    // Multiplicar
    @RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mult(
        @PathVariable(value = "numberOne") String numberOne,
        @PathVariable(value = "numberTwo") String numberTwo
    )throws Exception{
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return (NumberConverter.convertToDouble(numberOne) * NumberConverter.convertToDouble(numberTwo));
    }
    // Dividir
    @RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double div(
        @PathVariable(value = "numberOne") String numberOne,
        @PathVariable(value = "numberTwo") String numberTwo
    )throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return (NumberConverter.convertToDouble(numberOne) / NumberConverter.convertToDouble(numberTwo));
    }

    // Raiz
    @RequestMapping(value = "/square/{number}", method = RequestMethod.GET)
    public Double square(
        @PathVariable(value = "number") String number
    )throws Exception {
        if (!NumberConverter.isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return Math.sqrt(NumberConverter.convertToDouble(number));
    }
    
}

