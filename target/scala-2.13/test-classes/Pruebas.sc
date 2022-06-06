import Colecciones._

val frse = List("cosas como yo")
val palabra = "cy"

lOcPal("paraguas")
lOcFrase(frse)
val dicc = diccionarioPorOcurrencias

anagramasDePalabra("moco")

val prueba = List(('a',2),('b',2))


combinaciones(prueba)
combinaciones(lOcPal("cyy"))
combinaciones(lOcPal("moco"))

val lcurrencias = lOcPal("moco")

val ocurrenciasDeFrase = lOcFrase(frse)
val cy = combinaciones(ocurrenciasDeFrase)
val anagramas = (for{
  n<- cy
}yield complemento(ocurrenciasDeFrase,n)).distinct

complemento(List(('c',2),('a',1),('o',1)), List(('c',1)))
complemento(lOcFrase(frse),List(('c', 1),('o', 1),('a', 1),('y', 1)))

(for {
  n<-anagramas
}yield diccionarioPorOcurrencias.get(n.sorted)).distinct




