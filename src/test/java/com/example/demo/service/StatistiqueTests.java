package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
public class StatistiqueTests {

    @MockBean
    StatistiqueImpl statistiqueImpl;

    @Test
    void testPrixMoyenAvecUneVoiture() {
        StatistiqueImpl statistique = new StatistiqueImpl();
        Voiture voiture = new Voiture("Peugeot", 10000);

        statistique.ajouter(voiture);
        Echantillon echantillon = statistique.prixMoyen();

        assertEquals(1, echantillon.getNombreDeVoitures());
        assertEquals(10000, echantillon.getPrixMoyen());
    }

    @Test
    void testPrixMoyenAvecPlusieursVoitures() {
        StatistiqueImpl statistique = new StatistiqueImpl();

        statistique.ajouter(new Voiture("Peugeot", 10000));
        statistique.ajouter(new Voiture("Renault", 20000));
        statistique.ajouter(new Voiture("BMW", 30000));

        Echantillon echantillon = statistique.prixMoyen();

        assertEquals(3, echantillon.getNombreDeVoitures());
        assertEquals(20000, echantillon.getPrixMoyen());
    }

}