
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