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
        
//funcion para obtener tokens de la expresion, reconoce si es simbolo o numero lo que se ingreso
void obtenerToken()
{
	while (expresion[contador] != '\0')
   {
   	if (expresion[contador] == '+')
      {
			cout << "se encontro una suma " << expresion[contador] << " en la posicion " << (contador+1) << endl;
			contador++;
			TipoOperacion = 1;
			break;
		}
		else if (expresion[contador] == '-')
      {
			cout << "Se encontro una resta " << expresion[contador] << " en la posicion " << (contador+1) << endl;
			contador++;
			TipoOperacion = 2;
			break;
		}
		else if (expresion[contador] == '*')
      {
			cout << "Se encontro una multiplicacion " << expresion[contador] << " en la posicion " << (contador+1) << endl;
			contador++;
			TipoOperacion = 3;
			break;   		
		}
		else if (expresion[contador] == '/')
      {
			cout << "Se encontro una division " << expresion[contador] << " en la posicion " << (contador+1) << endl;
			contador++;
			TipoOperacion = 4;
			break;
		}
		else if (expresion[contador] == '(')
      {
			cout << "se encontro un parentesis izq " << expresion[contador] << " en la posicion " << (contador+1) << endl;
			contador++;
			pizq++;
			TipoOperacion = 6;
			break;
		}
		else if (expresion[contador] == ')')
      {
			cout << "se encontro un parentesis der " << expresion[contador] << " en la posicion " << (contador+1) << endl;
			contador++;
			pder++;
			TipoOperacion = 7;
			break;    			
		}

		else if(expresion[contador]>=48 && expresion[contador]<=57||expresion[contador]=='.')
      {
      	contadorLexema = 0;
			punto = 0;
         limpiar_cadenas(lexema, 50);
         TipoOperacion = 123;

         do
         {
         	lexema [contadorLexema] = expresion[contador];
            contador++;
            contadorLexema++;

            if (expresion[contador] == '.')
            {
            	punto++;
            }
         }while(expresion[contador] >= 48 && expresion[contador] <= 57||expresion[contador]=='.');
				

				if (punto > 1) {
					cout << "----------Error ha ingresado una cantidad de punto no valido-----------"<<endl;
					system("pause");
					exit(0);
				}


			break;
		
		}

		else {
			cout << "Error" << endl;
			TipoOperacion = 100;
			system("pause");
			exit(0);
			break;
		}
   }
}
  
//funcion requerida para la llamada de los tokens
void Toma_Token()
{
	if (TokenAnterior == true)
   {
		TokenAnterior = false;
	}
	else
   {
		obtenerToken();
	}
}

//funcion que elimina nodos
void DestruyeArbol(arbolexp **ptr)
{
	if (*ptr != NULL)
   {
		DestruyeArbol(&(*ptr)->izq);
		DestruyeArbol(&(*ptr)->der);
		free(*ptr);
	}
}

//funcion que crea el arbol de expresiones
arbolexp *CrearArbol(arbolexp *Izq, arbolexp *Der, int Tipo, float valor)
{
	arbolexp *NodoArbol = NULL;
	if ((NodoArbol = (arbolexp *)malloc(sizeof(arbolexp))) == 0)
   {
		return NULL;
	}
	else
   {
		NodoArbol->izq = Izq; //Enlaza el arbol iquierdo
		NodoArbol->der = Der; //Enlaza el subarbol derecho
		NodoArbol->info = Tipo; //Tipo de Nodo del arbol
		NodoArbol->dato = valor; //Contenido del nodo
		return NodoArbol;
	}
}

//funcion Factor()
arbolexp *F()
{
	arbolexp *ptr = NULL;
	Toma_Token();
	if (TipoOperacion == 6)
   {
		ptr = E();
		if (ptr == NULL)
			return NULL;

		Toma_Token();
		if (TipoOperacion == 7)
			return ptr;
	}
	else if (TipoOperacion == 123)
   {
		return CrearArbol(NULL, NULL, TipoOperacion, atof(lexema));
	}
   else
   {
		return NULL;
	}
}

//funcion Termino()
arbolexp *T()
{
	arbolexp *izq = NULL;
	arbolexp *der = NULL;
	int operador=0;

	izq = F();
	if (izq == NULL)
   {
		return NULL;
	}
	else
   {
		TipoOperacion = 0;
		Toma_Token();
		if (TipoOperacion == 3||TipoOperacion == 4)
      {
			operador = TipoOperacion;
			der = T();
         if (der == NULL)
         {
				DestruyeArbol(&izq);
				return NULL;
			}
			else return CrearArbol(izq, der, operador, 0);
		}
		else
      {
			TokenAnterior = true;
			return izq;
		}
	}
}

