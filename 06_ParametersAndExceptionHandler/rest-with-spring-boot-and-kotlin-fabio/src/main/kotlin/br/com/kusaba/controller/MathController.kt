package br.com.kusaba.controller

import br.com.kusaba.converters.NumberConverter
import br.com.kusaba.exceptions.UnsupportedMathOperationException
import br.com.kusaba.math.SimpleMath
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.math.sqrt

@RestController
class MathController {

    private val math: SimpleMath = SimpleMath()

    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please, set a numeric value.")
        return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @RequestMapping(value = ["/subtraction/{numberOne}/{numberTwo}"])
    fun subtraction(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please, set a numeric value.")
        return math.subtraction(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @RequestMapping(value = ["/multiply/{numberOne}/{numberTwo}"])
    fun multiply(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please, set a numeric value.")
        return math.multiplication(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @RequestMapping(value = ["/divide/{numberOne}/{numberTwo}"])
    fun divide(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please, set a numeric value.")
        if (numberTwo.equals("0") || numberTwo.equals("0.0"))
            throw UnsupportedMathOperationException("Can't divide by zero.")
        return math.division(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @RequestMapping(value = ["/average/{numberOne}/{numberTwo}"])
    fun average(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please, set a numeric value.")
        return math.average(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @RequestMapping(value = ["/square/{numberOne}"])
    fun square(
        @PathVariable(value = "numberOne") numberOne: String?
    ): Double {
        if (!NumberConverter.isNumeric(numberOne))
            throw UnsupportedMathOperationException("Please, set a numeric value.")
        return math.squareRoot(NumberConverter.convertToDouble(numberOne))
    }
}