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