// funcion Expresion()
arbolexp *E()
{
	arbolexp *izq = NULL;
	arbolexp *der = NULL;
	int operador;

	izq = T();
	if (izq == NULL)
   {
		return NULL;
	}
	else
   {
		Toma_Token();
		if (TipoOperacion == 1 || TipoOperacion == 2)
      {
			operador = TipoOperacion;
			der = E();
		
         if (der == NULL)
         {
         	DestruyeArbol(&izq);
            return NULL;
         }
				else return CrearArbol(izq, der, operador, 0);
			}
			else
				if (TipoOperacion == 100)
            {
					DestruyeArbol(&izq);
					return NULL;
				}
				else
            {
					TokenAnterior = true;
					return izq;
				}
	}
}

//funcion que grafica el arbol
void DiagramaArbol(arbolexp *raizptr, int Nivel)
{
	if (pizq != pder)
   {
		cout << "\n\n";
		cout << "Error cantidad de parentesis no valida"<<endl;
		system("pause");
		exit(0);
	}

	if(raizptr != NULL)
   {
		DiagramaArbol(raizptr->der, Nivel + 1);
		for (int i = 0; i < Nivel; i++)
      {
			printf("    ");
		}
		switch (raizptr->info)
      {
			case 1:
				printf("+");
				break;
			case 2:
				printf("-");
				break;
			case 3:
				printf("*");
				break;
			case 4:
				printf("/");
				break;
			default:
				printf("%f", raizptr->dato);
		}
		printf("\n\n\n");
		DiagramaArbol(raizptr->izq, Nivel + 1); 		
	}
}

//funion que opera el arbol y manda el resultado 
float EvaluaArbol(arbolexp *RaizPtr)
{
	float Derecho = 0;
	float izquierdo = 0;
	
	if (RaizPtr != NULL)
   {
		if (RaizPtr->info == 123)
      {
			return RaizPtr->dato;
		}
		else
      {
			izquierdo = EvaluaArbol(RaizPtr->izq);
			Derecho = EvaluaArbol(RaizPtr->der);

			switch (RaizPtr->info)
         {
				case 1:
					return (izquierdo + Derecho);
					break;
				case 2:
					return (izquierdo - Derecho);
					break;
				case 4:
					if (Derecho == 0)
               {
						printf("Error semantico, division entre cero! \n");
						exit(0);
					}
					return (izquierdo / Derecho);
					break;
				case 3:  				
				return (izquierdo * Derecho);
				break;
			}
		}
	}
}

// funcion encargada de leer la expresion y encargada de mostrar el resultado de la operacion
void EvaluaExpresion()
{
	arbolexp *RaizPtr = NULL;
	float Resultado = 0;

	RaizPtr = E(); //La funcion devuelve un puntero al arbol de expresiones

	if (RaizPtr == NULL)
   {
		printf("Hubo error en la expresion\n\n");
	}
	else
   {
		printf("\n\n");
		DiagramaArbol(RaizPtr, 1);
		Resultado = EvaluaArbol(RaizPtr);
		DestruyeArbol(&RaizPtr);
		printf("\n El resultado es: \n-------- \"%f\" ---------\n", Resultado);
      cout<<"\n\t>>Alejandro Enrique Jimenez Montenegro"<<endl;
      cout<<"\t>>090-16-2110\n"<<endl;
	}
}

//mensaje que se muestra al inicio del programa si no se mando ningun argumento
void inicio()
{
	cout << "-------------Programa Arbol de Expresiones----------------" << endl;
	cout << "-->Acerca de: \n ***Este es un programa capaz evaluar expresiones regulares*** " << endl;
	cout << " ***y capaz de formar un Arbol binario con las expresiones***\n ***que sean ingresadas***" << endl;
	cout << "\n-->Ayuda:\n Para la ejecucion del programa ingrese un argumento valido.\n por ejemplo: (10+5)*3" << endl;
	cout << "\n A continuacion se ejecutara un el ejemplo para ver la funcionalidad del programa"<<endl;
	strcpy(expresion, "(10+5)*3");
	cout << "\n";
	system("pause");
}

//funcion principal del programa
int main(int argc, char*argv[])
{
	limpiar_cadenas(expresion, 100);
	limpiar_cadenas(lexema, 50);

	if (argc == 1)
   {
		inicio();
	}
	else
   {
		for (int i = 1; i < argc; i++)
      {
			strcat(expresion, argv[i]);
		}
	}

	TokenAnterior = false;
	EvaluaExpresion();
	system("pause");
}      
