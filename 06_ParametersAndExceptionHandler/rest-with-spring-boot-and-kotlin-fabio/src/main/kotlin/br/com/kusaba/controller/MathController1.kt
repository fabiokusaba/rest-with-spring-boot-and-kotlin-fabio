package br.com.kusaba.controller

import br.com.kusaba.exceptions.UnsupportedMathOperationException
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.math.sqrt

// @RestController
class MathController1 {

    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please, set a numeric value.")
        return convertToDouble(numberOne) + convertToDouble(numberTwo)
    }

    @RequestMapping(value = ["/subtraction/{numberOne}/{numberTwo}"])
    fun subtraction(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please, set a numeric value.")
        return convertToDouble(numberOne) - convertToDouble(numberTwo)
    }

    @RequestMapping(value = ["/multiply/{numberOne}/{numberTwo}"])
    fun multiply(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please, set a numeric value.")
        return convertToDouble(numberOne) * convertToDouble(numberTwo)
    }

    @RequestMapping(value = ["/divide/{numberOne}/{numberTwo}"])
    fun divide(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please, set a numeric value.")
        if (numberTwo.equals("0") || numberTwo.equals("0.0"))
            throw UnsupportedMathOperationException("Can't divide by zero.")
        return convertToDouble(numberOne) / convertToDouble(numberTwo)
    }

    @RequestMapping(value = ["/average/{numberOne}/{numberTwo}"])
    fun average(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please, set a numeric value.")
        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2
    }

    @RequestMapping(value = ["/square/{numberOne}"])
    fun square(
        @PathVariable(value = "numberOne") numberOne: String?
    ): Double {
        if (!isNumeric(numberOne))
            throw UnsupportedMathOperationException("Please, set a numeric value.")
        return sqrt(convertToDouble(numberOne))
    }

    private fun convertToDouble(strNumber: String?): Double {
        if (strNumber.isNullOrBlank()) return 0.0
        // BR 10,20 -> USA 10.20
        val number = strNumber.replace(",".toRegex(), ".")
        return if (isNumeric(number)) number.toDouble() else 0.0
    }

    private fun isNumeric(strNumber: String?): Boolean {
        if (strNumber.isNullOrBlank()) return false
        val number = strNumber.replace(",".toRegex(), ".")
        return number.matches("""[-+]?[0-9]*\.?[0-9]+""".toRegex())
    }
}