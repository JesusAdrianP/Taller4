import Colecciones._

val frse = List("cy","no","ascc")
val palabra = "cy"

lOcPal("paraguas")
lOcFrase(frse)
val dicc = diccionarioPorOcurrencias

anagramasDePalabra("moco")
combinaciones(lOcPal("cyy"))

val paraguas = List(('a',2),('b',2))

combinaciones(paraguas)
/*val comb = (for {
  n <- paraguas
  f <- paraguas
  j <- 1 to n._2
  i <- 1 to f._2
  if n._1 !=  f._1
}yield (List():+(n._1,j):+(f._1,i)).sorted).distinct

val comb2 = (for{
  x<-paraguas
  i<- 1 to x._2
}yield List():+(x._1,i))

val combWithout = List.concat(comb,comb2):+List()*/

