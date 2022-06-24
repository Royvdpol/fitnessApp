package com.ilionx.fitness.api;

import com.ilionx.fitness.model.Dumbbell;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("integrationtest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FitnessControllerIT {

    private static long currentId = -1;

    @Autowired
    private TestRestTemplate restTemplate; // sort of Postman



    @Test
    @Order(1)
    void testCreateUsingPost() {
        Dumbbell dumbbell = new Dumbbell();
        dumbbell.setMaterial("Aluminum");
        dumbbell.setWeight(35);

        ResponseEntity<Dumbbell> response  = this.restTemplate.postForEntity(FitnessController.URL, dumbbell, Dumbbell.class);
        assertEquals(200, response.getStatusCodeValue());

        Dumbbell returnedDumbbell = response.getBody();
        assertNotEquals(0, returnedDumbbell.getId());
        assertNotNull(returnedDumbbell);
        assertEquals("Aluminum", returnedDumbbell.getMaterial());
        currentId = returnedDumbbell.getId();
    }

    @Test
    @Order(2)
    void testFetchit() {
        ResponseEntity<Dumbbell> response  = this.restTemplate.getForEntity(FitnessController.URL+"/getbyid/"+currentId, Dumbbell.class);
        assertNotNull(response.getBody());
        Dumbbell dumbbellResponse = response.getBody();
        assertEquals(35, dumbbellResponse.getWeight());
    }

}
