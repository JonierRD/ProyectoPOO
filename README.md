# Proyecto API RESTful en Java con Spark

## Descripción

Este proyecto consiste en una API RESTful implementada en Java utilizando el framework Spark. La API permite gestionar información de clientes, productos, categorías, pedidos y facturas. Está diseñada para ofrecer un CRUD completo, con operaciones para crear, leer, actualizar y eliminar datos en memoria.

## Funcionalidades

- CRUD completo para las entidades Cliente, Producto, Factura, Categoria, Pedido.
- Endpoints RESTful para cada entidad.
- Gestión de información en memoria, sin base de datos externa.

## Tecnologías utilizadas

- Java
- Spark Framework
- Gson (para la serialización de objetos)

## Instrucciones de ejecución

1. Clona el repositorio.
2. Abre el proyecto en IntelliJ IDEA 
3. Ejecuta la clase `MainApi` para iniciar el servidor local.
4. Usa herramientas como Postman o Insomnia para probar los endpoints de la API.

## Endpoints

### GET /clientes
Obtiene todos los clientes registrados.

### POST /clientes
Crea un nuevo cliente.

### PUT /clientes/{id}
Actualiza los datos de un cliente.

### DELETE /clientes/{id}
Elimina un cliente.

(Continúa con los demás endpoints…)

## Informe

El informe completo del proyecto se encuentra en la carpeta `documentacion`.

## Licencia

Este proyecto está bajo la licencia MIT.
