package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public void beautify(String uglyText, PoemDecorator poemDecorator){
        System.out.println("From now, the beauty text is: " + poemDecorator.decorate(uglyText));
    }
}
