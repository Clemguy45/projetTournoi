package com.example.servicetournois.dto;

import java.util.Date;
import java.util.List;

public record TournoisDTO(String nomTournois, Long idJeu, String responsable, String organisation, List<Long> joueursIds, List<Long> equipesIds, List<String> regles, Date date, String nomTournoi) {
}
