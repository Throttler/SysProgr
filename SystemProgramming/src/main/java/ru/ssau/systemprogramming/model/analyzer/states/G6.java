package ru.ssau.systemprogramming.model.analyzer.states;

import ru.ssau.systemprogramming.model.analyzer.Semantic;
import ru.ssau.systemprogramming.model.analyzer.StringReader;
import ru.ssau.systemprogramming.model.analyzer.SyntaxClass;

public class G6 implements State {
    @Override
    public State nextState(StringReader reader, Semantic semantic) {
        char ch = reader.read();

        if (SyntaxClass.isAlphabetic(ch)) {
            semantic.addCharToThirdOperandName(ch);
            return this;
        }
        if (ch ==' ') {
            return new H5();
        }
        if (ch ==')') {
            return new H6();
        }

        return new Error(getClass().getSimpleName(), "Chars 'space' or ')' expected", reader);
    }
}
