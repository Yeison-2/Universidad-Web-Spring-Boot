package com.jdc.web2026i.entities;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SeleccionalEntityTest {

    private static Validator validator;

    @BeforeAll
    static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testEntityValidations() {
        SeleccionalEntity seccional = new SeleccionalEntity();
        seccional.setNombre("Seccional Centro");
        seccional.setDireccion("Calle 123 #45-67");

        var violations = validator.validate(seccional);
        assertTrue(violations.isEmpty(), "No deberia haber violaciones de validacion");
    }

    @Test
    void testNombreValidation() {
        SeleccionalEntity seccional = new SeleccionalEntity();
        seccional.setNombre("");
        seccional.setDireccion("Direccion valida");

        var violations = validator.validate(seccional);
        assertEquals(1, violations.size(), "Deberia haber 1 violacion por nombre vacio");
        assertEquals("nombre", violations.iterator().next().getPropertyPath().toString());
    }

    @Test
    void testDireccionValidation() {
        SeleccionalEntity seccional = new SeleccionalEntity();
        seccional.setNombre("Seccional valida");
        seccional.setDireccion("");

        var violations = validator.validate(seccional);
        assertEquals(1, violations.size(), "Deberia haber 1 violacion por direccion vacia");
        assertEquals("direccion", violations.iterator().next().getPropertyPath().toString());
    }

    @Test
    void testGettersAndSetters() {
        SeleccionalEntity seccional = new SeleccionalEntity();
        UniversidadEntity universidad = new UniversidadEntity();

        Integer id = 1;
        String nombre = "Seccional Norte";
        String direccion = "Avenida 10 #20-30";

        seccional.setIdSeleccional(id);
        seccional.setNombre(nombre);
        seccional.setDireccion(direccion);
        seccional.setUniversidad(universidad);

        assertEquals(id, seccional.getIdSeleccional());
        assertEquals(nombre, seccional.getNombre());
        assertEquals(direccion, seccional.getDireccion());
        assertEquals(universidad, seccional.getUniversidad());
    }
}

