object Colecciones {
  type Palabra = String
  type Frase = List[String]
  type Ocurrencias = List[(Char,Int)]
  //val diccionario:List[Palabra] = List("moco","como","oomc","cy","los","sol")
  val diccionario:List[Palabra] = List("cosas", "como", "yo", "y", "ocasos", "oca", "cayo", "mocosos", "roca", "moco", "sos")


  def lOcPal(p: Palabra):Ocurrencias = {
    val ocurr = (for {
      n <- p
    } yield (n, p.count(x=>x==n))).toList

    ocurr.distinct
  }

  def lOcFrase(f:Frase):Ocurrencias = {
    val concatFrase = f reduceLeft ((x,y)=>x+y)
    lOcPal(concatFrase).filter(_._1 !=' ')
  }


  lazy val diccionarioPorOcurrencias:Map[Ocurrencias, List[Palabra]] = {
    diccionario.groupBy((pal:Palabra)=>lOcPal(pal).sorted)
  }

  def anagramasDePalabra(pal: Palabra): List[Palabra]={
    diccionarioPorOcurrencias.get(lOcPal(pal).sorted).head
  }

  def combinaciones(lOcurrencias: Ocurrencias):List[Ocurrencias]= lOcurrencias match {
    case Nil => List(List())
    case y::ys =>{
      val combinacion = combinaciones(ys)
      combinacion++
        (for {
          n<- combinacion
          i<- 1 to y._2
        }yield (y._1,i)::n)
    }
  }

  def complemento(lOc: Ocurrencias, slOc: Ocurrencias): Ocurrencias ={
    if(slOc.isEmpty) lOc
    else{
      if(slOc.head._1 == lOc.head._1){
        if(slOc.head._2==lOc.head._2) complemento(lOc.tail,slOc.tail)
        else (slOc.head._1,lOc.head._2-slOc.head._2)::complemento(lOc.tail,slOc.tail)
      }else lOc.head::complemento(lOc.tail,slOc)
    }
  }



}
