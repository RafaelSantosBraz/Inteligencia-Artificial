grammar RBC_Grammar;

@header{
    package parser;
}

base    : head (values)+
        ;

head    : types weights ident (stand)*
        ;

stand   : DEF STR (value)+ EOL
        ;

ident   : (STR)+ EOL
        ;

types   : (NUM)+ EOL
        ;

weights : (NUM)+ EOL
        ;

values  : NUM goal (value)+ EOL
        ;

goal    : value
        ;

value   : NUM     #valueNum
        | STR     #valueStr
        ;

DEF     : '#';
NUM     : '-'?[0-9]+('.'[0-9]+)?;
EOL     : '\r'?'\n';
SEP     : ';' -> skip;
STR     : (~["\\\r\n;])+;