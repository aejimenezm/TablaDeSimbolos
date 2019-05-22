//librerias utilizadas

//estructura para el arbol de expresiones
public class arbolexp
{
	public float dato;
	public int info;
	public arbolexp izq;
	public arbolexp der;
}

public class GlobalMembers
{
	//variables globales
	public static String expresion = new String(new char[100]);
	public static String Token = new String(new char[20]);
	public static String lexema = new String(new char[100]);
	public static int contador = 0;
	public static int contadorLexema = 0;
	//bool Alto = false;
	public static boolean TokenAnterior = false;
	public static int TipoOperacion = 0;
	public static int punto;
	public static int pizq = 0;
	public static int pder = 0;

//funcion para limpiar cadenas

	//prototipos de funciones
	public static void limpiar_cadenas(String ptr, int largo)
	{
		String ptrtemp = ptr;
		int i;
		for (i = 0; i < largo; i++)
		{
			(ptrtemp++) = '\0';
		}
	}

//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
	//void TomaToken();
//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
	//arbolexp E();
//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
	//arbolexp T();
//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
	//arbolexp F();
//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
	//arbolexp CrearArbol(arbolexp UnnamedParameter, arbolexp UnnamedParameter2, int UnnamedParameter3, float UnnamedParameter4);
//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
	//void DestruyeArbol(arbolexp[] UnnamedParameter);
//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
	//void EvaluaExpresion();
//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
	//float EvaluaArbol(arbolexp UnnamedParameter);
//C++ TO JAVA CONVERTER TODO TASK: The implementation of the following method could not be found:
	//void DiagramaArbol(arbolexp UnnamedParameter, int UnnamedParameter2);

}


public class GlobalMembers
{
	//funcion para obtener tokens de la expresion, reconoce si es simbolo o numero lo que se ingreso
	public static void obtenerToken()
	{
		while (expresion[contador] != '\0')
		{
		   if (expresion[contador] == '+')
		   {
				System.out.print("se encontro una suma ");
				System.out.print(expresion[contador]);
				System.out.print(" en la posicion ");
				System.out.print((contador + 1));
				System.out.print("\n");
				contador++;
				TipoOperacion = 1;
				break;
		   }
			else if (expresion[contador] == '-')
			{
				System.out.print("Se encontro una resta ");
				System.out.print(expresion[contador]);
				System.out.print(" en la posicion ");
				System.out.print((contador + 1));
				System.out.print("\n");
				contador++;
				TipoOperacion = 2;
				break;
			}
			else if (expresion[contador] == '*')
			{
				System.out.print("Se encontro una multiplicacion ");
				System.out.print(expresion[contador]);
				System.out.print(" en la posicion ");
				System.out.print((contador + 1));
				System.out.print("\n");
				contador++;
				TipoOperacion = 3;
				break;
			}
			else if (expresion[contador] == '/')
			{
				System.out.print("Se encontro una division ");
				System.out.print(expresion[contador]);
				System.out.print(" en la posicion ");
				System.out.print((contador + 1));
				System.out.print("\n");
				contador++;
				TipoOperacion = 4;
				break;
			}
			else if (expresion[contador] == '(')
			{
				System.out.print("se encontro un parentesis izq ");
				System.out.print(expresion[contador]);
				System.out.print(" en la posicion ");
				System.out.print((contador + 1));
				System.out.print("\n");
				contador++;
				pizq++;
				TipoOperacion = 6;
				break;
			}
			else if (expresion[contador] == ')')
			{
				System.out.print("se encontro un parentesis der ");
				System.out.print(expresion[contador]);
				System.out.print(" en la posicion ");
				System.out.print((contador + 1));
				System.out.print("\n");
				contador++;
				pder++;
				TipoOperacion = 7;
				break;
			}

			else if (expresion[contador] >= 48 && expresion[contador] <= 57 || expresion[contador] == '.')
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
			 }while (expresion[contador] >= 48 && expresion[contador] <= 57 || expresion[contador] == '.');


					if (punto > 1)
					{
						System.out.print("----------Error ha ingresado una cantidad de punto no valido-----------");
						System.out.print("\n");
						system("pause");
						System.exit(0);
					}


				break;

			}

			else
			{
				System.out.print("Error");
				System.out.print("\n");
				TipoOperacion = 100;
				system("pause");
				System.exit(0);
				break;
			}
		}
	}

}


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
			free(ptr);
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


public class GlobalMembers
{
	// funcion Expresion()
	public static arbolexp E()
	{
		arbolexp izq = null;
		arbolexp der = null;
		int operador;

		izq = T();
		if (izq == null)
		{
			return null;
		}
		else
		{
			Toma_Token();
			if (TipoOperacion == 1 || TipoOperacion == 2)
			{
				operador = TipoOperacion;
				der = E();

			 if (der == null)
			 {
				 DestruyeArbol(izq);
				return null;
			 }
					else
					{
						return CrearArbol(izq, der, operador, 0);
					}
			}
				else
				{
					if (TipoOperacion == 100)
					{
						DestruyeArbol(izq);
						return null;
					}
					else
					{
						TokenAnterior = true;
						return izq;
					}
				}
		}
	}

	//funcion que grafica el arbol
	public static void DiagramaArbol(arbolexp raizptr, int Nivel)
	{
		if (pizq != pder)
		{
			System.out.print("\n\n");
			System.out.print("Error cantidad de parentesis no valida");
			System.out.print("\n");
			system("pause");
			System.exit(0);
		}

		if (raizptr != null)
		{
			DiagramaArbol(raizptr.der, Nivel + 1);
			for (int i = 0; i < Nivel; i++)
			{
				System.out.print("    ");
			}
			switch (raizptr.info)
			{
				case 1:
					System.out.print("+");
					break;
				case 2:
					System.out.print("-");
					break;
				case 3:
					System.out.print("*");
					break;
				case 4:
					System.out.print("/");
					break;
				default:
					System.out.printf("%f", raizptr.dato);
			}
			System.out.print("\n\n\n");
			DiagramaArbol(raizptr.izq, Nivel + 1);
		}
	}

}