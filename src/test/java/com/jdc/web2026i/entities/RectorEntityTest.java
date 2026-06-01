package com.jdc.web2026i.entities;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RectorEntityTest {

    private static Validator validator;

    @BeforeAll
    static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testEntityValidations() {
        RectorEntity rector = new RectorEntity();
        rector.setPrimerapellido("Perez");
        rector.setSegundoapellido("Gomez");
        rector.setNombre("Juan");
        rector.setNum_documento(12345678);
        rector.setTipo("CC");
        rector.setFechaNacimiento(new Date());

        var violations = validator.validate(rector);
        assertTrue(violations.isEmpty(), "No deberia haber violaciones de validacion");
    }

    @Test
    void testPrimerApellidoValidation() {
        RectorEntity rector = new RectorEntity();
        rector.setPrimerapellido(null);
        rector.setSegundoapellido("Gomez");
        rector.setNombre("Juan");
        rector.setNum_documento(12345678);
        rector.setTipo("CC");
        rector.setFechaNacimiento(new Date());

        var violations = validator.validate(rector);
        assertEquals(1, violations.size(), "Deberia haber 1 violacion por primer apellido nulo");
        assertEquals("primerapellido", violations.iterator().next().getPropertyPath().toString());
    }

    @Test
    void testFechaNacimientoValidation() {
        RectorEntity rector = new RectorEntity();
        rector.setPrimerapellido("Perez");
        rector.setSegundoapellido("Gomez");
        rector.setNombre("Juan");
        rector.setNum_documento(12345678);
        rector.setTipo("CC");
        rector.setFechaNacimiento(null);

        var violations = validator.validate(rector);
        assertEquals(1, violations.size(), "Deberia haber 1 violacion por fecha de nacimiento nula");
        assertEquals("fechaNacimiento", violations.iterator().next().getPropertyPath().toString());
    }

    @Test
    void testGettersAndSetters() {
        RectorEntity rector = new RectorEntity();

        Integer id = 1;
        String primerApellido = "Lopez";
        String segundoApellido = "Perez";
        String nombre = "Carlos";
        int numeroDocumento = 34567890;
        String tipo = "CC";
        Date fechaNacimiento = new Date();

        rector.setIdDirector(id);
        rector.setPrimerapellido(primerApellido);
        rector.setSegundoapellido(segundoApellido);
        rector.setNombre(nombre);
        rector.setNum_documento(numeroDocumento);
        rector.setTipo(tipo);
        rector.setFechaNacimiento(fechaNacimiento);

        assertEquals(id, rector.getIdDirector());
        assertEquals(primerApellido, rector.getPrimerapellido());
        assertEquals(segundoApellido, rector.getSegundoapellido());
        assertEquals(nombre, rector.getNombre());
        assertEquals(numeroDocumento, rector.getNum_documento());
        assertEquals(tipo, rector.getTipo());
        assertEquals(fechaNacimiento, rector.getFechaNacimiento());
    }
}

