#!/bin/bash
war=$(ls -1tr ionia-server/target/ionia-server-*.war | tail -1 )
java -jar ./payara-micro-5.183.jar $war  --addJars lib/jpa/h2-1.4.197.jar
