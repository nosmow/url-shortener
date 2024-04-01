# Url Shortener

<p align="left" > 
  <img src="https://img.shields.io/badge/Java%20JDK-v.17-green"/>
  <img src="https://img.shields.io/badge/Spiring%20Boot-v.3-yellow"/>
  <img src="https://img.shields.io/badge/MySQL-v.8.0.33-blue"/>
</p>

## Tabla de Contenido

- [Descripción del proyecto](#descripcion-del-proyecto)
- [Estado del proyecto](#estado-del-proyecto)
- [Demo](#demo)
- [Funcionalidades](#funcionalidades)
    - [Acortador](#acortador)
	 - [Registrar url](#registrar-url)
	- [Abrir url](#abrir-url)
- [Acceso al proyecto](#acceso-al-proyecto)
- [Tecnologías utilizadas](#tecnologias-utilizadas)
- [Dependencias utilizadas](#dependencias-utilizadas)
- [Autor](#autor)
- [Licencia](#licencia)


## Descripcion del proyecto

El acortador de enlaces te permite pasar de tener una url super extensa a tener una corta y simple para que puedas compartirla fácilmente.

## Estado del proyecto

   ![Badge en Desarollo](https://img.shields.io/badge/ESTADO-FINALIZADO-green)

## Demo

![](https://media1.giphy.com/media/v1.Y2lkPTc5MGI3NjExdjU2cTRnYXduZDdlZW5iMnk3bDI3bDFmaGN6YTYxZ3V3OW5xZjlwNSZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/8EggdiFm1xdBPygazF/giphy.gif)

## Funcionalidades

### Acortador

```Java
private String encodedUrl(String url) {
        String encodedUrl = "";
        do {
            encodedUrl = Hashing.murmur3_32()
                    .hashString(url, StandardCharsets.UTF_8)
                    .toString();
        } while (urlRepository.existsByShortLink(encodedUrl));

        return encodedUrl;
    }
```

### Registrar url

Envia a la base de datos la url original y la url acortada.

```bash
[POST] https://localhost:8080/shorten
```

```json
{
  "id": 0,
  "originalUrl": "string",
  "shortLink": "string"
}
```

#### Abrir url

Ingresa la url acortada en el sistema y automáticamente te redirige a la dirección de la url original.

```bash
[GET] https://localhost:8080/{shortLink}
```

## Acceso al proyecto

1. Descargue la versión 17 de [Java JDK.](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

2. Descargue el IDE [IntelliJ IDEA Community.](https://www.jetbrains.com/idea/download/)

3. Descargue [MySQL.](https://dev.mysql.com/downloads/installer/)

4. Descargue [MySQL Workbench.](https://dev.mysql.com/downloads/workbench/)

5. Clone el repositoria mediante el siguiente enlace: https://github.com/nosmow/url-shortener.git

6. Abra MySQL Workbench y ejecute la siguiente linea de codigo para crear la base de datos:

```sql
CREATE DATABASE shortener;
```

```sql
CREATE TABLE url(
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	originalUrl VARCHAR(2100) NOT NULL,
    shortLink VARCHAR(500) NOT NULL
);
```

7. Abra el proyecto en el IDE IntelliJ IDEA Community.

8. Dirijase a la carpeta de **resources** y en **application.properties ** modifique los campos **spring.datasource.username** y **spring.datasource.password** reemplazandolos por el *usuario* y la *contraseña* que asigno al instalar MySQL en su PC.

9. Compile y ejecute la aplicación, listo 🙃.

## Tecnologias utilizadas

* Java 17

* Spring Boot 3

* MySQL

* Javascript

## Dependencias utilizadas

*  `Spring Web`

* `Spring Boot DevTools`

* `Lombok`

*  `thymeleaf`

* `MySQL Driver`

* `JPA`
  
* `Hibernate`


## Autor

|  [<img src="https://avatars.githubusercontent.com/u/165520012?v=4" width=115><br><sub>Nosmow</sub>](https://github.com/nosmow) |
| :---: |

## Licencia

> Foro Alura está licenciado bajo la [licencia MIT](https://github.com/nosmow/challenge-one-foro-alura/blob/main/LICENSE)
