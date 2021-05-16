val d = sc.textFile("IMDB_dataset_1.csv")
val header = d.first()
val data = d.filter(r => r!=header)

val A = data.map{l =>
    val s =l.split(',')
    val g =s(1).split('|')
    val k =s(4).split('|')
    val prc = s(9).split('|')
    var K:List[String] = List()
    var G:List[String] = List()
    var PRC:List[String] = List()
    for(i <- 0 until g.length){
         if(i%2 !=0){
            G = g(i)::G } } 
    for(i <- 0 until k.length){
         if(i%2 !=0){
            K = k(i)::K } }      
    for(i <- 0 until prc.length)
    	{
         if(i%2 == 0){
            PRC = prc(i)::PRC } }   
                  


val(budget, genres, homepage, id, keywords, original_language, original_title, overview, popularity, production_companies, 
release_date, revenue, runtime, spoken_languages, status, tagline, title, vote_average, vote_count) = (s(0).toDouble,G,s(2),s(3).toInt,K,
s(5),s(6),s(7),s(8).toFloat,PRC,s(10).replaceAll("-","").toDouble,s(11).toDouble,s(12).toDouble,s(13),s(14),s(15),s(16),s(17).toFloat,s(18).toInt)  
(budget, original_title, revenue, original_language, production_companies(0))}    

A.toDF.show()

val AF = A.filter{ l => l._3 != 0 }
// Profit calculation
val A_mod = AF.map{ l => 
 val p =   (l._3 - l._1)/1000000
 (l._2,p.toDouble) }
val aa =A_mod.sortBy(-_._2)

A_mod.toDF.show()

// Production companies analysis
val prc = AF.map{ l =>
	val v = l._5
	val p = (l._3 - l._1)/1000000
	(v,p.toDouble)
 }.reduceByKey(_+_)
 val production_companies =prc.sortBy(-_._2)

 production_companies.toDF.show()


