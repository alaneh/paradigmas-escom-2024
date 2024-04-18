/* Facts */
male(jack).
male(oliver).
male(ali).
male(james).
male(simon).
male(harry).
male(santiago).
male(erik).
male(ernesto).
male(raul).
female(helen).
female(sophie).
female(jess).
female(lily).
female(paola).
female(elena).
female(silvia).
female(ana).
married(santiago,elena).
married(raul,paola).
married(raul,silvia).
married(ernesto,silvia).
parent_of(silvia,ana).
parent_of(raul,ana).
parent_of(ernesto,helen).
parent_of(silvia,helen).
parent_of(jack,jess).
parent_of(jack,lily).
parent_of(helen, jess).
parent_of(helen, lily).
parent_of(oliver,james).
parent_of(sophie, james).
parent_of(jess, simon).
parent_of(ali, simon).
parent_of(lily, harry).
parent_of(james, harry).
 
/* Rules */
father_of(X,Y):- male(X),
    parent_of(X,Y).
 
mother_of(X,Y):- female(X),
    parent_of(X,Y).
 
grandfather_of(X,Y):- male(X),
    parent_of(X,Z),
    parent_of(Z,Y).
 
grandmother_of(X,Y):- female(X),
    parent_of(X,Z),
    parent_of(Z,Y).
 
sister_of(X,Y):- %(X,Y or Y,X)%
    female(X),
    father_of(F, Y), father_of(F,X),X \= Y.
 
sister_of(X,Y):- female(X),
    mother_of(M, Y), mother_of(M,X),X \= Y.
 
aunt_of(X,Y):- female(X),
    parent_of(Z,Y), sister_of(Z,X),!.
 
brother_of(X,Y):- %(X,Y or Y,X)%
    male(X),
    father_of(F, Y), father_of(F,X),X \= Y.
 
brother_of(X,Y):- male(X),
    mother_of(M, Y), mother_of(M,X),X \= Y.
 
uncle_of(X,Y):-
    parent_of(Z,Y), brother_of(Z,X).

ancestor_of(X,Y):- parent_of(X,Y).
ancestor_of(X,Y):- parent_of(X,Z),
    ancestor_of(Z,Y).

descendant_of(X,Y):-parent_of(Y,X).
wife_of(X,Y):-female(Y),married(X,Y).
husband_of(X,Y):-male(X),married(X,Y).
step_sister_of(X,Y):-female(Y),parent_of(Q,Y),parent_of(P,X), parent_of(P,Y),P\=Q.