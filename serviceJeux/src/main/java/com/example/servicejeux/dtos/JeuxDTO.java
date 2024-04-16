package com.example.servicejeux.dtos;

import java.util.List;

public record JeuxDTO(String titre, String type, int pegi, List<String> rangs, int nombreMaxJoueurs, List<String> modesDeJeu, String typeTournoi) {
}
