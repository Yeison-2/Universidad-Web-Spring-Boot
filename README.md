
# Web-2026-i

Proyecto Spring Boot (Java) para gestión universitaria y envío de correos.

## Descripción
- Aplicación web creada con Spring Boot. Contiene entidades como Universidad, Rector, Seccional y Teléfono y vistas Thymeleaf en `src/main/resources/templates`.
- Incluye una clase de configuración para el envío de correos: `com.jdc.web2026i.Config.MailConfiguration`.

## Estructura relevante
- `src/main/java/com/jdc/web2026i` - código fuente Java.
- `src/main/resources/templates` - plantillas Thymeleaf (.html).
- `src/main/resources/static` - recursos estáticos (css, imágenes, txt).
- `pom.xml` - configuración Maven.

## Configuración del correo (SMTP)
- Archivo: `MailConfiguration.java` (en `com.jdc.web2026i.Config`). Actualmente define un `JavaMailSender` con los valores de host, puerto, usuario y contraseña.
- Llaves a completar en `MailConfiguration.java`:
  - `mailSender.setUsername(...)` → correo remitente
  - `mailSender.setPassword(...)` → contraseña o App Password
- Recomendación: no dejar credenciales en el código. En lugar de eso, pásalas por `application.properties` o variables de entorno y modifica `MailConfiguration` para leerlas.

Ejemplo de configuración recomendada (`application.properties`):

```
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=tu-correo@gmail.com
spring.mail.password=tu-app-password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

> Nota sobre Gmail: Google ya no permite "Less secure apps". Si usas Gmail habilita 2FA y crea una App Password para la aplicación, o usa un servicio SMTP compatible.

## Cómo ejecutar
1. Desde Windows PowerShell, en la raíz del proyecto:
   `Set-Location 'C:\Users\Usuario\OneDrive\Documentos\NetBeansProjects\Web-2026-i'`
2. Compilar y ejecutar con Maven wrapper:
   `.\mvnw.cmd clean package`
   `.\mvnw.cmd spring-boot:run`
   O ejecutar el jar generado:
   `java -jar target\\web-2026-i.jar`

## Tests
- Ejecutar: `.\mvnw.cmd test`

## Buenas prácticas
- No subir credenciales (usuario/contraseña) al repositorio. Usa variables de entorno, `application.properties` excluido del control de versiones o un gestor de secretos.
- Añade un `.gitignore` que excluya `target/`, archivos de IDE y `application.properties` si contiene secretos.

## Git: añadir, commitear y push
- Comandos básicos (PowerShell):
  ```powershell
  Set-Location 'C:\Users\Usuario\OneDrive\Documentos\NetBeansProjects\Web-2026-i'
  git add README.md
  git commit -m "docs: add README.md"
  git push
  ```

Si falla el push por autenticación:
- Comprueba si el remoto usa HTTPS o SSH: `git remote -v`.
- Para HTTPS en Windows recomienda activar el helper de credenciales: `git config --global credential.helper manager-core`.
- Para SSH asegúrate de tener la clave y el agente: `Start-Service ssh-agent; ssh-add C:\\Users\\Usuario\\.ssh\\id_rsa`.
- Si usas GitHub y 2FA, crea un Personal Access Token (PAT) y úsalo en lugar de la contraseña.

## Contacto / Más cambios
- Si quieres, puedo:
  - Modificar `MailConfiguration` para leer propiedades desde `application.properties` y actualizar el README con pasos para crear el App Password.
  - Añadir un `.gitignore` recomendado.

---
README generado por el asistente. Revisa y completa tus credenciales de forma segura antes de ejecutar el envío de correos.


