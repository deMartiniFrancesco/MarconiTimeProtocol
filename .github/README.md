# Marconi Time Protocol (mtp)

## Descrizione

Il protocollo implementa la richiesta di 3 informazioni, con 2 variazioni.  
Prima di inviare una richiesta al server, l’utente dovrà annunciarsi al server registrandosi, una volta che ci si è registrati, se tutto va a buon fine, verrà restituito un numero a 4 byte (32 bit), generato randomicamente, che dovrà essere fornito alla fine di ogni pacchetto.
Se questo identificatore univoco non verrà fornito, l’accesso non verrà garantito.
I tipi di errore che possiamo ottenere sono REGError e DATAError.

## Lato Client

Uso di un'interfaccia grafica con un menù.

## Funzionalità dell’applicazione

Dal menù puoi inserire una classe, un docente o un’aula e ti verrà restituito un orario.

## Interfaccia utente

Casi di uso
Ricercare un docente, una classe o un’aula.
