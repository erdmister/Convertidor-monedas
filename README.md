# Conversor de Monedas
## ✨ Descripción

Este es un conversor de monedas desarrollado en Java que permite convertir entre diferentes divisas utilizando una API de tasas de cambio en tiempo real.

## 📄 Características

- Conversión de monedas en tiempo real.

- Historial de conversiones.

- Uso de la API ExchangeRate-API.

- Validación de entrada del usuario.

## 📚 Tecnologías Utilizadas

- Java: Lenguaje principal para la lógica del conversor.

- Gson: Para manejar datos en formato JSON.

- ExchangeRate-API: Para obtener tasas de conversión en tiempo real.

## 🔧 Usa el conversor:

- Selecciona la opción de conversión.

- Ingresa la cantidad a convertir.

- Obtén el resultado de la conversión.

- Consulta el historial de conversiones.

### 🔒 Diccionario de Códigos de Moneda

| Moneda   | Código  |
| ------------ | ------------ |
| Peso Mexicano   |  MXN |
| Peso Argentino  | ARS  |
| Peso Colombiano  |  COP |
| Dólar Estadounidense  | USD  |
| Euro   | EUR  |



## 📚 Estructura del Proyecto

conversor-de-monedas/
Main.java               # Clase principal que gestiona la interfaz de usuario
ConvertidorDeMoneda.java # Clase para manejar la conversión de monedas usando la API
HistorialDeConversion.java # Clase para almacenar y mostrar el historial de conversiones
README.md               # Documentación del proyecto

## 🌍 Funcionamiento de la API

El conversor utiliza la API de ExchangeRate-API para obtener tasas de conversión en tiempo real:
Se realiza una solicitud HTTP GET a la API con la moneda base.
Se recibe un JSON con todas las tasas de conversión disponibles.
Se extrae la tasa correspondiente a la moneda de destino.
Se multiplica la cantidad ingresada por la tasa obtenida y se muestra el resultado.
Ejemplo de respuesta JSON:

{
  "conversion_rates": {
    "USD": 1,
    "MXN": 17.50,
    "EUR": 0.92
  }
}

En este caso, 1 USD equivale a 17.50 MXN y 0.92 EUR.

### ➕ Agregar Nuevas Monedas

Si deseas agregar una nueva moneda que esté disponible en la API pero no en la lista actual del conversor:

Revisa el código de la moneda en la documentación de la API.

**Modifica el método **getCurrencyCode en ConvertidorDeMoneda.java y agrega la nueva moneda al diccionario.

Actualiza la tabla en el README con la nueva moneda y su código.

Prueba la conversión para asegurarte de que funciona correctamente.

Ejemplo de modificación en getCurrencyCode:

    case "Real Brasileño (BRL)":
        return "BRL";

## Imagenes
![img_1](https://github.com/user-attachments/assets/067f25ef-29c8-4b7d-8df3-c6c4d6de40b2)
![img_2](https://github.com/user-attachments/assets/a1d16fa2-9414-44ed-9a0a-6cfc1ba16daa)

        
