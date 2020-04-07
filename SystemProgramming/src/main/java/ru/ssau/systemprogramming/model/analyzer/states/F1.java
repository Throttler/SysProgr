package ru.ssau.systemprogramming.model.analyzer.states;

import ru.ssau.systemprogramming.model.analyzer.Semantic;
import ru.ssau.systemprogramming.model.analyzer.StringReader;
import ru.ssau.systemprogramming.model.analyzer.SyntaxClass;

public class F1 implements State {
    @Override
    public State nextState(StringReader reader, Semantic semantic) {
        char ch = reader.read();
        if (ch == '=') {
            semantic.setEqualsign(true);
            return new F3();
        }
        if (ch == ' ') {
            return new F5();
        }
        if (SyntaxClass.isAlphabetic(ch)) {
            semantic.addCharToSecondOperandName(ch);
            return new F7();
        }

        return new Error(getClass().getSimpleName(), "Char or 'space' char or '=' expected", reader);
    }
}
