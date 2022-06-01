object Colecciones {
  type Palabra = String
  type Frase = List[String]
  type Ocurrencias = List[(Char,Int)]
  val diccionario:List[Palabra] = List("moco","como","oomc","cy","los","sol")


  def lOcPal(p: Palabra):Ocurrencias = {
    val ocurr = (for {
      n <- p
    } yield (n, p.count(x=>x==n))).toList

    ocurr.distinct
  }

  def lOcFrase(f:Frase):Ocurrencias = {
    val concatFrase = f reduceLeft ((x,y)=>x+y)
    lOcPal(concatFrase)
  }


  lazy val diccionarioPorOcurrencias:Map[Ocurrencias, List[Palabra]] = {
    diccionario.groupBy((pal:Palabra)=>lOcPal(pal).sorted)
  }

  def anagramasDePalabra(pal: Palabra): List[Palabra]={
    (diccionarioPorOcurrencias.get(lOcPal(pal).sorted).toList).head
  }

  def combinaciones(lOcurrencias: Ocurrencias):List[Ocurrencias]={
    val comb = (for {
      n <- lOcurrencias
      f <- lOcurrencias
      j <- 1 to n._2
      i <- 1 to f._2
      if n._1 !=  f._1
    }yield (List():+(n._1,j):+(f._1,i)).sorted).distinct

    val comb2 = (for{
      x<-lOcurrencias
      i<- 1 to x._2
    }yield List():+(x._1,i))

    List.concat(comb,comb2):+List()
  }

  //def complemento(lOc: Ocurrencias, slOc: Ocurrencias): Ocurrencias{}

  //def anagramasDeFrase(frase: Frase): List[Frase]{}
}
