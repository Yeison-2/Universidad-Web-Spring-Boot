package com.jdc.web2026i.entities;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UniversidadEntityTest {

    private static Validator validator;

    @BeforeAll
    static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testEntityValidations() {
        UniversidadEntity universidad = new UniversidadEntity();
        universidad.setNombre("Universidad Nacional");
        universidad.setNit("12345678901234");
        universidad.setEstado(true);
        universidad.setDescripcion("Universidad publica de educacion superior");

        var violations = validator.validate(universidad);
        assertTrue(violations.isEmpty(), "No deberia haber violaciones de validacion");
    }

    @Test
    void testNombreValidation() {
        UniversidadEntity universidad = new UniversidadEntity();
        universidad.setNombre("");
        universidad.setNit("12345678901234");
        universidad.setEstado(true);
        universidad.setDescripcion("Descripcion valida");

        var violations = validator.validate(universidad);
        assertEquals(1, violations.size(), "Deberia haber 1 violacion por nombre vacio");
        assertEquals("nombre", violations.iterator().next().getPropertyPath().toString());
    }

    @Test
    void testNitValidation() {
        UniversidadEntity universidad = new UniversidadEntity();
        universidad.setNombre("Universidad valida");
        universidad.setNit("123456789012345");
        universidad.setEstado(true);
        universidad.setDescripcion("Descripcion valida");

        var violations = validator.validate(universidad);
        assertEquals(1, violations.size(), "Deberia haber 1 violacion por NIT con longitud invalida");
        assertEquals("nit", violations.iterator().next().getPropertyPath().toString());
    }

    @Test
    void testDescripcionValidation() {
        UniversidadEntity universidad = new UniversidadEntity();
        universidad.setNombre("Universidad valida");
        universidad.setNit("12345678901234");
        universidad.setEstado(true);
        universidad.setDescripcion("");

        var violations = validator.validate(universidad);
        assertEquals(1, violations.size(), "Deberia haber 1 violacion por descripcion vacia");
        assertEquals("descripcion", violations.iterator().next().getPropertyPath().toString());
    }

    @Test
    void testGettersAndSetters() {
        UniversidadEntity universidad = new UniversidadEntity();

        Integer id = 1;
        String nombre = "Universidad de Prueba";
        String nit = "98765432101234";
        boolean estado = true;
        String descripcion = "Universidad para pruebas unitarias";

        universidad.setIdUniversidad(id);
        universidad.setNombre(nombre);
        universidad.setNit(nit);
        universidad.setEstado(estado);
        universidad.setDescripcion(descripcion);

        assertEquals(id, universidad.getIdUniversidad());
        assertEquals(nombre, universidad.getNombre());
        assertEquals(nit, universidad.getNit());
        assertEquals(estado, universidad.isEstado());
        assertEquals(descripcion, universidad.getDescripcion());
    }
}

