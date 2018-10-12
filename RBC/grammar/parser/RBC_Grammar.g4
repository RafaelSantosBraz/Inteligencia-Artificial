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

tipos   : (NUM SEP)+ EOL
        ;

pesos   : (NUM SEP)+ EOL
        ;

valores : id objetivo (valor SEP)+ EOL
        ;

id      : NUM SEP
        ;

objetivo: valor SEP
        ;

valor   : NUM     #valorNum
        | STR     #valorStr
        ;

NUM     : '-'?[0-9]+('.'[0-9]+)?;
EOL     : '\r'?'\n';
SEP     : ';';
STR     : (~["\\\r\n;])+;