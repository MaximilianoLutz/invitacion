creo rama config server
creo proyecto de configuracion
dependencia spring server config
creo server application.yaml config
creo carpeta config data con la configuracion de cada microservicio en archivo yaml con el nombre de cada microservicio
agrego dependencias config client y spring bootstrap en los microservicios
renombro los application.properties a bootstrap.yaml con el nombre de cada microservicio
git add .
git commit -m "config server"
git push -u origin config-server

creo rama eureka para configurar el server y los clientes 3h

Heroku es una empresa muy simple de plataforma como servicio. La forma en que funciona Heroku es muy sencilla:‎

‎Tiene varios proyectos (servicios) en repositorios de Git.‎
‎Crea una aplicación Heroku para cada proyecto (cada repositorio de Git).‎
‎A continuación, envía su código desde cada repositorio de Git a su respectiva aplicación Heroku.‎
‎Heroku te asigna una URL pública para cada aplicación que tengas.‎
‎Si cada uno de sus servicios se está ejecutando ahora en Heroku, pueden enviarse solicitudes de API entre sí a través de HTTP públicos.‎
‎Ahora, con respecto a su pregunta sobre la arquitectura orientada a servicios en Heroku.‎

‎Si está haciendo SOA en Heroku, deberá hacer que cada servicio hable públicamente entre sí a través de HTTPS. Este es el típico 'patrón'.‎

‎Debido a que Heroku proporciona SSL gratuito para cada aplicación, y cada aplicación está en la misma región de Amazon, hablar entre sus servicios a través de HTTP es muy rápido + seguro.‎

‎Cada aplicación Heroku tiene equilibrio de carga automático, por lo que no hay necesidad de preocuparse por los equilibradores de carga.‎

‎La siguiente opción aquí (si no desea seguir los patrones típicos) es usar algo como RabbitMQ o Amazon SQS (un servicio de cola) y compartir 'mensajes' entre sus diferentes servicios.‎

‎En este patrón, seguiría teniendo una aplicación Heroku para cada servicio, pero en lugar de comunicarse entre sí a través de HTTP, se comunicaría con sus otros servicios a través de un protocolo de cola como Rabbit o SQS. Esto tiene algunos beneficios de velocidad.‎

‎En lo que respecta a los servicios de autenticación, hay varios proveedores que puede utilizar para proporcionar esta funcionalidad. El más popular que conozco es ‎‎Stormpath‎‎. Si miras a través del ‎‎mercado de complementos de Heroku‎‎, también puedes encontrar otros.‎

‎Finalmente, para las cosas de la base de datos: puede usar cualquier proveedor de base de datos que desee. El más popular es probablemente ‎‎Heroku Postgres‎‎. Es una versión alojada de PostgreSQL que es muy confiable / fácil de usar.‎

‎Puede compartir una base de datos entre TODOS sus servicios o puede tener una base de datos por servicio. Cualquiera de las dos estrategias funcionará bien.‎