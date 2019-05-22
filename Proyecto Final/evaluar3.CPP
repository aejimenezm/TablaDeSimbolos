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
