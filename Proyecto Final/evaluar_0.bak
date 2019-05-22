//librerias utilizadas
#include<stdio.h>
#include<iostream>
#include<string>
#include<string.h>

//estructura para el arbol de expresiones
struct arbolexp
{
	float dato;
	int info;
	arbolexp *izq;
	arbolexp *der;
};

//variables globales
char expresion[100];
char Token[20];
char lexema[100];
int contador = 0;
int contadorLexema=0;
//bool Alto = false;
bool TokenAnterior=false;
int TipoOperacion=0;
int punto;
int pizq=0, pder=0;

//prototipos de funciones
void limpiar_cadenas(char[], int);
void TomaToken();
arbolexp *E();
arbolexp *T();
arbolexp *F();
arbolexp *CrearArbol(arbolexp*, arbolexp*, int, float);
void DestruyeArbol(arbolexp **);
void EvaluaExpresion();
float EvaluaArbol(arbolexp *);
void DiagramaArbol(arbolexp *, int);   

//funcion para limpiar cadenas
void limpiar_cadenas(char ptr[],int largo )
{
	char *ptrtemp = ptr;
	int i;
	for (i = 0; i < largo; i++)
   {
		*(ptrtemp++) = '\0';
	}
}
