FROM java:8

ADD target/JPA-1.0-SNAPSHOT-jar-with-dependencies.jar /

CMD java -jar /JPA-1.0-SNAPSHOT-jar-with-dependencies.jar

