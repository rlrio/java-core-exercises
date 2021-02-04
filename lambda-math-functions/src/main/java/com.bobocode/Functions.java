package com.bobocode;

public class Functions {
    /**
     * A static factory method that creates an integer function map with basic functions:
     * - abs (absolute value)
     * - sgn (signum function)
     * - increment
     * - decrement
     * - square
     *
     * @return an instance of {@link FunctionMap} that contains all listed functions
     */
    public static FunctionMap<Integer, Integer> intFunctionMap() {
        FunctionMap<Integer, Integer> intFunctionMap = new FunctionMap<>();

        intFunctionMap.addFunction("abs", Math::abs);
        intFunctionMap.addFunction("sgn", Integer::signum); //n -> (n != 0) ? n / abs(n) : 0
        intFunctionMap.addFunction("increment", a -> ++a);
        intFunctionMap.addFunction("decrement", a -> --a);
        intFunctionMap.addFunction("square", a -> a*a);

        return intFunctionMap;
    }
}
