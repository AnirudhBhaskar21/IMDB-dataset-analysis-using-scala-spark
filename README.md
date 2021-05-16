# IMDB-dataset-analysis-using-scala-spark
In this project we took two IMDB datasets and conducted a simple analysis on the various columns.

## The Dataset
1) IMDB_dataset : This dataset contains 28 variables for 5043 movies, spanning across 100 years(1916-2016)  in 66 countries with 47 different languages 
2) IMDB_dataset_1 : Dataset contains 19 variables for 5000 movies. It includes the names of **production companies** which is used in the script `Production_analysis.scala` 

## The script
It is written in scala and run in spark shell. <br/>
Click link to learn how to download spark (https://youtu.be/cYL42BBL3Fo)<br/>
To load any script after loading spark shell using command `spark-shell` do `:load filename.scala`

## Load to csv
If u want to save the output as a csv file for plotting final answer in excel use the following commands 
```
val file = new java.io.PrintStream("filename.csv")
// directorRdd is from director_analysis and is used as example
directorRdd.collect.foreach{file.println(_)}
file.close
```

## Things to note
The dataset has quite a few errors which need to be neglected. So only a simple analysis is being done.
