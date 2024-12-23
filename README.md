# BookingAPP

## requirements

### 1. método que reciba: ciudad, tipo de alojamiento, día de inicio del hospedaje, día de finalización del hospedaje, cantidad de adultos, cantidad de niños y la cantidad de habitaciones.( Este método debe devolver todos los hoteles que se acomoden con los parámetros ingresados)
- **tipos de alojamiento**: Hotel, Apartamento, Finca, Dia de Sol
- **hotel info**: nombre del hotel, calificación (del 1 al 5), precio por noche, precio calculado según los días de estadía.
- Si los días de estadías comprenden los 5 últimos días de un mes, al precio total de la estadía se le debe aumentar el 15%.
- Si los días de estadía comprenden los días del 10 al 15 del mes, al precio total de la estadía se le debe aumentar el 10%.
- Si los días de estadía comprende del 5 al 10 del mes, se realiza un descuento de 8%.
- **precio total** : se calcula con base al precio de la habitación más simple disponible del alojamiento, se multiplica según la cantidad de habitaciones escogidas y por último se realiza el descuento o aumento según los días escogidos. Los descuentos y aumentos deben aplicarse y mostrar su valor aparte.
- Si el cliente lo que busca es un día de sol, se deben de mostrar todas las actividades que puede realizar en el alojamiento, si incluye almuerzo o refrigerio y su precio.

## 2. método para confirmar las habitaciones del establecimiento este debe recibir los parámetros (nombre del hotel, día de inicio del hospedaje, día de finalización del hospedaje, cantidad de adultos, cantidad de niños y la cantidad de habitaciones.) Este devolverá los tipos de habitaciones disponibles para las fechas dadas, las características y precio de la habitación.
- **Ejemplo de habitación**: La habitación doble tiene 2 camas dobles, vista al mar, aire acondicionado, cafetera, Tv de pantalla plana, ducha y escritorio.
- Se debe manejar 5 tipos de habitaciones cada una con precios distintos basados en las acomodaciones que ofrezca.

## 3. método para reservar que reciba los siguientes datos de la persona que está reservando (Nombre, apellido, email, nacionalidad, número de teléfono y hora aproximada de llegada) Este método solo devuelve el mensaje de “Se ha realizado la reserva con éxito”. Se debe de generar el registro de que se ha realizado una reserva y disminuir la cantidad de habitaciones disponibles según el tipo de habitación reservada.
## 4. Cada hotel lleva un registro de reservas con la información personal del cliente que realizó la reserva.
- En caso de ser necesario la actualización de una reserva, se debe realizar una autenticación con el correo y la fecha de nacimiento del usuario que reservo para poder acceder y actualizar. Al momento de actualizar, se deben mostrar los datos de la reserva y preguntar si quiere hacer un cambio de habitación o de alojamiento.
- Si la persona escoge qué quiere hacer un cambio de habitación, se le muestran las habitaciones que tiene, se le pide que escoja la que quiere cambiar, se le muestran las habitaciones disponibles(en el mismo alojamiento) y que escoja la nueva habitación.
- Cuando el usuario escoja la opción de cambiar de alojamiento, se borra la reserva y se le redirige a crear una nueva reserva.
