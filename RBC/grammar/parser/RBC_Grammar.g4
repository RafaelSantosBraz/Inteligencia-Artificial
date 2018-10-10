grammar RBC_Grammar;

@header{
package parser;
}

base    : cab (valores)+
        ;

cab     : tipos pesos ident
        ;

ident   : (STR SEP)+ EOL
        ;

tipos   : (INT SEP)+ EOL
        ;

pesos   : (INT SEP)+ EOL
        ;

valores : (valor SEP)+ EOL
        ;

valor   : NUM SEP     #valorNum
        | STR SEP     #valorStr
        ;

INT     : [0-9]+;
NUM     : '-'?[0-9]+('.'[0-9]+)?;
EOL     : '\r'?'\n';
SEP     : ';';
STR     : (~["\\\r\n;])+;