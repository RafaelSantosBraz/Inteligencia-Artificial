grammar RBC_Grammar;

@header{
    package parser;
}

base    : head (values)+
        ;

head    : types weights ident
        ;

ident   : (STR)+ EOL
        ;

types   : (NUM)+ EOL
        ;

weights : (NUM)+ EOL
        ;

values  : id goal (value)+ EOL
        ;

id      : NUM
        ;

goal    : value
        ;

value   : NUM     #valorNum
        | STR     #valorStr
        ;

NUM     : '-'?[0-9]+('.'[0-9]+)?;
EOL     : '\r'?'\n';
SEP     : ';' -> skip;
STR     : (~["\\\r\n;])+;