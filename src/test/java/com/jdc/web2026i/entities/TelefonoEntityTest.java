package com.jdc.web2026i.entities;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TelefonoEntityTest {

    private static Validator validator;

    @BeforeAll
    static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testEntityValidations() {
        TelefonoEntity telefono = new TelefonoEntity();
        telefono.setNumero("3001234567");
        telefono.setTipo("Movil");

        var violations = validator.validate(telefono);
        assertTrue(violations.isEmpty(), "No deberia haber violaciones de validacion");
    }

    @Test
    void testNumeroValidation() {
        TelefonoEntity telefono = new TelefonoEntity();
        telefono.setNumero("");
        telefono.setTipo("Movil");

        var violations = validator.validate(telefono);
        assertEquals(1, violations.size(), "Deberia haber 1 violacion por numero vacio");
        assertEquals("numero", violations.iterator().next().getPropertyPath().toString());
    }

    @Test
    void testTipoValidation() {
        TelefonoEntity telefono = new TelefonoEntity();
        telefono.setNumero("3001234567");
        telefono.setTipo("");

        var violations = validator.validate(telefono);
        assertEquals(1, violations.size(), "Deberia haber 1 violacion por tipo vacio");
        assertEquals("tipo", violations.iterator().next().getPropertyPath().toString());
    }

    @Test
    void testGettersAndSetters() {
        TelefonoEntity telefono = new TelefonoEntity();
        SeleccionalEntity seccional = new SeleccionalEntity();
        UniversidadEntity universidad = new UniversidadEntity();

        Integer id = 1;
        String numero = "3119876543";
        String tipo = "Fijo";
        Integer idLegacy = 99;

        telefono.setIdTelefono(id);
        telefono.setNumero(numero);
        telefono.setTipo(tipo);
        telefono.setSeleccional(seccional);
        telefono.setUniversidad(universidad);
        telefono.setIdSeccionalesLegacy(idLegacy);

        assertEquals(id, telefono.getIdTelefono());
        assertEquals(numero, telefono.getNumero());
        assertEquals(tipo, telefono.getTipo());
        assertEquals(seccional, telefono.getSeleccional());
        assertEquals(universidad, telefono.getUniversidad());
        assertEquals(idLegacy, telefono.getIdSeccionalesLegacy());
    }
}

