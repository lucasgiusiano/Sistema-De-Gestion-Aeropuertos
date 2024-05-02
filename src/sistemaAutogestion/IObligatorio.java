package sistemaAutogestion;

public interface IObligatorio {

    /*
    **************** REGISTROS **************************************
     */
    //pre:Clase sistema previamente definida con la cración de listas relacionadas      
    //post:Se espera un retorno OK  y se crea sistema
    //No implementado cuando aún no se definió el método.
    public Retorno crearSistemaDeGestion();

    ;
    /*pre:Recibir un nombre distinto a aerolinea que ya estén cargadas en sistema previamente,
    recibir un país del tipo string que contenga solo letras
    que el valor de cantMaxAviones sea un entero mayor a 0
    post:OK si cumple con las precondiciones y se crea aerolinea.
    Error 1 en caso de que ya exista una aerolinea cargada en sistema
    Error 2 en caso de que se ingrese un valor menor o igual a 0 en cantMaxAviones
    No implementado cuando aún no se definió el método.
    */
    public Retorno crearAerolinea(String nombre, String pais, int cantMaxAviones);

    /*pre:Recibir un nombre de aerolinea el cual este cargado en sistema y no tenga ningún avión relacionado. 
    post:OK si cumple con las precondiciones y se elimina aerolinea.
    Error 1 en caso de que no exista una aerolinea con ese nombre
    Error 2 en caso de que la aerolinea ingresada tenga aviones relacionados.
    No implementado cuando aún no se definió el método.
     */
    public Retorno eliminarAerolinea(String nombre);

    ; 
    /*pre:Recibir un código distinto a avión cargado previamente en el nombre de la aerolinea ingresado,
    el nombre de la aerolinea debe pertenecer a una que este cargada previamente en sistema
    que el valor de capacidadMax sea un entero mayor a 0
    Que el registrar el avión no se supere la cantMax definida para la aerolinea.
    post:OK si cumple con las precondiciones y se elimina aerolinea.
    Error 1 en caso de que ya exista un código de avión en la aerolinea ingresada.
    Error 2 en caso de que se ingrese un valor menor o igual a 0 en capacidadMax
    Error 3 Si no existe una aerolinea cargada en sistema con el nomAerolinea ingresado.
    Error 4 En caso de que se supere la cantMax definida para la aerolinea ingresada.
    No implementado cuando aún no se definió el método.
    */
    public Retorno registrarAvion(String codigo, int capacidadMax, String nomAerolinea);

    ; 
   /*pre: Que la aerolinea ingresada este cargada en sistema 
    y tenga dentro de su lista de aviones el código ingresado.
    Que el avión relacionado con el  código no tenga ningún vuelo con pasajes vendidos.
    post:OK si cumple con las precondiciones y se elimina el avión.
    Error 1 en caso de que no exista una aerolinea con ese nombre
    Error 2 en caso de que no exista código de avión dentro de la aerolinea
    Error 3 Si el avión encontrado tiene vuelos con pasajes vendidos.
    No implementado cuando aún no se definió el método.
    */
    public Retorno eliminarAvion(String nomAerolinea, String codAvion);

    /*pre: El pasapote ingresado contiene 7 caracteres alfanumericos y no esta cargado previamente en sistema
    El nombre debe ser un string únicametne con letras
    La edad debe ser mayor o igual a 0
    post:OK si cumple con las precondiciones y se registra el cliente.
    Error 1 en caso de que la edad ingresada sea menor a 0
    Error 2 en caso de que el pasaporte no contenga 7 caracteres
    Error 3 En caso de que el pasaporte ya este cargado en sistema.
    No implementado cuando aún no se definió el método.
     */
    public Retorno registrarCliente(String pasaporte, String nombre, int edad);

