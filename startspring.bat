@echo off 

echo Creando Eureka

curl -o eureka.zip "https://start.spring.io/starter.zip?type=gradle-project&bootVersion=1.3.3.RELEASE&baseDir=eureka&groupId=es.paradigma&artifactId=eureka&name=eureka&description=Demo+project+for+Spring+Boot&packageName=es.paradigma&packaging=jar&javaVersion=1.8&language=java&autocomplete=&generate-project=&style=cloud-eureka-server" 

7z x eureka.zip

echo Creando ConfigServer

curl -o configserver.zip "https://start.spring.io/starter.zip?type=gradle-project&bootVersion=1.3.3.RELEASE&baseDir=configserver&groupId=es.paradigma&artifactId=configserver&name=configserver&description=Demo+project+for+Spring+Boot&packageName=es.paradigma&packaging=jar&javaVersion=1.8&language=java&autocomplete=&style=cloud-starter&style=cloud-config-server&style=cloud-eureka-server&generate-project="

7z x configserver.zip

echo Creando User

curl -o user.zip "https://start.spring.io/starter.zip?type=gradle-project&bootVersion=1.3.3.RELEASE&baseDir=user&groupId=es.paradigma&artifactId=user&name=user&description=Demo+project+for+Spring+Boot&packageName=es.paradigma.service.user&packaging=jar&javaVersion=1.8&language=java&autocomplete=&style=cloud-starter&style=cloud-config-client&style=cloud-eureka&generate-project="

7z x user.zip


echo Creando Product

curl -o product.zip "https://start.spring.io/starter.zip?type=gradle-project&bootVersion=1.3.3.RELEASE&baseDir=product&groupId=es.paradigma&artifactId=product&name=product&description=Demo+project+for+Spring+Boot&packageName=es.paradigma.service.product&packaging=jar&javaVersion=1.8&language=java&autocomplete=&style=cloud-starter&style=cloud-config-client&style=cloud-eureka&generate-project="

7z x product.zip


echo Creando Agregation

curl -o agregation.zip "https://start.spring.io/starter.zip?type=gradle-project&bootVersion=1.3.3.RELEASE&baseDir=agregation&groupId=es.paradigma&artifactId=agregation&name=agregation&description=Demo+project+for+Spring+Boot&packageName=es.paradigma.service.agregation&packaging=jar&javaVersion=1.8&language=java&autocomplete=&style=cloud-starter&style=cloud-config-client&style=cloud-eureka&generate-project="

7z x agregation.zip

