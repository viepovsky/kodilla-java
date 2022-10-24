package com.kodilla.stream;

import com.kodilla.stream.lambda.*;
import com.kodilla.stream.reference.FunctionalCalculator;

public class Application {
    public static void main(String[] args) {
        SaySomething saySomething = new SaySomething();
        saySomething.say();
        System.out.println("----");
        Processor processor = new Processor();
        Executor codeToExecute = () -> System.out.println("This is example - text.");
        processor.execute(codeToExecute);

        processor.execute(() -> System.out.println("This is example --> text."));

        ExpressionExecuter expressionExecuter = new ExpressionExecuter();
        expressionExecuter.executeExpression(10,5,(a, b) -> a + b);
        expressionExecuter.executeExpression(10,5,(a, b) -> a - b);
        expressionExecuter.executeExpression(10,5,(a, b) -> a * b);
        expressionExecuter.executeExpression(10,5,(a, b) -> a / b);

        expressionExecuter.executeExpression(10,5, FunctionalCalculator::addAToB);
        expressionExecuter.executeExpression(10,5, FunctionalCalculator::multiplyAByB);
    }
}
