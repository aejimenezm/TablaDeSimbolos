
public class GlobalMembers
{
	//funion que opera el arbol y manda el resultado 
	public static float EvaluaArbol(arbolexp RaizPtr)
	{
		float Derecho = 0F;
		float izquierdo = 0F;

		if (RaizPtr != null)
		{
			if (RaizPtr.info == 123)
			{
				return RaizPtr.dato;
			}
			else
			{
				izquierdo = EvaluaArbol(RaizPtr.izq);
				Derecho = EvaluaArbol(RaizPtr.der);

				switch (RaizPtr.info)
				{
					case 1:
						return (izquierdo + Derecho);
						break;
					case 2:
						return (izquierdo - Derecho);
						break;
					case 4:
						if (Derecho == 0F)
						{
							System.out.print("Error semantico, division entre cero! \n");
							System.exit(0);
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
	public static void EvaluaExpresion()
	{
		arbolexp RaizPtr = null;
		float Resultado = 0F;

		RaizPtr = E(); //La funcion devuelve un puntero al arbol de expresiones

		if (RaizPtr == null)
		{
			System.out.print("Hubo error en la expresion\n\n");
		}
		else
		{
			System.out.print("\n\n");
			DiagramaArbol(RaizPtr, 1);
			Resultado = EvaluaArbol(RaizPtr);
			DestruyeArbol(RaizPtr);
			System.out.printf("\n El resultado es: \n-------- \"%f\" ---------\n", Resultado);
		  System.out.print("\n\t>>Alejandro Enrique Jimenez Montenegro");
		  System.out.print("\n");
		  System.out.print("\t>>090-16-2110\n");
		  System.out.print("\n");
		}
	}

	//mensaje que se muestra al inicio del programa si no se mando ningun argumento
	public static void inicio()
	{
		System.out.print("-------------Programa Arbol de Expresiones----------------");
		System.out.print("\n");
		System.out.print("-->Acerca de: \n ***Este es un programa capaz evaluar expresiones regulares*** ");
		System.out.print("\n");
		System.out.print(" ***y capaz de formar un Arbol binario con las expresiones***\n ***que sean ingresadas***");
		System.out.print("\n");
		System.out.print("\n-->Ayuda:\n Para la ejecucion del programa ingrese un argumento valido.\n por ejemplo: (10+5)*3");
		System.out.print("\n");
		System.out.print("\n A continuacion se ejecutara un el ejemplo para ver la funcionalidad del programa");
		System.out.print("\n");
		expresion = "(10+5)*3";
		System.out.print("\n");
		system("pause");
	}

	//funcion principal del programa
	public static int Main()
	{
		limpiar_cadenas(expresion, 100);
		limpiar_cadenas(lexema, 50);

	   System.out.print("Ingrese una expresion");
	   char argv;
	   scanf(%c, argv);
		expresion += argv;

		TokenAnterior = false;
		EvaluaExpresion();
		system("pause");
	}
}