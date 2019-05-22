
public class GlobalMembers
{
	public static void Toma_Token()
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
	public static void DestruyeArbol(arbolexp[] ptr)
	{
		if (ptr[0] != null)
		{
			DestruyeArbol(ptr.izq);
			DestruyeArbol(ptr.der);
			freeptr;
		}
	}

	//funcion que crea el arbol de expresiones
	public static arbolexp CrearArbol(arbolexp Izq, arbolexp Der, int Tipo, float valor)
	{
		arbolexp NodoArbol = null;
		if ((NodoArbol = new arbolexp()) == null)
		{
			return null;
		}
		else
		{
			NodoArbol.izq = Izq; //Enlaza el arbol iquierdo
			NodoArbol.der = Der; //Enlaza el subarbol derecho
			NodoArbol.info = Tipo; //Tipo de Nodo del arbol
			NodoArbol.dato = valor; //Contenido del nodo
			return NodoArbol;
		}
	}

	//funcion Factor()
	public static arbolexp F()
	{
		arbolexp ptr = null;
		Toma_Token();
		if (TipoOperacion == 6)
		{
			ptr = E();
			if (ptr == null)
			{
				return null;
			}

			Toma_Token();
			if (TipoOperacion == 7)
			{
				return ptr;
			}
		}
		else if (TipoOperacion == 123)
		{
			return CrearArbol(null, null, TipoOperacion, Double.parseDouble(lexema));
		}
	   else
	   {
			return null;
	   }
	}

	//funcion Termino()
	public static arbolexp T()
	{
		arbolexp izq = null;
		arbolexp der = null;
		int operador = 0;

		izq = F();
		if (izq == null)
		{
			return null;
		}
		else
		{
			TipoOperacion = 0;
			Toma_Token();
			if (TipoOperacion == 3 || TipoOperacion == 4)
			{
				operador = TipoOperacion;
				der = T();
			 if (der == null)
			 {
					DestruyeArbol(izq);
					return null;
			 }
				else
				{
					return CrearArbol(izq, der, operador, 0F);
				}
			}
			else
			{
				TokenAnterior = true;
				return izq;
			}
		}
	}

}