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
int main()
{
	limpiar_cadenas(expresion, 100);
	limpiar_cadenas(lexema, 50);

   cout<<"Ingrese una expresion";
   char argv;
   scanf(%c,&argv);
	strcat(expresion, argv);

	TokenAnterior = false;
	EvaluaExpresion();
	system("pause");
}