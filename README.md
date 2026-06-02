# 🎓 Sistema de Gestión Universitaria

<img width="1347" height="627" alt="image" src="https://github.com/user-attachments/assets/37e9edd7-48e5-44d1-850b-835150c46f87" />


Una plataforma integral para la administración y gestión de universidades, diseñada con las tecnologías más modernas de desarrollo web.

## 📋 Acerca del Sistema

<img width="1280" height="625" alt="image" src="https://github.com/user-attachments/assets/55a52ad7-7a45-46bb-89b7-769bd5d40781" />


Este sistema web proporciona una solución completa para la gestión de instituciones de educación superior. Permite administrar información de universidades, recintos seccionales, rectores y datos de contacto de forma centralizada y eficiente.

La plataforma incluye funcionalidades de comunicación integradas, permitiendo envío automático de correos electrónicos para notificaciones y gestión de información institucional. Con una interfaz intuitiva y responsiva, facilita la interacción entre los diferentes usuarios del sistema.

---

## 🛠️ Tecnologías Utilizadas

**Backend & Framework:**
- **Spring Boot 4.0.2** - Framework principal para desarrollo ágil de aplicaciones web
- **Java 25** - Lenguaje de programación backend
- **Spring Data JPA** - Abstracción y gestión de datos con persistencia
- **Spring Security** - Autenticación y autorización de usuarios

**Base de Datos:**
- **PostgreSQL** - Sistema de gestión de bases de datos relacional

**Frontend & Plantillas:**
- **Thymeleaf** - Motor de plantillas para vistas dinámicas
- **HTML**

**Comunicaciones:**
- **SMTP** - Protocolo para envío seguro de correos electrónicos

<img width="1250" height="756" alt="image" src="https://github.com/user-attachments/assets/245818a9-04bc-4962-bd56-c714d9330ed8" />

**Herramientas & DevOps:**
- **Maven** - Gestor de dependencias y compilación
- **Spring Boot DevTools** - Herramientas para desarrollo ágil con recarga automática
- **JUnit 5** - Framework de testing

---

## ✨ Características Principales

✓ Gestión completa de universidades y seccionales  
✓ Administración de datos de rectores  
✓ Sistema de contactos y telefonía integrado  
✓ Envío de correos automatizado mediante SMTP  
✓ Autenticación y control de acceso seguro  
✓ Interfaz web responsiva y moderna  
✓ Suite de pruebas automatizadas  

---

## 📁 Estructura del Proyecto

```
src/main/
  ├── java/com/jdc/
  │   └── web2026i/          # Código fuente Java (controladores, servicios, entidades)
  ├── resources/
  │   ├── templates/          # Vistas HTML con Thymeleaf
  │   ├── static/             # CSS, imágenes y otros recursos estáticos
  │   └── application.properties # Configuración de la aplicación
```

---

## 🚀 Inicio Rápido

### Requisitos Previos
- Java 25+
- Maven (o usar el incluido: mvnw)
- PostgreSQL configurado


### Ejecutar Tests
```bash
.\mvnw.cmd test
```

---

## 🔒 Seguridad

- Las credenciales nunca deben incluirse en el repositorio
- Utiliza variables de entorno para datos sensibles
- Spring Security proporciona protección contra vulnerabilidades comunes
- Se recomienda usar un gestor de secretos en producción

---

## 📝 Notas de Desarrollo

- El proyecto utiliza Lombok para reducir código boilerplate
- Spring Boot DevTools permite recarga automática durante desarrollo
- Las pruebas unitarias están disponibles en `src/test/java`

---

**Sistema de Gestión Universitaria | 2026**