    /*
    **************** GESTIÓN DE VUELOS Y PASAJES **************************************
     */
 /*pre: El código de vuelo no esta previamente ingresado en sistema
    La aerolinea esta cargada en sistema y el código de avión pertence a dicha aerolinea.
    El avión no tiene un vuelo pre cargado con el mismo día mes y año ingresado. (Las tres condiciones juntas)
    La cantidad de pasajes economicos y cantidad de pasajes primera clase son multiplo de 3 
    y la suma de estos no superan la capacidad máxima del avión.
    post:OK si cumple con las precondiciones y se crea el vuelo.
    Error 1 en caso de que exista código de vuelo en el sistema.
    Error 2 en caso de la aerolinea no exista en sistema.
    Error 3 El código de avión no pertenece a la aerolinea ingresada.
    Error 4 Ya existe un vuelo creado en el día mes y año ingresado para el código de avión.
    Error 5:La cantidad de pasajes en economico o en primera clase no son multiplo de 3
    Error 6: La suma de pasajes economicos y priemra clase superan la capacidad máxima del avión.
    No implementado cuando aún no se definió el método.
     */
    public Retorno crearVuelo(String codigoVuelo, String aerolinea, String codAvion, String paisDestino, int dia, int mes, int año, int cantPasajesEcon, int cantPasajesPClase);

    /*pre: El pasaporte y código de vuelo están previamente cargado en sistema
    post:OK si cumple con las precondiciones y se emite el pasaje.
    OK en caso de que no existe disponibilidad el pasaje queda en lista de pendiente esperando un lugar disponible
    Error 1 en caso de que no exista el pasaporte ingresado en sistema.
    Error 2 en caso de que no exista un vuelo con el codigo ingresado.
    No implementado cuando aún no se definió el método.
     */
    public Retorno comprarPasaje(String pasaporteCliente, String codigoVuelo, int categoríaPasaje);

    /*pre: El pasaporte y código de vuelo están previamente cargado en sistema
    El cliente tiene un pasaje comprado para ese vuelo.
    post:OK si cumple con las precondiciones y se realiza devolución del pasaje.
    En caso de que el vuelo tenga lista de espera, se le dará este pasaje al primera en la lista.
    Error 1 en caso de que no exista el pasaporte ingresado en sistema.
    Error 2 en caso de que no exista un vuelo con el codigo ingresado.
    Error 3 el cliente no tiene pasajes comprados con el vuelo ingresado.
    No implementado cuando aún no se definió el método.
     */
    public Retorno devolverPasaje(String pasaporteCliente, String codigoVuelo);

    /*
    **************** REPORTES Y CONSULTAS **************************************
     */
 /*pre:Se espera que hayan aerolineas pre cargadas en sistema.
    post:OK y se muestran aerolineas.
    No implementado cuando aún no se definió el método.
     */
    public Retorno listarAerolineas();

    /*pre:Se espera que hayan aviones pre cargadas con el nombre de la aerolinea ingresada..
    post:OK si cumple con las precondiciones y se muestra la lista de aviones de la aerolinea.
    Erro 1 en caso de que no exista una aerolinea en sistema con ese nombre.
    No implementado cuando aún no se definió el método.
     */
    public Retorno listarAvionesDeAerolinea(String nombre);

    /*pre:Se espera que hayan clientes pre cargadas en sistema.
    post:OK y se muestran los clientes.
    No implementado cuando aún no se definió el método.
     */ 
    public Retorno listarClientes();

    /*pre:Se espera que hayan vuelos pre cargadas en sistema.
    post:OK y se muestran los vuelos.
    No implementado cuando aún no se definió el método.
     */ 
    public Retorno listarVuelos();

    /*pre:Se espera que hayan vuelos en los que el cliente ingresado tenga pasaje comprado.
    post:OK si cumple con las precondiciones y se muestra la lista de vuelos del cliente.
    Erro 1 en caso de que no exista pasaporte en sistema.
    No implementado cuando aún no se definió el método.
     */ 
    public Retorno vuelosDeCliente(String pasaporte);

    /*pre:Se espera que hayan vuelos con pasajes devueltos con la aerolinea ingresada.
    post:OK si cumple con las precondiciones y se muestran los pasajes devueltos.
    Erro 1 en caso de que no exista la aerolinea en el sistema.
    No implementado cuando aún no se definió el método.
     */  
    public Retorno pasajesDevueltos(String nombreAerolinea);

    /*pre:Se espera que haya un vuelo con el código de vuelo ingresado pre cargadas en sistema.
    post:OK y se muestra la distribución de pasajes vendidos por ese vuelo.
    No implementado cuando aún no se definió el método.
     */ 
    public Retorno vistaDeVuelo(String codigoVuelo);

}
