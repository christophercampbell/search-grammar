grammar Search;

AND : '&';
OR  : '|';

EQ      : '=';
NOTEQ   : '!=';

LPAREN: '(';
RPAREN: ')';

STRINGLITERAL : '\'' (~'\'')* '\'' ;

IDENTIFIER : [a-zA-Z_][a-zA-Z_0-9]* ;

DOT: '.';

COMMENT : '//' .+? ('\n'|EOF) -> skip ;

WS : [ \r\t\u000C\n]+ -> skip ;

where_expr  : logical_expr EOF;

logical_expr
    : logical_expr AND logical_expr
    | logical_expr OR logical_expr
    | comparison_expr
    | LPAREN logical_expr RPAREN
    ;

comparison_expr
    : key_entity comp_operator value_entity
    | LPAREN comparison_expr RPAREN
    ;

comp_operator
    : EQ
    | NOTEQ
    ;

value_entity
    : STRINGLITERAL
    ;

key_entity
    : IDENTIFIER DOT IDENTIFIER // family.attribute
    ;