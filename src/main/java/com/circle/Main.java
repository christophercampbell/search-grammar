package com.circle;

import com.circle.entities.SearchLexer;
import com.circle.entities.SearchListener;
import com.circle.entities.SearchParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

public class Main {


    public static void main(String[] args) {
        try {
            CharStream expression = CharStreams.fromString("person.firstName = 'mickey' & person.lastName != 'mouse'");
            SearchLexer lexer = new SearchLexer(expression);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            SearchParser parser = new SearchParser(tokens);
            SearchParser.Where_exprContext where = parser.where_expr();
            SearchExtractor extractor = new SearchExtractor();
            ParseTreeWalker.DEFAULT.walk(extractor, where);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    static class SearchExtractor implements SearchListener {

        public void enterWhere_expr(SearchParser.Where_exprContext ctx) {
        }

        public void exitWhere_expr(SearchParser.Where_exprContext ctx) {
        }

        public void enterLogical_expr(SearchParser.Logical_exprContext ctx) {
        }

        public void exitLogical_expr(SearchParser.Logical_exprContext ctx) {
        }

        public void enterComparison_expr(SearchParser.Comparison_exprContext ctx) {
            System.out.print("family.attribute: " + ctx.key_entity().getText());
            System.out.print(", operator:  " + ctx.comp_operator().getText());
            System.out.println(", value:     " + ctx.value_entity().getText());
        }

        public void exitComparison_expr(SearchParser.Comparison_exprContext ctx) {
        }

        public void enterComp_operator(SearchParser.Comp_operatorContext ctx) {
        }

        public void exitComp_operator(SearchParser.Comp_operatorContext ctx) {

        }

        public void enterValue_entity(SearchParser.Value_entityContext ctx) {
        }

        public void exitValue_entity(SearchParser.Value_entityContext ctx) {

        }

        public void enterKey_entity(SearchParser.Key_entityContext ctx) {

        }

        public void exitKey_entity(SearchParser.Key_entityContext ctx) {

        }

        public void visitTerminal(TerminalNode node) {

        }

        public void visitErrorNode(ErrorNode node) {

        }

        public void enterEveryRule(ParserRuleContext ctx) {

        }

        public void exitEveryRule(ParserRuleContext ctx) {
        }
    }


}
