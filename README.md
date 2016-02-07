# apache-mahout-recommendation-starter
Simple Java project that recommends items for user.

# Getting started
Clone this project into your projects folder. Via command line, `cd` into the project and run `gradle clean run`. You should see the following output:
```
11:47:58: Executing external tasks 'clean run'...
:clean
:compileJava
:processResources
:classes
log4j:WARN No appenders could be found for logger (org.apache.mahout.cf.taste.impl.model.file.FileDataModel).
log4j:WARN Please initialize the log4j system properly.
log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
:run
RecommendedItem[item:12, value:4.8328104]
RecommendedItem[item:13, value:4.6656213]
RecommendedItem[item:14, value:4.331242]

BUILD SUCCESSFUL

Total time: 0.52 secs
11:47:58: External tasks execution finished 'clean run'.
```

The rows starting with RecommendedItem are the items that have been recommended. Item denotes the itemId (second column in resources/dataset.csv) and value denotes the strength of preference.
